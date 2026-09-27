package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if (students == null || students.length == 0) return null;
        Student oldest = students[0];
        for (Student s : students) {
            if (s.getAge() > oldest.getAge()) {
                oldest = s;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for (Student s : students) {
            if (s.isAdult()) { // ou s.getAge() >= 18
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students == null || students.length == 0) return 0.0;
        double sum = 0;
        for (Student s : students) {
            sum += s.getGrade();
        }
        return sum / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getGrade() < students[j + 1].getGrade()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student s : students) {
            if (s.getGrade() >= 15) {
                System.out.println(s.getName() + " (Note: " + s.getGrade() + ")");
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        boolean duplicateFound = false;
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getName().equalsIgnoreCase(students[j].getName())) {
                    duplicateFound = true;
                    break;
                }
            }
        }
        return duplicateFound;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newArray = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newArray[i] = students[i];
        }
        newArray[newArray.length - 1] = newStudent;
        return newArray;
    }


    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[] {
                new Student(1, "Alice", 19, 16),
                new Student(2, "Bob", 17, 14),
                new Student(3, "Charlie", 21, 18),
                new Student(4, "Dina", 18, 12),
                new Student(5, "Alice", 20, 15)
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("Oldest: " + findOldest(arr));

        // 3) Count adults
        System.out.println("Number of adults: " + countAdults(arr));

        // 4) Average grade
        System.out.println("Average grade: " + averageGrade(arr));

        // 5) Find by name
        System.out.println("Finding Alice: " + findStudentByName(arr, "ALice"));

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = updateGrade(arr, 4, 18);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("There exists duplicates: " + hasDuplicateNames(arr));

        // 10) Append new student
        Student newS = new Student(6, "Jon", 19, 17);
        Student[] newArr = appendStudent(arr, newS);

        // 11)
        Student[][] classroom = new Student[2][3];

        classroom[0][0] = new Student(101, "Anna", 18, 14);
        classroom[0][1] = new Student(102, "Ben", 19, 17);
        classroom[0][2] = new Student(103, "Clara", 18, 16);

        classroom[1][0] = new Student(201, "Dan", 20, 13);
        classroom[1][1] = new Student(202, "Emma", 19, 19);
        classroom[1][2] = new Student(203, "Frank", 18, 15);

        for (int row = 0; row < classroom.length; row++) {
            System.out.println("Class " + (row + 1) + " :");
            for (int col = 0; col < classroom[row].length; col++) {
                System.out.println("  - " + classroom[row][col].getName());
            }
        }

        System.out.println("Top student in each class: ");
        for (int row = 0; row < classroom.length; row++) {
            Student topStudent = classroom[row][0];
            for (int col = 1; col < classroom[row].length; col++) {
                if (classroom[row][col].getGrade() > topStudent.getGrade()) {
                    topStudent = classroom[row][col];
                }
            }
            System.out.println("Top student in class " + (row + 1) + " : "
                    + topStudent.getName() + " (grade: " + topStudent.getGrade() + ")");
        }

    }
}

