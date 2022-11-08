package Admin;

import Cancellation.CancellationForm;
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
            System.out.println("1.Get All Reserved Passengers List\n2.Get All Cancelled Passengers List\n3.Show All Available Trains\n4.Update Train Information\n5.Main menu\n6.Exit");
            int choice = s.nextInt();
            switch (choice) {
                case 1 -> getAllReservedPassengersList();
                case 2 -> getAllCancelledPassengersList();
                case 3 -> showAllAvailableTrains();
                case 4 -> updateTrainInformation();
                case 5 -> {
                    System.out.println("Main menu");
                    new Operations().doOperation();
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
                        new Operations().doOperation();
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
        System.out.println("Total Trains : " + AvailableTrains.trains.size());
        AvailableTrains.trains.forEach(System.out::println);
    }

    public void getAllReservedPassengersList() {
        List<ReservedPassengers> allReservedPassengers = ReservedPassengers.passengerReserved;
        assert allReservedPassengers != null;
        try {
            if (!allReservedPassengers.isEmpty()) {
                System.out.println("Total Passengers Reserved : " + allReservedPassengers.size());
                System.out.println();
                allReservedPassengers.forEach(System.out::println);
            }
        } catch (NullPointerException e) {
            System.out.println("All Reserved Passengers is Empty, so make sure that there is at least one Registration done");
        }
    }
    public void getAllCancelledPassengersList(){
        List<ReservedPassengers> cancelledPassengers = CancellationForm.cancelledPassengerList;
        assert cancelledPassengers != null;
        try{
            System.out.println();
            System.out.println("Total Cancelled Tickets : " + cancelledPassengers.size());
            System.out.println();
            cancelledPassengers.forEach(System.out::println);
        }catch (NullPointerException e){
            System.out.println("No Cancelled Tickets found");
        }
    }

}
