import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Quit");

            System.out.print("Enter your choice (1/2/3/4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the task: ");
                    String task = scanner.nextLine();
                    addTask(todoList, task);
                    break;
                case 2:
                    viewTasks(todoList);
                    break;
                case 3:
                    viewTasks(todoList);
                    System.out.print("Enter the task number to remove: ");
                    int taskIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    removeTask(todoList, taskIndex);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void addTask(ArrayList<String> todoList, String task) {
        todoList.add(task);
        System.out.println("Task '" + task + "' has been added to the to-do list.");
    }

    private static void viewTasks(ArrayList<String> todoList) {
        if (todoList.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    private static void removeTask(ArrayList<String> todoList, int taskIndex) {
        if (taskIndex >= 1 && taskIndex <= todoList.size()) {
            String removedTask = todoList.remove(taskIndex - 1);
            System.out.println("Task '" + removedTask + "' has been removed from the to-do list.");
        } else {
            System.out.println("Invalid task index. Please enter a valid task number.");
        }
    }
}