package LinkedList;

/**
 * 3. 单链表
 *          定义HeroNode,每个heroNode 对象就是一个节点
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1,"小一","一一");
        HeroNode hero2 = new HeroNode(2,"小二","一二");
        HeroNode hero3 = new HeroNode(3,"小三","一三");
        HeroNode hero4 = new HeroNode(4,"小四","一四");

        //创建链表
        SingleLinkedList linkedList = new SingleLinkedList();
        //添加数据
      /*  linkedList.add(hero1);
        linkedList.add(hero3);
        linkedList.add(hero2);
        linkedList.add(hero4);*/

        // 加入按照编号的顺序
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
        //遍历数据
        linkedList.list();
        System.out.println();
        HeroNode newHeroNode = new HeroNode(3,"333","333333");
        linkedList.update(newHeroNode);
        linkedList.list();

        //删除节点
        linkedList.delete(2);
        System.out.println();
        linkedList.list();

        //面试题01:
        //      求单链表中有效节点的个数
        int length = SingleLinkedList.getLength(linkedList.getHead());
        System.out.println("链表的长度为:"+length);

        //     02: 查找单链表中倒数第k个结点
        HeroNode lastIndexNode = SingleLinkedList.findLastIndexNode(linkedList.getHead(), 1);
        System.out.println(lastIndexNode);


    }



}

//02.定义链表
class SingleLinkedList{
    //01.先定义一个头节点,头节点不能动,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    //获取头节点信息
    public HeroNode getHead() {
        return head;
    }
    //面试02: 查找单链表中倒数第k个结点
    //思路:
    // 1. 编写一个方法，接收head节点，同时接收一个index
    // 2. index 表示是倒数第index个节点
    // 3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    // 4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    // 5. 如果找到了，则返回该节点，否则返回nulll
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next == null){
            return null;  //空链表
        }
        //获取链表长度
        int length = getLength(head);
        //第二次遍历前 判断
        if (index <= 0 || index > length){
            return  null;
        }
        HeroNode temp = head.next;  //temp指向第一个
        for (int i = 0; i < length - index;i++){
            temp = temp.next;
        }
        return temp;
    }

    //面试01: 获取单链表中有效节点的个数
    public  static int getLength(HeroNode head){
        if (head.next == null){
            return 0;  //空链表
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    //02.添加节点到单向链表尾部
    /**
     * 思路:
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next 指向 新的节点
     */
    public void add(HeroNode heroNode){
        //先找到头节点
        HeroNode temp = head;
        //遍历链表,找到最后
        while (true){
            //找到链表最后
            if (temp.next == null){
                break;
            }
            //没有找到最后,将temp向后移
            temp = temp.next;

        }
        //循环结束,temp就指向了链表最后  最后这个temp的next 指向新节点
        temp.next = heroNode;
    }

    //02.第二种方式添加数据,按照编号将数据添加到指定位置
    //(如果数据存在,则添加失败,并给出提示)
    public void addByOrder(HeroNode heroNode){
        //头节点不动,找个辅助变量来找到添加的位置
        //temp 标识 添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false;  //flag标识添加的编号是否存在,默认false
        while (true){
            if (temp.next == null){//说明temp已经是最后
                break;
            }
            if (temp.next.no >heroNode.no){ //位置找到,就在temp后面添加
                break;
            }
            if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;    //后移,遍历当前链表
        }

        if (flag){
            System.out.printf("添加的编号为%d 的数据已经存在",heroNode.no);
        }else{
            //插入链表中,temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //03.修改节点信息
    //根据newHeroNode的no 来修改就可以
    public void update(HeroNode newHeroNode){
        //判空
        if (head.next == null){
            System.out.println("链表为空~~");
        }

        //找到需要修改的节点
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;  //表示是否找到该节点
        while (true){
            if (temp == null){
                break;  //已经遍历完链表
            }
            if (temp.next.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;//相当于遍历链表
        }

        if (flag){
            temp.next.name = newHeroNode.name;
            temp.next.nickName = newHeroNode.nickName;
        }else{
            System.out.printf("没有找到编号为 %d 的节点信息",newHeroNode.no);
        }

    }

    //04.删除指定节点
    public void  delete(int no){

        HeroNode temp = head;
        boolean flag = false;  //判断是否找到待删除节点
        if (head.next == null){
            System.out.println("链表为空~~");
        }
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next; //相当于遍历链表
        }
        if (flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的 %d 节点不存着\n",no);
        }
    }

    //06. 遍历显示链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //因为头节点不能动,需要辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            System.out.println(temp);
            //将temp后移   不后移会造成死循环
            temp = temp.next;
        }
    }

}

/**
 * 01.定义HeroNode,每个heroNode 对象就是一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;  //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方法,重写toString()
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
    }

}



