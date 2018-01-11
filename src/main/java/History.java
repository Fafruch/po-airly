import com.google.gson.annotations.SerializedName;

public class History {
    private String fromDateTime, tillDateTime;

    @SerializedName("measurements")
    private Measurements measurements;

    @Override
    public String toString() {
        return "Sensor information from: " + fromDateTime + " to: " + tillDateTime + "\n"
                + measurements.toString() + "\n";
    }
}