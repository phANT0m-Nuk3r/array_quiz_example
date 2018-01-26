import quiz.Quiz;

/** Main class */
public class Main {

    /** APPLICATION ENTRY POINT */
    public static void main(String[] args) {
        /* VERSION #1 */

        try {
            // Create the quiz using test questions and answers
            Quiz quiz = new Quiz(Quiz.generateTestQuestions(), Quiz.generateTestAnswers());

            // Start the quiz
            quiz.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* VERSION #2

        try{
            // Create the quiz using test questions and answers
            Quiz quiz = new Quiz(Quiz.generateTestQuestionAndAnswers());

            // Start the quiz
            quiz.start();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        */
    }
}
