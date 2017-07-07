import java.util.List;

/**
* This Service is an API/Interface service for the
* client to interact with the business layer/domain objects
*/
public class UserAccountService {
    
    //TODO Factory for User    

    public static long viewBalance(User user) {
        return user.getBalance();
    }

    public void deposit(long amount) {
        //this.balance += amount;
        throw new UnsupportedOperationException("To do! Implement this shit!");
    }

    public void purchase(long price) {
        throw new UnsupportedOperationException("To do! Implement this shit!");
    }
    
    public void closeAccount() {
        throw new UnsupportedOperationException("To do! Implement this shit!");
    }

    public void openAccount(long deposit) {
        throw new UnsupportedOperationException("To do! Implement this shit!");
    }

    /*private boolean authenticate(String username, String password) throws Exception {
        User user = new User(username, password);
        return user.authenticate();
    }*/

    public static User getAuthenticatedUser(String username, String password) throws Exception {
        User user = new User(username, password);
        return user.authenticate() ? user : null;
    }

    public String toString(User user) {
        return user.toString();        
    }

}
