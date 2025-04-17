import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== To-Do List =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> removeTask();
                case 4 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 4);
    }

    static void addTask() {
        System.out.print("Enter a new task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added!");
    }

    static void viewTasks() {
        System.out.println("\n--- Your Tasks ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    static void removeTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter the task number to remove: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (index > 0 && index <= tasks.size()) {
                tasks.remove(index - 1);
                System.out.println("Task removed.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}