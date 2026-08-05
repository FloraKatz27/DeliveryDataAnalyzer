package studentanalysis;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class StudentReportGenerator {
    private final List<Student> students;

    public StudentReportGenerator(List<Student> students) {
        this.students = students;
    }
    public void printAllStudents() {
        System.out.println("\n====== ALL STUDENTS ======");

        students.forEach(System.out::println);
    }

    /*public void printPartTimeStudents() {
        System.out.println("\n====== PART-TIME STUDENTS ======");

        students.stream().filter(Student::isPartTime).forEach(System.out::println);
    }*/

    public List<Student> getPartTimeStudents() {
        return students.stream().filter(Student::isPartTime).toList();
    }

    public void printHonorRoll() {
        System.out.println("====== HONOR ROLL ======");

        students.stream().filter(student -> student.getAverageGrade() >= 80).map(Student::getName).sorted().forEach(System.out::println);
    }

    private int countTotalStudents() {
        return students.size();
    }

    private double calculateTotalGrades() {
        return calculateTotalGrades(student -> true);
    }

    private double calculateTotalGrades(Predicate<Student> condition) {
       return students.stream().filter(condition).mapToDouble(Student::getAverageGrade).sum();
    }



    public void printStatistics() {
        System.out.println("\n====== STUDENT STATISTICS ======");

        System.out.println("Total Students: " + countTotalStudents());
        System.out.println("Passed Students: " + countPassedStudents());
        System.out.println("Failed Students: " + countFailedStudents());
        System.out.println("Part-Time Students: " + countPartTimeStudents());
        System.out.println("Full-Time Students: " + countFullTimeStudents());
        System.out.println("Average grade (all students): " + calculateAverageGrade());
    }

    private long countStudentsMatching(Predicate<Student> condition) {
        return students.stream().filter(condition).count();
    }

    private long countPassedStudents() {
        //return students.stream().filter(Student::isPassed).count();
        return countStudentsMatching(Student::isPassed);
    }

    private long countFailedStudents() {
        //return students.stream().filter(student -> !student.isPassed()).count();
        return countStudentsMatching(student -> !student.isPassed());
    }

    private long countPartTimeStudents() {
        //return students.stream().filter(Student::isPartTime).count();
        return countStudentsMatching(Student::isPartTime);
    }

    private long countFullTimeStudents() {
        //return students.stream().filter(student -> !student.isPartTime()).count();
        return countStudentsMatching(student -> !student.isPartTime());
    }

    private double calculateAverageGrade() {
        return calculateAverageGrade(student -> true);
    }

    private double calculateAverageGrade(Predicate<Student> condition) {
        long matchingStudents = countStudentsMatching(condition);

        if (matchingStudents == 0) {
            return 0.0;
        }

        return calculateTotalGrades(condition) / matchingStudents;
    }

    private void printStudent(Optional<Student> studentOptional, String title) {
        System.out.println("\n====== " + title + " ======");

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            System.out.println(student.getName() + " - " + student.getAverageGrade());
        } else {
            System.out.println("No students found.");
        }
    }

    public void printTopPerformingStudent() {
       Optional<Student> topStudent = students.stream().max(Comparator.comparingDouble(Student::getAverageGrade));

        printStudent(topStudent, "TOP-PERFORMING STUDENT");

       /*if (topStudent.isPresent()) {
           Student student = topStudent.get();
           System.out.println(student.getName() + " - " + student.getAverageGrade());
       } else {
           System.out.println("No students found.");
       }*/
    }

    public void printLowestPerformingStudent() {
        Optional<Student> worstStudent = students.stream().min(Comparator.comparingDouble(Student::getAverageGrade));

        printStudent(worstStudent, "LOWEST-PERFORMING STUDENT");

        /*System.out.println("\n====== LOWEST-PERFORMING STUDENT ======");

        if (worstStudent.isPresent()) {
            Student student = worstStudent.get();
            System.out.println(student.getName() + " - " + student.getAverageGrade());
        } else {
            System.out.println("No students found.");
        }*/
    }


    public void printTopStudents(int numberOfStudents) {
        if (numberOfStudents < 0) {
            throw new IllegalArgumentException("Number of students cannot be negative.");
        }

        System.out.println("\n====== TOP " + numberOfStudents + " STUDENTS (by grade) ======");

        students.stream().sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed()).limit(numberOfStudents).forEach(student -> System.out.println(student.getName() + " - " + student.getAverageGrade()));
    }

    public void printStudentsAlphabetically() {

        System.out.println("n====== STUDENTS (A-Z) ======");
        students.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);
    }

    public void searchStudentByName(String name) {
        Optional<Student> foundStudent = students.stream().filter(student -> student.getName().equals(name)).findFirst();

        System.out.println("\n====== SEARCH RESULT ======");

        if (foundStudent.isPresent()) {
            Student student = foundStudent.get();

            System.out.println(student.getName() + " - " + student.getAverageGrade());
        } else {
            System.out.println("No student found matching that name.");
        }
    }

    public void printStudentsByStatus() {
        System.out.println("\n====== STUDENTS BY STATUS ======");

        System.out.println("\nPASSED:");
         students.stream().filter(Student::isPassed).forEach(student -> System.out.println(student.getName()));

        System.out.println("\nFAILED:");
        students.stream().filter(student -> !student.isPassed()).forEach(student -> System.out.println(student.getName()));
    }

    public void printPartTimeStatistics() {
        System.out.println("\n====== PART-TIME STATISTICS ======");

        System.out.println("Average grade: " + calculateAverageGrade(Student::isPartTime));
    }
}
