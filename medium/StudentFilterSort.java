import java.util.*;
import java.util.stream.*;

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 88.5),
            new Student("Bob", 72.0),
            new Student("Charlie", 79.3),
            new Student("David", 65.0),
            new Student("Eva", 91.2)
        );

        System.out.println("Students scoring above 75%, sorted by marks:");

        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
