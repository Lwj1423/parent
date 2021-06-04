package search;

/**
 *
 * 线性查找
 */
public class SeqSearch {


    public static void main(String[] args) {
        int[] arr = {1,2,4,5,3};
        int index = seqSearch(arr,3);
        if (index == -1){
            System.out.println("没招到");
        }else{
            System.out.println("找打，下标为=：" + index);
        }
    }

    /**
     *  线性查找一个满足条件的值，就返回
     * @param arr
     * @param i
     * @return
     */
    private static int seqSearch(int[] arr, int i) {
        //线性查找，逐一对比
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i){
                return j;
            }
        }

        return -1;
    }
}
