/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5.P0084;

/**
 *
 * @author ADMIN
 */
public class LargeNumber {

    
    private String number;

    public LargeNumber(String number) {
        this.number = number;
    }
    
    public String convertToString(int[] arr) {
        StringBuilder kq = new StringBuilder();
        for ( int  d: arr) {
            kq.append(d);
        }
        return kq.toString();
    }
    
     @Override
    public String toString() {
        return number;
    }
    
    public LargeNumber add(LargeNumber other) {
        int k = Math.max(this.number.length(),other.number.length());
        int [] result = new int[k+1];
        int i = this.number.length() -1;
        int j = other.number.length() -1;
        int sodu = 0;
                
        while (i>= 0 || j>=0) {
            
            int so1 = (i>=0) ? this.number.charAt(i) -'0' :0;
            int so2 = (j>=0) ? this.number.charAt(j) - '0':0;
            
            int kq = so1 + so2 + sodu;
            result[k] = kq%10;
            sodu = kq/10;
            j--;
            i--;
            k--;
        }
       
        if (sodu > 0) result[k] = sodu;
    
    return new LargeNumber(convertToString(result));
    }
 

public LargeNumber multiply(LargeNumber other) {
        int len1 = this.number.length();
        int len2 = other.number.length();
        int[] result = new int[len1 + len2];
        
        // Nhân từng chữ số của số thứ nhất với từng chữ số của số thứ hai
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int num1 = this.number.charAt(i) - '0';
                int num2 = other.number.charAt(j) - '0';
                
                int mul = num1 * num2;
                int pos1 = i + j;
                int pos2 = i + j + 1;
                
                int sum = mul + result[pos2];
                
                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }
        
        return new LargeNumber(convertToString(result));
    }
}
