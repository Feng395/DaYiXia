package com.chen.linkedlist;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,2,5);

    }
}

class CircleSingleLinkedList {
    //创建first节点
    private Boy first = new Boy(-1);

    //添加小孩节点，构成一个环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        //使用for循环来创建链表
        for (int i = 1; i <=nums; i++) {
            //根据编号来创建小孩节点
            Boy boy = new Boy(i);
            //第一个小孩特别
            if (i == 1) {
                first = boy;
                first.setNext(first); //构成环状
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }

    }

    //遍历环形列表
    public void showBoy() {
        //辅助指针
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号为%d\n",curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    /**
     * startNo 表示从第几个小孩开始
     * countNum 表示数几下
     * nums 表示起初有几个小孩  取决于起初所创建链表有几个节点  该方法中并无设置*/
    //根据用户输入，计算小孩出圈顺序
    public void countBoy(int startNo, int countNum, int nums) {
        //辅助指针
        Boy helper = first;
        //让辅助指针指向环形列表最后节点
        //即helper一直指向first的前一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        //报数前，先让first 和 helper 移动 startNo - 1 次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //报数时，让first 和 helper 移动 countNum - 1 次，然后出圈
        while (true) {
            if (helper == first) {
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
                //此时first即所需出圈小孩
            }
            System.out.printf("%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }

        //报数后，圈中只剩一个节点小孩
        System.out.printf("最后所剩小孩编号为%d\n",first.getNo());

    }
}

//创建boy类，表示节点
class Boy {
    private int no; //编号
    private Boy next; //指向下一个节点，默认为null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}