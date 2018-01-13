import com.google.gson.annotations.SerializedName;

public class Measurements {
    @SerializedName("airQualityIndex")
    private Double aqi;

    @SerializedName("pm25")
    private Double pm25;

    @SerializedName("pm10")
    private Double pm10;

    @SerializedName("pressure")
    private Double pressure;

    @SerializedName("humidity")
    private Double humidity;

    @SerializedName("temperature")
    private Double temperature;

    public void printInfo() {
        printFafbot();
        printAqi();
        printPm25();
        printPm10();
        printPressure();
        printHumidity();
        printTemperature();

        System.out.println();
        System.out.println();
    }

    private void printFafbot() {
        Fafbot fafbot = new Fafbot();

        if (aqi == null) {
            fafbot.confused();
        } else {
            if (aqi < 50) {
                fafbot.happy();
            } else if (aqi < 100) {
                fafbot.satisfied();
            } else if (aqi < 150) {
                fafbot.joyless();
            } else {
                fafbot.dying();
            }
        }
    }

    private void printAqi() {
        OutColor outColor = new OutColor();

        System.out.print("AQI:         ");
        if (aqi == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);
        } else {
            if (aqi < 50) {
                outColor.switchTo(Color.BLUE);
            } else if (aqi < 100) {
                outColor.switchTo(Color.GREEN);
            } else if (aqi < 150) {
                outColor.switchTo(Color.YELLOW);
            } else {
                outColor.switchTo(Color.RED);
            }

            System.out.println(Round.to(2, aqi));
            outColor.switchTo(Color.WHITE);
        }
    }

    private void printPm25() {
        OutColor outColor = new OutColor();

        System.out.print("PM 2,5:      ");
        if (pm25 == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);

        } else {
            if (pm25 < 15) {
                outColor.switchTo(Color.BLUE);
            } else if (pm25 < 40) {
                outColor.switchTo(Color.GREEN);
            } else if (pm25 < 90) {
                outColor.switchTo(Color.YELLOW);
            } else {
                outColor.switchTo(Color.RED);
            }

            System.out.print(Round.to(2, pm25));
            outColor.switchTo(Color.WHITE);

            System.out.println(" μg/m^3");
        }
    }

    private void printPm10() {
        OutColor outColor = new OutColor();

        System.out.print("PM 10:       ");
        if (pm10 == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);

        } else {
            if (pm10 < 30) {
                outColor.switchTo(Color.BLUE);
            } else if (pm10 < 60) {
                outColor.switchTo(Color.GREEN);
            } else if (pm10 < 150) {
                outColor.switchTo(Color.YELLOW);
            } else {
                outColor.switchTo(Color.RED);
            }

            System.out.print(Round.to(2, pm10));
            outColor.switchTo(Color.WHITE);

            System.out.println(" μg/m^3");
        }
        outColor.switchTo(Color.WHITE);
    }

    private void printPressure() {
        OutColor outColor = new OutColor();

        System.out.print("Pressure:    ");
        if (pressure == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);
        } else {
            System.out.println(Round.to(2, pressure / 100) + " hPa");
        }
    }

    private void printHumidity() {
        OutColor outColor = new OutColor();

        System.out.print("Humidity:    ");
        if (humidity == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);
        } else {
            System.out.println(Round.to(2, humidity) + " %");
        }
    }

    private void printTemperature() {
        OutColor outColor = new OutColor();

        System.out.print("Temperature: ");
        if (temperature == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);
        } else {
            System.out.println(Round.to(2, temperature) + "\u00b0" + "C");
        }
    }
}