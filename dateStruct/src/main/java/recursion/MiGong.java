package recursion;

/**
 * 递归：
 *      迷宫问题
 */
public class MiGong {

    //测试代码
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];

        //使用1 表示墙
        for (int i = 0; i < 7; i ++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置障碍物
        map[3][1] = 1;
        map[3][2] = 1;
        map[4][4] = 1;
        map[5][4] = 1;
        map[6][4] = 1;
        map[4][4] = 1;

        System.out.println("地图情况");

        //遍历map
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //测试
        setWay(map,1,1);
        System.out.println("小球走过，并标识过的 地图的情况");

        //遍历map
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }


    /**
     *使用递归回溯算法
     * 思路
     *     1.map表示地图
     *     2.i j 表示从什么位置开始
     *     3. 结束位置 map[6][5] ,
     *     4. 规则：
     *          0：表示没走过
     *          1：表示墙
     *          2：表示通路，可以走
     *          3： 表示走过的路，不通
     *     5， 走迷宫策略 ：
     *          下 -> 右 -> 上 -> 左
     * @param map 表示地图
     * @param i     从哪个位置开始
     * @param j
     * @return   找到通路就返回true
     */
    public static boolean setWay(int[][] map,int i, int j){
        //通路已经找到，结束
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0) { //当前节点还没走过
                map[i][j] = 2;  //假设该节点可以走通
                if (setWay(map,i+1,j)){ //向下走
                    return true;
                }else if (setWay(map,i,j + 1)){ //向右走
                    return true;
                }else if (setWay(map,i -1, j)){ //向上走
                    return true;
                }else if (setWay(map,i,j - 1)){ //向左走
                    return true;
                }else {
                    //说明此路不通
                    map[i][j] = 3;
                    return false;
                }
            }else { // 如果map[i][j] != 0 ,可能是1,2,3
                return false;
            }
        }
    }

    // 修改找路的策略，
    //      改成 上->右->下->左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 通路已经找到ok
            return true;
        } else {
            if (map[i][j] == 0) { // 如果当前这个点还没有走过
                // 按照策略 上->右->下->左
                map[i][j] = 2; // 假定该点是可以走通.
                if (setWay2(map, i - 1, j)) {// 向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    // 说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j] != 0 , 可能是 1（墙体）， 2（已经走过的格子）， 3（已经走过，并且无法走通的格子）
                return false;
            }
        }
    }
}
