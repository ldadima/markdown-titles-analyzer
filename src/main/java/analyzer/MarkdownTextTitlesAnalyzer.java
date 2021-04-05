package analyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MarkdownTextTitlesAnalyzer implements TextTitlesAnalyzer {

    private String text;
    private final List<Title> titles = new ArrayList<>();

    @Override
    public void analyzeText(Scanner text) {
        StringBuilder allText = new StringBuilder();
        while (text.hasNext()) {
            String line = text.nextLine();
            Title title = getTitle(line);
            if (title != null) {
                titles.add(title);
            }
            allText.append(line).append("\n");
        }
        this.text = allText.toString();
    }

    private Title getTitle(String line) {
        int level = 0;
        while (line.charAt(level) == '#') {
            level++;
        }
        if(level == 0){
            return null;
        }
        String name = line.replaceFirst("#+ +", "");
        return new MarkdownTitle(name, level);
    }

    @Override
    public String getTableOfContents() {
        Map<Integer, Integer> levelsCounter = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        int currentLevel = 0;
        for(var title: titles){
            while (currentLevel > title.getLevel()){
                levelsCounter.put(currentLevel, 1);
                currentLevel--;
            }
            currentLevel = title.getLevel();
            levelsCounter.putIfAbsent(currentLevel, 1);
            stringBuilder.append("\t".repeat(currentLevel - 1));
            stringBuilder.append(levelsCounter.get(currentLevel))
                    .append(". [")
                    .append(title.getName())
                    .append("](#")
                    .append(title.getName().toLowerCase().replace(' ', '-'))
                    .append(")\n");
            levelsCounter.merge(currentLevel, 1, Integer::sum);
        }
        return stringBuilder.toString();
    }

    @Override
    public String getFullText() {
        return getTableOfContents() + "\n" + text;
    }
}

