package analyzer;

import analyzer.model.MarkdownTests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarkdownAnalyzerTest {

    private final TextTitlesAnalyzer analyzer = new MarkdownTextTitlesAnalyzer();

    @ParameterizedTest
    @EnumSource(MarkdownTests.class)
    void analyzeTest(MarkdownTests test){
        analyzer.analyzeText(new Scanner(test.getInput()));
        assertEquals(test.getOutput(), analyzer.getFullText());
    }

}
