import com.google.gson.Gson;

public class Main {
    public static void main(String args[]) throws Exception {
        String sensorId = "185",
                latitude = "50.079241",
                longitude = "19.919793";
        String mapPointUrl = "https://airapi.airly.eu/v1/mapPoint/measurements?latitude=" + latitude + "&longitude=" + longitude;
        String sensorIdUrl = "https://airapi.airly.eu/v1/sensor/measurements?sensorId=" + sensorId;
        String userApiKey = "";

        String apiKey = userApiKey.equals("") ? Api.MY_KEY : userApiKey;

        RequestHandler requestHandler = new RequestHandler();
        Gson gson = new Gson();

        Data mapPointData = gson.fromJson(requestHandler.get(mapPointUrl, apiKey), Data.class);
        mapPointData.printCurrentInfo();
        mapPointData.printHistoryInfo();

        Data sensorIdData = gson.fromJson(requestHandler.get(sensorIdUrl, apiKey), Data.class);
        sensorIdData.printCurrentInfo();
        sensorIdData.printHistoryInfo();
    }
}