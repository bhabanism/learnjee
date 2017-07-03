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

    public long viewBalance() {
        return this.getBalance();
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

    public boolean authenticate(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }

}
