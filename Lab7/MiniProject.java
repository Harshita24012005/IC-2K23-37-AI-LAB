import java.util.*;

public class EmployeeSalaryPrediction {

    // Sample employee dataset
    // Feature: Years of Experience
    // Target: Salary (in LPA)

    static double[] experience = {
            1, 2, 2, 3, 3, 4, 4, 5, 5, 6,
            6, 7, 7, 8, 9, 10, 11, 12, 13, 15
    };

    static double[] salary = {
            2.5, 3.0, 3.2, 3.8, 4.0, 4.5, 4.8, 5.2, 5.5, 6.0,
            6.2, 7.0, 7.2, 8.0, 8.5, 9.5, 10.0, 11.0, 12.0, 14.0
    };

    // Linear Regression Model
    static double slope, intercept;

    // Train the model
    static void trainModel(double[] x, double[] y) {

        double sumX = 0, sumY = 0;
        double sumXY = 0, sumX2 = 0;

        int n = x.length;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        slope = (n * sumXY - sumX * sumY) /
                (n * sumX2 - sumX * sumX);

        intercept = (sumY - slope * sumX) / n;
    }

    // Predict salary
    static double predict(double years) {
        return intercept + slope * years;
    }

    // Calculate Mean Absolute Error
    static double calculateMAE(double[] actual, double[] predicted) {

        double error = 0;

        for (int i = 0; i < actual.length; i++) {
            error += Math.abs(actual[i] - predicted[i]);
        }

        return error / actual.length;
    }

    // Calculate R2 Score
    static double calculateR2(double[] actual, double[] predicted) {

        double mean = 0;

        for (double value : actual) {
            mean += value;
        }

        mean /= actual.length;

        double total = 0, residual = 0;

        for (int i = 0; i < actual.length; i++) {
            total += Math.pow(actual[i] - mean, 2);
            residual += Math.pow(actual[i] - predicted[i], 2);
        }

        if (total == 0) {
            return 0;
        }

        return 1 - (residual / total);
    }

    public static void main(String[] args) {

        System.out.println("EMPLOYEE SALARY PREDICTION SYSTEM");
        System.out.println("---------------------------------");

        // Split dataset into training and testing data
        int trainSize = 16;

        double[] xTrain = Arrays.copyOfRange(experience, 0, trainSize);
        double[] yTrain = Arrays.copyOfRange(salary, 0, trainSize);

        double[] xTest = Arrays.copyOfRange(experience, trainSize, 20);
        double[] yTest = Arrays.copyOfRange(salary, trainSize, 20);

        // Train model
        trainModel(xTrain, yTrain);

        // Test model
        double[] predictions = new double[xTest.length];

        for (int i = 0; i < xTest.length; i++) {
            predictions[i] = predict(xTest[i]);
        }

        // Evaluate model
        System.out.printf("Mean Absolute Error: %.2f LPA%n",
                calculateMAE(yTest, predictions));

        System.out.printf("R2 Score: %.2f%n",
                calculateR2(yTest, predictions));

        // Take user input
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter Employee Details:");

        System.out.print("Years of Experience: ");
        double years = sc.nextDouble();

        if (years < 0) {
            System.out.println("Experience cannot be negative.");
            sc.close();
            return;
        }

        // Predict salary
        double predictedSalary = predict(years);

        System.out.printf("\nPredicted Salary: %.2f LPA%n",
                predictedSalary);

        // Display salary category
        if (predictedSalary >= 10) {
            System.out.println("Salary Category: High");
        } else if (predictedSalary >= 5) {
            System.out.println("Salary Category: متوسط");
        } else {
            System.out.println("Salary Category: Entry Level");
        }

        sc.close();
    }
}
