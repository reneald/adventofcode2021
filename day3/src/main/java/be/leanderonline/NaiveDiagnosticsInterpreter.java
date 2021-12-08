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
        String binaryGammaRate = calculateMostCommonBits();
        return Integer.parseInt(binaryGammaRate,2);
    }

    private String calculateMostCommonBits() {
        String binaryResult = "";
        for (int i = 0; i < stringLength; i++) {
            binaryResult = binaryResult.concat(calculateMostCommonBit(i));
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

    private String calculateMostCommonBit(int characterIndex) {
        return mostCommonBitAtIndex(characterIndex) ? "1" : "0";
    }

    private boolean mostCommonBitAtIndex(int index) {
        long amountOfOnes = countAmountOfOnesAtIndex(index);
        return amountOfOnes >= (diagnostics.size() / 2);
    }

    private long countAmountOfOnesAtIndex(int i) {
        return diagnostics.stream()
                .filter(line -> line.charAt(i) == '1')
                .count();
    }

    @Override
    public int getEpsilonRate() {
        String binaryGammaRate = calculateMostCommonBits();
        String binaryEpsilonRate = invertBinaryString(binaryGammaRate);
        return Integer.parseInt(binaryEpsilonRate,2);
    }

    @Override
    public int getPowerConsumption() {
        return getGammaRate() * getEpsilonRate();
    }

    @Override
    public int getOxygenGeneratorRating() {
        return 0;
    }

    @Override
    public int getCo2ScrubberRating() {
        return 0;
    }

    @Override
    public int getLifeSupportRating() {
        return 0;
    }
}
