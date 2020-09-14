import java.util.Scanner;

public class ZAtest2 {

    public static void main(String[] args) {

        int[] grid = {20,30,20};
        System.out.println(saveZhenaiCoin (grid));

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param grid int整型一维数组
     * @return int整型
     */
    //直接贪心
    public static int saveZhenaiCoin (int[] grid) {
        // write code here

        int len = grid.length;

        int i=0;        //索引从0出发
        int sum = 0;
        sum += grid[0];
        while(i+2<len){                //如果两步已经可以跳出来了，直接退出
            if(grid[i+1]<grid[i+2]){
                sum += grid[i+1];
                i = i+1;
            }
            else{
                sum += grid[i+2];
                i=i+2;
            }
        }

        i=1;
        int sum1=0;
        sum1+=grid[1];

        while(i+2<len){

            if(grid[i+1]<grid[i+2]){
                sum1 += grid[i+1];
                i = i+1;
            }
            else{
                sum1 += grid[i+2];
                i=i+2;
            }
        }

        if (sum>sum1)
            return sum1;
        else
            return sum;
    }
}
