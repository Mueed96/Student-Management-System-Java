import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class StudentRecordSystem {
    private LinkedList<Student> studentList;

    public StudentRecordSystem() {
        studentList = new LinkedList<>();
    }

    // Add a new student record
    public void addStudent(int id, String name, String course) {
        Student newStudent = new Student(id, name, course);
        studentList.add(newStudent);
        System.out.println("Student added: " + newStudent);
    }

    // Remove a student record by ID
    public void removeStudent(int id) {
        ListIterator<Student> iterator = studentList.listIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.id == id) {
                iterator.remove();
                System.out.println("Student removed: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Update a student record by ID
    public void updateStudent(int id, String newName, String newCourse) {
        for (Student student : studentList) {
            if (student.id == id) {
                student.name = newName;
                student.course = newCourse;
                System.out.println("Student updated: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Search for a student record by ID
    public void searchStudent(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Display all student records
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentRecordSystem srs = new StudentRecordSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student course: ");
                    String course = scanner.nextLine();
                    srs.addStudent(id, name, course);
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    id = scanner.nextInt();
                    srs.removeStudent(id);
                    break;
                case 3:
                    System.out.print("Enter student ID to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new student name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new student course: ");
                    course = scanner.nextLine();
                    srs.updateStudent(id, name, course);
                    break;
                case 4:
                    System.out.print("Enter student ID to search: ");
                    id = scanner.nextInt();
                    srs.searchStudent(id);
                    break;
                case 5:
                    srs.displayAllStudents();
                    break;
                case 6:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
