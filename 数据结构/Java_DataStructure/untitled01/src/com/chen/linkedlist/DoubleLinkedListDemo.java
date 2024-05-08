package com.chen.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试：");
        HeroNode2 hero1 = new HeroNode2(1,"刘备","大哥");
        HeroNode2 hero2 = new HeroNode2(2,"关羽","二弟");
        HeroNode2 hero3 = new HeroNode2(3,"张飞","三弟");
        HeroNode2 hero4 = new HeroNode2(4,"帅哥","某人");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.getHead();

        doubleLinkedList.list();

        System.out.println("以下为删除后的链表：");
        doubleLinkedList.del(2);
        doubleLinkedList.list();

        System.out.println("以下为更改后的链表：");
        HeroNode2 newHero = new HeroNode2(3,"飞飞","老三");
        doubleLinkedList.update(newHero);
        doubleLinkedList.list();


    }
}

//创建一个双向链表
class DoubleLinkedList {

    //先初始化一个头节点  其中不存放数据
    private HeroNode2 head = new HeroNode2(0,"","");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //创建辅助变量来进行遍历
        HeroNode2 temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }

            //输出节点信息
            System.out.println(temp);

            //后移节点
            temp = temp.next;
        }
    }

    //添加节点到双向链表末尾
    public void add(HeroNode2 heroNode) {
        //辅助节点
        HeroNode2 temp = head;
        //循环遍历
        while (true) {
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //按照no编号来修改节点信息
    /**temp是用来标记该所需修改的节点
     方法所传参数newHero是修改后的节点信息*/
    public void update (HeroNode2 newHeroNode) {
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;//用于判断是否找到该节点
        while (true) {
            if (temp == null) {
                break;//遍历至尾部也没有找到该节点，说明并无该节点
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        temp.nickname = newHeroNode.nickname;
        temp.name = newHeroNode.name;

    }

    //删除节点
    /**思路：
     * 1.找到待删除结点
     * 2.方法传递的参数是所需删除节点的编号no
     */
    public void del(int no) {

        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;//是否有所删除节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("想要删除的节点不存在！");
        }
    }

}

//定义HeroNode2, 每个HeroNode 对象就是一个节点
//此处应该就是发挥结构体的作用
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.name = name;
        this.no  = no;
        this.nickname = nickname;
    }

    //重写toString方法
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ",nickname=" + nickname +"]";
    }


}