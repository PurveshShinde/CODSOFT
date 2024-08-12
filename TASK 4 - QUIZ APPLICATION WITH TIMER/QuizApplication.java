import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  

class QuizQuestion {  
    String query;  
    List<String> choices;  
    int answerIndex;  

    public QuizQuestion(String query, List<String> choices, int answerIndex) {  
        this.query = query;  
        this.choices = choices;  
        this.answerIndex = answerIndex;  
    }  
}  

public class QuizApplication {  
    private static List<QuizQuestion> quizQuestions = new ArrayList<>();  
    private static int userScore = 0;  
    
    public static void main(String[] args) {  
        // Setup quiz questions  
        loadQuestions();  
        startQuiz();  
        showResults();  
    }  

    private static void loadQuestions() {  
        quizQuestions.add(new QuizQuestion("Capital of France?", List.of("1. Berlin", "2. Paris", "3. Madrid", "4. Rome"), 1));  
        quizQuestions.add(new QuizQuestion("Red Planet?", List.of("1. Earth", "2. Mars", "3. Jupiter", "4. Venus"), 1));  
        quizQuestions.add(new QuizQuestion("Largest ocean?", List.of("1. Atlantic", "2. Indian", "3. Arctic", "4. Pacific"), 3));  
        quizQuestions.add(new QuizQuestion("Gold's symbol?", List.of("1. Au", "2. Ag", "3. Pb", "4. Fe"), 0));  
        quizQuestions.add(new QuizQuestion("Author of 'Romeo and Juliet'?", List.of("1. Mark Twain", "2. Charles Dickens", "3. Shakespeare", "4. J.K. Rowling"), 2));  
    }  

    private static void startQuiz() {  
        Scanner inputScanner = new Scanner(System.in);  
        
        for (int index = 0; index < quizQuestions.size(); index++) {  
            QuizQuestion currentQuestion = quizQuestions.get(index);  
            System.out.println("Q" + (index + 1) + ": " + currentQuestion.query);  
            currentQuestion.choices.forEach(System.out::println);  
            
            // Get user response  
            System.out.print("Choose (1-4): ");  
            int response = -1;  
            try {  
                response = Integer.parseInt(inputScanner.nextLine()) - 1;  
            } catch (NumberFormatException e) {  
                System.out.println("Invalid input!");  
                continue;  
            }  

            if (response == currentQuestion.answerIndex) {  
                userScore++;  
                System.out.println("Correct!");  
            } else {  
                System.out.println("Wrong. The correct answer is: " + (currentQuestion.answerIndex + 1));  
            }  
            System.out.println();  
        }  
    }  

    private static void showResults() {  
        System.out.println("Quiz Over! Final score: " + userScore + " out of " + quizQuestions.size());  
    }  
}
