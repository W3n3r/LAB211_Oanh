/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5.P0084;

/**
 *
 * @author ADMIN
 */
public class TestNumber {
    public static void main(String[] args) {
        LargeNumber a = new LargeNumber("55");
        LargeNumber b = new LargeNumber("55");
        LargeNumber c = new LargeNumber("12345");
        LargeNumber d = new LargeNumber("6789");

        // Kiểm thử cộng
        System.out.println("9999 + 1 = " + a.add(b)); // 10000
        System.out.println("12345 + 6789 = " + c.add(d)); // 19134

        // Kiểm thử nhân
        System.out.println("12345 * 6789 = " + c.multiply(d)); // 83810205
        System.out.println("9999 * 1 = " + a.multiply(b)); // 9999
    }
}
