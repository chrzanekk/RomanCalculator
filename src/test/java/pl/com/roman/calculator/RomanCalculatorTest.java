package pl.com.roman.calculator;

import org.junit.*;
import pl.com.roman.calculator.DigitConverter;
import pl.com.roman.calculator.RomanCalculator;

import static org.junit.Assert.*;

public class RomanCalculatorTest {
    private static DigitConverter digitConverter;
    private static RomanCalculator romanCalculator;

    @BeforeClass
    public static void initDigitConverterFromArabicToNumeralAndOpposite() {
        digitConverter = new DigitConverter();
        romanCalculator = new RomanCalculator(digitConverter);
    }
//dodatkowy test - male literały rzymskie


    @Test
    public void testRomanAddTwoNumeralsHasCorrectRange() {
        String firstNumeral = "DCCXXVI";
        String secondNumeral = "XLVIII";

        String result = romanCalculator.romanAdd(firstNumeral, secondNumeral);

        assertEquals("DCCLXXIV", result);
    }

    @Test
    public void testRomanAddTwoNumeralsHasIncorrectRange() {
        String firstNumeral = "MMMD";
        String secondNumeral = "DC";

        String result = romanCalculator.romanAdd(firstNumeral, secondNumeral);

        assertEquals("Result out of range.", result);
    }


    @Test
    public void testRomanSubTwoNumeralsFirstHigherThanSecondCorrectRange() {
        String firstNumeral = "MMMD";
        String secondNumeral = "DC";

        String result = romanCalculator.romanSubtraction(firstNumeral, secondNumeral);

        assertEquals("MMCM", result);
    }

    @Test
    public void testRomanSubTwoNumeralsFirstLowerThanSecondIncorrectRange() {
        String firstNumeral = "DC";
        String secondNumeral = "MMMDC";

        String result = romanCalculator.romanSubtraction(firstNumeral, secondNumeral);

        assertEquals("Result out of range.", result);
    }

    @Test
    public void testRomanSubTwoNumeralsFirstEqualsSecondResultZero() {
        String firstNumeral = "I";
        String secondNumeral = "I";

        String result = romanCalculator.romanSubtraction(firstNumeral, secondNumeral);

        assertEquals("None.", result);
    }


    @Test
    public void testRomanDivWithModuloTwoNumeralsFirstAndSecondHasCorrectRange() {
        String firstNumeral = "III";
        String secondNumeral = "II";

        String moduloResult = romanCalculator.romanDivision(firstNumeral, secondNumeral).getRomanModuloResult();
        String divisionResult = romanCalculator.romanDivision(firstNumeral, secondNumeral).getRomanDivisionResult();

        assertEquals(null, moduloResult);
        assertEquals("I", divisionResult);
//        assertEquals("Division result: I. Modulo: I", result);
    }

    @Test
    public void testRomanDivWithoutModuloTwoNumeralsFirstAndSecondHasCorrectRange() {
        String firstNumeral = "IIII";
        String secondNumeral = "II";

        String moduloResult = romanCalculator.romanDivision(firstNumeral, secondNumeral).getRomanModuloResult();
        String divisionResult = romanCalculator.romanDivision(firstNumeral, secondNumeral).getRomanDivisionResult();

        assertEquals(null, moduloResult);
        assertEquals("II", divisionResult);
    }

    @Test
    public void testRomanDivWithModuloTwoNumeralsFirstAndSecondHasCorrectRangeAndFirstIsLowerThanSecond() {
        String firstNumeral = "II";
        String secondNumeral = "IIII";

        String moduloResult = romanCalculator.romanDivision(firstNumeral, secondNumeral).getRomanModuloResult();
        String divisionResult = romanCalculator.romanDivision(firstNumeral, secondNumeral).getRomanDivisionResult();

        assertEquals("II", moduloResult);
        assertEquals(null, divisionResult);

    }

    @Test
    public void testRomanMultiplyTwoNumeralsFirstAndSecondHasCorrectRange() {
        String firstNumeral = "II";
        String secondNumeral = "IIII";

        String result = romanCalculator.romanMultiply(firstNumeral, secondNumeral);

        assertEquals("VIII", result);
    }

    @Test
    public void testRomanMultiplyTwoNumeralsResultIsOutOfRange() {
        String firstNumeral = "DCCXXVI";
        String secondNumeral = "XLVIII";

        String result = romanCalculator.romanMultiply(firstNumeral, secondNumeral);

        assertEquals("Result out of range.", result);
    }
}
//https://www.calculatorsoup.com/calculators/conversions/roman-numeral-calculator.php