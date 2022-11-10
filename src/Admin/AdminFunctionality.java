package Admin;

import Cancellation.CancellationForm;
import Reservation.*;
import Trains.AvailableTrains;
import Trains.Train;
import Operations.Operations;

import java.util.List;
import java.util.Scanner;

public class AdminFunctionality {
    Scanner s = new Scanner(System.in);

    public void adminFunctions() {
        while (true) {
            System.out.println("***** Admin *****");
            System.out.println("1.Get All Reserved Passengers List\n2.Get All Cancelled Passengers List\n3.Show All Available Trains\n4.Update Train Information\n5.Main menu\n6.Exit");
            int choice = s.nextInt();
            switch (choice) {
                case 1 -> getAllReservedPassengersList();
                case 2 -> getAllCancelledPassengersList();
                case 3 -> showAllAvailableTrains();
                case 4 -> updateTrainInformation();
                case 5 -> {
                    System.out.println("Main menu");
                    new Operations().goBackAdmin();
                }
                case 6 -> System.exit(0);
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
                        System.out.println("Train No Updated Successfully");
                        s.nextLine();
                    }
                    case 2 -> {
                        System.out.println("Enter updated source destination time : ");
                        train.setSourceDepartureTime(s.nextLine());
                        System.out.println("Source Departure Time Updated Successfully");
                    }
                    case 3 -> {
                        System.out.println("Enter updated destination arrival time : ");
                        train.setDestinationArrivalTime(s.nextLine());
                        System.out.println("Destination Arrival Time Updated Successfully");
                    }
                    case 4 -> {
                        System.out.println("Enter new updated fair : ");
                        train.setTrainFair(s.nextInt());
                        System.out.println("Train Fair Updated Successfully");
                        s.nextLine();
                    }
                    case 5 -> {
                        System.out.println("Main menu");
                        new Operations().goBackUser();
                    }
                    case 6 -> System.exit(0);
                    default -> System.out.println("Invalid Choice 🥲");
                }
            }
        }
        if (!trainNoCheck)
            System.out.println("Invalid Train No......🥲");
    }

    private void showAllAvailableTrains() {
        System.out.println("***** All Trains *****");
        System.out.println("Total Trains : " + AvailableTrains.trains.size());
        AvailableTrains.trains.forEach(System.out::println);
    }

    public void getAllReservedPassengersList() {
        List<ReservedPassengers> allReservedPassengers = ReservedPassengers.passengerReserved;
        try {
            System.out.println();
            if (allReservedPassengers.size() == 0) {
                System.out.println("***** No tickets found *****");
                System.out.println("Total Passengers Reserved : " + allReservedPassengers.size());
            }
            System.out.println();
            allReservedPassengers.forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("All Reserved Passengers is Empty, so make sure that there is at least one Registration done");
        }
    }

    public void getAllCancelledPassengersList() {
        List<ReservedPassengers> cancelledPassengers = CancellationForm.cancelledPassengerList;
        try {
            System.out.println();
            if (cancelledPassengers.size() == 0) {
                System.out.println("***** No tickets found *****");
                System.out.println("Total Cancelled Tickets : " + cancelledPassengers.size());
            }
            System.out.println();
            cancelledPassengers.forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("No Cancelled Tickets found");
        }
    }


}
