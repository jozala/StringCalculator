package pl.aetas.oakfusion;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class InputStringParserTest {
    private InputStringParser inputStringParser;

    @Before
    public void setUp() throws Exception {
        inputStringParser = new InputStringParser();
    }

    @Test
    public void shouldParseMultipleDelimitersWhenPassedInSeparateSquareBrackets() throws Exception {
        InputData inputData = inputStringParser.parseInputData("//[**][&]\n1**2&3");
        assertThat(inputData.getDelimiters(), containsInAnyOrder("**","&"));
    }
}