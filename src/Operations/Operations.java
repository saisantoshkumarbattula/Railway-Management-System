package Operations;

import Admin.AdminFunctionality;
import Cancellation.CancellationDetailsValidator;
import Login.AdminLogin;
import Reservation.ReservationFormValidator;
import Login.UserLogin;
import Reservation.ReservedPassengers;

import java.util.Scanner;

public class Operations {
    static Scanner s = new Scanner(System.in);

    public void doOperation() {
        while (true) {
            System.out.println("Welcome to Indian Railways");
            System.out.println("1.User Login\n2.Admin Login\n3.Exit");
            int choice = s.nextInt();
            if (choice == 1) {
                UserLogin login = new UserLogin();
                if (login.check()) {
                    userOperations();
                } else {
                    System.out.println("U r User login credentials did not match , please try again later 😊");
                }
            } else if (choice == 2) {
                AdminLogin login = new AdminLogin();
                if (login.check()) {
                    adminOperations();
                } else {
                    System.out.println("U r Admin login credentials did not match , please try again later 😊");
                }
            } else if (choice == 3) {
                System.out.println("Thank u for Using Indian Railways Online Booking System 😊😊😊\n");
                System.exit(0);
            }
        }
    }

    private void adminOperations() {
        while (true) {
            System.out.println("Welcome to Indian Railways");
            System.out.println("1.Admin Operations\n2.Main Menu\n3.exit");
            int choice = s.nextInt();
            switch (choice) {
                case 1 -> new AdminFunctionality().adminFunctions();
                case 2 -> new Operations().doOperation();
                case 3 -> {
                    System.out.println("Thank u for Using Indian Railways Online Booking System 😊😊😊\n");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Entry");
            }
        }
    }

    public void goBackAdmin() {
        adminOperations();
    }

    public void goBackUser() {
        userOperations();
    }

    private void userOperations() {
        while (true) {
            System.out.println("Welcome to Indian Railways");
            System.out.println("1.Reservation\n2.Cancel ticket\n3.Show Ticket\n4.Main Menu\n5.exit");
            int choice = s.nextInt();
            switch (choice) {
                case 1 -> ReservationFormValidator.getDetails();
                case 2 -> new CancellationDetailsValidator().getDetails();
                case 3 -> {
                    if (ReservedPassengers.passengerReserved.size() == 0)
                        System.out.println("No Reserved Tickets Found 🥲");
                    else {
                        System.out.println("***** Ticket *****");
                        ReservedPassengers.passengerReserved.forEach(System.out::println);
                    }
                }
                case 4 -> new Operations().doOperation();
                case 5 -> {
                    System.out.println("Thank u for Using Indian Railways Online Booking System 😊😊😊\n");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Entry");
            }
            System.out.println("Thank u for Using Indian Railways Online Booking System 😊😊😊\n");
        }
    }
}
