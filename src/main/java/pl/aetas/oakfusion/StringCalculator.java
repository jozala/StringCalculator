package pl.aetas.oakfusion;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER_REGEX = "[,\n]";
    public static final String NONDEFAULT_DELIMITER_INDICATOR = "//";
    public static final int MAX_LIMIT_NUMBER_VALUE = 1000;

    public int add(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }

        StringCalculator.InputData inputData = parseInputData(inputString);
        List<Integer> numbers = splitNumbers(inputData);

        List<Integer> negativeNumbers = findNegativeNumbers(numbers);
        if (!negativeNumbers.isEmpty()) {
            String negativeNumbersString = negativeNumbers.stream().map(Object::toString).collect(Collectors.joining(", "));
            throw new IllegalArgumentException("Negative numbers in input are illegal: " + negativeNumbersString);
        }

        return numbers.stream()
                .filter(number -> number <= MAX_LIMIT_NUMBER_VALUE)
                .reduce(0, (acc, number) -> acc + number);
    }

    private List<Integer> findNegativeNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number < 0)
                .collect(Collectors.toList());
    }

    private List<Integer> splitNumbers(StringCalculator.InputData inputData) {
        String numbersString = inputData.getNumbersString();
        String[] splitNumbers = numbersString.split(inputData.getDelimiterRegex());
        return Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    private StringCalculator.InputData parseInputData(String inputString) {
        String delimiterRegex = DEFAULT_DELIMITER_REGEX;
        String numbersString = inputString;
        if (inputString.startsWith(NONDEFAULT_DELIMITER_INDICATOR)) {
            delimiterRegex = inputString.substring(2, inputString.indexOf("\n"));
            if (delimiterRegex.startsWith("[") && delimiterRegex.endsWith("]")) {
                delimiterRegex = delimiterRegex.substring(1).substring(0,delimiterRegex.length()-2);
            }
            delimiterRegex = Pattern.quote(delimiterRegex);
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


