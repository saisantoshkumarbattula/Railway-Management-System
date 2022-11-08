package UserOperations;

import Admin.AdminFunctionality;
import Cancellation.CancellationDetailsValidator;
import Reservation.ReservationFormValidator;

import java.util.Scanner;

public class Operations {
    static Scanner s = new Scanner(System.in);
    public void doOperation() {
        while (true) {
            System.out.println("Welcome to Indian Railways");
            System.out.println("1.Reservation\n2.Admin Operations\n3.Cancel ticket\n4.exit");
            int choice = s.nextInt();
            switch (choice) {
                case 1 -> ReservationFormValidator.entryPassengerDetails();
                case 2 -> new AdminFunctionality().adminFunctions();
                case 3 -> new CancellationDetailsValidator().getDetails();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid Entry");
            }
            System.out.println("Thank u for Using Indian Railways Online Booking System\n");
        }
    }
}
