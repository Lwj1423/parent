package sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        /*int[] arr = {1,2,4,3,7,9,6,5,2};
        insertSort(arr);*/

        int[] testarr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            testarr[i] = (int) (Math.random() * 80000);
        }
        //创建时间
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = ofPattern.format(now1);
        System.out.println("排序前的时间是=" + now1);

        insertSort(testarr);

        LocalDateTime now2 = LocalDateTime.now();
        String format2 = ofPattern.format(now2);
        System.out.println("排序后的时间=" + now2);

    }

    // 插入排序
    public static void insertSort(int[] arr){

        int insertVal = 0;
        int insertIndex = 0;
        //遍历集合
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            //记录待插入数 的前一个位置
            insertIndex = i - 1;
            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && arr[insertIndex] > insertVal){
                //将待插入数  替换为  前一个数
                //待插入数  小于  前一个数
                arr[insertIndex + 1] = arr[insertIndex];
                //指针前移
                insertIndex--;
            }
            //将前一个数 替换为带插入数
            arr[insertIndex + 1] = insertVal;

            /*System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));*/
        }
    }
}
