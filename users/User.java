package gr.hua.it219151.users;

public class User extends Person{
    private String firstName;
    private String lastName;
    private String AFM;
    private String Address;
    private String ID;
    private String userType;
    private String email;
    private String password;
    private int discount;

    // this is a constructor for a User object
    public User(String firstName, String lastName, String AFM, String address, String ID, String userType, String email, String password, int discount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.AFM = AFM;
        this.Address = address;
        this.ID = ID;
        this.userType = userType;
        this.email = email;
        this.password = password;
        this.discount = discount;
    }

    //getters and setters for all fields

    //overrides the setters and getters of the Person class that User class extends from
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAFM() {
        return AFM;
    }

    public void setAFM(String AFM) {
        this.AFM = AFM;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
