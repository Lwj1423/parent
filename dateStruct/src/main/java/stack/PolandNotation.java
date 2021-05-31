package stack;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器
 * 
 */
public class PolandNotation {

    public static void main(String[] args) {
        //1.将中缀表达式转换成后缀表达式
        String expression = "1+((2+3)*4)-5";
        List<String> list1 = toInfixExpression(expression);
        System.out.println("中缀表达式集合" + list1);

        //2.将中缀表达式集合 转成 后缀表达式,
        List<String> suffixlist = parseSuffixExpressionList(list1);
        System.out.println("后缀表达式：" + suffixlist);


        //先定义一个逆波兰表达式
        String suffixExpress = "4 5 * 8 - 60 + 8 2 / +";
        //思路:
        // 1.先将表达式放入Arraylist中
        //2. 遍历集合,配合栈 完成计算
        List<String> list = getListString(suffixExpress);
        System.out.println("rpnList= "+ list);
        //计算
        int res = calculate(suffixlist);
        System.out.println("计算的结果是=" + res);
    }

    //将中缀集合转成逆波兰表达式
    private static List<String> parseSuffixExpressionList(List<String> list) {
        //定义两个栈
        //符号栈
        Stack<String> operStack = new Stack<>();
        //定义数组栈
        //由于数字栈只需要存数据和符号，并且需要将结果逆序 才是逆波兰表达式
        //所以采用集合 替代
        List<String> tempList = new ArrayList<>();

        //遍历集合
        for (String str:
             list) {
            //如果是数字，直接入集合
            if (str.matches("\\d+")){
                tempList.add(str);
            }else if (str.equals("(")){   //遇到左括号，直接入符号栈
                operStack.push(str);
            }else if (str.equals(")")){
                //如果是右括号，将弹出符号栈中运算符，放入集合，直到遇到左括号，并丢弃括号
                while (!operStack.peek().equals("(")){
                    tempList.add(operStack.pop());
                }
                operStack.pop();  //将 （ 弹出栈
            } else { //比较剩下运算符的优先级
                    //如果str 小于等于 栈顶运算符优先级 ， 直接弹栈
                while (operStack.size() != 0 && Operation.getValue(operStack.peek()) >= Operation.getValue(str)){
                    tempList.add(operStack.pop());
                }
                //将 str 压栈
                operStack.push(str);
            }
        }

        //将剩余运算符 加入 集合
        while ( operStack.size() != 0){
            tempList.add(operStack.pop());
        }
        return tempList;
    }


    //将中缀表达式 转成对应list
    private static List<String> toInfixExpression(String expression) {
        //定义一个List,存放数据
        List<String> list = new ArrayList<>();
        int i = 0;//定义指针,遍历中缀字符串
        String str;//拼接多位数
        char c;// 存放字符串
        while (i < expression.length()){
            //如果c不是一个数字,直接加入集合
            if ((c = expression.charAt(i)) <48 || (c = expression.charAt(i)) >57){
                list.add(c + "");
                i++;
            } else {
                str = "";//多位数置空
              while (i < expression.length() && (c = expression.charAt(i)) >= 48 && (c = expression.charAt(i)) <= 57){
                  str += c;
                  i++;
              }
              list.add(str);
            }
        }
        return list;
    }

    //计算逆波兰表达式的值
    //1. 从左到右扫描,将数字压入栈
    //2.遇到运算符,弹出两个数,将计算结果, 压入栈
    //3.依次计算
    private static int calculate(List<String> list) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历集合
        for (String str:list) {
            //使用正则表达式来取数
            if (str.matches("\\d+")){
                stack.push(str);
            }else{
                //pop两个数,并运算,再入栈
                int num2 = Integer.parseInt(stack.pop()); //栈中第一个元素
                int num1 = Integer.parseInt(stack.pop()); //栈中第二个元素
                int res = 0;
                if (str.equals("+")){
                    res = num1 + num2;
                }else if (str.equals("-")){
                    res = num1 - num2;
                }else if (str.equals("*")){
                    res = num1 * num2;
                }else if (str.equals("/")){
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                //最后一个数字入栈
                stack.push(res+"");
            }
        }
        //最后的就是运算结果
        return Integer.parseInt(stack.pop());
    }

    //将逆波兰表达式,放入集合中
    private static List<String> getListString(String suffixExpress) {
        //将表达式分隔
        String[] split = suffixExpress.split(" ");
        List<String> list = new ArrayList<>();
        for (String str: split) {
            list.add(str);
        }
        return list;
    }
}

//判断运算符优先级
class Operation{
    private static int LEFT_BRACKET = 0;
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 3;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "(":
                result = LEFT_BRACKET;
                break;
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("运算符有误");
                break;
        }
        return result;
    }
}