package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import classes.WeightHelper;

public class TestWeightHelper {

    @Test
    public void testCalculateBMI_NormalValues() {

        // arrange
        double height = 170;
        double weight = 65;
        double expectedBMI = 22.49;

        // act
        double calcuatedBMI = WeightHelper.calculateBMI(height, weight);

        // assert
        Assert.assertEquals(expectedBMI, calcuatedBMI, 0.01);
    }

    @Test
    public void testCalculateBMI_Minimum() {
        // arrange
        double height = 0;
        double weight = 0;
        double expectedBMI = 0;

        // act
        double calculatedBMI = WeightHelper.calculateBMI(height, weight);

        // assert
        assertEquals(expectedBMI, calculatedBMI, 0.01);

    }

    @Test
    public void testCalculateBMI_Maximum() { // Reasonable maximum weight and height
        // arrange
        double height = 250;
        double weight = 250;
        double expectedBMI = 1000000;

        // act
        double calculatedBMI = WeightHelper.calculateBMI(height, weight);

        // assert
        assertEquals(expectedBMI, calculatedBMI, 0.01);
    }

    @Test
    public void testCalculateBMI_JustBelowMaximum() {
        // arrange
        double height = 249.99;
        double weight = 249.99;
        double expectedBMI = 2.78;

        // act
        double calculatedBMI = WeightHelper.calculateBMI(height, weight);

        // assert
        assertEquals(expectedBMI, calculatedBMI, 0.01);
    }

    @Test
    public void testCalculateBMI_JustAboveMinimum() {
        // arrange
        double height = 0.01;
        double weight = 0.01;
        double expectedBMI = 1000000;

        // act
        double calculatedBMI = WeightHelper.calculateBMI(height, weight);

        // assert
        assertEquals(expectedBMI, calculatedBMI, 0.01);
    }

    @Test
    public void testGetCategory_Underweight() {
        // arrange
        double height = 170;
        double weightUnderweight = 50;

        // act
        String categoryUnderweight = WeightHelper.getCategory(height, weightUnderweight);

        // assert
        assertEquals("Underweight", categoryUnderweight);
    }

    @Test
    public void testGetCategory_Normal() {
        // arrange
        double height = 170;
        double weightNormal = 70;

        // act
        String categoryNormal = WeightHelper.getCategory(height, weightNormal);

        // assert
        assertEquals("Normal weight", categoryNormal);

    }

    @Test
    public void testGetCategory_Overweight() {
        // arrange
        double height = 170;
        double weightOverweight = 80;

        // act
        String categoryOverweight = WeightHelper.getCategory(height, weightOverweight);

        // assert
        assertEquals("Overweight", categoryOverweight);

    }

    @Test
    public void testGetCategory_Obese() {
        // arrange
        double height = 170;
        double weightObese = 100;

        // act
        String categoryObese = WeightHelper.getCategory(height, weightObese);

        // assert
        assertEquals("Obese", categoryObese);

    }
}
