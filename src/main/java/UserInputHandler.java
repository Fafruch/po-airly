import com.google.gson.Gson;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class UserInputHandler {
    private String[] args;

    @Option(name = "--latitude", usage = "Latitude of point on map. Pass together with longitude")
    private String latitude;

    @Option(name = "--longitude", usage = "Longitude of point on map. Pass together with latitude")
    private String longitude;

    @Option(name = "--sensor-id", usage = "Check data from particular sensor with provided ID")
    private String sensorId;

    @Option(name = "--api-key", usage = "(optional) Provide your own apiKey")
    private String apiKey = Api.MY_KEY;

    @Option(name = "--history", usage = "(optional) Get historical data (from 24 hours every hour)")
    private boolean history;

    public UserInputHandler(String[] args) {
        this.args = args;
    }

    public void run() throws Exception {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
            checkArgs();
        } catch (InputException e) {
            System.err.println(e.getMessage());
            System.out.println();
            System.err.println("java Main [options...] arguments...");
            // print the list of available options
            parser.printUsage(System.err);
            System.err.println();
            System.err.println("  Example: java Main --latitude=VAL --longitude=VAL --history --api-key=VAL");

            return;
        }

        /*// TEST
        if (history) {
            System.out.println("--history flag is set");
        } else {
            System.out.println("--history flag is NOT set");
        }
        System.out.println("--latitude was " + latitude);
        System.out.println("--longitude was " + longitude);
        System.out.println("--sensor-id was " + sensorId);
        System.out.println("--api-key was " + (apiKey.equals(Api.MY_KEY) ? "default and its value was " : "") + apiKey);
        System.out.println();
        // END_TEST*/

        Data data = getData();

        Printer printer = new Printer(data, history);
        printer.printInfo();
    }

    private void checkArgs() throws InputException {
        if (args.length == 0) {
            throw new InputException("No argument is given");
        }

        if (latitude == null && longitude == null && sensorId == null) {
            throw new InputException("Please provide arguments like '--latitude=50.07918 --longitude=19.91983' or --sensor-id=185'");
        } else if (latitude == null && longitude != null && sensorId == null) {
            throw new InputException("Please provide missing latitude argument, like '--latitude=50.07918'");
        } else if (latitude != null && longitude == null && sensorId == null) {
            throw new InputException("Please provide missing longitude argument, like '--longitude=19.91983'");
        }
    }

    private Data getData() throws Exception {
        RequestHandler requestHandler = new RequestHandler();
        Gson gson = new Gson();
        Data data;

        if (sensorId != null) {
            String sensorIdUrl = "https://airapi.airly.eu/v1/sensor/measurements?sensorId=" + sensorId;
            data = gson.fromJson(requestHandler.get(sensorIdUrl, apiKey), Data.class);

        } else {
            String mapPointUrl = "https://airapi.airly.eu/v1/mapPoint/measurements?latitude=" + latitude + "&longitude=" + longitude;
            data = gson.fromJson(requestHandler.get(mapPointUrl, apiKey), Data.class);
        }

        return data;
    }
}
