package middleware;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import model.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arman 4/9/20.
 */
class FirebaseGateway {

    private static Firestore GetClient(){
        FileInputStream serviceAccount =
                null;
        try {
            serviceAccount = new FileInputStream("creds.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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

    String GetUserRoleByLoginAndPassword(String login, String password) throws Exception {
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

        productData.put("id", product.Id);
        productData.put("type", product.Type);
        productData.put("description", product.Description);
        productData.put("price", product.Price);
        productData.put("quantity", product.Quantity);

        // runs in asynchronous mode
        client.collection("products").document().set(productData);
    }
}
