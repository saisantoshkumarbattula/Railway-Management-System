package Cancellation;

import Reservation.ReservedPassengers;

import java.util.LinkedList;
import java.util.List;

public class CancellationForm {
    public String passengerName;
    public String phoneNo;
    public int trainNo;
    public String dateOfJourney;
    public static List<ReservedPassengers> cancelledPassengerList = new LinkedList<>();
    public CancellationForm(String userName, String phoneNo, int trainNo, String dateOfJourney) {
        this.passengerName = userName;
        this.phoneNo = phoneNo;
        this.trainNo = trainNo;
        this.dateOfJourney = dateOfJourney;
    }
}
