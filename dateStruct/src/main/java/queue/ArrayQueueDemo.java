package queue;

import exception.MyException;

import java.util.Scanner;

/**
 * 2.  队列
 *       使用数组模拟队列
 *
 */
public class ArrayQueueDemo {

    //测试
    public static void main(String[] args) {
        //创建队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';  //接收用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        //输入一个菜单
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            System.out.println();
            System.out.println("请选择:");
            key = sc.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数:");
                    int value = sc.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int headQueue = queue.headQueue();
                        System.out.printf("队列头数据是%d\n",headQueue);
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    sc.close();;
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueue{
    private int maxSize;    //表示数组最大容量
    private int front;     //队列头， 队列头前一个位置
    private int rear;      //队列尾， 队列最后一个位置数据
    private int[] arr;      //存放数据，模拟队列

    //构造器初始化数据
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;     //队列头前一个位置
        rear = -1;      //队列尾部，队列最后数据
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //判断队列为空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满！！！！");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //取数据
    public int getQueue() throws MyException {
        if (isEmpty()){
            throw new MyException("队列空!!!");
        }
        front++;
        return arr[front];
    }

    //显示队列中所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列空的,没数据");
            return;
        }
        for (int i = front + 1; i < arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //获取队列第一个元素
    public int headQueue() throws MyException {
        //判断
        if (isEmpty()){
            throw new MyException("队列为空!!!");
        }
        return arr[front + 1];
    }
}
