package search;

/**
 *
 * 插值查找算法
 */
public class InsertValueSearch {

    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr,0,arr.length - 1,10);
        System.out.println("index = " + index);
    }

    //编写插值查找算法
    //插值查找算法, 要求数组是有序的

    /**
     *  如果找到,就返回对应下标,没找到 返回 -1
     * @param arr 数组
     * @param left  左边索引
     * @param right 右边索引
     * @param findVal  查找值
     * @return
     */
    private static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        if (left > right ||findVal < arr[left] || arr[right] < findVal){
            return -1;
        }

        //插值重点:
        //          自定义函数来获取 中间值
        int mid = left + (left - right) * (findVal - arr[left]) / (arr[left] - arr[right]);
        int minVal = arr[mid];
        if (findVal > minVal){
            return insertValueSearch(arr,mid + 1, right,findVal);
        }else if (findVal < minVal){
            return insertValueSearch(arr,left,mid + 1, findVal);
        }else{
            return mid;
        }
    }

}
