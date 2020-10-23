package pl.com.roman.calculator;

public class RomanDivisionResult {
    private int divided;
    private int divider;
    private String romanDivisionResult;
    private String romanModuloResult;

    public RomanDivisionResult(int divided, int divider) {
        this.divided = divided;
        this.divider = divider;
    }

    private String romanModuloResult() {
        int moduloResult = 0;
        if (divider != 0) {
            moduloResult = Math.floorMod(divided, divider);
        }

        if (moduloResult != 0) {
            DigitConverter digitConverter = new DigitConverter();
            romanModuloResult = digitConverter.arabicToRoman(moduloResult);
        }

        return romanModuloResult;
    }


    private String romanDivisionResult() {
        int divisionResult = 0;
        if (divider != 0) {
            divisionResult = Math.floorDiv(divided, divider);
        } else {
            romanDivisionResult = null;
        }

        if (divisionResult != 0) {
            DigitConverter digitConverter = new DigitConverter();
            romanDivisionResult = digitConverter.arabicToRoman(divisionResult);
        } else {
            romanDivisionResult = null;
        }

        return romanDivisionResult;
    }

    public String getRomanDivisionResult() {
        return romanDivisionResult();
    }

    public String getRomanModuloResult() {
        return romanModuloResult();
    }
}
