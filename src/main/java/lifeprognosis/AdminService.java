package lifeprognosis;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdminService {
    
    // Method to initiate patient registration
    public void initiateRegistration(String email) {
        try {
            ProcessBuilder pb = new ProcessBuilder("bash", "scripts/user-manager.sh", "initiate_registration", email);
            Process process = pb.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.out.println("Error during initiating registration.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to export user data
    public void exportUserData() {
        try {
            ProcessBuilder pb = new ProcessBuilder("bash", "scripts/user-manager.sh", "export_user_data");
            Process process = pb.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.out.println("Error during exporting user data.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
