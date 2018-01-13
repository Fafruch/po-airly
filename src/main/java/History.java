import com.google.gson.annotations.SerializedName;

public class History {
    @SerializedName("fromDateTime")
    private String fromDateTime;

    @SerializedName("tillDateTime")
    private String tillDateTime;

    @SerializedName("measurements")
    private Measurements measurements;

    public void printInfo() {
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("Sensor information");
        System.out.println("between:       " + tillDateTime);
        System.out.println("    and:       " + fromDateTime);
        System.out.println();
        printMeasurements();
        System.out.println();
    }

    private void printMeasurements() {
        OutColor outColor = new OutColor();

        if(measurements != null) {
            measurements.printInfo();
        } else {
            outColor.switchTo(Color.GREY);
            System.out.println("no data for this time range :(");
            outColor.switchTo(Color.WHITE);
        }
    }
}