package be.leanderonline;

import java.util.List;

public class NaiveDiagnosticsInterpreter implements DiagnosticsInterpreter{
    private List<String> diagnostics;
    private int stringLength;

    public NaiveDiagnosticsInterpreter(List<String> diagnostics) {
        this.stringLength = diagnostics.get(0).length();
        verifyDiagnostics(diagnostics);
        this.diagnostics = diagnostics;
    }

    private void verifyDiagnostics(List<String> diagnostics) {
        if (diagnostics.stream()
                .anyMatch(number -> number.length() != this.stringLength)) {
            throw new IllegalArgumentException("not all numbers have the same length");
        }
    }

    @Override
    public int getGammaRate() {
        String binaryGammaRate = calculateBasedOnAmountOfOnes("1", "0");
        return Integer.parseInt(binaryGammaRate,2);
    }

    private String calculateBasedOnAmountOfOnes(String whenMostCommonBitIsOne, String whenMostCommonBitIsZero) {
        String binaryResult = "";
        for (int i = 0; i < stringLength; i++) {
            binaryResult = binaryResult.concat(calculateOneBitBasedOnAmountOfOnes(whenMostCommonBitIsOne, whenMostCommonBitIsZero, i));
        }
        return binaryResult;
    }

    private String invertBinaryString(String binaryString) {
        String result = "";
        for (int i = 0; i < stringLength; i++) {
            result = result.concat(binaryString.charAt(i) == '1' ? "0" : "1");
        }
        return result;
    }

    private String calculateOneBitBasedOnAmountOfOnes(String whenMostCommonBitIsOne, String whenMostCommonBitIsZero, int characterIndex) {
        long amountOfOnes = countAmountOfCharAtIndex('1', characterIndex);
        return amountOfOnes > (diagnostics.size() / 2) ? whenMostCommonBitIsOne : whenMostCommonBitIsZero;
    }

    private long countAmountOfCharAtIndex(char c, int i) {
        return diagnostics.stream()
                .filter(line -> line.charAt(i) == c)
                .count();
    }

    @Override
    public int getEpsilonRate() {
        String binaryGammaRate = calculateBasedOnAmountOfOnes("1", "0");
        String binaryEpsilonRate = invertBinaryString(binaryGammaRate);
        return Integer.parseInt(binaryEpsilonRate,2);
    }

    @Override
    public int getPowerConsumption() {
        return getGammaRate() * getEpsilonRate();
    }
}
