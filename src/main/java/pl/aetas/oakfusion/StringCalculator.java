package pl.aetas.oakfusion;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int add(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }

        List<String> splitNumbers = Arrays.asList(inputString.split(","));
        return splitNumbers.stream().mapToInt(Integer::parseInt).sum();
    }
}


