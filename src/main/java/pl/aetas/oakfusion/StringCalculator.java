package pl.aetas.oakfusion;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int add(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }

        StringCalculator.InputData inputData = parseInputData(inputString);

        String numbersString = inputData.getNumbersString();
        String delimiterRegex = inputData.getDelimiterRegex();
        List<String> splitNumbers = Arrays.asList(numbersString.split(delimiterRegex));
        return splitNumbers.stream().mapToInt(Integer::parseInt).sum();
    }

    private StringCalculator.InputData parseInputData(String inputString) {
        String delimiterRegex = "[,\n]";
        String numbersString = inputString;
        if (inputString.startsWith("//")) {
            delimiterRegex = inputString.substring(2, inputString.indexOf("\n"));
            numbersString = inputString.substring(inputString.indexOf("\n") + 1);

        }
        return new StringCalculator.InputData(delimiterRegex, numbersString);
    }

    private static final class InputData {
        private final String delimiterRegex;
        private final String numbersString;

        public InputData(String delimiterRegex, String numbersString) {
            this.delimiterRegex = delimiterRegex;
            this.numbersString = numbersString;
        }

        public String getDelimiterRegex() {
            return delimiterRegex;
        }

        public String getNumbersString() {
            return numbersString;
        }
    }
}


