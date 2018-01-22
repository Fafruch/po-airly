import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("currentMeasurements")
    public Measurements measurements;

    @SerializedName("history")
    public History[] history;
}