package quiz;

import model.Answer;
import model.Question;
import model.QuestionAndAnswer;
import org.jetbrains.annotations.NotNull;
import util.Util;

import java.util.*;
import java.util.function.Function;

/** CLI quiz class */
public class Quiz {
    private Question[] questions;
    private Answer[] answers;

    private int score;

    /**
     * Constructor taking two separate arrays
     */
    public Quiz(@NotNull Question[] questions, @NotNull Answer[] answers) throws Exception {
        this.questions = questions;
        this.answers = answers;
        this.score = 0;

        if (0 == questions.length || 0 == answers.length || questions.length != answers.length) {
            throw new Exception("Invalid arguments passed to Quiz constructor");
        }
    }

    /**
     * Constructor taking a Collection
     */
    public Quiz(@NotNull Set<QuestionAndAnswer> questionAndAnswerSet) throws Exception {
        if (questionAndAnswerSet.size() > 0) {
            this.questions = new Question[questionAndAnswerSet.size()];
            this.answers = new Answer[questionAndAnswerSet.size()];
            this.score = 0;

            Iterator<QuestionAndAnswer> iter = questionAndAnswerSet.iterator();
            for (int i = 0; iter.hasNext(); ++i) {
                QuestionAndAnswer qa = iter.next();
                questions[i] = new Question(qa.getQuestion().get());
                answers[i] = new Answer(qa.getAnswer().get());
            }
        } else {
            throw new Exception("Invalid arguments passed to Quiz constructor");
        }
    }

    /**
     * Begin the quiz
     */
    public void start() {
        boolean retry = false;

        do {
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < questions.length; ++i) {
                Question question = questions[i];
                prompt(question.get());

                String attempt = scanner.nextLine();

                Answer answer = answers[i];

                if (attempt.equals(answer.get())) {
                    ++score;
                    prompt("\nCorrect!\n\n");
                } else {
                    prompt("\nIncorrect!\n\n");
                }
            }

            prompt("You scored: " + score + " out of " + questions.length + " points!" + "\n");

            // If the user scored less than 100% ask them if they'd like to retry
            if (score < questions.length) {
                // Function checks if a Character equals 'Y'/'y' || 'N'/'n'
                Function<@NotNull Character, Boolean> firstCheck = character -> character.toString().toLowerCase().equals("y") || character.toString().toLowerCase().equals("n");

                // Get character using utility method
                Character choice = Util.getChar("Try again (Y/n): ", firstCheck);

                // Set the retry condition which is about to be evaluated
                retry = choice.toString().toLowerCase().equals("y");
            } else {
                retry = false;
                System.out.println("Quiz over!");
            }

            // Reset score in case of a retry attempt
            score = 0;
        } while (retry);
    }

    /**
     * Simple print abstraction
     */
    private void prompt(String s) {
        System.out.print(s);
    }

    /**
     * Static method for generating 'test' questions
     */
    @NotNull
    public static Question[] generateTestQuestions() {

        return new Question[]{
                new Question("1 + 1 = "),
                new Question("2 * 2 = "),
                new Question("sqrt(81) = ")};
    }

    /**
     * Static method for generating 'test' answers
     */
    @NotNull
    public static Answer[] generateTestAnswers() {

        return new Answer[]{
                new Answer("2"),
                new Answer("4"),
                new Answer("9")};
    }

    /**
     * Static method for generating 'test' Set<QuestionAndAnswer>
     */
    @NotNull
    public static Set<QuestionAndAnswer> generateTestQuestionAndAnswers() {
        return new LinkedHashSet<>(
                Arrays.asList(
                        new QuestionAndAnswer(new Question("1 + 1 = "), new Answer("2")),
                        new QuestionAndAnswer(new Question("2 * 2 = "), new Answer("4")),
                        new QuestionAndAnswer(new Question("sqrt(81) = "), new Answer("9"))
                )
        );
    }
}
