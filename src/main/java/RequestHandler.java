import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestHandler {
    public String get(String userUrl, String apiKey) throws IOException {
        return responseFor(createConnection("GET", userUrl, apiKey));
    }

    private HttpURLConnection createConnection(String method, String userUrl, String apiKey) throws IOException {
        URL url = new URL(userUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod(method);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("apikey", apiKey);

        return connection;
    }

    private String responseFor(HttpURLConnection connection) throws IOException {
        StringBuilder response = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            response.append(line);
        }

        bufferedReader.close();

        return response.toString();
    }
}