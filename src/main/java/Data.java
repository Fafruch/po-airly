import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("currentMeasurements")
    private Measurements measurements;

    @SerializedName("history")
    private History[] history;

    public void printCurrentInfo () {
        System.out.println("Current sensor information: ");
        System.out.println(measurements.toString());
    }

    public void printHistoryInfo () {
        for(History historyMeasure : history) {
            System.out.println(historyMeasure.toString());
        }
    }
}