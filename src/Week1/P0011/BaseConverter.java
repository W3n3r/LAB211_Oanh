/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0011;

/**
 *
 * @author tothi
 */
public class BaseConverter {
    
    public String convertBase(String number, int fromBase, int toBase) {
        // Convert to decimal first
        long decimal = toDecimal(number, fromBase);
        
        // Convert from decimal to target base
        return fromDecimal(decimal, toBase);
    }
    
    private long toDecimal(String number, int base) {
        long result = 0;
        long power = 1;
        
        for (int i = number.length() - 1; i >= 0; i--) {
            char digit = number.charAt(i);
            int digitValue;
            
            if (digit >= '0' && digit <= '9') {
                digitValue = digit - '0';
            } else {
                digitValue = digit - 'A' + 10;
            }
            
            result += digitValue * power;
            power *= base;
        }
        
        return result;
    }
    
    private String fromDecimal(long decimal, int base) {
        if (decimal == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        String digits = "0123456789ABCDEF";
        
        while (decimal > 0) {
            result.insert(0, digits.charAt((int)(decimal % base)));
            decimal /= base;
        }
        
        return result.toString();
    }
    
    public void displayMenu() {
        System.out.println("\n========= Change Base Number System =========");
        System.out.println("1. Binary (2)");
        System.out.println("2. Decimal (10)");
        System.out.println("3. Hexadecimal (16)");
    }
    
    public String getBaseName(int choice) {
        return switch (choice) {
            case 1 -> "BIN";
            case 2 -> "DEC";
            case 3 -> "HEX";
            default -> "Unknown";
        };
    }
    
    public int getBaseValue(int choice) {
        return switch (choice) {
            case 1 -> 2;
            case 2 -> 10;
            case 3 -> 16;
            default -> 10;
        };
    }
}
