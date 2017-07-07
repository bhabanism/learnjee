import java.util.List;

public class User {
    private String username;
    private String password;
    private long balance;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public long getBalance() {
        return this.balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void deposit(long amount) {
        this.balance += amount;
    }

    public void purchase(long price) {
        this.balance -= price;
    }
    
    public void closeAccount() {
        this.balance = 0;
    }

    public void openAccount(long deposit) {
        this.balance = deposit;
    }

    public boolean authenticate() throws Exception {
        List<User> list = UserDataUtil.getAllUsers();
        boolean isUserValid = false;
        for(User user : list) {
            isUserValid = user.username.equals(this.username) && user.password.equals(this.password);
            if(isUserValid) {
                this.setBalance(user.getBalance());
                return isUserValid;
            }
        }
        return isUserValid;
    }

    public String toString() {
        return this.username + ":" + this.password + ":" + this.balance;
    }

}
