package LinkedList;

import com.sun.jmx.snmp.SnmpNull;

/**
 * 双向链表
 */
public class DoubleLinkedDemo {
    public static void main(String[] args) {
// 测试
        System.out.println("双向链表的测试");


        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(5, "林冲", "豹子头");

        // 创建一个双向链表
        DoubleLinked doubleLinkedList = new DoubleLinked();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 测试按需插入
        doubleLinkedList.addByOrder(new HeroNode2(4, "Heygo", "Heygogo"));
        doubleLinkedList.addByOrder(new HeroNode2(6, "Oneby", "Onebyone"));
        System.out.println("按顺序插入后的情况");
        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode2 = new HeroNode2(5, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode2);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(1);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();


    }

}

//02.定义链表
class DoubleLinked{
    //01.先定义一个头节点,头节点不能动,不存放具体数据
    private HeroNode2 head = new HeroNode2(0,"","");

    //获取头节点信息
    public HeroNode2 getHead() {
        return head;
    }

    //删除节点
    public void del(int no){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //找到需要修改的节点
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }

            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //找到节点
        if (flag){
            temp.pre.next = temp.next;
            //如果是最后一个节点 ，temp.next == null
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("要删除的节点，没有找到！！！");
        }
    }

    //修改节点内容
    public void update(HeroNode2 heroNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //找到需要修改的节点
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }

            if (temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //找到节点
        if (flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else{
            System.out.println("没有找到！！！");
        }
    }

    //尾部插入
    public void add(HeroNode2 heroNode){
        //因为头节点不动，所以需要辅助变量
        HeroNode2 temp = head;
        while (true){
            //找到链表最后
            if (temp.next == null){
                break;
            }
            //循环遍历
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //按顺序插入
    public void addByOrder(HeroNode2 newHeroNode){
        //因为头节点不动，所以需要辅助变量
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            //找到链表最后
            if (temp.next == null){
                break;
            }
            if (temp.next.no > newHeroNode.no){
                break;
            }else if (temp.next.no == newHeroNode.no){
                flag = true;
                break;
            }
            //循环遍历
            temp = temp.next;
        }

        if (flag){
            System.out.println("数据已经存在，不能添加");
        }else{
            //最后一个节点 temp.next == null
            newHeroNode.next = temp.next;
            if (temp.next!=null){
                temp.next.pre = newHeroNode;
            }

            // 当退出while循环时，temp就指向了链表的最后
            // 形成一个双向链表
            temp.next = newHeroNode;
            newHeroNode.pre = temp;
        }


    }



    //遍历双向链表
    public void list(){
        if (head.next == null){
            System.out.println("链表为空！！");
            return;
        }

        //因为头节点不动，所以需要辅助变量
        HeroNode2 temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;  //模拟遍历
        }
    }


}

/**
 * 01.定义HeroNode,每个heroNode 对象就是一个节点
 */
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;  //指向下一个节点
    public HeroNode2 pre;  //指向上一个节点

    //构造器
    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方法,重写toString()
    @Override
    public String toString() {
        return "HeroNode2 [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
    }

}
