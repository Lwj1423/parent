package stack;

import java.util.Scanner;

public class ArrayStackTest {
    public static void main(String[] args) {

        //创建测试数据
        ArrayStock stock = new ArrayStock(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println();
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    stock.list();
                    break;
                case "push":
                    System.out.println("请输入一个数:");
                    int value = scanner.nextInt();
                    stock.push(value);
                    break;
                case "pop":
                    try {
                        int res = stock.pop();
                        System.out.printf("出栈数:%d\n",res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~");

    }
}

//定义一个栈
class ArrayStock{
    private int maxSize; //栈空间
    private int[] stack;  //数组模拟栈
    private  int top= -1; //top表示栈顶,默认-1

    //构造器
    public ArrayStock(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //入栈
    public void push(int value){
        //先判断栈是否满
        if (isFull()){
            System.out.println(("栈满"));
            return;
        }
        top++;
        stack[top] =value;
    }

    //出栈
    public int pop(){
        //判空
        if (isEmpty()){
            throw new RuntimeException("栈空,没数据");
        }
        int value = stack[top];
        --top;
        return value;
    }

    //显示栈中数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        //从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }



}