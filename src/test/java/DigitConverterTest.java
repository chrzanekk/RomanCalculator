import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitConverterTest {

    private static DigitConverter digitConverter;

    @BeforeClass
    public static void initDigitConverterFromArabicToNumeralAndOpposite() {
        digitConverter = new DigitConverter();
    }

    @Test
    public void testRomanStringToArabicIntegerConvertCorrectInput() {
        String romanNumeral = "mmxviii";

        int result = digitConverter.romanToArabic(romanNumeral);

        assertEquals(2018, result);

    }

    @Test
    public void testRomanStringToArabicIntegerConvertIncorrectInput() {
        String romanNumeral = "rmxviii";

        int result = digitConverter.romanToArabic(romanNumeral);

        assertEquals(0, result);

    }

    @Test
    public void testArabicToRomanConverterCorrectInput() {
        int arabicNumber = 2018;

        String result = digitConverter.arabicToRoman(arabicNumber);

        assertEquals("MMXVIII", result);

    }

    @Test
    public void testArabicToRomanConverterIncorrectInput() {
        int arabicNumber = 4018;

        String result = digitConverter.arabicToRoman(arabicNumber);

        assertEquals("Number is out of range (0,4000]", result);

    }

}
