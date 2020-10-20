public class RomanCalculator {
    DigitConverter digitConverter;

    public RomanCalculator(DigitConverter digitConverter) {
        this.digitConverter = digitConverter;
    }

    String addRoman(String firstNumeral, String secondNumeral) {

        int firstArabicDigits = digitConverter.romanToArabic(firstNumeral);
        int secondArabicDigits = digitConverter.romanToArabic(secondNumeral);

        int arabicResult = arabicAddition(firstArabicDigits, secondArabicDigits);

        return getResult(arabicResult);
    }

    String subRoman(String firstNumeral, String secondNumeral) {

        int firstArabDigit = digitConverter.romanToArabic(firstNumeral);
        int secondArabDigit = digitConverter.romanToArabic(secondNumeral);

        int arabResult = arabicSubtraction(firstArabDigit, secondArabDigit);
        return getResult(arabResult);
    }

    String divRoman(String romanDivided, String romanDivider) {
        int divisionResult = 0;
        int moduloResult = 0;
        String romanDivisionResult = "";
        String romanModuloResult = "";

        int divided = digitConverter.romanToArabic(romanDivided);
        int divider = digitConverter.romanToArabic(romanDivider);

        if (divider != 0) {
            moduloResult = Math.floorMod(divided,divider);
            divisionResult = Math.floorDiv(divided, divider);
            if (divisionResult != 0) {
                romanDivisionResult = digitConverter.arabicToRoman(divisionResult);
            } else {
                romanDivisionResult = "none";
            }

            if (moduloResult != 0) {
                romanModuloResult = digitConverter.arabicToRoman(moduloResult);
            } else {
                romanModuloResult = "none";
            }

        } else {
            romanDivisionResult = "none";
            romanModuloResult = "none";
        }


        return "Division result: " + romanDivisionResult + ". Modulo: " + romanModuloResult;

    }

    private String getResult(int arabResult) {
        if (arabResult < 0 || arabResult > 4000) {
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


}
