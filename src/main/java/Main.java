import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        try {
            UserInput userInput = new UserInput(args);
            userInput.parse();

            Data data = getData(userInput);

            Printer printer = new Printer(data, userInput.history);
            printer.printInfo();
        } catch (Exception ex) {
            System.err.println("ERROR: ");
            System.err.println(ex);
        }
    }

    private static Data getData(UserInput userInput) throws Exception {
        RequestHandler requestHandler = new RequestHandler();
        Gson gson = new Gson();
        Data data;

        if (userInput.sensorId != null) {
            String sensorIdUrl = "https://airapi.airly.eu/v1/sensor/measurements?sensorId=" + userInput.sensorId;
            data = gson.fromJson(requestHandler.get(sensorIdUrl, userInput.apiKey), Data.class);

        } else {
            String mapPointUrl = "https://airapi.airly.eu/v1/mapPoint/measurements?latitude=" + userInput.latitude + "&longitude=" + userInput.longitude;
            data = gson.fromJson(requestHandler.get(mapPointUrl, userInput.apiKey), Data.class);
        }

        return data;
    }
}