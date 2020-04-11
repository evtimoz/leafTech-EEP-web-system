package midlleware.tests;

import middleware.FirebaseGateway;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by arman 4/10/20.
 */
class FirebaseGatewayTest {

    @org.junit.jupiter.api.Test
    void getUserRoleByLoginAndPassword() {
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        try {
            assertEquals("inventory", firebaseGateway.GetUserRoleByLoginAndPassword("laskau", "qwerty"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}