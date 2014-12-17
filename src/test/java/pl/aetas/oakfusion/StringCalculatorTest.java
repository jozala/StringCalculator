package pl.aetas.oakfusion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void shouldAcceptChangedDelimiterWhenSpecifiedInFirstLineAfterTwoSlashes() throws Exception {
        int result = stringCalculator.add("//;\n1;2");
        assertThat(result, is(3));
    }

    @Test
    public void shouldChangeDelimiterWhenItIsSpecialCharacterInRegexp() throws Exception {
        int result = stringCalculator.add("//*\n2*4*1");
        assertThat(result, is(7));
    }

    @Test
    public void shouldThrowExceptionWithNegativeNumbersInMessageWhenCallingAddWithNegativeNumber() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("-1");
        expectedException.expectMessage("-99");
        stringCalculator.add("1,2,3,-1,2,-99");
    }

    @Test
    public void shouldSumOnlyNumberLessThen1000AndIgnoreHigherNumbers() throws Exception {
        int result = stringCalculator.add("1000,1001,3");
        assertThat(result, is(1003));
    }

    @Test
    public void shouldSupportMultiCharacterDelimiterWhenDelimiterIsSpecifiedInsideSquareBrackets() throws Exception {
        int result = stringCalculator.add("//[***]\n1***2***3");
        assertThat(result, is(6));
    }
}
