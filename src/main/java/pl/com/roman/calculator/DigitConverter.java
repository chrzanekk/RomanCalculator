package pl.com.roman.calculator;

import java.util.*;

public class DigitConverter {

//    LET numeral be the input String representing an Roman Numeral
//    LET symbol be initialy set to RomanNumeral.values()[0]
//    WHILE numeral.length > 0:
//    IF numeral starts with symbol's name:
//    add symbol's value to the result
//    remove the symbol's name from the numeral's beginning
//    ELSE:
//    set symbol to the next symbol

    public Integer romanToArabic(String romanInput) {
        if (romanInput == null) {
            throw new IllegalArgumentException("Unable to convert. String cant be null.");
        }

        String romanNumeral = romanInput.toUpperCase();
        List<RomanNumeral> romanNumerals = RomanNumeral.getReversedArabicValues();

        if (romanNumeral.length() == 0) {
            throw new IllegalArgumentException("Unable to convert. Empty string is invalid.");
        }

        int result = 0;
        int index = 0;

        while (romanNumeral.length() > 0 && index < romanNumerals.size()) {
            RomanNumeral romanSymbol = romanNumerals.get(index);
            if (romanNumeral.startsWith(romanSymbol.name())) {
                result += romanSymbol.getValue();
                romanNumeral = romanNumeral.substring(romanSymbol.name().length());
            } else {
                index++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException("Unable to convert. " + romanInput + "is invalid.");
        }

        return result;
    }

//    LET number be an integer between 1 and 4000
//    LET symbol be RomanNumeral.values()[0]
//    LET result be an empty String
//    WHILE number > 0:
//    IF symbol's value <= number:
//    append the result with the symbol's name
//    subtract symbol's value from number
//    ELSE:
//    pick the next symbol

    public String arabicToRoman(int arabicNumber) {
        String romanNumeralOutput = "";

        if ((arabicNumber <= 0) || (arabicNumber > 4000)) {
            throw new IllegalArgumentException("Unable to convert. " + arabicNumber + " is out of range [0,4000)");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReversedArabicValues();
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




//    https://www.baeldung.com/java-convert-roman-arabic
//https://stackoverflow.com/questions/33005654/converting-roman-numerals-to-arabic
//    https://www.calculatorsoup.com/calculators/conversions/roman-numeral-calculator.php
}
