package recursion;

/**
 * 8皇后问题
 */
public class queen8 {

    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        //测试8，皇后是否正确
        queen8 queen8 = new queen8();
        queen8.check(0);
        System.out.printf("一共有%d种解法\n", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w
    }

    //编写一个方法，放置第n个
    // check每递归一次，进入到check中都有一个for()
    private void check(int n) {
        if (n == max){
            //print();  //输出数组
            System.out.println("执行了几次");
            return;
        }

        //依次放入数据，判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前数据，放到该行第1列
            array[n] = i;
            //判断当前放置第n个数据到i列，是否冲突
            if (judge(n)){  //不冲突
                check(n + 1);
            }

            // 如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行的后移的一个位置
        }
    }

    //判断当放置第n个皇后，是否和前面已经摆放的冲突
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 说明
            // 1. array[i] == array[n] 表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            // 2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            // n = 1 放置第 2列 1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            // 3. 判断是否在同一行, 没有必要，n 每次都在递增
            if (array[i] == array[n] ||Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //遍历皇后位置
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
