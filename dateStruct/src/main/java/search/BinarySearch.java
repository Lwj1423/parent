package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二分查找算法
 *      前提： 数组有序
 */
public class BinarySearch {

    public static void main(String[] args) {

        int arr[] = { 1, 8, 10, 89, 1000, 1234 };
        int resIndex = myBinarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndex=" + resIndex);
    }

    /**
     *  查找到就退出
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    private static int myBinarySearch(int[] arr, int left, int right, int findVal) {

        //当left > right 时，说明递归整个数组，但是没找到
        if (left > right){
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal){
            return myBinarySearch(arr,mid + 1, right,findVal);
        }else if (findVal < midVal) { // 向左递归
            return myBinarySearch(arr, left, mid - 1, findVal);
        } else {
            return  mid;
        }

        /*while (left <= right) {
            int mid = (left + right) >>> 1;
            long midVal = arr[mid];

            if (midVal < findVal)
                left = mid + 1;
            else if (midVal > findVal)
                right = mid - 1;
            else
                return mid; // key found
        }*/
    }


    public static List<Integer> binarySearch(int[] arr,int left, int right,int findVal){

        //当left > right 时,说明没找到
        if (left > right){
            return  new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal){
            return binarySearch(arr,mid + 1, right,findVal);
        }else if (findVal < midVal){
            return binarySearch(arr,left,mid -1 ,findVal);
        }else {
        // 思路分析
            // 1. 在找到mid 索引值，不要马上返回
            // 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            // 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            // 4. 将Arraylist返回

            List<Integer> resIndexList = new ArrayList<>();
            //向mid索引值的左边扫描,扫描所有相等元素
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }

                //将数据放入集合
                resIndexList.add(arr[temp]);
                temp -= 1;
            }
            resIndexList.add(mid);

            //向右边扫描
            temp = mid + 1;
            while (true){
                if (temp > arr.length - 1 || arr[temp] != findVal){
                    break;
                }

                //添加数据
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }

}
