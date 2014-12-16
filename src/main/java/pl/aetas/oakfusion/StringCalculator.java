package pl.aetas.oakfusion;

public class StringCalculator {

    public int add(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }

        String[] splitNumbers = inputString.split(",");

        if (splitNumbers.length == 1) {
            return Integer.parseInt(splitNumbers[0]);
        }
        return Integer.parseInt(splitNumbers[0]) + Integer.parseInt(splitNumbers[1]);
    }
}


