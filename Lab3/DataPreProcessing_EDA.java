import java.util.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.jfree.data.xy.*;

public class StudentPerformanceEDA {

    static class Student {
        String name;
        double age, studyHours, marks;

        Student(String name, double age,
                double studyHours, double marks) {
            this.name = name;
            this.age = age;
            this.studyHours = studyHours;
            this.marks = marks;
        }

        public String toString() {
            return String.format(
                    "%-10s %-10.2f %-15.2f %-10.2f",
                    name, age, studyHours, marks
            );
        }
    }

    // Create Dataset
    static ArrayList<Student> createDataset() {

        ArrayList<Student> data = new ArrayList<>();

        data.add(new Student("A", 20, 2, 45));
        data.add(new Student("B", 21, 4, 70));
        data.add(new Student("C", Double.NaN, 3, 60));
        data.add(new Student("D", 22, Double.NaN, 80));
        data.add(new Student("E", 20, 5, 90));
        data.add(new Student("F", 21, 4, 70));

        return data;
    }

    // Preprocess Data
    static ArrayList<Student> preprocessData(
            ArrayList<Student> data) {

        System.out.println("\nMissing Values Before Preprocessing:");

        int ageMissing = 0, hoursMissing = 0;

        double ageSum = 0, hoursSum = 0;
        int ageCount = 0, hoursCount = 0;

        for (Student s : data) {

            if (Double.isNaN(s.age))
                ageMissing++;
            else {
                ageSum += s.age;
                ageCount++;
            }

            if (Double.isNaN(s.studyHours))
                hoursMissing++;
            else {
                hoursSum += s.studyHours;
                hoursCount++;
            }
        }

        System.out.println("Age: " + ageMissing);
        System.out.println("Study_Hours: " + hoursMissing);
        System.out.println("Marks: 0");

        double ageMean = ageSum / ageCount;
        double hoursMean = hoursSum / hoursCount;

        // Replace missing values with column means
        for (Student s : data) {

            if (Double.isNaN(s.age))
                s.age = ageMean;

            if (Double.isNaN(s.studyHours))
                s.studyHours = hoursMean;
        }

        // Remove duplicate records
        ArrayList<Student> uniqueData = new ArrayList<>();

        for (Student s : data) {

            boolean duplicate = false;

            for (Student u : uniqueData) {

                if (s.name.equals(u.name) &&
                        s.age == u.age &&
                        s.studyHours == u.studyHours &&
                        s.marks == u.marks) {

                    duplicate = true;
                    break;
                }
            }

            if (!duplicate)
                uniqueData.add(s);
        }

        return uniqueData;
    }

    // Display Dataset
    static void displayDataset(ArrayList<Student> data) {

        System.out.printf(
                "%-10s %-10s %-15s %-10s%n",
                "Student", "Age", "Study_Hours", "Marks"
        );

        for (Student s : data)
            System.out.println(s);
    }

    // Calculate Mean
    static double mean(ArrayList<Student> data, int column) {

        double sum = 0;

        for (Student s : data) {

            if (column == 0)
                sum += s.age;
            else if (column == 1)
                sum += s.studyHours;
            else
                sum += s.marks;
        }

        return sum / data.size();
    }

    // Calculate Standard Deviation
    static double standardDeviation(
            ArrayList<Student> data, int column) {

        double avg = mean(data, column);
        double sum = 0;

        for (Student s : data) {

            double value = column == 0 ? s.age :
                    column == 1 ? s.studyHours :
                    s.marks;

            sum += Math.pow(value - avg, 2);
        }

        return Math.sqrt(sum / data.size());
    }

    // Correlation Calculation
    static double correlation(
            ArrayList<Student> data, int x, int y) {

        double mx = mean(data, x);
        double my = mean(data, y);

        double numerator = 0;
        double sumX = 0, sumY = 0;

        for (Student s : data) {

            double a = x == 0 ? s.age :
                    x == 1 ? s.studyHours : s.marks;

            double b = y == 0 ? s.age :
                    y == 1 ? s.studyHours : s.marks;

            numerator += (a - mx) * (b - my);
            sumX += Math.pow(a - mx, 2);
            sumY += Math.pow(b - my, 2);
        }

        return numerator / Math.sqrt(sumX * sumY);
    }

    // Perform EDA
    static void performEDA(ArrayList<Student> data) {

        System.out.println("\nDataset After Preprocessing:");
        displayDataset(data);

        String[] columns = {
                "Age", "Study_Hours", "Marks"
        };

        System.out.println("\nSummary Statistics:");

        System.out.printf(
                "%-15s %-10s %-10s %-10s%n",
                "Column", "Mean", "Std Dev", "Count"
        );

        for (int i = 0; i < 3; i++) {

            System.out.printf(
                    "%-15s %-10.2f %-10.2f %-10d%n",
                    columns[i],
                    mean(data, i),
                    standardDeviation(data, i),
                    data.size()
            );
        }

        System.out.println("\nCorrelation Matrix:");

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.printf(
                        "%10.3f ",
                        correlation(data, i, j)
                );
            }

            System.out.println();
        }
    }

    // Visualize Data
    static void visualizeData(ArrayList<Student> data) {

        // Bar Chart: Student Marks
        DefaultCategoryDataset barDataset =
                new DefaultCategoryDataset();

        for (Student s : data) {
            barDataset.addValue(
                    s.marks, "Marks", s.name
            );
        }

        JFreeChart barChart =
                ChartFactory.createBarChart(
                        "Student Performance",
                        "Student",
                        "Marks",
                        barDataset
                );

        ChartFrame barFrame =
                new ChartFrame("Student Performance", barChart);

        barFrame.pack();
        barFrame.setVisible(true);

        // Scatter Plot: Study Hours vs Marks
        XYSeries series =
                new XYSeries("Study Hours vs Marks");

        for (Student s : data) {
            series.add(s.studyHours, s.marks);
        }

        XYSeriesCollection scatterDataset =
                new XYSeriesCollection(series);

        JFreeChart scatterChart =
                ChartFactory.createScatterPlot(
                        "Study Hours vs Marks",
                        "Study Hours",
                        "Marks",
                        scatterDataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false
                );

        ChartFrame scatterFrame =
                new ChartFrame("Study Hours vs Marks",
                        scatterChart);

        scatterFrame.pack();
        scatterFrame.setVisible(true);
    }

    // Main Method
    public static void main(String[] args) {

        ArrayList<Student> data = createDataset();

        System.out.println("Original Dataset:");
        displayDataset(data);

        data = preprocessData(data);

        performEDA(data);

        visualizeData(data);
    }
}
