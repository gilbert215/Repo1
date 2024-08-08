package lifeprognosis;

public class Admin implements User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // Constructor
    public Admin(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Implement User interface methods
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    // Admin specific methods
    // Define any additional methods specific to Admin here
}
