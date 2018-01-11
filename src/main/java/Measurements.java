public class Measurements {
    private double airQualityIndex, pm25, pm10, pressure, humidity, temperature;

    @Override
    public String toString() {
        return  "Air quality index: " + Round.to(airQualityIndex, 2) + "\n"
                + "Pm 2.5: " + Round.to(pm25, 2) + "\n"
                + "Pm 10: " + Round.to(pm10, 2) + "\n"
                + "Pressure: " + Round.to(pressure, 2) + "\n"
                + "Humidity: " + Round.to(humidity, 2) + "\n"
                + "Temperature: " + Round.to(temperature, 2) + "\n";
    }
}