package lifeprognosis;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminService adminService = new AdminService();
        PatientService patientService = new PatientService();

        // Test admin initiating registration
        System.out.println("Admin Initiate Registration:");
        System.out.print("Enter patient email: ");
        String email = scanner.nextLine();
        adminService.initiateRegistration(email);

        // Test patient completing registration
        System.out.println("\nPatient Complete Registration:");
        System.out.print("Enter UUID: ");
        String uuid = scanner.nextLine();
        patientService.completeRegistration(uuid);

        // Test patient login
        System.out.println("\nPatient Login:");
        System.out.print("Enter email: ");
        String loginEmail = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean isLoggedIn = patientService.login(loginEmail, password);
        if (isLoggedIn) {
            System.out.println("Patient logged in successfully.");
        } else {
            System.out.println("Login failed.");
        }

        scanner.close();
    }
}
