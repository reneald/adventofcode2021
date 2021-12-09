package be.leanderonline;

import java.util.List;
import java.util.stream.Collectors;

public class NaiveDiagnosticsInterpreter implements DiagnosticsInterpreter {
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
        return parseBinaryToInt(binaryGammaRate);
    }

    private int parseBinaryToInt(String binaryGammaRate) {
        return Integer.parseInt(binaryGammaRate, 2);
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
            result = result.concat(bitAtIndex(binaryString, i) ? "0" : "1");
        }
        return result;
    }

    private String calculateMostCommonBit(int characterIndex) {
        return mostCommonBitAtIndex(characterIndex, diagnostics) ? "1" : "0";
    }

    private boolean mostCommonBitAtIndex(int index, List<String> diagnosticsList) {
        long amountOfOnes = countAmountOfOnesAtIndex(index, diagnosticsList);
        return isMajorityOf(amountOfOnes, diagnosticsList);
    }

    private boolean isMajorityOf(long amountOfOnes, List<String> diagnosticsList) {
        long amountOfZeroes = diagnosticsList.size() - amountOfOnes;
        return amountOfOnes >= amountOfZeroes;
    }

    private long countAmountOfOnesAtIndex(int i, List<String> diagnosticsList) {
        return diagnosticsList.stream()
                .filter(line -> bitAtIndex(line, i))
                .count();
    }

    @Override
    public int getEpsilonRate() {
        String binaryGammaRate = calculateMostCommonBits();
        String binaryEpsilonRate = invertBinaryString(binaryGammaRate);
        return parseBinaryToInt(binaryEpsilonRate);
    }

    @Override
    public int getPowerConsumption() {
        return getGammaRate() * getEpsilonRate();
    }

    @Override
    public int getOxygenGeneratorRating() {
        int index = 0;
        List<String> remainingDiagnosticNumbers = diagnostics;
        while (remainingDiagnosticNumbers.size() > 1) {
            remainingDiagnosticNumbers = filterDiagnosticsByEqualToMostCommonBitAtIndex(remainingDiagnosticNumbers, index);
            index++;
        }
        return parseBinaryToInt(remainingDiagnosticNumbers.get(0));
    }

    private List<String> filterDiagnosticsByEqualToMostCommonBitAtIndex(List<String> diagnosticList, int index) {
        return diagnosticList.stream()
                .filter(diagnostic -> this.equalToMostCommonBitAtIndex(diagnostic, index, diagnosticList))
                .collect(Collectors.toList());
    }

    private List<String> filterDiagnosticsByEqualToLeastCommonBitAtIndex(List<String> diagnosticList, int index) {
        return diagnosticList.stream()
                .filter(diagnostic -> this.equalToLeastCommonBitAtIndex(diagnostic, index, diagnosticList))
                .collect(Collectors.toList());
    }

    private boolean equalToMostCommonBitAtIndex(String diagnosticString, int index, List<String> diagnosticsList) {
        boolean mostCommonBitAtIndex = mostCommonBitAtIndex(index, diagnosticsList);
        boolean bitAtIndex = bitAtIndex(diagnosticString, index);
        return mostCommonBitAtIndex == bitAtIndex;
    }

    private boolean equalToLeastCommonBitAtIndex(String diagnosticString, int index, List<String> diagnosticsList) {
        boolean mostCommonBitAtIndex = mostCommonBitAtIndex(index, diagnosticsList);
        boolean bitAtIndex = bitAtIndex(diagnosticString, index);
        return mostCommonBitAtIndex != bitAtIndex;
    }

    private boolean bitAtIndex(String diagnosticString, int index) {
        return diagnosticString.charAt(index) == '1';
    }

    @Override
    public int getCo2ScrubberRating() {
        int index = 0;
        List<String> remainingDiagnosticNumbers = diagnostics;
        while (remainingDiagnosticNumbers.size() > 1) {
            remainingDiagnosticNumbers = filterDiagnosticsByEqualToLeastCommonBitAtIndex(remainingDiagnosticNumbers, index);
            index++;
        }
        return parseBinaryToInt(remainingDiagnosticNumbers.get(0));
    }

    @Override
    public int getLifeSupportRating() {
        return getOxygenGeneratorRating() * getCo2ScrubberRating();
    }
}
