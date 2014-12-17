package pl.aetas.oakfusion;

final class InputData {
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
