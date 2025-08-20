import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades.add(sc.nextInt());
        }

        int max = Collections.max(grades);
        int min = Collections.min(grades);
        double avg = grades.stream().mapToInt(a -> a).average().orElse(0);

        System.out.println("\n--- Student Grades Report ---");
        System.out.println("All Grades: " + grades);
        System.out.println("Highest Grade: " + max);
        System.out.println("Lowest Grade: " + min);
        System.out.println("Average Grade: " + avg);

        sc.close();
    }
}
