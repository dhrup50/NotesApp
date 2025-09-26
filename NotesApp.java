package basicsthread;

import java.io.*;
import java.util.Scanner;

public class NotesApp {

    // Method to add note
    public static void addNote() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try (FileWriter fw = new FileWriter("notes.txt", true)) {
            fw.write(note + System.lineSeparator());
            System.out.println("✅ Note saved successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error writing note: " + e.getMessage());
        }
    }

    // Method to view notes
    public static void viewNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            System.out.println("\n--- Saved Notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠ No notes found yet.");
        } catch (IOException e) {
            System.out.println("❌ Error reading notes: " + e.getMessage());
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Notes App =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("👋 Exiting Notes App. Goodbye!");
                    break;
                default:
                    System.out.println("⚠ Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
