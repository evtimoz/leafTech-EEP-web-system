package middleware;

import model.Order;
import model.Product;

import java.util.List;

/**
 * Created by evtimoz 4/11/20.
 */
public class OrderService {

    private static OrderService instance;

    public static OrderService getInstance() {
        if(instance == null) {
            synchronized (InventoryService.class){
                if(instance == null) {
                    instance = new OrderService();
                }
            }
        }
        return instance;
    }

    public List<Order> GetOrders() throws Exception{
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        return firebaseGateway.GetListOfOrders();
    }

    public Order GetOrderById(Integer Id) throws Exception{
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        return firebaseGateway.GetOrderById(Id);
    }

}
