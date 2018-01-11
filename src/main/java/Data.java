import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("currentMeasurements")
    private Measurements measurements;

    @SerializedName("history")
    private History[] history;

    public void printCurrentInfo () {
        System.out.println("------------------------------");
        System.out.println("| Current sensor information |");
        System.out.println("------------------------------");
        measurements.printInfo();
    }

    public void printHistoryInfo () {
        System.out.println("---------------------------------");
        System.out.println("| Historical sensor information |");
        System.out.println("---------------------------------");
        for(int i = history.length - 1; i >= 0; i--) {
            history[i].printInfo();
        }
    }
}