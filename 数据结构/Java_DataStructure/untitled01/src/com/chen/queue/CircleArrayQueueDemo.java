package com.chen.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //以下为环形队列的测试
        System.out.println("以下为环形队列的测试：");
        CircleArray queue = new CircleArray(4);//队列的有效空间仍然只有3
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
class CircleArray {
    private int maxSize;// 表示数组最大容量
    //front指向队列的第一个元素   初始值为0
    private int front;// 队列头
    //rear指向队列的最后一个元素的后一个位置   初始值为0
    private int rear;// 队列尾
    private int[] arr;// 该数组用于存放数据，模拟队列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        //rear位置后移  并且要考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据，出队列
    public int getQueue(){
        //首先要先判断队列是否为空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("队列为空，暂无数据");
        }
        //1. 先将front的值保存到一个临时变量中
        //2. 再将front后移 同样需要考虑取模
        //3. 返回临时变量
        int value = arr[front];
        front++;
        return value;
    }

    //显示队列所有数据
    public void showQueue(){
        //首先要先判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for(int i = front; i < front + size(); i++){
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列中有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列头数据，注意不是取出数据
    public int headQueue(){
        //首先要先判断队列是否为空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("队列为空，暂无数据");
        }
        return arr[front];
    }



}