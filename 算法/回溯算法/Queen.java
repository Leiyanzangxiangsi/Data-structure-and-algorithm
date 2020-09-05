

//**************************************************************************
// 八王后问题
//**************************************************************************


public class Queen {

    static int total = 0;           //全局变量，总的可能

    public static void main(String[] args) {

        int n = 8;                  //皇后数量
        int[] c = new int[n];       //用来存储路径上的每一个结点

        queen(0, c, n);
        System.out.print(total);

    }

    public static void queen(int row, int[] c, int n){

        if (row == n){                      //满足结束条件，就是行数等于个数，皇后都摆完了
            for (int i = 0; i < n;i++)      //依次打印每一行的皇后放在第几列
                System.out.print(c[i]);

            System.out.println('\n');
            total++;                        //可能性加1
        }
        else{
            for (int col = 0; col < n; col++){      //从第0列开始

                c[row] = col;                       //某一行的皇后从第0列开始放
                if (isok(c, row, n))                //是否满足约束条件，这一行的皇后和前面放好的皇后都不在一条线上    //前序
                    queen(row+1, c, n);//满足进入一下个结点
            }
            //如果循环了所有列都不可以摆放，回溯上一层改变商议后皇后的拜访

        }
    }

    public static boolean isok(int[] c, int row, int n){
        for (int i = 0; i < row; i++){
            //第ROW行的皇后不能和任意之前的皇后在同一列，和斜角方向。从左往右斜，就是列减行相等，从右往左斜，就是列加行相等
            if (c[i] == c[row] || row - i == Math.abs(c[row] - c[i]))
                return false;
        }
        return true;
    }

}
