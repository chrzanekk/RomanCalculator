import org.junit.*;

import static org.junit.Assert.*;

public class RomanCalculatorTest {
    private static DigitConverter digitConverter;
    private static RomanCalculator romanCalculator;

    @BeforeClass
    public static void initDigitConverterFromArabicToNumeralAndOpposite() {
        digitConverter = new DigitConverter();
        romanCalculator = new RomanCalculator(digitConverter);
    }


    @Test
    public void testRomanAddTwoNumeralsHasCorrectRange() {
        String firstNumeral = "DCCXXVI";
        String secondNumeral = "XLVIII";

        String result = romanCalculator.addRoman(firstNumeral,secondNumeral);

        assertEquals("DCCLXXIV",result);
    }

    @Test
    public void testRomanAddTwoNumeralsHasIncorrectRange() {
        String firstNumeral = "MMMD";
        String secondNumeral = "DC";

        String result = romanCalculator.addRoman(firstNumeral,secondNumeral);

        assertEquals("Result out of range.",result);
    }

    @Test
    public void testRomanSubTwoNumeralsFirstHigherThanSecondCorrectRange() {
        String firstNumeral = "MMMD";
        String secondNumeral = "DC";

        String result = romanCalculator.subRoman(firstNumeral,secondNumeral);

        assertEquals("MMCM",result);
    }

    @Test
    public void testRomanSubTwoNumeralsFirstLowerThanSecondIncorrectRange() {
        String firstNumeral = "DC";
        String secondNumeral = "MMMDC";

        String result = romanCalculator.subRoman(firstNumeral,secondNumeral);

        assertEquals("Result out of range.",result);
    }

    @Test
    public void testRomanSubTwoNumeralsFirstEqualsSecondResultZero() {
        String firstNumeral = "I";
        String secondNumeral = "I";

        String result = romanCalculator.subRoman(firstNumeral,secondNumeral);

        assertEquals("None.",result);
    }
}
