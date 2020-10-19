import java.util.*;

public class DigitConverter {

    public Integer romanToArabian(String romanInput) {
        String romanNumeral = romanInput.toUpperCase();
        List<RomanNumeral> romanNumerals = getReversedArabicValues();
        Integer result = 0;

        int index = 0;

        while ((romanNumeral.length() > 0) && (index < romanNumerals.size())) {
            RomanNumeral romanSymbol = romanNumerals.get(index);
            if (romanNumeral.startsWith(romanSymbol.name())) {
                result += romanSymbol.getValue();
                romanNumeral = romanNumeral.substring(romanSymbol.name().length());
            } else {
                index++;
            }
        }
        try {
            if (romanNumeral.length() > 0) {
                throw new IllegalArgumentException(romanInput);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to convert " + romanInput + " to Arabic Number.");
        }
        return result;
    }

    public String arabianToRoman(int arabicNumber) {
        String romanNumeralOutput = "";
        try {
            if ((arabicNumber <= 0) || (arabicNumber > 4000)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Number is out of range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = getReversedArabicValues();
        int index = 0;

        while ((arabicNumber > 0) && (index < romanNumerals.size())) {
            RomanNumeral currentRomanSymbol = romanNumerals.get(index);
            if (currentRomanSymbol.getValue() <= arabicNumber) {
                romanNumeralOutput = romanNumeralOutput.concat(currentRomanSymbol.toString());
                arabicNumber -= currentRomanSymbol.getValue();
            } else {
                index++;
            }
        }
        return romanNumeralOutput;
    }


    private List<RomanNumeral> getReversedArabicValues() {
        List<RomanNumeral> arabicNumerals = new ArrayList<>();
        for (RomanNumeral arabicNumeral : RomanNumeral.values()) {
            arabicNumerals.add(arabicNumeral);
        }
        Comparator<RomanNumeral> romanNumeralsComparator = Comparator.comparing(RomanNumeral::getValue).reversed();
        Collections.sort(arabicNumerals, romanNumeralsComparator);
        arabicNumerals.stream().sorted(romanNumeralsComparator);
        return arabicNumerals;
    }

//    https://www.baeldung.com/java-convert-roman-arabic
//https://stackoverflow.com/questions/33005654/converting-roman-numerals-to-arabic
}