package middleware;

import com.google.api.core.ApiFuture;
import com.google.api.services.storage.Storage;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import model.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    void AddNewInventoryItem(Product product){
        Firestore client = GetClient();

        Map<String, Object> productData = new HashMap<String, Object>();

        productData.put("id", product.getId());
        productData.put("type", product.getType());
        productData.put("description", product.getDescription());
        productData.put("price", product.getPrice());
        productData.put("quantity", product.getQuantity());

        // runs in asynchronous mode
        client.collection("products").document().set(productData);
    }

    List<Product> GetListOfProductsByType(String type) {
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
            ex.printStackTrace();
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
}
