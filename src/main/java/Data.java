import com.google.gson.annotations.SerializedName;

import java.text.ParseException;

public class Data {
    @SerializedName("currentMeasurements")
    private Measurements measurements;

    @SerializedName("history")
    private History[] history;

    public void printCurrentInfo() {
        System.out.println("----------------------------------");
        System.out.println("|   Current sensor information   |");
        System.out.println("----------------------------------");
        System.out.println();
        printMeasurements();
    }

    public void printHistoryInfo() throws ParseException {
        System.out.println("-----------------------------------");
        System.out.println("|  Historical sensor information  |");

        for (int i = history.length - 1; i >= 0; i--) {
            history[i].printInfo();
        }
    }

    private void printMeasurements() {
        OutColor outColor = new OutColor();

        if(measurements != null) {
            measurements.printInfo();
        } else {
            outColor.switchTo(Color.GREY);
            System.out.println("no data :(");
            outColor.switchTo(Color.WHITE);
        }
    }
}