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

    @Test
    public void shouldReturnTheGivenNumberWhenSingleNumberGiven() throws Exception {
        int result = stringCalculator.add("2");
        assertThat(result, is(2));
    }

    @Test
    public void shouldReturnSumOfTwoNumbersWhenTwoCommaSeparatedNumbersGiven() throws Exception {
        int result = stringCalculator.add("1,2");
        assertThat(result, is(3));
    }

    @Test
    public void shouldReturnSumOfAnyAmountOfNumbers() throws Exception {
        int result = stringCalculator.add("1,2,3,1");
        assertThat(result, is(7));
    }

    @Test
    public void shouldSumNumbersWhenNumbersAreSeparatedByNewLineSignsAndCommas() throws Exception {
        int result = stringCalculator.add("1\n2,3");
        assertThat(result, is(6));
    }
}
