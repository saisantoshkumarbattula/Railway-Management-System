package Admin;

import Reservation.*;
import Trains.AvailableTrains;
import Trains.Train;
import UserOperations.Operations;

import java.util.List;
import java.util.Scanner;

public class AdminFunctionality {
    Scanner s = new Scanner(System.in);

    public void adminFunctions() {
        System.out.println("Enter admin id : ");
        int id = s.nextInt();
        int attempts = 3;
        while (!ReservationFormValidator.adminIdValidator(id)) {
            if (attempts == 1) {
                System.out.println("Sorry please try again later");
                System.exit(0);
            }
            System.out.println("No of attempts : " + --attempts);
            System.out.println("Incorrect Admin Id please enter again : ");
            id = s.nextInt();
        }
        while (true) {
            System.out.println("1. Get All Reserved Passengers List\n2.Show All Available Trains\n3.Update Train Information\n4.Main menu\n5.Exit");
            int choice = s.nextInt();
            switch (choice) {
                case 1 -> getAllReservedPassengersList();
                case 2 -> showAllAvailableTrains();
                case 3 -> updateTrainInformation();
                case 4 -> {
                    System.out.println("Main menu");
                    new Operations().doOperation();
                }
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void updateTrainInformation() {
        System.out.println("Enter train no u want to update info of : ");
        int trainNum = s.nextInt();
        boolean trainNoCheck = false;
        for (int i = 0; i < AvailableTrains.trains.size(); i++) {
            Train train = AvailableTrains.trains.get(i);
            if (train.trainNo == trainNum) {
                trainNoCheck = true;
                System.out.println("1.Update Train No\n2.Update Source departure time\n3.Update Destination Arrival time\n4.Update train fare\n5.Main menu\n6.Exit");
                int choice = s.nextInt();
                s.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter train new train no : ");
                        train.setTrainNo(s.nextInt());
                        s.nextLine();
                    }
                    case 2 -> {
                        System.out.println("Enter updated source destination time : ");
                        train.setSourceDepartureTime(s.nextLine());
                    }
                    case 3 -> {
                        System.out.println("Enter updated destination arrival time : ");
                        train.setDestinationArrivalTime(s.nextLine());
                    }
                    case 4 -> {
                        System.out.println("Enter new updated fair : ");
                        train.setTrainFair(s.nextInt());
                        s.nextLine();
                    }
                    case 5 -> {
                        System.out.println("Main menu");
                        new Operations().doOperation();
                    }
                    case 6 -> System.exit(0);
                    default -> System.out.println("Invalid Choice");
                }
            }
        }
        if (!trainNoCheck)
            System.out.println("Invalid Train No......");
    }

    private void showAllAvailableTrains() {
        System.out.println("Total Trains : " + AvailableTrains.trains.size());
        AvailableTrains.trains.forEach(System.out::println);
    }

    public void getAllReservedPassengersList() {
        List<ReservedPassengers> allReservedPassengers = ReservationFormValidator.getAllReservedPassengers();
        assert allReservedPassengers != null;
        try {
            if (!allReservedPassengers.isEmpty()) {
                System.out.println("Total Passengers Reserved : " + allReservedPassengers.size());
                System.out.println();
                allReservedPassengers.forEach(reservedPassengers -> {
                    System.out.println("passenger Name : " + reservedPassengers.passengerName);
                    System.out.println("Address : " + reservedPassengers.address);
                    System.out.println("Date of Journey : " + reservedPassengers.dateOfJourney);
                    System.out.println("From Station : " + reservedPassengers.fromStation);
                    System.out.println("To Station : " + reservedPassengers.toStation);
                    System.out.println("Coach : " + reservedPassengers.coach);
                    System.out.println("No of Passengers : " + reservedPassengers.noOfPassengers);
                    System.out.println("Total Cost : " + reservedPassengers.totalCost);
                    System.out.println();
                });
            }
        } catch (NullPointerException e) {
            System.out.println("All Reserved Passengers is Empty, so make sure that there is at least one Registration done");
        }
    }

}
