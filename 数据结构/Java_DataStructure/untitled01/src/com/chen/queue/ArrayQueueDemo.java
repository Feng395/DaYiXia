package com.chen.queue;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ArrayQueueDemo {
    /**队列先进先出
    队列头数据即 即将要被取出的数据
     rear是队列尾 添加数据是从队列尾添加
     front是队列头 取出数据是从队列头取出
     该队列取出后前面的空间就无法操作：原因是这并不是一个环形队列

    */
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0); //接受一个字符
            switch (key){
                case 's':
                    queue.showQueue();;
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g'://取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage() );
                    }
                    break;
                case 'h'://查看队列头数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}

class ArrayQueue{
    private int maxSize;// 表示数组最大容量
    private int front;// 队列头
    private int rear;// 队列尾
    private int[] arr;// 该数组用于存放数据，模拟队列

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;// front指向队列头的前一个位置
        rear = -1;// rear指向队列尾的当前位置
    }

    //判断队列是否已满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n){
        //首先要先判断队列是否已满
        if(isFull()){
            System.out.println("队列已满，无法添加数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列数据，出队列
    public int getQueue(){
        //首先要先判断队列是否为空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("队列为空，暂无数据");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue(){
        //首先要先判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //显示队列头数据，注意不是取出数据
    public int headQueue(){
        //首先要先判断队列是否为空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("队列为空，暂无数据");
        }
        return arr[front + 1];
    }

}