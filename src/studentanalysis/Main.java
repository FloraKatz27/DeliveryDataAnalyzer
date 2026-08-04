package studentanalysis;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = createStudentData();

        StudentReportGenerator reportGenerator = new StudentReportGenerator(students);

        /*System.out.println("=================================");
        System.out.println("      STUDENT STREAM ANALYZER   ");
        System.out.println("=================================");
        System.out.println("Students loaded: " + students.size());*/

        reportGenerator.printAllStudents();

        List<Student> partTimeStudents = reportGenerator.getPartTimeStudents();

        System.out.println("\n====== PART-TIME STUDENTS ======");
        partTimeStudents.forEach(System.out::println);

        System.out.println();

        reportGenerator.printHonorRoll();

        reportGenerator.printStatistics();

        System.out.println();

        reportGenerator.printStudentsAlphabetically();

    }

    private static List<Student> createStudentData() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("John", 21, 73.8, false, true));
        students.add(new Student("Emma", 19, 91.4, true, true));
        students.add(new Student("Michael", 27, 58.2, true, true));
        students.add(new Student ("Sophia", 24, 39.7, false, false));
        students.add(new Student("Daniel", 30, 84.9, true, true));

        return students;

    }

    reportGenerator.searchStudentByName("Emma");
}
