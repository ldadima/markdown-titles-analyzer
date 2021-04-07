package analyzer;

import java.util.Scanner;

public interface TextHeadersAnalyzer {

    void analyzeText(Scanner text);

    String getTableOfContents();

    String getFullText();

}
