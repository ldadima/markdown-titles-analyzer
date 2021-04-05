package analyzer;

import java.util.Scanner;

public interface TextTitlesAnalyzer {

    void analyzeText(Scanner text);

    String getTableOfContents();

    String getFullText();

}
