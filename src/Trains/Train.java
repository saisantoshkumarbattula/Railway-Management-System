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
    public final int baseFair = 300;

    public Train(int trainNo, String trainName, String fromLocation, String toLocation, String trainRunningDate, int totalSeatsInFirstAc, int totalSeatsInSecondAc, int totalSeatsInThirdAc, int totalSeatsInSleeper) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.trainRunningDate = trainRunningDate;
        this.totalSeatsInFirstAc = totalSeatsInFirstAc;
        this.totalSeatsInSecondAc = totalSeatsInSecondAc;
        this.totalSeatsInThirdAc = totalSeatsInThirdAc;
        this.totalSeatsInSleeper = totalSeatsInSleeper;
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


}
