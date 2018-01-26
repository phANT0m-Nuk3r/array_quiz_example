package model;

import org.jetbrains.annotations.NotNull;

/** Class for storing Questions */
public class Question {
    private final String question;

    /** Constructor */
    public Question(@NotNull String question) {
        this.question = question;
    }

    /** Get the Question String */
    @NotNull
    public String get() {
        return question;
    }
}
