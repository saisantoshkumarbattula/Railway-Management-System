package Login;

import java.util.Scanner;

public class AdminLogin {
    private static final int defaultAdminId = 1704021002;
    private static final String defaultAdminPassword = "santhu";
    static Scanner s = new Scanner(System.in);
    public boolean check(){
        return validateAdminLoginDetails();
    }
    private int getAdminId() {
        System.out.println("Enter ur Admin id : ");
        int id = s.nextInt();
        s.nextLine();
        return id;
    }

    private String getAdminPassword() {
        System.out.println("Enter password : ");
        return s.nextLine();
    }
    private boolean validateAdminLoginDetails(){
        int attempts = 3;
        while (attempts-- >= 1) {
            int adminId = getAdminId();
            String password = getAdminPassword();
            if (defaultAdminId != adminId) {
                System.out.println("Invalid user id");
            }
            if (!defaultAdminPassword.equals(password)) {
                System.out.println("Invalid password");
            }
            System.out.println();
            if (defaultAdminId == adminId && defaultAdminPassword.equals(password)) {
                return true;
            }
            if (attempts != 0)
                System.out.println("No of attempts : " + attempts);
        }
        return false;
    }

}
