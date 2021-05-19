package LinkedList;

/**
 * 约瑟夫问题
 *      模拟单项环形链表
 */
public class josephuTest {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //模拟小孩出圈
        //从第一个开始数，一次数两个数，数第二个数字的出局
        circleSingleLinkedList.countBoy(1,2,3);
    }
}

class CircleSingleLinkedList{
    //创建一个first节点，没编号
    private Boy first = null;

    //创建一个环形链表
    public void addBoy(int nums){
        //校验
        if (nums < 1){
            System.out.println("nums值不正常！！!");
            return;
        }
        Boy temp = null; //辅助指针
        for (int i =1; i <= nums; i++){
            //根据编号创建
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if ( i==1 ){
                first = boy; //初始化first节点
                first.setNext(first); //构造环
                temp = boy;
            }else {
                temp.setNext(boy); //boy添加到链表尾部
                boy.setNext(first); //构成环
                temp = boy; //指针后移
            }
        }
    }

    //遍历单向循环链表
    public void showBoy(){
        if (first == null){
            System.out.println("链表为空！！！");
            return;
        }
        //创建一个指针,first不能动
        Boy temp = first;
        while (true){
            System.out.printf("小孩的编号 %d \n", temp.getNo());
            if (temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }
    }

    //根据用户输入，计算小孩出圈的顺序

    /**
     *
     * @param startNo  小孩从第几个开始数
     * @param countNum  数几下停
     * @param nums      圈内有多少个小孩
     */
    public void countBoy(int startNo,int countNum,int nums){
        //校验
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("参数有误！！！！");
            return;
        }
        //创建辅助指针
        Boy temp = first;
        //遍历链表  让辅助节点指向链表最后一个节点
        while (true){
            if (temp.getNext() == first){  //遍历完成
                break;
            }
            temp = temp.getNext();
        }

        //报数前，开始移动指针  startNo  从第几个开始数
        for (int i = 0; i < startNo - 1; i++) {
                first = first.getNext();
                temp = temp.getNext();
        }

        //开始报数时,让first指针,temp指针同时移动
        //循环到  圈中只有一个节点
        while (true){
            if (temp == first){  //说明只剩下一个节点
                break;
            }
            //循环，移动指针
            for (int i = 0; i < countNum - 1 ; i++) {
                first = first.getNext();
                temp = temp.getNext();
            }
            //已经找到了要出圈的小孩子
            System.out.printf("出圈%d \n",first.getNo());
            first = first.getNext();
            temp.setNext(first);
        }

        System.out.printf("最后剩下的小号是%d\n",first.getNo());

    }
}

//创建一个Boy类，表示一个节点
class Boy{
    private int no; //编号
    private Boy next;//指向下一个节点，默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}