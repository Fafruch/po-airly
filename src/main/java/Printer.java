import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Printer {
    private Data data;
    private boolean history;

    public Printer (Data data, UserInput userInput) {
        this.data = data;
        this.history = userInput.history;
    }

    public void printData() throws ParseException {
        printCurrentInfo();

        if(history) {
            printHistoryInfo();
        }
    }



    ///region Current info

    private void printCurrentInfo() {
        System.out.println("----------------------------------");
        System.out.println("|   Current sensor information   |");
        System.out.println("----------------------------------");
        System.out.println();
        printMeasurements();
    }

    private void printMeasurements() {
        OutColor outColor = new OutColor();

        if(data.measurements != null) {
            printMeasurementsInfo(data.measurements);
        } else {
            outColor.switchTo(Color.GREY);
            System.out.println("no data :(");
            outColor.switchTo(Color.WHITE);
        }
    }

    ///endregion



    ///region Historical info

    private void printHistoryInfo() throws ParseException {
        System.out.println("-----------------------------------");
        System.out.println("|  Historical sensor information  |");

        for (int i = data.history.length - 1; i >= 0; i--) {
            System.out.println("-----------------------------------");
            System.out.println("|         " + getFormattedTimeFor(data.history[i].tillDateTime) + " - " + getFormattedTimeFor(data.history[i].fromDateTime) + "           |");
            System.out.println("-----------------------------------");
            System.out.println();
            printHistoryMeasurements(data.history[i].measurements);
            System.out.println();
        }
    }

    private void printHistoryMeasurements(Measurements measurements) {
        OutColor outColor = new OutColor();

        if (measurements != null) {
            printMeasurementsInfo(measurements);
        } else {
            outColor.switchTo(Color.GREY);
            System.out.println("no data for this time range :(");
            outColor.switchTo(Color.WHITE);
        }
    }

    ///endregion



    ///region Universal methods

    private void printMeasurementsInfo(Measurements measurements) {
        printFafbot(measurements);
        printAqi(measurements);
        printPm25(measurements);
        printPm10(measurements);
        printPressure(measurements);
        printHumidity(measurements);
        printTemperature(measurements);

        System.out.println();
        System.out.println();
    }

    private void printFafbot(Measurements measurements) {
        Fafbot fafbot = new Fafbot();

        if (measurements.aqi == null) {
            fafbot.confused();
        } else {
            if (measurements.aqi < 30) {
                fafbot.happy();
            } else if (measurements.aqi < 60) {
                fafbot.satisfied();
            } else if (measurements.aqi < 100) {
                fafbot.joyless();
            } else {
                fafbot.dying();
            }
        }
    }

    private void printAqi(Measurements measurements) {
        OutColor outColor = new OutColor();

        System.out.print("AQI:         ");
        if (measurements.aqi == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);
        } else {
            if (measurements.aqi < 30) {
                outColor.switchTo(Color.BLUE);
            } else if (measurements.aqi < 60) {
                outColor.switchTo(Color.GREEN);
            } else if (measurements.aqi < 100) {
                outColor.switchTo(Color.YELLOW);
            } else {
                outColor.switchTo(Color.RED);
            }

            System.out.println(Round.to(2, measurements.aqi));
            outColor.switchTo(Color.WHITE);
        }
    }

    private void printPm25(Measurements measurements) {
        OutColor outColor = new OutColor();

        System.out.print("PM 2,5:      ");
        if (measurements.pm25 == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);

        } else {
            if (measurements.pm25 < 15) {
                outColor.switchTo(Color.BLUE);
            } else if (measurements.pm25 < 40) {
                outColor.switchTo(Color.GREEN);
            } else if (measurements.pm25 < 90) {
                outColor.switchTo(Color.YELLOW);
            } else {
                outColor.switchTo(Color.RED);
            }

            System.out.print(Round.to(2, measurements.pm25));
            outColor.switchTo(Color.WHITE);

            System.out.println(" μg/m^3");
        }
    }

    private void printPm10(Measurements measurements) {
        OutColor outColor = new OutColor();

        System.out.print("PM 10:       ");
        if (measurements.pm10 == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);

        } else {
            if (measurements.pm10 < 30) {
                outColor.switchTo(Color.BLUE);
            } else if (measurements.pm10 < 60) {
                outColor.switchTo(Color.GREEN);
            } else if (measurements.pm10 < 150) {
                outColor.switchTo(Color.YELLOW);
            } else {
                outColor.switchTo(Color.RED);
            }

            System.out.print(Round.to(2, measurements.pm10));
            outColor.switchTo(Color.WHITE);

            System.out.println(" μg/m^3");
        }
        outColor.switchTo(Color.WHITE);
    }

    private void printPressure(Measurements measurements) {
        OutColor outColor = new OutColor();

        System.out.print("Pressure:    ");
        if (measurements.pressure == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);
        } else {
            System.out.println(Round.to(2, measurements.pressure / 100) + " hPa");
        }
    }

    private void printHumidity(Measurements measurements) {
        OutColor outColor = new OutColor();

        System.out.print("Humidity:    ");
        if (measurements.humidity == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);
        } else {
            System.out.println(Round.to(2, measurements.humidity) + " %");
        }
    }

    private void printTemperature(Measurements measurements) {
        OutColor outColor = new OutColor();

        System.out.print("Temperature: ");
        if (measurements.temperature == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);
        } else {
            System.out.println(Round.to(2, measurements.temperature) + "\u00b0" + "C");
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

    ///endregion
}
