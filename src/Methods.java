import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Methods {

    private static final String FOLDER_PATH = "D:/DATA";
    private static final String FILE_PATH = FOLDER_PATH+File.separator+"students.txt";

    public static void addStudent(Student student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(student.getName() + "," + student.getScore());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    students.add(new Student(name, score));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void categorizeStudents(ArrayList<Student> students, String type) {
        ArrayList<Student> failed = new ArrayList<>();
        ArrayList<Student> bad = new ArrayList<>();
        ArrayList<Student> ok = new ArrayList<>();
        ArrayList<Student> excellent = new ArrayList<>();

        for (Student student : students) {
            if (student.getScore() < 50) {
                failed.add(student);
            } else if (student.getScore() < 65) {
                bad.add(student);
            } else if (student.getScore() < 80) {
                ok.add(student);
            } else {
                excellent.add(student);
            }
        }

        switch (type.toLowerCase()) {
            case "failed":
                System.out.println("Failed students: " + failed);
                break;
            case "bad":
                System.out.println("Bad students: " + bad);
                break;
            case "ok":
                System.out.println("OK students: " + ok);
                break;
            case "excellent":
                System.out.println("Excellent students: " + excellent);
                break;
            case "all":
                System.out.println("Failed students: " + failed);
                System.out.println("Bad students: " + bad);
                System.out.println("OK students: " + ok);
                System.out.println("Excellent students: " + excellent);
                break;
            default:
                System.out.println("Invalid category type.");
        }
    }
}


