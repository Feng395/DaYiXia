package com.chen.linkedlist;
/**
 * 1.整体来说每进行某个操作都要先通过遍历操作
 * 找到所需节点后再操作
 *
 *
 * */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"刘备","大哥");
        HeroNode hero2 = new HeroNode(2,"关羽","二弟");
        HeroNode hero3 = new HeroNode(3,"张飞","三弟");
        HeroNode hero4 = new HeroNode(4,"帅哥","某人");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.list();

        System.out.println("进行删除后的链表：");
        singleLinkedList.del(3);
        singleLinkedList.list();

    }
}

//定义单链表进行管理
class SingleLinkedList {
    //先初始化一个头节点  其中不存放数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向链表
    /**思路
    1. 遍历链表找到最后一个节点
    2. 并将最后一个结点的next 指向新的节点*/
    public void add(HeroNode heroNode) {
        //辅助节点
        HeroNode temp = head;
        //循环遍历
        while (true) {
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //按照no编号来修改节点信息
    /**temp是用来标记该所需修改的节点
    方法所传参数newHero是修改后的节点信息*/
    public void update (HeroNode newHeroNode) {
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //辅助变量
        HeroNode temp = head.next;
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

    //按照顺序添加节点
    public void addByOrder (HeroNode heroNode) {
        //辅助指针
        HeroNode temp = head;

        //flag作用是为了检查所添加编号是否存在
        //只要flag为true就表示不能添加
        boolean flag = false;
        while (true) { //注意是先判断再位置后移
            if (temp.next == null) {
                break;//此处表示位置已经找到
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true; //说明编号存在
                break;
            }
            temp = temp.next;
        }
        //判断flag 的值
        if (flag) {
            System.out.printf("准备添加的英雄编号%d 已存在，无法加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }


    }

    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //创建辅助变量来进行遍历
        HeroNode temp = head.next;
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

    //删除节点
    /**思路：
     * 1.找到待删除结点的上一个节点
     * 2.方法传递的参数是所需删除节点的编号no
     */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("想要删除的节点不存在！");
        }
    }



}

//定义HeroNode, 每个HeroNode 对象就是一个节点
//此处应该就是发挥结构体的作用
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.name = name;
        this.no  = no;
        this.nickname = nickname;
    }

    //重写toString方法
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ",nickname=" + nickname +"]";
    }


}
