package pl.aetas.oakfusion;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroWhenGivenEmptyString() throws Exception {
        int result = stringCalculator.add("");
        assertThat(result, is(0));
    }
}
