import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitConverterTest {

    private static DigitConverter digitConverter;

    @BeforeClass
    public static void initDigitConverterFromArabicToNumeralAndOpposite() {
        digitConverter = new DigitConverter();
    }
//dodatkowy scenariusz - duze literały rzymskie.
//    dodatkowy scenariusz - pusty string
//    dodatkowy scenariusz - cyfra w stringu.
//    dodatkowy scenariusz - string w cyfrze.
//    dodatkowy scnariusz - null
//    dodatkowy scenariusz - ujemny integer.
    @Test
    public void testRomanStringToArabicIntegerConvertCorrectInput() {
        String romanNumeral = "mmxviii";

        int result = digitConverter.romanToArabic(romanNumeral);

        assertEquals(2018, result);

    }

    @Test(expected =  IllegalArgumentException.class)
    public void testRomanStringToArabicIntegerConvertIncorrectInput() {
        String romanNumeral = "rmxviii";

        digitConverter.romanToArabic(romanNumeral);
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

    @Test
    public void testArabicToRomanConverterZeroInput() {
        int arabicNumber = 0;

        String result = digitConverter.arabicToRoman(arabicNumber);

        assertEquals("Number is out of range (0,4000]", result);

    }

}
