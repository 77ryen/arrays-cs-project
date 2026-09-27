package samplearrays;
import java.util.Arrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        int newCourse = 3010;
        int[] updatedCourses = new int[registeredCourses.length + 1];

        for (int i = 0; i < registeredCourses.length; i++) {
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[updatedCourses.length - 1] = newCourse;

        System.out.println("Updated Courses: " + Arrays.toString(updatedCourses));

        int searchCourse = 2140;
        boolean found = false;

        for (int course : updatedCourses) {
            if (course == searchCourse) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Course " + searchCourse + " is in the updated list.");
        } else {
            System.out.println("Course " + searchCourse + " was not found.");
        }

    }

}
