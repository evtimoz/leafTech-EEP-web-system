package middleware;

import model.Product;

import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by arman 4/9/20.
 */
public class InventoryService {
    private static InventoryService instance;

    private InventoryService(){ }

    public static InventoryService getInstance() {
        if(instance == null) {
            synchronized (InventoryService.class){
                if(instance == null) {
                    instance = new InventoryService();
                }
            }
        }

        return instance;
    }

    public void AddProduct(Product product) throws Exception {
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        firebaseGateway.AddNewInventoryItem(product);
    }

    public List<Product> GetProductsByType(String type){
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        return firebaseGateway.GetListOfProductsByType(type);
    }

    public void DeleteProductById(String Id) {
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        firebaseGateway.DeleteProductById(Id);
    }

    public void DecrementProductQuantity(String Id) throws Exception {
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        firebaseGateway.DecrementProductQuantityById(Id);
    }
}
