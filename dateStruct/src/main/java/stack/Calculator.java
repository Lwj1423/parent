package stack;

public class Calculator {
    public static void main(String[] args) {
        //创建表达式
        String expression = "10-1*2+4/4+1";
        CalStack numStack = new CalStack(10);
        CalStack operStack = new CalStack(10);

        //定义相关变量
        int index = 0; //扫描表达式
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';  //每次扫描的char保存到ch
        String keepNum = ""; //拼接
        //循环扫描表达式
        while (true){
            //扫描一位
            ch = expression.substring(index,index+1).charAt(0);
            //判断是否是操作符
            if (operStack.isOper(ch)){
                //判断栈内是否为空
                if (!operStack.isEmpty()){
                    while (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            oper = operStack.pop();
                            res = numStack.cal(num1,num2,oper);
                            //计算结果入数栈
                            numStack.push(res);
                            //当前操作符入符号栈
                            if (operStack.peek() == -1){
                                break;
                            }
                    }
                        //当前操作符直接入符号栈
                        operStack.push(ch);

                }else{
                    //直接入栈
                    operStack.push(ch);
                }
            }else{  //如果是数,则直接入数栈
                // 分析思路
                // 1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                // 2. 在处理数，需要向expression的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                // 3. 因此我们需要定义一个变量 字符串，用于拼接
                keepNum += ch;

                //如果ch 是最后一位,直接出栈
                if (index == expression.length() -1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //如果是数字就继续扫描
                    if (operStack.isOper(expression.substring(index + 1,index + 2).charAt(0))){
                        //如果后一位是运算符,数字入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            //让index + 1 ,判断是否扫描到最后
            index++;
            if (index >= expression.length()){
                break;
            }
        }

        //扫描完毕  按照顺序从 数栈和符号中 pop,并运行
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        //运算结束, pop出,结果
        res = numStack.pop();
        System.out.printf("表达式 %s = %d",expression,res);

    }
}

//创建一个栈
//扩展   增加功能
class CalStack {
    private int maxSize; //栈空间
    private int[] stack;  //数组模拟栈
    private  int top= -1; //top表示栈顶,默认-1

    //构造器
    public CalStack(int maxSize){
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

    //显示栈顶数据
    public int peek(){
        if (top == -1){
            return -1;
        }
        return stack[top];
    }

    //返回运算符的优先级, 数字越大,优先级越高
    public int priority(int oper){
        int res = 0;
        switch (oper){
            case '/':
                res = 4;
                break;
            case '*':
                res = 3;
                break;
            case '-':
                res = 2;
                break;
            case '+':
                res = 1;
                break;
        }
        return res;

    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val =='/';
    }

    //计算方式
    public int cal(int num1, int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }


}
