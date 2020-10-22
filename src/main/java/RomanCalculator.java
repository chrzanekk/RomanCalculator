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

    String romanDivision(String romanDivided, String romanDivider) {
        int divided = digitConverter.romanToArabic(romanDivided);
        int divider = digitConverter.romanToArabic(romanDivider);

        String romanDivisionResult = "";
        String romanModuloResult = "";
        if (divider != 0) {
            int moduloResult = Math.floorMod(divided, divider);
            int divisionResult = Math.floorDiv(divided, divider);

            if (divisionResult != 0) {
                romanDivisionResult = digitConverter.arabicToRoman(divisionResult);
            } else {
                romanDivisionResult = null;
            }

            if (moduloResult != 0) {
                romanModuloResult = digitConverter.arabicToRoman(moduloResult);
            } else {
                romanModuloResult = null;
            }

        } else {
            romanDivisionResult = null;
            romanModuloResult = null;
        }
//         do poprawy -> divisionResult obiekt.
        return "Division result: " + romanDivisionResult + ". Modulo: " + romanModuloResult;
    }

    String romanMultiply(String firstNumeral, String secondNumeral) {
        int firstNumber = digitConverter.romanToArabic(firstNumeral);
        int secondNumber = digitConverter.romanToArabic(secondNumeral);
        return getResult(arabicMultiply(firstNumber, secondNumber));
    }

//    wyjatek w ifie.
    private String getResult(int arabResult) {
        if (arabResult < LOWER_BOUND || arabResult > UPPER_BOUND) {
            return "Result out of range.";
        } else if (arabResult == 0) {
            return "None.";
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
