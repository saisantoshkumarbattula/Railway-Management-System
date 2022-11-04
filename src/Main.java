import Reservation.*;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Indian Railways");
        System.out.println("1.Reservation\n2.exit");
        int choice = s.nextInt();
        switch (choice) {
            case 1 -> ReservationFormValidator.getPassengerDetails();
            case 2 -> System.exit(0);
            default -> System.out.println("Invalid Entry");
        }
        System.out.println("Thank u for Using Indian Railways Online Booking System");
    }
}