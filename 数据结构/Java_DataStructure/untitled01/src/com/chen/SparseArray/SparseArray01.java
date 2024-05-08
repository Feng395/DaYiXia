package com.chen.SparseArray;

public class SparseArray01 {
    public static void main(String[] args) {
        //原始二维数组表示棋盘（11*11）
        //0 -- 空   1 -- 黑   2 -- 蓝
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始二维数组为：");
        for (int i = 0; i < chessArr1.length; i++){
            for(int j = 0; j < chessArr1[i].length; j++){
                System.out.printf("%d\t",chessArr1[i][j]);
            }
            System.out.println();
        }

        //将原始数组转换为稀疏数组
        //1.首先要先遍历原始数组得到非零的数据有几个（sum）

        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++){
            for (int j = 0; j < chessArr1[i].length; j++){
                if (chessArr1[i][j] != 0)sum++;
            }
        }
        //2.创建稀疏数组
        int[][] sparseArr1 = new int[sum + 1][3];
        sparseArr1[0][0] = 11;
        sparseArr1[0][1] = 11;
        sparseArr1[0][2] = sum;
        //3.在进行遍历一次原始数组并将非零数据填入稀疏数组
        //用于记录非零数据个数（等同于sum）
        int count = 0;

        for (int i = 0; i < chessArr1.length; i++){
            for (int j = 0; j < chessArr1[i].length; j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr1[count][0] = i;
                    sparseArr1[count][1] = j;
                    sparseArr1[count][2] = chessArr1[i][j];
                }
            }
        }
        //4.输出稀疏数组
        System.out.println();
        System.out.println("以下为所得稀疏数组：");
        for (int i = 0; i < sparseArr1.length; i++){
            for (int j = 0; j < sparseArr1[i].length; j++){
                System.out.printf("%d\t", sparseArr1[i][j]);
            }
            System.out.println();
        }

        //再将稀疏数组转变回二维数组
        int[][] chessArr2= new int[sparseArr1[0][0]][sparseArr1[0][1]];
        //对原始数组的非零部分进行赋值
        for (int i = 1; i < sparseArr1.length; i++){
            chessArr2[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
        }
        //遍历所得原始数组
        System.out.println();
        System.out.println("以下为由稀疏数组转变所得的二维数组：");
        for (int i = 0; i < chessArr2.length; i++){
            for (int j = 0; j < chessArr2[i].length; j++){
                System.out.printf("%d\t",chessArr2[i][j]);
            }
            System.out.println();
        }
    }
}
