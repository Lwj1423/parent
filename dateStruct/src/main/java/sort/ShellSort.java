package sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        //交换法
        /* int[] arr = { 101, 34, 119, 1 };
        shellSort(arr);*/

        //插入法
        int[] arr2 = { 101, 34, 119, 1 };
        //shellSort2(arr2);


        // 创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(now1);
        System.out.println("排序前的时间是=" + date1Str);

        //shellSort(arr); // 交换式
        shellSort2(arr); // 插入式

        LocalDateTime now2 = LocalDateTime.now();
        String date2Str = simpleDateFormat.format(now2);
        System.out.println("排序前的时间是=" + date2Str);

    }

    //希尔排序,插入法
    public static void shellSort2(int[] arr){
        int count = 0;
        //希尔排序
        //定义分组,直接到组为止
        for (int gap = arr.length / 2; gap >0; gap/= 2) {
            //按照第几组  进行遍历组
            for (int i = gap; i < arr.length ; i++) {
                int j = i;
                int temp = arr[j];
                //遍历各组中的元素
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && arr[j - gap] > temp){
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后,插入temp
                    arr[j] = temp;
                }
            }
            System.out.println("希尔排序弟" + (++count) + "轮=" + Arrays.toString(arr));
        }
    }

    //希尔排序,交换法
    public static void shellSort(int[] arr){
        int temp = 0;
        int count = 0;
        //希尔排序
        //定义分组,直接到组为止
        for (int gap = arr.length / 2; gap >0; gap/= 2) {
            //按照第几组  进行遍历组
            for (int i = gap; i < arr.length ; i++) {
                //遍历各组中的元素
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序弟" + (++count) + "轮=" + Arrays.toString(arr));
        }
    }
}
