import java.util.Scanner;

public class StudyTracker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Weekly goal in minutes
        int weeklyGoal = 600;

        // Accumulators: total minutes for each subject
        int programming = 0;
        int mathematics = 0;
        int english = 0;
        int other = 0;

        // Total study time and number of sessions
        int totalTime = 0;
        int sessions = 0;

        // ===== Main menu loop: repeats until the student chooses Exit =====
        while (true) {
            System.out.println("===== STUDY TRACKER =====");
            System.out.println();
            System.out.println("1. Add study session");
            System.out.println("2. View statistics");
            System.out.println("3. Check weekly goal");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            System.out.println();

            if (option == 1) {
                // ===== Option 1: Add study session =====
                System.out.println("Choose subject:");
                System.out.println("1. Programming");
                System.out.println("2. Mathematics");
                System.out.println("3. English");
                System.out.println("4. Other");
                System.out.println();
                System.out.print("Choose an option: ");
                int subject = scanner.nextInt();

                // Validate the subject choice
                if (subject < 1 || subject > 4) {
                    System.out.println("\nInvalid subject. Please choose a number from 1 to 4.\n");
                    continue; // back to the main menu, nothing is added
                }

                System.out.print("Study time in minutes: ");
                int minutes = scanner.nextInt();

                // Validate the study time
                if (minutes <= 0) {
                    System.out.println("\nInvalid study time. Time must be greater than 0.\n");
                    continue; // back to the main menu, totals are unchanged
                }

                // Add minutes to the selected subject
                if (subject == 1) {
                    programming += minutes;
                } else if (subject == 2) {
                    mathematics += minutes;
                } else if (subject == 3) {
                    english += minutes;
                } else {
                    other += minutes;
                }

                // Update total time and number of sessions
                totalTime += minutes;
                sessions++;

                System.out.println("\nStudy session added!");
                System.out.println("Current total study time: " + totalTime + " minutes\n");

            } else if (option == 2) {
                // ===== Option 2: View statistics =====
                System.out.println("===== WEEKLY STATISTICS =====");
                System.out.println();
                System.out.println("Study sessions: " + sessions);
                System.out.println("Total study time: " + totalTime + " minutes");
                System.out.println();
                System.out.println("Programming: " + programming + " minutes");
                System.out.println("Mathematics: " + mathematics + " minutes");
                System.out.println("English: " + english + " minutes");
                System.out.println("Other: " + other + " minutes");
                System.out.println();

            } else if (option == 3) {
                // ===== Option 3: Check weekly goal =====
                System.out.println("Weekly goal: " + weeklyGoal + " minutes");
                System.out.println("You studied: " + totalTime + " minutes");

                if (totalTime >= weeklyGoal) {
                    System.out.println("Weekly goal achieved!");
                } else {
                    System.out.println("Remaining: " + (weeklyGoal - totalTime) + " minutes");
                }
                System.out.println();

            } else if (option == 4) {
                // ===== Option 4: Exit =====
                System.out.println("Study tracker closed. Keep up the good work!");
                break;

            } else {
                // Invalid menu choice
                System.out.println("Invalid option. Please choose a number from 1 to 4.\n");
            }
        }
    }
}
