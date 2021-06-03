package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 快速排序
 */
public class quickSort {

    public static void main(String[] args) {
        /*int[] arr = {25, 84, 21, 47, 15, 27, 68, 35, 20};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));*/


        //测试性能
        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 800000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr, 0, arr.length - 1); // 交换式

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }


    //快速排序
    public static void quickSort(int[] arr,int left ,int right){
        if (left < right){
            int partitionIndex = partition(arr,left,right);
            quickSort(arr,left,partitionIndex - 1);
            quickSort(arr,partitionIndex + 1,right);
        }

    }

    private static int partition(int[] arr, int left, int right) {

        int pivot = arr[left];
        //终止while循环以后left 和right 相等
        while (left < right){
            //遍历右边
            while (left < right && arr[right] >= pivot){
                --right;
            }
            //右边遇到比pivot小的,右边的值 赋给左边,
            arr[left] = arr[right];
            //开始遍历左边
            while (left < right && arr[left] <= pivot){
                ++left;
            }
            //遇到左边大于pivot  赋值
            arr[right] = arr[left];
        }
        //给最后剩余位置赋值
        arr[left] = pivot;
        return left;
    }
}
