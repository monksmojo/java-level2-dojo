package Java2Exercise.Q7;

public class Q7SecondConversion {
    public void convertSecond(int totalSec){
        int day = totalSec / (24 * 3600);

        totalSec = totalSec % (24 * 3600);
        int hour = totalSec / 3600;

        totalSec %= 3600;
        int minutes = totalSec / 60 ;

        totalSec %= 60;
        int seconds = totalSec;

        System.out.println( day + " " + "days " + hour
                + " " + "hours " + minutes + " "
                + "minutes " + seconds + " "
                + "seconds ");
    }
}
