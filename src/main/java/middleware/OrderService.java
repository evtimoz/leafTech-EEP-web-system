package middleware;

import model.Order;
import model.Product;

import java.util.List;

/**
 * Created by arman 4/9/20.
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
}
