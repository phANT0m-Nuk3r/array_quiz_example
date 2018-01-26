package model;

import org.jetbrains.annotations.NotNull;

/** Class for storing Answers */
public class Answer {
    private final String answer;

    /** Constructor */
    public Answer(@NotNull String answer) {
        this.answer = answer;
    }

    /** Get the Answer String */
    @NotNull
    public String get() {
        return answer;
    }
}
