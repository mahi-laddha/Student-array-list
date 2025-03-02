import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentManagement {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add Student
    public void addStudent() {
        System.out.print("Enter PRN: ");
        String prn = scanner.next();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter DOB (dd-MM-yyyy): ");
        String dobStr = scanner.next();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            students.add(new Student(prn, name, sdf.parse(dobStr), marks));
            System.out.println("Student added successfully!");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Use dd-MM-yyyy.");
        }
    }

    // Display All Students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    // Search by PRN
    public void searchByPrn() {
        System.out.print("Enter PRN to search: ");
        String prn = scanner.next();
        for (Student s : students) {
            if (s.getPrn().equals(prn)) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search by Name
    public void searchByName() {
        System.out.print("Enter Name to search: ");
        String name = scanner.next();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                s.display();
            }
        }
    }

    // Update Student
    public void updateStudent() {
        System.out.print("Enter PRN to update: ");
        String prn = scanner.next();
        for (Student s : students) {
            if (s.getPrn().equals(prn)) {
                System.out.print("Enter new Name: ");
                s.setName(scanner.next());
                System.out.print("Enter new Marks: ");
                s.setMarks(scanner.nextDouble());
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Delete Student
    public void deleteStudent() {
        System.out.print("Enter PRN to delete: ");
        String prn = scanner.next();
        students.removeIf(s -> s.getPrn().equals(prn));
        System.out.println("Student deleted (if PRN existed).");
    }
}
