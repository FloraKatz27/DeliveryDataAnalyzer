package studentanalysis;

public class Student {
    private String name;
    private int age;
    private double averageGrade;
    private boolean partTime;
    private boolean passed;

    public Student(String name, int age, double averageGrade, boolean partTime, boolean passed) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
        this.partTime = partTime;
        this.passed = passed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public boolean isPartTime() {
        return partTime;
    }

    public boolean isPassed() {
        return passed;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", averageGrade=" + averageGrade + ", partTime=" + partTime + ", passed=" + passed + '}';
    }
}




