import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> percentages = new ArrayList<>();

        System.out.println("==============================================");
        System.out.println("         STUDENT GRADE TRACKER");
        System.out.println("==============================================");

        System.out.print("Enter Number of Students: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Invalid number of students!");
            return;
        }

        double classPercentageSum = 0;
        double highestPercentage = 0;
        String topperName = "";

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Physics Marks (0-100): ");
            int physics = sc.nextInt();

            System.out.print("Chemistry Marks (0-100): ");
            int chemistry = sc.nextInt();

            System.out.print("Biology Marks (0-100): ");
            int biology = sc.nextInt();

            sc.nextLine();

            int total = physics + chemistry + biology;
            double percentage = total / 3.0;

            studentNames.add(name);
            percentages.add(percentage);

            classPercentageSum += percentage;

            if (percentage > highestPercentage) {
                highestPercentage = percentage;
                topperName = name;
            }
        }

        System.out.println("\n==============================================================");
        System.out.println("                     STUDENT REPORT");
        System.out.println("==============================================================");

        System.out.printf("%-20s %-15s %-10s %-10s%n",
                "Student Name", "Percentage", "Grade", "Status");

        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < studentNames.size(); i++) {

            double percentage = percentages.get(i);

            String grade;
            String status;

            if (percentage >= 90)
                grade = "A+";
            else if (percentage >= 80)
                grade = "A";
            else if (percentage >= 70)
                grade = "B";
            else if (percentage >= 60)
                grade = "C";
            else if (percentage >= 40)
                grade = "D";
            else
                grade = "F";

            status = (percentage >= 40) ? "Pass" : "Fail";

            System.out.printf("%-20s %-15.2f %-10s %-10s%n",
                    studentNames.get(i),
                    percentage,
                    grade,
                    status);
        }

        double classAverage = classPercentageSum / n;

        System.out.println("--------------------------------------------------------------");
        System.out.printf("Class Average Percentage : %.2f%n", classAverage);
        System.out.printf("Top Performer            : %s (%.2f%%)%n",
                topperName,
                highestPercentage);
        System.out.println("==============================================================");

        sc.close();
    }
}

