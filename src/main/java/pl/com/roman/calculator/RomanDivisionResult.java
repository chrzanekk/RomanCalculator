package pl.com.roman.calculator;

public class RomanDivisionResult {
    private String divisionResult;
    private String moduloResult;

    public RomanDivisionResult(String divisionResult, String moduloResult) {
        this.divisionResult = divisionResult;
        this.moduloResult = moduloResult;
    }

    public String getDivisionResult() {
        return divisionResult;
    }

    public String getModuloResult() {
        return moduloResult;
    }
}
