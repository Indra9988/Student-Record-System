import java.util.*;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class Main {
    static ArrayList<Student> students = new ArrayList<>();

    // ✅ Sample Data Method
    static void addSampleStudents() {
        students.add(new Student(101, "Ravi", 85));
        students.add(new Student(102, "Priya", 92));
        students.add(new Student(103, "Amit", 78));
        students.add(new Student(104, "Sneha", 88));
        students.add(new Student(105, "Kiran", 81));
        students.add(new Student(106, "Anjali", 95));
        students.add(new Student(107, "Rahul", 73));
        students.add(new Student(108, "Pooja", 89));
        students.add(new Student(109, "Vikram", 76));
        students.add(new Student(110, "Neha", 91));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        addSampleStudents(); // ✅ Automatically load data

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(sc); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(sc); break;
                case 4: deleteStudent(sc); break;
                case 5: 
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default: 
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ✅ Add Student
    static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("✅ Student Added Successfully!");
    }

    // ✅ View Students
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.display();
        }
    }

    // ✅ Update Student
    static void updateStudent(Scanner sc) {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                sc.nextLine();
                System.out.print("Enter new name: ");
                s.name = sc.nextLine();

                System.out.print("Enter new marks: ");
                s.marks = sc.nextDouble();

                System.out.println("✅ Updated successfully!");
                return;
            }
        }

        System.out.println("❌ Student not found!");
    }

    // ✅ Delete Student
    static void deleteStudent(Scanner sc) {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                System.out.println("✅ Deleted successfully!");
                return;
            }
        }

        System.out.println("❌ Student not found!");
    }
}