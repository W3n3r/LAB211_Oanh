/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2.P0051;

/**
 *
 * @author tothi
 */
public class Calculator {
    
    public enum Operator {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        POWER("^"),
        EQUAL("=");
        
        private final String symbol;
        
        Operator(String symbol) {
            this.symbol = symbol;
        }
        
        public String getSymbol() {
            return symbol;
        }
        
        public static Operator fromString(String symbol) {
            for (Operator op : Operator.values()) {
                if (op.symbol.equals(symbol)) {
                    return op;
                }
            }
            return null;
        }
    }

    private double memory;

    public Calculator() {
        this.memory = 0;
    }
    
    public Calculator(double memory) {
        this.memory = memory;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }
    
    // Method required by assignment
    public double calculate(double a, Operator operator, double b) throws ArithmeticException {
        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return a / b;
            case POWER:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public void calculate(String op, double num) {
        Operator operator = Operator.fromString(op);
        if (operator == null) {
            System.out.println("Invalid operator.");
            return;
        }
        
        try {
            memory = calculate(memory, operator, num);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public Operator checkOperator(String operator) {
        return Operator.fromString(operator);
    }
    
    public Double checkNumber(String inputVal) {
        try {
            return Double.parseDouble(inputVal.trim());
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }
}