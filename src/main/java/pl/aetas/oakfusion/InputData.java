package pl.aetas.oakfusion;

import java.util.Collection;
import java.util.Collections;

final class InputData {
    private final Collection<String> delimiters;
    private final String numbersString;

    public InputData(Collection<String> delimiters, String numbersString) {
        this.delimiters = Collections.unmodifiableCollection(delimiters);
        this.numbersString = numbersString;
    }

    public Collection<String> getDelimiters() {
        return delimiters;
    }

    public String getNumbersString() {
        return numbersString;
    }
}
