package middleware;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;

/**
 * Created by arman 4/9/20.
 */
public class AuthenticationService {
    private static AuthenticationService instance;
    private static final String HASH_METHOD = "SHA-256";
    private static final String CHARSET = "UTF-8";
    private static final int DEFAULT_BYTECOUNT = 32;

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
        firebaseGateway.LogEvent("login", login);

        String hashedPassword = GenerateHash(password);
        System.out.println(hashedPassword);
        return firebaseGateway.GetUserRoleByLoginAndPassword(login, hashedPassword);
    }

    public void LogEvent(String type, String userName) throws Exception{
        FirebaseGateway firebaseGateway = new FirebaseGateway();
        firebaseGateway.LogEvent(type, userName);
    }

    private String GenerateHash(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest digest = MessageDigest.getInstance(AuthenticationService.HASH_METHOD);

        // Convert input strings to UTF-8 encoded byte arrays
        byte[] inputBytes = input.getBytes(AuthenticationService.CHARSET);

        digest.reset();

        byte[] outputBytes = digest.digest(inputBytes);
        String outputString = Encryption.encodeBytes(outputBytes);

        return outputString;
    }
}
