import com.google.gson.annotations.SerializedName;

public class History {
    @SerializedName("fromDateTime")
    public String fromDateTime;

    @SerializedName("tillDateTime")
    public String tillDateTime;

    @SerializedName("measurements")
    public Measurements measurements;
}