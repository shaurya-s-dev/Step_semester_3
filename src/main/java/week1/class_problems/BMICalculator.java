package week1.class_problems;

import java.util.Random;

public class BMICalculator {
    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("heights and weights must have the same length");
        }
        System.out.printf("%-10s %-12s %-12s %-10s %s\n", "Person", "Height(m)", "Weight(kg)", "BMI", "Status");
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] <= 0) {
                throw new IllegalArgumentException("height must be > 0 (index " + i + ")");
            }
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("Person %-4d %-12.2f %-12.2f %-10.2f %s\n",
                               i+1, heights[i], weights[i], bmi, getBMIStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 10;
        double[] heights = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            heights[i] = 1.5 + rand.nextDouble() * 0.6;  // 1.5 – 2.1 m
            weights[i] = 50 + rand.nextDouble() * 60;    // 50 – 110 kg
        }
        printWellnessReport(heights, weights);
    }
}