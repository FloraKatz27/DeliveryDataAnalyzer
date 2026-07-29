package studentanalysis;
import java.util.List;

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
}
