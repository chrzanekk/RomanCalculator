package pl.com.roman.calculator;

public class RomanCalculator {
    DigitConverter digitConverter;

    public RomanCalculator(DigitConverter digitConverter) {
        this.digitConverter = digitConverter;
    }

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 4000;

    String romanAdd(String firstNumeral, String secondNumeral) {

        int firstArabicDigits = digitConverter.romanToArabic(firstNumeral);
        int secondArabicDigits = digitConverter.romanToArabic(secondNumeral);

        int arabicResult = arabicAddition(firstArabicDigits, secondArabicDigits);

        return getResult(arabicResult);
    }

    String romanSubtraction(String firstNumeral, String secondNumeral) {

        int firstArabDigit = digitConverter.romanToArabic(firstNumeral);
        int secondArabDigit = digitConverter.romanToArabic(secondNumeral);

        int arabResult = arabicSubtraction(firstArabDigit, secondArabDigit);
        return getResult(arabResult);
    }

    RomanDivisionResult romanDivision(String romanDivided, String romanDivider) {
        int divided = digitConverter.romanToArabic(romanDivided);
        int divider = digitConverter.romanToArabic(romanDivider);

        String romanDivisionResult = "";
        String romanModuloResult = "";
        if (divider != 0) {
            int divisionResult = Math.floorDiv(divided, divider);
            int moduloResult = Math.floorMod(divided, divider);
            if (divisionResult == 0) {
                romanDivisionResult = null;
            } else {
                romanDivisionResult = digitConverter.arabicToRoman(divisionResult);
            }

            if (moduloResult == 0) {
                romanModuloResult = null;
            } else {
                romanModuloResult = digitConverter.arabicToRoman(moduloResult);
            }
        }
        return new RomanDivisionResult(romanDivisionResult, romanModuloResult);
    }

    String romanMultiply(String firstNumeral, String secondNumeral) {
        int firstNumber = digitConverter.romanToArabic(firstNumeral);
        int secondNumber = digitConverter.romanToArabic(secondNumeral);
        return getResult(arabicMultiply(firstNumber, secondNumber));
    }


    private String getResult(int arabResult) {
        if (arabResult < LOWER_BOUND || arabResult > UPPER_BOUND) {
            throw new IllegalArgumentException("Unable to get result. Result out of range [0,4000).");
        } else if (arabResult == 0) {
            throw new IllegalArgumentException("Unable to get result. Result is 0 and cant be converted to Roman." +
                    "Numeral");
        }
        return digitConverter.arabicToRoman(arabResult);
    }


    private int arabicAddition(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private int arabicSubtraction(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    private int arabicMultiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }


}
