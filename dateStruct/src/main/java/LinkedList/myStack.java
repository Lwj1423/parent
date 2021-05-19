package LinkedList;

import java.util.Stack;

/**
 * 栈的基本使用
 */
public class myStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("a");
        stack.add("b");
        stack.add("c");
        stack.push("e");

        //出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
