package middleware;

import model.Product;

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

    public void AddProduct(Product product) {
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        firebaseGateway.AddNewInventoryItem(product);
    }
}
