package Reservation;

import Trains.AvailableTrains;
import Trains.Train;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static Reservation.Validator.*;

public class ReservationFormValidator {
    static final List<ReservedPassengers> passengerReserved = new LinkedList<>();
    private static final int adminId = 143;
//    static List<Train> trains = AvailableTrains.trains;
    static Scanner s = new Scanner(System.in);
    static int trainNumber = 0;

    public static void entryPassengerDetails() {
        System.out.println("Enter passenger Name : ");
        String passengerName = s.nextLine();
        System.out.println("Enter address : ");
        String address = s.nextLine();
        System.out.println("Enter Date of Journey : (dd/mm/yyyy)");
        String dateOfJourney = s.nextLine();
        System.out.println("Enter From Station : ");
        String fromStation = s.nextLine();
        System.out.println("Enter To Station : ");
        String toStation = s.nextLine();
        System.out.println("Enter the coach u want to travel : (1AC, 2AC, 3AC, SLEEPER) ");
        String coach = s.nextLine();
        System.out.println("Enter Purpose Of Journey");
        String purposeOfJourney = s.nextLine();
        System.out.println("Enter Mode Of Payment");
        String modeOfPayment = s.nextLine();
        System.out.println("Enter no of passengers including u : ");
        int noOfPassengers = s.nextInt();
        s.nextLine();
        ReservationForm form = new ReservationForm(passengerName, address, dateOfJourney, fromStation, toStation, coach, purposeOfJourney, modeOfPayment, noOfPassengers);
        detailsValidator(form);
    }


    private static void detailsValidator(ReservationForm form) {
        String validator = "";
        validator += fromAndToValidator(form) ? "" : NoFromStationFound_Or_NoToStationFound + ", ";
        validator += validator.length() == 0 && dateValidator(form.dateOfJourney) ? "" : InvalidDateOfJourney + ", ";
        validator += validator.length() == 0 && seatsAvailableInCoach(form) ? "" : NoSeatsAvailable + ", ";
        validator += validator.length() == 0 && paymentModeCheck(form) ? "" : InvalidModeOfPayment + "";
        validator = validator.length() == 0 ? "successful" : validator;
        int totalFare = 0;
        if (validator.equalsIgnoreCase("successful")) {
            System.out.println("***** Reservation successful *****");
            for (Train train : AvailableTrains.trains) {
                if (train.trainNo == trainNumber) {
                    if (form.coach.equalsIgnoreCase("sleeper")) {
                        train.setTotalSeatsInSleeper(train.totalSeatsInSleeper - form.noOfPassengersIncludingU);
                        totalFare = train.trainFair;
                    }
                    if (form.coach.equalsIgnoreCase("third ac") || form.coach.equalsIgnoreCase("3rd ac") || form.coach.charAt(0) == '3') {
                        train.setTotalSeatsInThirdAc(train.totalSeatsInThirdAc - form.noOfPassengersIncludingU);
                        totalFare = train.trainFair * 2;
                    }
                    if (form.coach.equalsIgnoreCase("second ac") || form.coach.equalsIgnoreCase("2nd ac") || form.coach.charAt(0) == '2') {
                        train.setTotalSeatsInSecondAc(train.totalSeatsInThirdAc - form.noOfPassengersIncludingU);
                        totalFare = train.trainFair * 3;
                    }
                    if (form.coach.equalsIgnoreCase("first ac") || form.coach.equalsIgnoreCase("2nd ac") || form.coach.charAt(0) == '1') {
                        train.setTotalSeatsInFirstAc(train.totalSeatsInFirstAc - form.noOfPassengersIncludingU);
                        totalFare = train.trainFair * 4;
                    }
                    passengerReserved.add(new ReservedPassengers(form.passengerName, form.address, form.dateOfJourney, form.fromStation, form.toStation, form.coach, form.purposeOfJourney, form.modeOfPayment, form.noOfPassengersIncludingU, totalFare * form.noOfPassengersIncludingU));
                    System.out.println("***** Reservation Details *****");
                    System.out.println("Passenger Name : " + form.passengerName);
                    System.out.println("Reservation Successful");
                    System.out.println("***** Train Details *****");
                    System.out.println("Train No : " + train.trainNo);
                    System.out.println("Train Name : " + train.trainName);
                    System.out.println("From Location : " + train.fromLocation);
                    System.out.println("To Location : " + train.toLocation);
                    System.out.println("Date Of Journey : " + form.dateOfJourney);
                    System.out.println("Coach : " + form.coach);
                    System.out.println("Price per Ticket : " + totalFare);
                    System.out.println("Total fare rs : " + totalFare * form.noOfPassengersIncludingU);
                    System.out.println("We wish u a happy and safe Journey");
                }
            }
        } else {
            System.out.println("Some thing went wrong :");
            System.out.println(validator);
        }
    }

    private static boolean paymentModeCheck(ReservationForm form) {
        return form.modeOfPayment.equalsIgnoreCase("cash") || form.modeOfPayment.equalsIgnoreCase("online");
    }

    private static boolean dateValidator(String dateOfJourney) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(dateOfJourney, formatter);
        LocalDate date2 = LocalDate.parse(formatter.format(now), formatter);
        long daysBetween = ChronoUnit.DAYS.between(date2, date1);
        return daysBetween >= 1;
    }

    private static boolean fromAndToValidator(ReservationForm form) {
        for (Train train : AvailableTrains.trains) {
            if (train.fromLocation.equalsIgnoreCase(form.fromStation) && train.toLocation.equalsIgnoreCase(form.toStation)) {
                trainNumber = train.trainNo;
                return true;
            }
        }
        return false;
    }

    private static boolean seatsAvailableInCoach(ReservationForm form) {
        for (Train train : AvailableTrains.trains) {
            if (train.trainNo == trainNumber) {
                if (form.coach.equalsIgnoreCase("sleeper") && train.totalSeatsInSleeper > 0 && form.noOfPassengersIncludingU <= train.totalSeatsInSleeper) {
                    return true;
                }
                if (form.coach.equalsIgnoreCase("third ac") || form.coach.equalsIgnoreCase("3rd ac") || form.coach.charAt(0) == '3' && train.totalSeatsInThirdAc > 0 && form.noOfPassengersIncludingU <= train.totalSeatsInThirdAc) {
                    return true;
                }
                if (form.coach.equalsIgnoreCase("second ac") || form.coach.equalsIgnoreCase("2nd ac") || form.coach.charAt(0) == '2' && train.totalSeatsInSecondAc > 0 && form.noOfPassengersIncludingU <= train.totalSeatsInSecondAc) {
                    return true;
                }
                if (form.coach.equalsIgnoreCase("first ac") || form.coach.equalsIgnoreCase("1st ac") || form.coach.charAt(0) == '1' && train.totalSeatsInFirstAc > 0 && form.noOfPassengersIncludingU <= train.totalSeatsInFirstAc) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean adminIdValidator(int id) {
        return adminId == id;
    }

    public static List<ReservedPassengers> getAllReservedPassengers() {
//        if (adminIdValidator(id))
//            System.out.println("Incorrect admin id");
        if (passengerReserved.isEmpty())
            System.out.println("No passengers reserved");
        else
            return passengerReserved;
        return null;
    }
}

/*
nira
hyd
17/04/2023
secundrabad
nagarsole
1st ac
holiday
online
5
 */