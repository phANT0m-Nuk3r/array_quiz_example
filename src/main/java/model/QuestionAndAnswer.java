package model;

import org.jetbrains.annotations.NotNull;

/** Class for containing Question and Answer Pairs */
public class QuestionAndAnswer {
    private final Question question;
    private final Answer answer;

    /** Constructor */
    public QuestionAndAnswer(@NotNull Question question, @NotNull Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    /** Get the Question object */
    @NotNull
    public Question getQuestion() {
        return question;
    }

    /** Get the Answer object */
    @NotNull
    public Answer getAnswer() {
        return answer;
    }
}
