import com.google.gson.annotations.SerializedName;

public class Measurements {
    @SerializedName("airQualityIndex")
    public Double aqi;

    @SerializedName("pm25")
    public Double pm25;

    @SerializedName("pm10")
    public Double pm10;

    @SerializedName("pressure")
    public Double pressure;

    @SerializedName("humidity")
    public Double humidity;

    @SerializedName("temperature")
    public Double temperature;
}