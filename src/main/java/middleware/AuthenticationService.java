package middleware;

/**
 * Created by arman 4/9/20.
 */
public class AuthenticationService {
    private static AuthenticationService instance;

    private AuthenticationService(){ }

    public static AuthenticationService getInstance() {
        if(instance == null) {
            synchronized (AuthenticationService.class){
                if(instance == null) {
                    instance = new AuthenticationService();
                }
            }
        }

        return instance;
    }

    public String GainUserRole(String login, String password) throws Exception {
        FirebaseGateway firebaseGateway = new FirebaseGateway();

        return firebaseGateway.GetUserRoleByLoginAndPassword(login, password);
    }
}
