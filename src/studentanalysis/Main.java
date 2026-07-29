package studentanalysis;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student john = new Student("John", 21, 73.8, false, true);
        Student emma = new Student("Emma", 19, 91.4, true, true);
        Student michael = new Student("Michael", 27, 58.2, true, true);
        Student sophia = new Student("Sophia", 24, 39.7, false, false);
        Student daniel = new Student("Daniel", 30, 84.9, true, true);

        ArrayList<Student> students = new ArrayList<>();

        students.add(john);
        students.add(emma);
        students.add(michael);
        students.add(sophia);
        students.add(daniel);


    }
}
