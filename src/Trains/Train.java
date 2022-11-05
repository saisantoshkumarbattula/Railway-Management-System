package Trains;

public class Train {
    public int trainNo;
    public String trainName;
    public String fromLocation;
    public String toLocation;
    public String trainRunningDate;
    public int totalSeatsInFirstAc;
    public int totalSeatsInSecondAc;
    public int totalSeatsInThirdAc;
    public int totalSeatsInSleeper;
    public String sourceDepartureTime;
    public String destinationArrivalTime;
    public int trainFair;

    public Train(int trainNo, String trainName, String fromLocation, String toLocation, String trainRunningDate, int totalSeatsInFirstAc, int totalSeatsInSecondAc, int totalSeatsInThirdAc, int totalSeatsInSleeper, String sourceDepartureTime, String destinationArrivalTime, int trainFair) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.trainRunningDate = trainRunningDate;
        this.totalSeatsInFirstAc = totalSeatsInFirstAc;
        this.totalSeatsInSecondAc = totalSeatsInSecondAc;
        this.totalSeatsInThirdAc = totalSeatsInThirdAc;
        this.totalSeatsInSleeper = totalSeatsInSleeper;
        this.sourceDepartureTime = sourceDepartureTime;
        this.destinationArrivalTime = destinationArrivalTime;
        this.trainFair = trainFair;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public void setTotalSeatsInFirstAc(int totalSeatsInFirstAc) {
        this.totalSeatsInFirstAc = totalSeatsInFirstAc;
    }


    public void setTotalSeatsInSecondAc(int totalSeatsInSecondAc) {
        this.totalSeatsInSecondAc = totalSeatsInSecondAc;
    }


    public void setTotalSeatsInThirdAc(int totalSeatsInThirdAc) {
        this.totalSeatsInThirdAc = totalSeatsInThirdAc;
    }


    public void setTotalSeatsInSleeper(int totalSeatsInSleeper) {
        this.totalSeatsInSleeper = totalSeatsInSleeper;
    }


    public void setSourceDepartureTime(String sourceDepartureTime) {
        this.sourceDepartureTime = sourceDepartureTime;
    }


    public void setDestinationArrivalTime(String destinationArrivalTime) {
        this.destinationArrivalTime = destinationArrivalTime;
    }

    public void setTrainFair(int trainFair) {
        this.trainFair = trainFair;
    }

    @Override
    public String toString() {
        return "Train Details\n" + "trainNo = " + trainNo + "\n" +
                "trainName = " + trainName + "\n" +
                "fromLocation = " + fromLocation + "\n" +
                "toLocation = " + toLocation + "\n" +
                "trainRunningDate = " + trainRunningDate + "\n" +
                "totalSeatsInFirstAc = " + totalSeatsInFirstAc + "\n" +
                "totalSeatsInSecondAc = " + totalSeatsInSecondAc + "\n" +
                "totalSeatsInThirdAc = " + totalSeatsInThirdAc + "\n" +
                "totalSeatsInSleeper = " + totalSeatsInSleeper + "\n" +
                "sourceDepartureTime = " + sourceDepartureTime + "\n" +
                "destinationArrivalTime = " + destinationArrivalTime + "\n" +
                "trainFair = " + trainFair + "\n";
    }

}
