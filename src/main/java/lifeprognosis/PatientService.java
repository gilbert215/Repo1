package lifeprognosis;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PatientService {
    
    // Method to complete registration
    public void completeRegistration(String uuid) {
        try {
            ProcessBuilder pb = new ProcessBuilder("bash", "scripts/user-manager.sh", "complete_registration", uuid);
            Process process = pb.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.out.println("Error during completing registration.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to log in
    public boolean login(String email, String password) {
        try {
            ProcessBuilder pb = new ProcessBuilder("bash", "scripts/user-manager.sh", "login_user", email, password);
            Process process = pb.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            
            int exitCode = process.waitFor();
            if (exitCode == 0 && line != null && line.equals("Login successful")) {
                return true;
            } else {
                System.out.println("Invalid email or password");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
