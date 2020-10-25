package pl.com.roman.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum RomanNumeral {

    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);

    private int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumeral> getReversedArabicValues() {
        List<RomanNumeral> arabicValues = new ArrayList<>();
        for (RomanNumeral arabicValue : RomanNumeral.values()) {
            arabicValues.add(arabicValue);
        }
        Comparator<RomanNumeral> romanNumeralsComparator = Comparator.comparing(RomanNumeral::getValue).reversed();
        Collections.sort(arabicValues, romanNumeralsComparator);
        arabicValues.stream().sorted(romanNumeralsComparator);
        return arabicValues;
    }

}
