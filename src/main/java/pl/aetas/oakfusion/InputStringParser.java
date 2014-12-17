package pl.aetas.oakfusion;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputStringParser {

    private static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", "\n");
    private static final String NONDEFAULT_DELIMITER_INDICATOR = "//";

    public InputData parseInputData(String inputString) {
        if (inputString.startsWith(NONDEFAULT_DELIMITER_INDICATOR)) {
            Collection<String> delimiters = readNonDefaultDelimiters(inputString);
            String numbersString = inputString.substring(inputString.indexOf("\n") + 1);
            return new InputData(delimiters, numbersString);
        }
        return new InputData(DEFAULT_DELIMITERS, inputString);
    }

    private Collection<String> readNonDefaultDelimiters(String inputString) {
        String delimiter = inputString.substring(2, inputString.indexOf("\n"));
        if (delimiter.startsWith("[") && delimiter.endsWith("]")) {
            delimiter = delimiter.substring(1).substring(0,delimiter.length()-2);
            return Arrays.stream(delimiter.split("\\]\\[")).collect(Collectors.toList());
        }
        return Collections.singleton(delimiter);
    }
}
