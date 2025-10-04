/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3.P0083;


/**
 *
 * @author tothi
 */
import java.util.ArrayList;

public class MyStack {

    private ArrayList<Integer> stackValues;

    public MyStack() {
        stackValues = new ArrayList<>();
    }

    public void push(int value) {
        stackValues.add(value);
    }

    public Integer pop() {
        if (stackValues.isEmpty()) {
            return null;
        }
        return stackValues.remove(stackValues.size() - 1);
    }

    public Integer get() {
        if (stackValues.isEmpty()) {
            return null;
        }
        return stackValues.get(stackValues.size() - 1);
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top value: " + stack.get()); // 30

        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20
        System.out.println("Popped: " + stack.pop()); // 10
        System.out.println("Popped: " + stack.pop()); // null
    }
}

