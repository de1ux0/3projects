import java.util.Scanner;

public class ScreenTimeTracker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Accumulators: minutes for each category
        int socialMedia = 0;
        int gaming = 0;
        int studying = 0;
        int streaming = 0;

        // Total screen time and number of recorded sessions
        int totalTime = 0;
        int sessions = 0;

        // ===== Main menu loop: repeats until the student chooses Exit =====
        while (true) {
            System.out.println("===== SCREEN-TIME TRACKER =====");
            System.out.println();
            System.out.println("1. Add social media time");
            System.out.println("2. Add gaming time");
            System.out.println("3. Add studying time");
            System.out.println("4. Add video or streaming time");
            System.out.println("5. View statistics");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            System.out.println();

            if (option >= 1 && option <= 4) {
                // ===== Options 1-4: Add screen time =====
                if (option == 1) {
                    System.out.print("Enter social media minutes: ");
                } else if (option == 2) {
                    System.out.print("Enter gaming minutes: ");
                } else if (option == 3) {
                    System.out.print("Enter studying minutes: ");
                } else {
                    System.out.print("Enter video or streaming minutes: ");
                }
                int minutes = scanner.nextInt();

                // Validate the time: must be greater than 0
                if (minutes <= 0) {
                    System.out.println("\nInvalid time. Minutes must be greater than 0.\n");
                    continue; // statistics stay unchanged
                }

                // Add minutes to the selected category
                if (option == 1) {
                    socialMedia += minutes;
                } else if (option == 2) {
                    gaming += minutes;
                } else if (option == 3) {
                    studying += minutes;
                } else {
                    streaming += minutes;
                }

                // Update total time and number of sessions
                totalTime += minutes;
                sessions++;

                System.out.println("\nTime added successfully!\n");

            } else if (option == 5) {
                // ===== Option 5: View statistics =====
                System.out.println("===== TODAY'S SCREEN TIME =====");
                System.out.println();
                System.out.println("Social media: " + socialMedia + " minutes");
                System.out.println("Gaming: " + gaming + " minutes");
                System.out.println("Studying: " + studying + " minutes");
                System.out.println("Streaming: " + streaming + " minutes");
                System.out.println();
                System.out.println("Total screen time: " + totalTime + " minutes");
                System.out.println("Recorded sessions: " + sessions);
                System.out.println();

                // Productive vs. entertainment time
                int entertainmentTime = socialMedia + gaming + streaming;

                if (studying > entertainmentTime) {
                    System.out.println("Study screen time is greater than entertainment screen time. Good balance!");
                } else if (studying < entertainmentTime) {
                    System.out.println("Entertainment screen time is greater than study time.");
                } else {
                    System.out.println("Study and entertainment screen time are equal.");
                }
                System.out.println();

                // Daily screen-time message
                if (totalTime < 120) {
                    System.out.println("Low screen time");
                } else if (totalTime <= 240) {
                    System.out.println("Moderate screen time");
                } else {
                    System.out.println("High screen time");
                }
                System.out.println();

            } else if (option == 6) {
                // ===== Option 6: Exit =====
                System.out.println("Screen-time tracker closed.");
                break;

            } else {
                // Invalid menu choice
                System.out.println("Invalid option. Please choose a number from 1 to 6.\n");
            }
        }
    }
}
