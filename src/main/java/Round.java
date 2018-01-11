import java.math.BigDecimal;
import java.math.RoundingMode;

public class Round {
    public static double to(double number, int precision){
        return new BigDecimal(number).setScale(precision, RoundingMode.HALF_EVEN).doubleValue();
    }
}
