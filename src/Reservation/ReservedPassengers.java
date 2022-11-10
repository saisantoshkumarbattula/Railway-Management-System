package Reservation;

import java.util.LinkedList;
import java.util.List;

public class ReservedPassengers {
    public static List<ReservedPassengers> passengerReserved = new LinkedList<>();
    public String passengerName;
    public String phoneNo;
    public String address;
    public String pnr;
    public int trainNo;
    public String trainName;
    public String dateOfJourney;
    public String fromStation;
    public String toStation;
    public String coach;
    public String purposeOfJourney;
    public String modeOfPayment;
    public int noOfPassengers;
    public int totalCost;

    public ReservedPassengers(String passengerName, String phoneNo, String address, String pnr, int trainNo, String trainName, String dateOfJourney, String fromStation, String toStation, String coach, String purposeOfJourney, String modeOfPayment, int noOfPassengers, int totalCost) {
        this.passengerName = passengerName;
        this.phoneNo = phoneNo;
        this.address = address;
        this.pnr = pnr;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.dateOfJourney = dateOfJourney;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.coach = coach;
        this.purposeOfJourney = purposeOfJourney;
        this.modeOfPayment = modeOfPayment;
        this.noOfPassengers = noOfPassengers;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return  "passengerName = " + passengerName + "\n" +
                "phoneNo = " + phoneNo + "\n" +
                "address = " + address + "\n" +
                "Pnr No  = " + pnr + "\n" +
                "trainNo = " + trainNo + "\n" +
                "trainName = " + trainName + "\n" +
                "dateOfJourney = " + dateOfJourney + "\n" +
                "fromStation = " + fromStation + "\n" +
                "toStation = " + toStation + "\n" +
                "coach = " + coach + "\n" +
                "purposeOfJourney = " + purposeOfJourney + "\n" +
                "modeOfPayment = " + modeOfPayment + "\n" +
                "noOfPassengers = " + noOfPassengers + "\n" +
                "totalCost = " + totalCost + "\n";
    }

}
