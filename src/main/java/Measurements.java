public class Measurements {
    private double airQualityIndex, pm25, pm10, pressure, humidity, temperature;

    public void printInfo() {
        OutColor outColor = new OutColor();
        System.out.println("Air quality index: " + Round.to(2, airQualityIndex));


        System.out.print("PM 2,5: ");
        if(pm25 < 25) {
            outColor.switchTo(Color.GREEN);
        } else if (pm25 < 100) {
            outColor.switchTo(Color.YELLOW);
        } else {
            outColor.switchTo(Color.RED);
        }
        System.out.println(Round.to(2, pm25));
        outColor.switchTo(Color.WHITE);


        System.out.print("PM 10:  ");
        if(pm10 < 50) {
            outColor.switchTo(Color.GREEN);
        } else if (pm10 < 200) {
            outColor.switchTo(Color.YELLOW);
        } else {
            outColor.switchTo(Color.RED);
        }
        System.out.println(Round.to(2, pm10));
        outColor.switchTo(Color.WHITE);


        System.out.println("Pressure: " + Round.to(2, pressure));
        System.out.println("Humidity: " + Round.to(2, humidity));
        System.out.println("Temperature: " + Round.to(2, temperature));
        System.out.println();
    }
}