package MODEL;

public class Account {

    private String username;
    private String password;
    private String role;
    private Customer customer;

    public Account() {
    }

    public Account(String username, String passworld, String role) {
        this.username = username;
        this.password = passworld;
        this.role = role;
    }

    public Account(String username, String password, String role, Customer customer) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.customer = customer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Customer getPerson() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
