public class Measurements {
    private Double airQualityIndex, pm25, pm10, pressure, humidity, temperature;

    public void printInfo() {
        printAqi();
        printPm25();
        printPm10();
        printPressure();
        printHumidity();
        printTemperature();

        System.out.println();
        System.out.println();
    }

    private void printAqi() {
        OutColor outColor = new OutColor();

        System.out.print("AQI:         ");
        if (airQualityIndex == null) {
            outColor.switchTo(Color.GREY);
            System.out.println("no data");
            outColor.switchTo(Color.WHITE);
        } else {
            if (airQualityIndex < 50) {
                outColor.switchTo(Color.BLUE);
            } else if (airQualityIndex < 100) {
                outColor.switchTo(Color.GREEN);
            } else if (airQualityIndex < 150) {
                outColor.switchTo(Color.YELLOW);
            } else {
                outColor.switchTo(Color.RED);
            }

            System.out.println(Round.to(2, airQualityIndex));
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
            if (pm25 < 25) {
                outColor.switchTo(Color.GREEN);
            } else if (pm25 < 100) {
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
            if (pm10 < 50) {
                outColor.switchTo(Color.GREEN);
            } else if (pm10 < 200) {
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