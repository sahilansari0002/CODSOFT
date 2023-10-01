/**
 * Program: Student Management System. 
 * Developer: Sahil Ali
 * Project: Codsoft Internship Task
 * Date Created: September 26, 2023
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String stdname;
    private int roll_no;
    private String grade;

    public Student(String stdname, int roll_no, String grade) {
        this.stdname = stdname;
        this.roll_no = roll_no;
        this.grade = grade;
    }

    public String getstdname() {
        return stdname;
    }

    public int getroll_no() {
        return roll_no;
    }

    public String getGrade() {
        return grade;
    }

     public String toString() {
        return "stdname: " + stdname + ", Roll Number: " + roll_no + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int roll_no) {
        for (Student student : students) {
            if (student.getroll_no() == roll_no) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        System.out.println("List of all students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student searchStudent(int roll_no) {
        for (Student student : students) {
            if (student.getroll_no() == roll_no) {
                return student;
            }
        }
        return null;
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentManagementSystem action = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student Name: ");
                    String stdname = input.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll_no = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = input.nextLine();
                    action.addStudent(new Student(stdname, roll_no, grade));
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeroll_no = input.nextInt();
                    action.removeStudent(removeroll_no);
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchroll_no = input.nextInt();
                    Student foundStudent = action.searchStudent(searchroll_no);
                    if (foundStudent != null) {
                        System.out.println("Found Student: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    action.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System.");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
