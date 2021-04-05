import analyzer.MarkdownTextTitlesAnalyzer;
import analyzer.TextTitlesAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        TextTitlesAnalyzer analyzer = new MarkdownTextTitlesAnalyzer();
        try {
            analyzer.analyzeText(new Scanner(new File(args[0])));
            System.out.println(analyzer.getFullText());
        } catch (FileNotFoundException e) {
            System.err.printf("File %s doesn't exist%n", args[0]);
        }
    }
}
