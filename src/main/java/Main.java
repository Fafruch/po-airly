import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            UserInput userInput = new UserInput(args);
            userInput.parse();

            Fetcher fetcher = new Fetcher();
            Data data = fetcher.getData(userInput);

            Printer printer = new Printer(data, userInput);
            printer.printData();

        } catch (JsonSyntaxException | ParseException ex) {
            System.out.println("Received illegal response from Airly server. Please try again.");
        } catch (UnknownHostException ex) {
            System.out.println("Could not connect with Airly server. Please check your connection.");
        } catch (InputException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            if(ex.getMessage().matches("^Server returned HTTP response code: 400 for URL.*")) {
                System.out.println("Couldn't find data based on provided arguments.");
            } else if(ex.getMessage().matches("^Server returned HTTP response code: 403 for URL.*")) {
                System.out.print("Couldn't authorize with Airly server. ");

                if(System.getenv("API_KEY") != null) {
                    System.out.println("Check if provided API_KEY is correct. ");
                } else {
                    System.out.println("Check if environment variable API_KEY exists and is correct or pass one with --api-key=VAL");
                }
            } else {
                System.out.println(ex.getMessage());
            }
        }
    }
}