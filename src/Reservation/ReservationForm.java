package Reservation;



public class ReservationForm {
    public String passengerName;
    public String address;
    public String dateOfJourney;
    public String fromStation;
    public String toStation;
    public String coach;
    public String purposeOfJourney;
    public String modeOfPayment;
    public int noOfPassengersIncludingU;

    public ReservationForm(String passengerName, String address, String dateOfJourney, String fromStation, String toStation, String coach, String purposeOfJourney, String modeOfPayment, int noOfPassengersIncludingU) {
        this.passengerName = passengerName;
        this.address = address;
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
        return "ReservationForm{" +
                "passengerName='" + passengerName + '\'' +
                ", address='" + address + '\'' +
                ", dateOfJourney='" + dateOfJourney + '\'' +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", coach='" + coach + '\'' +
                ", purposeOfJourney='" + purposeOfJourney + '\'' +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", noOfPassengersIncludingU=" + noOfPassengersIncludingU +
                '}';
    }
}
