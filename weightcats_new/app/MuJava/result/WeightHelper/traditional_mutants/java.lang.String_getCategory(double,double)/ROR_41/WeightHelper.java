// This is a mutant program.
// Author : ysma

package org.example;


public class WeightHelper
{

    private static double heightBoundary = 250;

    private static double weightBoundary = 300;

    public static  double calculateBMI( double heightInCm, double weightInKg )
    {
        if (heightInCm <= 0 || weightInKg <= 0) {
            throw new java.lang.IllegalArgumentException( "Write values for height and weight above 0 kg or 0 cm." );
        } else {
            if (heightInCm >= heightBoundary || weightInKg >= weightBoundary) {
                throw new java.lang.IllegalArgumentException( "Write values for height and weight below " + heightBoundary + " kg or " + weightBoundary + " cm." );
            }
        }
        double heightInMeters = heightInCm / 100;
        return weightInKg / (heightInMeters * heightInMeters);
    }

    public static  java.lang.String getCategory( double heightInCm, double weightInKg )
    {
        double bmi = calculateBMI( heightInCm, weightInKg );
        if (bmi < 18.5) {
            return "Underweight";
        } else {
            if (true) {
                return "Normal weight";
            } else {
                if (bmi < 30) {
                    return "Overweight";
                } else {
                    return "Obese";
                }
            }
        }
    }

}
