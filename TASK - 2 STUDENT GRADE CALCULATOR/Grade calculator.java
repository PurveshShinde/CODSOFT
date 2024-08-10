import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSubjects = getTotalSubjects(scanner);
        int[] marks = getMarks(scanner, totalSubjects);

        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, totalSubjects);

        displayResults(totalMarks, averagePercentage, determineGrade(averagePercentage));

        scanner.close();
    }

    private static int getTotalSubjects(Scanner scanner) {
        System.out.print("Enter the total number of subjects: ");
        return scanner.nextInt();
    }

    private static int[] getMarks(Scanner scanner, int totalSubjects) {
        int[] marks = new int[totalSubjects];
        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        return marks;
    }

    private static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int totalSubjects) {
        return (double) totalMarks / totalSubjects;
    }

    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    private static char determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
