package Login;

import java.util.Scanner;

public class UserLogin {
    static final int defaultUserId = 1702;
    static final int defaultPassword = 17;
    static Scanner s = new Scanner(System.in);

    public boolean check() {
        return validateUserLoginDetails();
    }

    private int getUserId() {
        System.out.println("Enter ur user id : ");
        return s.nextInt();
    }

    private int getPassword() {
        System.out.println("Enter password : ");
        return s.nextInt();
    }

    private boolean validateUserLoginDetails() {
        int attempts = 3;
        while (attempts-- >= 1) {
            int userId = getUserId();
            int password = getPassword();
            if (defaultUserId != userId) {
                System.out.println("Invalid user id");
            }
            if (defaultPassword != password) {
                System.out.println("Invalid password");
            }
            System.out.println();
            if (defaultUserId == userId && defaultPassword == password) {
                return true;
            }
            if (attempts != 0)
                System.out.println("No of attempts : " + attempts);
        }
        return false;
    }
}
