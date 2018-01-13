import java.text.ParseException;

public class Printer {
    private Data data;
    private boolean history;

    public Printer (Data data, boolean history) {
        this.data = data;
        this.history = history;
    }

    public void printInfo() throws ParseException {
        data.printCurrentInfo();

        if(history) {
            data.printHistoryInfo();
        }
    }
}
