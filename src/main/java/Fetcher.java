import com.google.gson.Gson;

public class Fetcher {
    public Data getData(UserInput userInput) throws Exception {
        RequestHandler requestHandler = new RequestHandler();
        Gson gson = new Gson();
        Data data;

        if (userInput.sensorId != null) {
            String sensorIdUrl = "https://airapi.airly.eu/v1/sensor/measurements?sensorId=" + userInput.sensorId;
            String response = requestHandler.get(sensorIdUrl, userInput.apiKey);

            data = gson.fromJson(response, Data.class);

        } else {
            String mapPointUrl = "https://airapi.airly.eu/v1/mapPoint/measurements?latitude=" + userInput.latitude + "&longitude=" + userInput.longitude;
            String response = requestHandler.get(mapPointUrl, userInput.apiKey);

            data = gson.fromJson(response, Data.class);
        }

        return data;
    }
}
