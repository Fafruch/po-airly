import com.google.gson.annotations.SerializedName;

public class History {
    private String fromDateTime, tillDateTime;

    @SerializedName("measurements")
    private Measurements measurements;

    public void printInfo() {
        System.out.println("Sensor information from: " + fromDateTime + " to: " + tillDateTime);
        measurements.printInfo();
    }
}