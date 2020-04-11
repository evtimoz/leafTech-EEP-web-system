package middleware;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import model.Order;
import model.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by arman 4/9/20.
 */
public class FirebaseGateway {

    private static Firestore GetClient(){
        InputStream serviceAccount =
                null;
        serviceAccount = FirebaseGateway.class.getResourceAsStream("/creds.json");

        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://leaftech-eep-web-system.firebaseio.com")
                    .build();

            if(FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return FirestoreClient.getFirestore();
    }

    public String GetUserRoleByLoginAndPassword(String login, String password) throws Exception {
        Firestore client = GetClient();

        Query query = client.collection("users").whereEqualTo("login", login).whereEqualTo("password", password);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        if(documents.size() == 1){
            QueryDocumentSnapshot documentSnapshot = documents.get(0);
            return documentSnapshot.getString("role");
        }

        return "";
    }

    void AddNewInventoryItem(Product product) throws Exception {
        Firestore client = GetClient();

        ApiFuture<QuerySnapshot> future =
                client.collection("products").whereEqualTo("id", product.getId()).whereEqualTo("type", product.getType()).get();

        List<QueryDocumentSnapshot> productDocuments = future.get().getDocuments();

        if(productDocuments.size() != 0) throw new Exception("Product with ID:" + product.getId() + " has already been added. Enter unique ID.");

        // runs in asynchronous mode
        client.collection("products").document().set(product);
    }

    List<Product> GetListOfProductsByType(String type) throws Exception {
        List<Product> resultingList = new ArrayList<Product>();
        Firestore client = GetClient();

        ApiFuture<QuerySnapshot> future =
                client.collection("products").whereEqualTo("type", type).get();

        try {
            List<QueryDocumentSnapshot> productDocuments = future.get().getDocuments();
            for (DocumentSnapshot document : productDocuments) {
                resultingList.add(document.toObject(Product.class));
            }
        }
        catch (Exception ex) {
            throw new Exception("error establishing connection with Firebase - " + ex.getMessage());
        }

        return resultingList;
    }

    void DeleteProductById(String Id){
        Firestore client = GetClient();
        ApiFuture<QuerySnapshot> future =
                client.collection("products").whereEqualTo("id", Id).get();

        try {
            List<QueryDocumentSnapshot> productDocuments = future.get().getDocuments();

            if(productDocuments.size() != 0){
                QueryDocumentSnapshot productToDelete = productDocuments.get(0);

                productToDelete.getReference().delete();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void DecrementProductQuantityById(String Id) throws Exception {
        Firestore client = GetClient();
        ApiFuture<QuerySnapshot> future =
                client.collection("products").whereEqualTo("id", Id).get();

        List<QueryDocumentSnapshot> productDocuments = future.get().getDocuments();

        if(productDocuments.size() == 0) throw new Exception("This product was not found in the inventory. Please try again");

        QueryDocumentSnapshot productToDecrement = productDocuments.get(0);

        Product updatedProduct = productToDecrement.toObject(Product.class);
        updatedProduct.decrementQuantity();

        productToDecrement.getReference().update("quantity", updatedProduct.getQuantity());
    }

    public void createOrderWithProducts(Order order, List<Product> products) throws Exception{
        Firestore client = GetClient();
        Calendar rightNow = Calendar.getInstance();

        String orderDocName = "order" + rightNow.getTimeInMillis();

        client.collection("orders").document(orderDocName).set(order);

        for (Product p:
             products) {
            ApiFuture<WriteResult> future = client.collection("orders").document(orderDocName).collection("products").document().set(p);
            future.get();
        }
    }
}
