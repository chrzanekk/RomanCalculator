import pl.com.roman.calculator.DigitConverter;
import pl.com.roman.calculator.RomanCalculator;

public class Main {

    public static void main(String[] args) {
        DigitConverter digitConverter = new DigitConverter();
        RomanCalculator romanCalculator = new RomanCalculator(digitConverter);

        int divider = 2;
        int divisor = 4;
        System.out.println(Math.floorDiv(divider,divisor));
        System.out.println(Math.floorMod(divider,divisor));
    }
}
