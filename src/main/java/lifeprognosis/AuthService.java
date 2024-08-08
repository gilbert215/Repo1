package lifeprognosis;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AuthService {
    public User login(String email, String password) {
        try {
            ProcessBuilder pb = new ProcessBuilder("bash", "scripts/user-manager.sh", "login_user", email, password);
            Process process = pb.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            
            // Parse output to determine user type and details
            // Example output handling
            if (output != null && output.contains("Admin")) {
                return new Admin("firstName", "lastName", email, password); // Replace with actual data
            } else if (output != null && output.contains("Patient")) {
                return new Patient("firstName", "lastName", email, password, "dob", true, "diagnosisDate", true, "artStartDate", "countryCode");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
