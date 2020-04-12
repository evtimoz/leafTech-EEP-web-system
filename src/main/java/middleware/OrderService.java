package middleware;

import model.Order;
import model.Product;

import java.util.List;

/**
 * Created by evtimoz 4/11/20.
 */
public class OrderService {
    private static OrderService instance;

    private OrderService(){ }

    public static OrderService getInstance() {
        if(instance == null) {
            synchronized (OrderService.class){
                if(instance == null) {
                    instance = new OrderService();
                }
            }
        }

        return instance;
    }

    public void createOrder(Order order, List<Product> products) throws Exception{
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        firebaseGateway.createOrderWithProducts(order, products);
    }


    public List<Order> getOrders() throws Exception{
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        return firebaseGateway.getListOfOrders();
    }

    public Order getOrderById(String Id) throws Exception{
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        return firebaseGateway.getOrderById(Id);
    }

    public List<Product> getProductsFromOrder(String Id) throws Exception{
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        return firebaseGateway.getProductsFromOrder(Id);
    }

    public Boolean markOrderAsShipped(String id) throws Exception {
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        return firebaseGateway.updateOrderStatus(id);
    }
}
