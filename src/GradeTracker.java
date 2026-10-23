import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Accumulators and counters (individual scores are not stored)
        double assignmentPoints = 0;
        int assignmentCount = 0;
        double examPoints = 0;
        int examCount = 0;

        // ===== Main menu loop: repeats until the student chooses Exit =====
        while (true) {
            System.out.println("===== SEMESTER GRADE TRACKER =====");
            System.out.println();
            System.out.println("1. Add assignment result");
            System.out.println("2. Add exam result");
            System.out.println("3. View current grade");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            System.out.println();

            if (option == 1) {
                // ===== Option 1: Add assignment result =====
                System.out.print("Enter assignment score: ");
                double score = scanner.nextDouble();

                // A valid score is between 0 and 100, inclusive
                if (score < 0 || score > 100) {
                    System.out.println("\nInvalid score. Enter a value from 0 to 100.\n");
                } else {
                    assignmentPoints += score;
                    assignmentCount++;
                    System.out.println("\nAssignment score added.\n");
                }

            } else if (option == 2) {
                // ===== Option 2: Add exam result =====
                System.out.print("Enter exam score: ");
                double score = scanner.nextDouble();

                if (score < 0 || score > 100) {
                    System.out.println("\nInvalid score. Enter a value from 0 to 100.\n");
                } else {
                    examPoints += score;
                    examCount++;
                    System.out.println("\nExam score added.\n");
                }

            } else if (option == 3) {
                // ===== Option 3: View current grade =====
                if (assignmentCount == 0 && examCount == 0) {
                    // Empty-data rule: never divide by zero
                    System.out.println("No results available yet.\n");
                } else {
                    double assignmentAverage = 0;
                    double examAverage = 0;
                    double overallAverage;

                    // Calculate each average only when its counter is greater than 0
                    if (assignmentCount > 0) {
                        assignmentAverage = assignmentPoints / assignmentCount;
                    }
                    if (examCount > 0) {
                        examAverage = examPoints / examCount;
                    }

                    // Overall average: equal weights when both categories have results,
                    // otherwise the average of the only available category
                    if (assignmentCount > 0 && examCount > 0) {
                        overallAverage = assignmentAverage * 0.50 + examAverage * 0.50;
                    } else if (assignmentCount > 0) {
                        overallAverage = assignmentAverage;
                    } else {
                        overallAverage = examAverage;
                    }

                    // Round to 2 decimal places for display
                    assignmentAverage = Math.round(assignmentAverage * 100) / 100.0;
                    examAverage = Math.round(examAverage * 100) / 100.0;
                    double shownOverall = Math.round(overallAverage * 100) / 100.0;

                    System.out.println("===== CURRENT RESULTS =====");
                    System.out.println();
                    System.out.println("Assignments completed: " + assignmentCount);
                    if (assignmentCount > 0) {
                        System.out.println("Assignment average: " + assignmentAverage);
                    } else {
                        System.out.println("Assignment average: no results yet");
                    }
                    System.out.println();
                    System.out.println("Exams completed: " + examCount);
                    if (examCount > 0) {
                        System.out.println("Exam average: " + examAverage);
                    } else {
                        System.out.println("Exam average: no results yet");
                    }
                    System.out.println();

                    // Explain what the overall average is based on
                    if (assignmentCount == 0) {
                        System.out.println("Note: no assignment results yet, overall average is based on exams only.");
                    } else if (examCount == 0) {
                        System.out.println("Note: no exam results yet, overall average is based on assignments only.");
                    }
                    System.out.println("Overall average: " + shownOverall);

                    // Letter grade (uses the exact average, not the rounded one)
                    String grade;
                    if (overallAverage >= 90) {
                        grade = "A";
                    } else if (overallAverage >= 80) {
                        grade = "B";
                    } else if (overallAverage >= 70) {
                        grade = "C";
                    } else if (overallAverage >= 60) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }
                    System.out.println("Grade: " + grade);

                    // The student passes with an overall average of 60 or higher
                    if (overallAverage >= 60) {
                        System.out.println("Status: Passing");
                    } else {
                        System.out.println("Status: Failing");
                    }
                    System.out.println();
                }

            } else if (option == 4) {
                // ===== Option 4: Exit =====
                System.out.println("Grade tracker closed. Good luck with your studies!");
                break;

            } else {
                // Invalid menu choice
                System.out.println("Invalid option. Please choose a number from 1 to 4.\n");
            }
        }
    }
}
