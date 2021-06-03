package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序
 */
public class MergetSort {

    public static void main(String[] args) {

        /*int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        int temp[] = new int[arr.length]; // 归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("归并排序后=" + Arrays.toString(arr));*/

        // 测试快排的执行速度
        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int temp[] = new int[arr.length]; // 归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        // System.out.println("归并排序后=" + Arrays.toString(arr));

    }


    public static void mergeSort(int[] arr,int left, int right, int[] temparr){
        if (left < right){
            //创建中间索引
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort(arr,left,mid,temparr);
            //向右递归进行分解
            mergeSort(arr,mid + 1,right,temparr);
            //合并
            merge(arr,left,mid,right,temparr);
        }

    }

    /**
     * 合并方法
     * @param arr     排序的原始数组
     * @param left      左边有序序列的索引
     * @param mid       中间索引
     * @param right     右边索引
     * @param temparr       中转的数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temparr) {

        //初始化i,  左边有序序列的 初始索引
        int i = left;
        //初始化j, 右边有序序列的  初始索引
        int j = mid + 1;
        //定义指针  指向临时数组
        int t = 0;

        // (一)
        //先把左右两边(有序)的数据按照规则填充到temparr数组中
        // 直到左右两边的有序序列,有一边处理完为止
        while ( i <= mid && j <= right){ //保证左右两边数组不会越界

            //如果左边的当前元素  小于等于右边序列的当前元素
            //将左边的元素, 填充到temp数组
            if (arr[i] <= arr[j]){
                temparr[t] = arr[i];
                t += 1;
                i += 1;
            }else {// 反之,将右边有序序列的当前元素，填充到temp数组
                temparr[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        // (二)
        //如果有一边结束,将剩余另一边数据全部加到temparr
        while (i <= mid){ //左边的剩余元素 添加到数组
            temparr[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right){ //将右边的剩余元素 添加到数组
            temparr[t] = arr[j];
            t += 1;
            j += 1;
        }

        // (三)
        // 将temp数组的元素拷贝到arr
        // 注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temparr[t];
            t += 1;
            tempLeft += 1;
        }

    }

}



