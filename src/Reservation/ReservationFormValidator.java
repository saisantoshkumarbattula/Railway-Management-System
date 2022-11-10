package Reservation;

import Trains.AvailableTrains;
import Trains.Train;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static Reservation.ReservedPassengers.passengerReserved;
import static Reservation.Validator.*;

public class ReservationFormValidator {

    static Scanner s = new Scanner(System.in);
    static int trainNumber = 0;

    public static void getDetails() {
        System.out.println("Enter passenger Name : ");
        String passengerName = s.nextLine();
        System.out.println("Enter ur phone no");
        String phoneNo = s.nextLine();
        System.out.println("Enter address : ");
        String address = s.nextLine();
        System.out.println("Enter train No :");
        int trainNo = s.nextInt();
        s.nextLine();
        System.out.println("Enter train Name :");
        String trainName = s.nextLine();
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
        ReservationForm form = new ReservationForm(passengerName, phoneNo,address, trainNo,trainName, dateOfJourney, fromStation, toStation, coach, purposeOfJourney, modeOfPayment, noOfPassengers);
        detailsValidator(form);
    }
    private static Validator getValidationResult(ReservationForm form){
        if(!fromAndToValidator(form)){
            return NoFromStationFound_Or_NoToStationFound;
        } else if (!dateValidator(form.dateOfJourney)){
            return InvalidDateOfJourney;
        } else if (!seatsAvailableInCoach(form)){
            return NoSeatsAvailable;
        } else if (!paymentModeCheck(form)) {
            return InvalidModeOfPayment;
        } else {
            return Successful;
        }
    }

    private static void detailsValidator(ReservationForm form) {
        Validator validator = getValidationResult(form);
        int totalFare = 0;
        if (validator.toString().equalsIgnoreCase("successful")) {
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
                    passengerReserved.add(
                            new ReservedPassengers(
                                    form.passengerName,
                                    form.phoneNo,
                                    form.address,
                                    generatePnr(),
                                    form.trainNo,
                                    form.trainName,
                                    form.dateOfJourney,
                                    form.fromStation,
                                    form.toStation,
                                    form.coach,
                                    form.purposeOfJourney,
                                    form.modeOfPayment,
                                    form.noOfPassengersIncludingU,
                                    totalFare * form.noOfPassengersIncludingU));
                    System.out.println();
                    System.out.println("***** Reservation Details *****");
                    System.out.println("Passenger Name : " + form.passengerName);
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
    private static String generatePnr() {
        Random r = new Random();
        String numbers = "01234546789";
        StringBuilder b = new StringBuilder();
        int i = 3;
        while (i-- > 0) {
            b.append(numbers.charAt(r.nextInt(numbers.length())));
        }
        b.append("-");
        i = 7;
        while (i-- > 0) {
            b.append(numbers.charAt(r.nextInt(numbers.length())));
        }
        return b.toString();
    }

    private static boolean paymentModeCheck(ReservationForm form) {
        return form.modeOfPayment.equalsIgnoreCase("cash") || form.modeOfPayment.equalsIgnoreCase("online");
    }

    private static boolean dateValidator(String dateOfJourney) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = null;
        LocalDate date2 = null;
        try {
            date1 = LocalDate.parse(dateOfJourney, formatter);
            date2 = LocalDate.parse(formatter.format(now), formatter);
        } catch (Exception e) {
            System.out.println("InvalidDate -> Leading to Parse Exception please check the format dd/MM/yyyy");
        }
        long daysBetween = ChronoUnit.DAYS.between(Objects.requireNonNull(date2), date1);
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


}

/*
nira
987654321
hyd
17254
17/04/2023
secundrabad
nagarsole
1st ac
holiday
online
5

nira
987654321
17254
17/04/2023
 */