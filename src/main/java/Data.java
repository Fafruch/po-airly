import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("currentMeasurements")
    private Measurements measurements;

    @SerializedName("history")
    private History[] history;

    public void printCurrentInfo () {
        System.out.println("Current sensor information: ");
        measurements.printInfo();
    }

    public void printHistoryInfo () {
        for(History historyMeasure : history) {
            historyMeasure.printInfo();
        }
    }
}