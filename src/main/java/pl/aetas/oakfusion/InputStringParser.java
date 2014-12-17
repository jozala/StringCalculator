package pl.aetas.oakfusion;

import java.util.regex.Pattern;

public class InputStringParser {

    private static final String DEFAULT_DELIMITER_REGEX = "[,\n]";
    private static final String NONDEFAULT_DELIMITER_INDICATOR = "//";

    public InputData parseInputData(String inputString) {
        String delimiterRegex = DEFAULT_DELIMITER_REGEX;
        String numbersString = inputString;
        if (inputString.startsWith(NONDEFAULT_DELIMITER_INDICATOR)) {
            delimiterRegex = readNonDefaultDelimiter(inputString);
            numbersString = inputString.substring(inputString.indexOf("\n") + 1);
        }
        return new InputData(delimiterRegex, numbersString);
    }

    private String readNonDefaultDelimiter(String inputString) {
        String delimiterRegex = inputString.substring(2, inputString.indexOf("\n"));
        if (delimiterRegex.startsWith("[") && delimiterRegex.endsWith("]")) {
            delimiterRegex = delimiterRegex.substring(1).substring(0,delimiterRegex.length()-2);
        }
        return Pattern.quote(delimiterRegex);
    }
}
