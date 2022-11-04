package Reservation;

public class ReservedPassengers {
    public String passengerName;
    public String address;
    public String dateOfJourney;
    public String fromStation;
    public String toStation;
    public String coach;
    public String purposeOfJourney;
    public String modeOfPayment;
    public int noOfPassengers;
    public final int totalCost;

    public ReservedPassengers(String passengerName, String address, String dateOfJourney, String fromStation, String toStation, String coach, String purposeOfJourney, String modeOfPayment, int noOfPassengers, int totalCost) {
        this.passengerName = passengerName;
        this.address = address;
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
        return "ReservedPassengers{" +
                "passengerName='" + passengerName + '\'' +
                ", address='" + address + '\'' +
                ", dateOfJourney='" + dateOfJourney + '\'' +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", coach='" + coach + '\'' +
                ", purposeOfJourney='" + purposeOfJourney + '\'' +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", noOfPassengers=" + noOfPassengers +
                ", totalCost=" + totalCost +
                '}';
    }
}
