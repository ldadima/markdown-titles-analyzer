package analyzer.model;

public enum MarkdownTests {
    EMPTY("",""),
    NESTED_AT_END("""
            # My Project
            ## Idea
            content
            ## Implementation
            ### Step 1
            content
            ### Step 2
            content
            """,
            """
                    1. [My Project](#my-project)
                    \t1. [Idea](#idea)
                    \t2. [Implementation](#implementation)
                    \t\t1. [Step 1](#step-1)
                    \t\t2. [Step 2](#step-2)
                                        
                    # My Project
                    ## Idea
                    content
                    ## Implementation
                    ### Step 1
                    content
                    ### Step 2
                    content
                    """),
    NESTED_AT_MIDDLE("""
            # My Project
            ## Implementation
            ### Step 1
            content
            ### Step 2
            content
            ## Idea
            content
            """, """
            1. [My Project](#my-project)
            \t1. [Implementation](#implementation)
            \t\t1. [Step 1](#step-1)
            \t\t2. [Step 2](#step-2)
            \t2. [Idea](#idea)
                                        
            # My Project
            ## Implementation
            ### Step 1
            content
            ### Step 2
            content
            ## Idea
            content
            """),
    MANY_HEADERS("""
            # My Project
            ## Idea
            content
            ## Implementation
            ### Step 1
            content
            ### Step 2
            content
            # My New Project
            ## Idea
            content
            ## Implementation
            ### Step 1
            content
            ### Step 2
            content
            #### Step 2.1
            content
            # My Project
            ## Step 1
            content
            ### Step 1.1
            content
            ## Step 2
            content
            """,
            """
                    1. [My Project](#my-project)
                    \t1. [Idea](#idea)
                    \t2. [Implementation](#implementation)
                    \t\t1. [Step 1](#step-1)
                    \t\t2. [Step 2](#step-2)
                    2. [My New Project](#my-new-project)
                    \t1. [Idea](#idea)
                    \t2. [Implementation](#implementation)
                    \t\t1. [Step 1](#step-1)
                    \t\t2. [Step 2](#step-2)
                    \t\t\t1. [Step 2.1](#step-2.1)
                    3. [My Project](#my-project)
                    \t1. [Step 1](#step-1)
                    \t\t1. [Step 1.1](#step-1.1)
                    \t2. [Step 2](#step-2)
                    
                    # My Project
                    ## Idea
                    content
                    ## Implementation
                    ### Step 1
                    content
                    ### Step 2
                    content
                    # My New Project
                    ## Idea
                    content
                    ## Implementation
                    ### Step 1
                    content
                    ### Step 2
                    content
                    #### Step 2.1
                    content
                    # My Project
                    ## Step 1
                    content
                    ### Step 1.1
                    content
                    ## Step 2
                    content
                    """);

    private final String input;
    private final String output;

    MarkdownTests(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }
}
