import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Printer {
    private Data data;
    private boolean showHistory;
    private boolean showPercent;
    int pm25Norm = 25;
    int pm10Norm = 50;

    public Printer (Data data, UserInput userInput) {
        this.data = data;
        this.showHistory = userInput.history;
        this.showPercent = userInput.percent;
    }

    public void printData() throws ParseException {
        printCurrentInfo();

        if(showHistory) {
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
        if(data.measurements != null) {
            printMeasurementsInfo(data.measurements);
        } else {
            OutColor.switchTo(Color.GREY);
            System.out.println("no data :(");
            OutColor.switchTo(Color.WHITE);
        }
    }

    ///endregion



    ///region Historical info

    private void printHistoryInfo() throws ParseException {
        System.out.println("-----------------------------------");
        System.out.println("|  Historical sensor information  |");

        for (int i = data.history.length - 1; i >= 0; i--) {
            System.out.println("-----------------------------------");
            System.out.println("|         " + getFormattedTimeFor(data.history[i].fromDateTime) + " - " + getFormattedTimeFor(data.history[i].tillDateTime) + "           |");
            System.out.println("-----------------------------------");
            System.out.println();
            printHistoryMeasurements(data.history[i].measurements);
            System.out.println();
        }
    }

    private void printHistoryMeasurements(Measurements measurements) {
        if (measurements != null) {
            printMeasurementsInfo(measurements);
        } else {
            OutColor.switchTo(Color.GREY);
            System.out.println("no data for this time range :(");
            OutColor.switchTo(Color.WHITE);
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
            OutColor.switchTo(Color.GREY);
            fafbot.confused();
            OutColor.switchTo(Color.WHITE);

        } else {
            if (measurements.aqi < 25) {
                OutColor.switchTo(Color.BLUE);
                fafbot.happy();
                OutColor.switchTo(Color.WHITE);

            } else if (measurements.aqi < 50) {
                OutColor.switchTo(Color.GREEN);
                fafbot.satisfied();
                OutColor.switchTo(Color.WHITE);

            } else if (measurements.aqi < 100) {
                OutColor.switchTo(Color.YELLOW);
                fafbot.joyless();
                OutColor.switchTo(Color.WHITE);

            } else {
                OutColor.switchTo(Color.RED);
                fafbot.dying();
                OutColor.switchTo(Color.WHITE);
            }
        }
    }

    private void printAqi(Measurements measurements) {
        System.out.print("AQI:         ");
        if (measurements.aqi == null) {
            OutColor.switchTo(Color.GREY);
            System.out.println("no data");
            OutColor.switchTo(Color.WHITE);
        } else {
            if (measurements.aqi < 25) {
                OutColor.switchTo(Color.BLUE);
            } else if (measurements.aqi < 50) {
                OutColor.switchTo(Color.GREEN);
            } else if (measurements.aqi < 100) {
                OutColor.switchTo(Color.YELLOW);
            } else {
                OutColor.switchTo(Color.RED);
            }

            System.out.println(Round.to(2, measurements.aqi));
            OutColor.switchTo(Color.WHITE);
        }
    }

    private void printPm25(Measurements measurements) {
        System.out.print("PM 2,5:      ");
        if (measurements.pm25 == null) {
            OutColor.switchTo(Color.GREY);
            System.out.println("no data");
            OutColor.switchTo(Color.WHITE);

        } else {
            if (measurements.pm25 < 13) {
                OutColor.switchTo(Color.BLUE);
            } else if (measurements.pm25 < 25) {
                OutColor.switchTo(Color.GREEN);
            } else if (measurements.pm25 < 75) {
                OutColor.switchTo(Color.YELLOW);
            } else {
                OutColor.switchTo(Color.RED);
            }

            if (showPercent) {
                System.out.print((int)((measurements.pm25 / pm25Norm) * 100));
                System.out.println(" %");

                OutColor.switchTo(Color.WHITE);
            } else {
                System.out.print(Round.to(2, measurements.pm25));
                OutColor.switchTo(Color.WHITE);

                System.out.println(" μg/m^3");
            }
        }
    }

    private void printPm10(Measurements measurements) {
        System.out.print("PM 10:       ");
        if (measurements.pm10 == null) {
            OutColor.switchTo(Color.GREY);
            System.out.println("no data");
            OutColor.switchTo(Color.WHITE);

        } else {
            if (measurements.pm10 < 25) {
                OutColor.switchTo(Color.BLUE);
            } else if (measurements.pm10 < 50) {
                OutColor.switchTo(Color.GREEN);
            } else if (measurements.pm10 < 150) {
                OutColor.switchTo(Color.YELLOW);
            } else {
                OutColor.switchTo(Color.RED);
            }

            if (showPercent) {
                System.out.print((int)((measurements.pm10 / pm10Norm) * 100));
                System.out.println(" %");

                OutColor.switchTo(Color.WHITE);
            } else {
                System.out.print(Round.to(2, measurements.pm10));
                OutColor.switchTo(Color.WHITE);

                System.out.println(" μg/m^3");
            }
        }
        OutColor.switchTo(Color.WHITE);
    }

    private void printPressure(Measurements measurements) {
        System.out.print("Pressure:    ");
        if (measurements.pressure == null) {
            OutColor.switchTo(Color.GREY);
            System.out.println("no data");
            OutColor.switchTo(Color.WHITE);
        } else {
            System.out.println(Round.to(2, measurements.pressure / 100) + " hPa");
        }
    }

    private void printHumidity(Measurements measurements) {
        System.out.print("Humidity:    ");
        if (measurements.humidity == null) {
            OutColor.switchTo(Color.GREY);
            System.out.println("no data");
            OutColor.switchTo(Color.WHITE);
        } else {
            System.out.println(Round.to(2, measurements.humidity) + " %");
        }
    }

    private void printTemperature(Measurements measurements) {
        System.out.print("Temperature: ");
        if (measurements.temperature == null) {
            OutColor.switchTo(Color.GREY);
            System.out.println("no data");
            OutColor.switchTo(Color.WHITE);
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
