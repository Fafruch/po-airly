import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class UserInput {
    private String[] args;

    @Option(name = "--latitude", usage = "Latitude of point on map. Pass together with longitude")
    public String latitude;

    @Option(name = "--longitude", usage = "Longitude of point on map. Pass together with latitude")
    public String longitude;

    @Option(name = "--sensor-id", usage = "Check data from particular sensor with provided ID")
    public String sensorId;

    @Option(name = "--api-key", usage = "(optional) Provide your own apiKey")
    public String apiKey = System.getenv("API_KEY");

    @Option(name = "--history", usage = "(optional) Get historical data (from 24 hours every hour)")
    public boolean history;

    public UserInput(String[] args) {
        this.args = args;
    }

    public void parse() throws InputException {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
            checkArgs();

        } catch (CmdLineException ex) {
            // it's being caught here because only here it's possible to get options usage that can't be get
            // as String in this lib, it can only be printed
            System.out.println(ex.getMessage());
            System.out.println();
            System.out.println("java Main [options...] arguments...");
            // print the list of available options (with usage)
            parser.printUsage(System.out);
            System.out.println();
            System.out.println("  Example: java Main --latitude=VAL --longitude=VAL --history --api-key=VAL");

            throw new InputException("");
        }
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

        if(latitude != null && longitude != null) {
            if(!latitude.matches("\\d{1,3}(.\\d+)?")) {
                throw new InputException("Please provide valid latitude, '" + latitude + "' is not a correct input. You can use for example '--latitude=50.07918'.");
            }

            if(!longitude.matches("\\d{1,3}(.\\d+)?")) {
                throw new InputException("Please provide valid longitude, '" + longitude + "' is not a correct input. You can use for example '--latitude=19.91983'.");
            }
        }

        if(sensorId != null) {
            if(!sensorId.matches("\\d+")) {
                throw new InputException("Please provide valid sensor-id, '" + sensorId + "' is not a correct input. You can use for example '--sensor-id=185'.");
            }
        }
    }
}
