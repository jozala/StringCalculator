package pl.aetas.oakfusion;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final int MAX_LIMIT_NUMBER_VALUE = 1000;

    private final InputStringParser inputStringParser;

    public StringCalculator(InputStringParser inputStringParser) {
        this.inputStringParser = inputStringParser;
    }

    public int add(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }

        InputData inputData = inputStringParser.parseInputData(inputString);
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

    private List<Integer> splitNumbers(InputData inputData) {
        String numbersString = inputData.getNumbersString();
        String allDelimitersRegex = inputData.getDelimiters().stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        String[] splitNumbers = numbersString.split(allDelimitersRegex);
        return Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}


