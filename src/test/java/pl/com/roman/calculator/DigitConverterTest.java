package pl.com.roman.calculator;

import org.junit.BeforeClass;
import org.junit.Test;
import pl.com.roman.calculator.DigitConverter;

import static org.junit.Assert.assertEquals;

public class DigitConverterTest {

    private static DigitConverter digitConverter;

    @BeforeClass
    public static void initDigitConverterFromArabicToNumeralAndOpposite() {
        digitConverter = new DigitConverter();
    }

    //dodatkowy scenariusz - duze literaly rzymskie - done
    //    dodatkowy scenariusz - pusty string - done
    //    dodatkowy scenariusz - cyfra w stringu - done
    //    dodatkowy scenariusz - string w cyfrze - do omówienia.
    //    dodatkowy scnariusz - null - done
    //    dodatkowy scenariusz - ujemny integer - done
    @Test
    public void testRomanStringToArabicIntegerConvertCorrectInputLowerCase() {
        String romanNumeral = "mmxviii";

        int result = digitConverter.romanToArabic(romanNumeral);

        assertEquals(2018, result);

    }

    @Test
    public void testRomanStringToArabicIntegerConvertCorrectInputUppercase() {
        String romanNumeral = "MMMDCCXXIV";

        int result = digitConverter.romanToArabic(romanNumeral);

        assertEquals(3724, result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRomanStringToArabicIntegerConvertEmptyString() {
        String romanNumeral = "";

        digitConverter.romanToArabic(romanNumeral);

    }


    @Test(expected = NullPointerException.class)
    public void testRomanStringToArabicIntegerConvertStringIsNull() {
        String romanNumeral = null;

        digitConverter.romanToArabic(romanNumeral);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRomanStringToArabicIntegerConvertDigitInString() {
        String romanNumeral = "6";

        digitConverter.romanToArabic(romanNumeral);
    }


    @Test(expected = IllegalArgumentException.class)
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


    @Test(expected = IllegalArgumentException.class)
    public void testArabicToRomanConverterInCorrectInputNegativeInteger() {
        int arabicNumber = -2018;

       digitConverter.arabicToRoman(arabicNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArabicToRomanConverterIncorrectInput() {
        int arabicNumber = 4018;

        digitConverter.arabicToRoman(arabicNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArabicToRomanConverterZeroInput() {
        int arabicNumber = 0;

        digitConverter.arabicToRoman(arabicNumber);
    }
//ten scenariusz jest albo uzyteczny przy testach metody walidachji danych albo nie wiem jak go skonstruować
//    @Test
//    public void testArabicToRomanConverterIncorrectInputStringInInteger() {
//        int arabicNumber = "2018";
//
//        String result = digitConverter.arabicToRoman(arabicNumber);
//
//        assertEquals("MMXVIII", result);
//    }



}
