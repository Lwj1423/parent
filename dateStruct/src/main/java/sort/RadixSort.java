package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {

       /* int arr[] = { 53, 3, 542, 748, 14, 214 };
        radixSort(arr);
        System.out.println("基数排序后 " + Arrays.toString(arr));*/


        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
        int[] arr2 = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr2[i] = (int) (Math.random() * 800000); // 生成一个[0, 8000000) 数
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        radixSort(arr2);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

    }


    public static void radixSort(int[] arr){

        //1.获取最大值的长度,来判断循环几次
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //获取最大值的长度
        int maxLength = (max + "").length();

        //定义一个二维数组,表示10个桶,每个桶是一维数组
        /**
         * 说明;
         *  1.二维数组 包含10个一维数组
         *  2.防止数组越界, 设置一维数最大值
         *  3.基数排序
         */
        int[][] buket = new int[10][arr.length];

        //创建个临时数组,记录每个桶实际存放了多个少数据
        int[] bucketElementCounts = new int[10];


        //从 个位,十位,百位.....处理
        for (int i = 0, n = 1; i < maxLength; i++,n *= 10) {
            //遍历传进来的数组
            for (int j = 0; j < arr.length; j++) {
                //依次获取个位,十位,百位.... 取出数据,放到二维数组中
                int digitOfElement = arr[j] / n % 10;

                buket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                //临时数组递增
                bucketElementCounts[digitOfElement]++;
            }

            //循环结束,将数组放回原来数组
            //定义一个临时变量
            int index = 0;
            //遍历每个桶,并将桶中数据,放回到原数组
            //遍历临时桶,确定遍历几次
            for (int j = 0; j < bucketElementCounts.length; j++) {
                //如果桶中有数据,再取数
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    //取出元素放到原数组
                    arr[index++] = buket[j][k];
                }
                //将临时数组中 对应桶中数 设置为初始值
                bucketElementCounts[j] = 0;
            }
            //System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));
        }

    }
}
