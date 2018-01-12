import com.google.gson.annotations.SerializedName;

public class History {
    @SerializedName("fromDateTime")
    private String fromDateTime;

    @SerializedName("tillDateTime")
    private String tillDateTime;

    @SerializedName("measurements")
    private Measurements measurements;

    public void printInfo() {
        System.out.println("Sensor information");
        System.out.println("between: " + tillDateTime);
        System.out.println("    and: " + fromDateTime);
        System.out.println();
        if(measurements != null) {
            measurements.printInfo();
        }
    }
}