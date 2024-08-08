package lifeprognosis;

public class Patient implements User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;
    private boolean isHivPositive;
    private String diagnosisDate;
    private boolean isOnArt;
    private String artStartDate;
    private String countryCode;

    // Constructor
    public Patient(String firstName, String lastName, String email, String password, String dateOfBirth, 
                   boolean isHivPositive, String diagnosisDate, boolean isOnArt, 
                   String artStartDate, String countryCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.isHivPositive = isHivPositive;
        this.diagnosisDate = diagnosisDate;
        this.isOnArt = isOnArt;
        this.artStartDate = artStartDate;
        this.countryCode = countryCode;
    }

    // Implement User interface methods
    @Override
    public String getFirstName() { return firstName; }
    @Override
    public String getLastName() { return lastName; }
    @Override
    public String getEmail() { return email; }
    @Override
    public String getPassword() { return password; }

    // Getters for Patient specific fields
}
