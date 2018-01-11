import java.math.BigDecimal;
import java.math.RoundingMode;

public class Round {
    public static double to(int precision, double number){
        return new BigDecimal(number).setScale(precision, RoundingMode.HALF_EVEN).doubleValue();
    }
}
