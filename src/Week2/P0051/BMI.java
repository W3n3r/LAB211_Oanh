/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2.P0051;

/**
 *
 * @author tothi
 */
public class BMI {
    public enum BMIStatus {
        UNDER_STANDARD,
        STANDARD,
        OVERWEIGHT,
        FAT,
        VERY_FAT;
    }
    
    public BMIStatus getBMIStatus(double bmiValue){
        if(bmiValue < 19)
            return BMIStatus.UNDER_STANDARD;
        else if(bmiValue <= 25)
            return BMIStatus.STANDARD;
        else if (bmiValue <= 30)
            return BMIStatus.OVERWEIGHT;
        else if (bmiValue <= 40)
            return BMIStatus.FAT;
        else
            return BMIStatus.VERY_FAT;
    }
    
    public BMI calculateBMI(double weight, double height) {
        double heightM = height / 100.0;
        double bmiValue = weight / (heightM * heightM);
        this.bmiValue = bmiValue;
        return this;
    }
    
    private double bmiValue;
    
    public double getBMIValue() {
        return bmiValue;
    }
}