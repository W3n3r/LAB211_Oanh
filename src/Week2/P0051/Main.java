/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2.P0051;

/**
 *
 * @author tothi
 */
import java.util.Scanner;

public class Main {
    private Calculator calculator = new Calculator();
    
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Please choice one option: ");
            
            try {
                String menuInput = scanner.nextLine().trim();
                int option = Integer.parseInt(menuInput);
                
                switch (option) {
                    case 1:
                        normalCalculator(scanner);
                        break;
                    case 2:
                        bmiCalculator(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting program. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please enter a number.");
            }
        }
    }
    
    private void normalCalculator(Scanner scanner) {
        System.out.println("----- Normal Calculator -----");
        
        System.out.print("Enter number: ");
        Double firstNumber = getValidNumber(scanner);
        if (firstNumber == null) return;
        
        calculator.setMemory(firstNumber);
        
        while (true) {
            System.out.print("Enter Operator: ");
            String opInput = scanner.nextLine().trim();
            
            Calculator.Operator operator = calculator.checkOperator(opInput);
            
            if (operator == Calculator.Operator.EQUAL) {
                System.out.printf("Result: %.1f%n", calculator.getMemory());
                break;
            }
            
            if (operator == null) {
                System.out.println("Please input (+, -, *, /, ^)");
                continue;
            }
            
            System.out.print("Enter number: ");
            Double number = getValidNumber(scanner);
            if (number == null) continue;
            
            calculator.calculate(opInput, number);
            System.out.printf("Memory: %.1f%n", calculator.getMemory());
        }
    }
    
    private void bmiCalculator(Scanner scanner) {
        System.out.println("----- BMI Calculator -----");

        Double weight = null;
        while (weight == null) {
            System.out.print("Enter Weight(kg): ");
            String weightInput = scanner.nextLine().trim();
            weight = calculator.checkNumber(weightInput);
            if (weight == null) {
                System.out.println("BMI is digit");
            }
        }

        Double height = null;
        while (height == null) {
            System.out.print("Enter Height(cm): ");
            String heightInput = scanner.nextLine().trim();
            height = calculator.checkNumber(heightInput);
            if (height == null) {
                System.out.println("BMI is digit");
            }
        }
        
        BMI bmiObj = new BMI();
        BMI result = bmiObj.calculateBMI(weight, height);
        double bmiValue = result.getBMIValue();
        
        System.out.printf("BMI Number: %.2f%n", bmiValue);
        
        BMI.BMIStatus status = bmiObj.getBMIStatus(bmiValue);
        switch (status) {
            case UNDER_STANDARD -> System.out.println("BMI Status: UNDER_STANDARD");
            case STANDARD -> System.out.println("BMI Status: STANDARD");
            case OVERWEIGHT -> System.out.println("BMI Status: OVERWEIGHT");
            case FAT -> System.out.println("BMI Status: FAT");
            case VERY_FAT -> System.out.println("BMI Status: VERY_FAT");
        }
    }
    
    private Double getValidNumber(Scanner scanner) {
        String input = scanner.nextLine().trim();
        return calculator.checkNumber(input);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}