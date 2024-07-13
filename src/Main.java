import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your role: 1 for Laborant, 2 for Dekan");
        int role = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        switch (role) {
            case 1:
                System.out.println("Laborant: Add a new student");
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter student score: ");
                int score = scanner.nextInt();
                Methods.addStudent(new Student(name, score));
                break;
            case 2:
                System.out.println("Dekan: Choose a category (failed, bad, ok, excellent, all)");
                String type = scanner.nextLine();
                ArrayList<Student> students = (ArrayList<Student>) Methods.readStudents();
                Methods.categorizeStudents(students, type);
                break;
            default:
                System.out.println("Invalid role selected.");
        }

        scanner.close();
    }
}
