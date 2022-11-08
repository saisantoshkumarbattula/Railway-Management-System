package Cancellation;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Reservation.ReservationFormValidator;
import Reservation.ReservedPassengers;

public class CancellationDetailsValidator {
    public final double cancellationFee = 120;
    public final int GST = 18;

    Scanner s = new Scanner(System.in);
    public void getDetails(){
        System.out.println("Enter ur Name : ");
        String passengerName = s.nextLine();
        System.out.println("Enter ur phoneNo : ");
        String phNo = s.nextLine();
        System.out.println("Enter ur Train No : ");
        int trainNo = s.nextInt();
        s.nextLine();
        System.out.println("Enter ur Date of Journey : ");
        String dateOfJourney = s.nextLine();
        CancellationForm form = new CancellationForm(passengerName, phNo, trainNo, dateOfJourney);
        boolean validateResult = validateDetails(form);
        if (validateResult)
            cancelTickets(form);
        else
            System.out.println("No details found 😒");
    }

    private void cancelTickets(CancellationForm form) {
        boolean cancellationResult;
        ReservedPassengers cancelled;
        double deductedAmount;
        List<ReservedPassengers> allReservedPassengers = ReservedPassengers.passengerReserved;
        for (int i = 0; i < Objects.requireNonNull(allReservedPassengers).size(); i++) {
            ReservedPassengers current = allReservedPassengers.get(i);
            if (current.trainNo == form.trainNo) {
                deductedAmount =   cancellationFee + ((float)GST/100 * current.totalCost);
                cancelled = new ReservedPassengers(
                        current.passengerName,
                        current.phoneNo,
                        current.address,
                        current.pnr,
                        current.trainNo,
                        current.trainName,
                        current.dateOfJourney,
                        current.fromStation,
                        current.toStation,
                        current.coach,
                        current.purposeOfJourney,
                        current.modeOfPayment,
                        current.noOfPassengers,
                        current.totalCost);
                cancellationResult = ReservationFormValidator.cancelTicket(form.trainNo, deductedAmount);
                if (cancellationResult) {
                    System.out.println("**** Ticket Cancelled Successfully ****");
                    CancellationForm.cancelledPassengerList.add(cancelled);
                    System.out.println(cancelled);
                    System.out.println("Amount deducted : " + Math.round(deductedAmount));
                    System.out.println("Refund Amount : " + (int) Math.round(cancelled.totalCost - deductedAmount));
                }
                break;
            }
        }
    }

    private boolean validateDetails(CancellationForm form) {
        boolean validationResult = false;
        List<ReservedPassengers> allReservedPassengers = ReservedPassengers.passengerReserved;
        try{
            if (!allReservedPassengers.isEmpty()) {
                validationResult = allReservedPassengers.stream()
                        .anyMatch(current -> current.passengerName.equalsIgnoreCase(form.passengerName)
                                && current.phoneNo.equalsIgnoreCase(form.phoneNo)
                                && current.trainNo == form.trainNo
                                && current.dateOfJourney.equalsIgnoreCase(form.dateOfJourney));
            }
        }catch (NullPointerException e){
            System.out.println("No Passenger reserved, make sure u have a valid ticket");
        }
        return validationResult;
    }
}
