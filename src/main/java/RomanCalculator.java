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

    private String getResult(int arabResult) {
        if (arabResult < 0 || arabResult > 4000) {
            return "Result out of range.";
        } else if (arabResult==0){
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
