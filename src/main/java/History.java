import com.google.gson.annotations.SerializedName;

public class History {
    private String fromDateTime, tillDateTime;

    @SerializedName("measurements")
    private Measurements measurements;

    public void printInfo() {
        System.out.println("Sensor information");
        System.out.println("between: " + tillDateTime);
        System.out.println("    and: " + fromDateTime);
        System.out.println();
        measurements.printInfo();
    }
}