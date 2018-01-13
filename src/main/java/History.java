import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class History {
    @SerializedName("fromDateTime")
    private String fromDateTime;

    @SerializedName("tillDateTime")
    private String tillDateTime;

    @SerializedName("measurements")
    private Measurements measurements;

    public void printInfo() throws ParseException {
        System.out.println("-----------------------------------");
        System.out.println("|         " + getFormattedTimeFor(tillDateTime) + " - " + getFormattedTimeFor(fromDateTime) + "           |");
        System.out.println("-----------------------------------");
        System.out.println();
        printMeasurements();
        System.out.println();
    }

    private void printMeasurements() {
        OutColor outColor = new OutColor();

        if (measurements != null) {
            measurements.printInfo();
        } else {
            outColor.switchTo(Color.GREY);
            System.out.println("no data for this time range :(");
            outColor.switchTo(Color.WHITE);
        }
    }

    private String getFormattedTimeFor(String dateTime) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Date date = dateFormat.parse(dateTime);

        // workaround for deprecated Date .getHours(), getMinutes() and so on methods
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        return String.format(
                "%02d:%02d",
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE)
        );
    }
}