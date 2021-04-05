package analyzer;

public class MarkdownTitle implements Title{

    private final String name;

    private final int level;

    public MarkdownTitle(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getName() {
        return name;
    }

}
