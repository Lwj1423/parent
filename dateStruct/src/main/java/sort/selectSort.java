package sort;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 选择排序
 */
public class selectSort {

    public static void main(String[] args) {
        /*int[] arr = { 101, 34, 119, 1 };
        selectSort(arr);
*/
        int[] testarr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            testarr[i] = (int) (Math.random() * 80000);
        }
        //创建时间
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = ofPattern.format(now1);
        System.out.println("排序前的时间是=" + now1);

        selectSort(testarr);

        LocalDateTime now2 = LocalDateTime.now();
        String format2 = ofPattern.format(now2);
        System.out.println("排序后的时间=" + now2);

    }

    //选择排序
    public static void selectSort(int[] arr){

        // 使用逐步推导的方式来，讲解选择排序
        // 第1轮
        // 原始的数组 ： 101, 34, 119, 1
        // 第一轮排序 : 1, 34, 119, 101
        // 算法 先简单--》 做复杂， 就是可以把一个复杂的算法，拆分成简单的问题-》逐步解决
        int minIndex = 0;
        int min = 0;
        //先遍历数组
        for (int i = 0; i < arr.length -1; i++) {
            minIndex = i;  //记录最小数据下标      默认为数组第一个元素
            min = arr[i];   //记录最小数据的值    默认为数组第一个元素
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){  //说明假定的最小值不成立
                    min = arr[j];   //重置min
                    minIndex = j;   //重置minIndex
                }
            }
            // 将最小值，放在arr[0], 即交换
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
           /* System.out.println("第" + (i + 1) + "轮后~~");
            System.out.println(Arrays.toString(arr));*/
        }
    }
}
