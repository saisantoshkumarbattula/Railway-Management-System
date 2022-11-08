package Reservation;


import java.util.StringJoiner;

public class ReservationForm {
    public String passengerName;
    public String phoneNo;
    public String address;
    public int trainNo;
    public String trainName;
    public String dateOfJourney;
    public String fromStation;
    public String toStation;
    public String coach;
    public String purposeOfJourney;
    public String modeOfPayment;
    public int noOfPassengersIncludingU;

    public ReservationForm(String passengerName, String phoneNo, String address, int trainNo, String trainName, String dateOfJourney, String fromStation, String toStation, String coach, String purposeOfJourney, String modeOfPayment, int noOfPassengersIncludingU) {
        this.passengerName = passengerName;
        this.phoneNo = phoneNo;
        this.address = address;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.dateOfJourney = dateOfJourney;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.coach = coach;
        this.purposeOfJourney = purposeOfJourney;
        this.modeOfPayment = modeOfPayment;
        this.noOfPassengersIncludingU = noOfPassengersIncludingU;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReservationForm.class.getSimpleName() + "[", "]")
                .add("passengerName='" + passengerName + "'")
                .add("phoneNo='" + phoneNo + "'")
                .add("address='" + address + "'")
                .add("trainNo=" + trainNo)
                .add("trainName='" + trainName + "'")
                .add("dateOfJourney='" + dateOfJourney + "'")
                .add("fromStation='" + fromStation + "'")
                .add("toStation='" + toStation + "'")
                .add("coach='" + coach + "'")
                .add("purposeOfJourney='" + purposeOfJourney + "'")
                .add("modeOfPayment='" + modeOfPayment + "'")
                .add("noOfPassengersIncludingU=" + noOfPassengersIncludingU)
                .toString();
    }
}
