package sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/*
冒泡排序

 */
public class bubbleSort {

    public static void main(String[] args) {
        /*int[] arr = {5,4,3,2,1};
        bubble(arr);
        System.out.println(Arrays.toString(arr));*/
        //测试冒泡排序的性能
        int[] testarr = new int[20000];
        for (int i = 0; i < 20000; i++) {
            testarr[i] = (int) (Math.random() * 20000);
        }
        //创建时间
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = ofPattern.format(now1);
        System.out.println("排序前的时间是=" + now1);

        bubble(testarr);

        LocalDateTime now2 = LocalDateTime.now();
        DateTimeFormatter ofPattern2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format2 = ofPattern.format(now2);
        System.out.println("排序后的时间=" + now2);

    }


    /**冒泡排序
     *
     * @param arr
     */
    public static void bubble(int[] arr){
        int temp = 0;  //临时变量
        boolean flag = false; // 优化
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j +1];
                    arr[j + 1] = temp;
                }
            }

            if (!flag){
                break;
            }else{
                flag = false;
            }
        }
    }
}
