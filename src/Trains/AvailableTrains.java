package Trains;

import java.util.List;

public class AvailableTrains {
    public static final List<Train> trains =
            List.of(
                    new Train(17012, "Ajanta", "Munmad", "Secundrabad", "runs daily", 30, 70, 140, 864, "8:50 PM", "9:20 AM", 300),

                    new Train(17254, "Nagarsole SF Express", "Secundrabad", "Nagarsole", "runs daily", 25, 100, 150, 900, "8:00 PM", "7:10 AM", 450),

                    new Train(17040, "Falaknama", "Secundrabad", "Howrah", "daily", 70, 150, 200, 800, "4:10 AM", "6:30 PM", 530)
            );

}
