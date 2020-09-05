import java.util.Arrays;
import java.util.Scanner;

public class SFtest1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();   //个服务器
        int m = in.nextInt();   //m个用户

        int[] w = new int[n];           //每个物品的重量
        int[][] wv = new int[m][2];     //每个物品的价值


        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            wv[i][0] = in.nextInt();
            wv[i][1] = in.nextInt();
        }

        QuickSort(w, 0, w.length - 1);      //带宽排序
        QuickSort1(wv, 0, wv.length - 1);    //用愿意花的最大价值排序



        //System.out.println(Arrays.toString(w));
        //for (int[] a:wv)
        //    System.out.println(Arrays.toString(a));

        System.out.println(Getmax(w, wv));
    }

    public static int Getmax(int[] w, int[][] wv){

        int sum = 0;
        int i = 0;
        int j = wv.length - 1;

        while (j >= 0){       //循环退出的条件
            while (i < w.length && w[i] < wv[j][0])
                i++;

            if (i != w.length){
               w[i] = -1;
               sum = sum + wv[j][1];
               j--;
               i = 0;
            }
            else{
                i = 0;
                j--;
            }
        }

        return sum;

    }

    static void QuickSort(int[] nums, int left, int right){

        if (left < right){          //这个是能够继续进行递归的条件

            int index = GetIndex(nums, left, right);
            QuickSort(nums, left, index - 1);   //进行递归
            QuickSort(nums, index + 1, right);
        }

    }

    //如何获得索引值呢，就是整个数组与标定值比较，从右往左
    static int GetIndex(int[] nums, int left, int right){

        int temp = nums[left];      //将左边第一个值作为标定值
        int i = left;               //左右两根指针
        int j = right;

        while (i < j){      //找到标定值的条件

            while (i < j && nums[j] >= temp)
                j--;    //如果比标定值大，则值不改变，右指针往右移，知道比标定值小跳出循环

            nums[i] = nums[j];  //右指针指向小于标定值，右指针指向值赋给左指针

            while (i < j && nums[i] <= temp)     //现在开始从左往右扫描，比标定值小，则不动，否在改变
                i++;

            nums[j] = nums[i];  //右指针指向小于标定值，右指针指向值赋给左指针

        }
        nums[i] = temp;  //标定值找到了合适的位置

        return i;       //返回新的索引位置
    }

    static void QuickSort1(int[][] nums, int left, int right){

        if (left < right){          //这个是能够继续进行递归的条件

            int index = GetIndex1(nums, left, right);
            QuickSort1(nums, left, index - 1);   //进行递归
            QuickSort1(nums, index + 1, right);
        }

    }

    //如何获得索引值呢，就是整个数组与标定值比较，从右往左
    static int GetIndex1(int[][] nums, int left, int right){

        int[] temp = nums[left];      //将左边第一个值作为标定值
        int i = left;               //左右两根指针
        int j = right;

        while (i < j){      //找到标定值的条件

            while (i < j && nums[j][1] >= temp[1])
                j--;    //如果比标定值大，则值不改变，右指针往右移，知道比标定值小跳出循环

            nums[i] = nums[j];  //右指针指向小于标定值，右指针指向值赋给左指针

            while (i < j && nums[i][1] <= temp[1])     //现在开始从左往右扫描，比标定值小，则不动，否在改变
                i++;

            nums[j] = nums[i];  //右指针指向小于标定值，右指针指向值赋给左指针

        }
        nums[i] = temp;  //标定值找到了合适的位置

        return i;       //返回新的索引位置
    }
}
