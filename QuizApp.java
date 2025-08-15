import java.util.Scanner;

public class QuizApp {

    // Inner class to define a Question
    static class Question {
        String questionText;
        String[] options;
        char correctAnswer;

        public Question(String questionText, String[] options, char correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        // Display question and options
        public void display() {
            System.out.println(questionText);
            for (int i = 0; i < options.length; i++) {
                System.out.println((char) ('A' + i) + ". " + options[i]);
            }
        }

        // Check answer
        public boolean isCorrect(char userAnswer) {
            return Character.toUpperCase(userAnswer) == correctAnswer;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Create quiz questions
        Question[] questions = {
            new Question("1. What is the capital of France?",
                    new String[]{"Berlin", "London", "Paris", "Madrid"}, 'C'),
            new Question("2. Which language is used for Android development?",
                    new String[]{"Swift", "Kotlin", "Python", "Ruby"}, 'B'),
            new Question("3. Who wrote 'Romeo and Juliet'?",
                    new String[]{"Shakespeare", "Hemingway", "Tolkien", "Austen"}, 'A'),
            new Question("4. What is 5 + 7?",
                    new String[]{"10", "11", "12", "13"}, 'C'),
            new Question("5. Which planet is known as the Red Planet?",
                    new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 'B')
        };

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("----------------------------------");

        // Loop through questions
        for (Question q : questions) {
            q.display();
            System.out.print("Your answer (A/B/C/D): ");
            char userAnswer = scanner.next().charAt(0);
            if (q.isCorrect(userAnswer)) {
                System.out.println(" Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + q.correctAnswer + "\n");
            }
        }

        // Show final score
        System.out.println("----------------------------------");
        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + " out of " + questions.length);
        if (score == questions.length) {
            System.out.println(" Excellent!");
        } else if (score >= 3) {
            System.out.println(" Good job!");
        } else {
            System.out.println("Keep practicing!");
        }

        scanner.close();
    }
}
