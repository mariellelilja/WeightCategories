package classes;

public class WeightHelper {
    public static double calculateBMI(double heightInCm, double weightInKg) {
        double heightInMeters = heightInCm / 100;
        return weightInKg / (heightInMeters * heightInMeters);
    }

    public static String getCategory(double heightInCm, double weightInKg) {
        double bmi = calculateBMI(heightInCm, weightInKg);
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}