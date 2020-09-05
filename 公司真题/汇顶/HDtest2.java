import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HDtest2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        Double[] nums = new Double[10];

        String grade = in.nextLine();
        String[] gra = grade.split(",");

        for (int i = 0; i < 10;i++)
            nums[i] = getdouble(gra[i]);


        QuickSort(nums,0,nums.length-1);

        int ans = 1;
        double f = nums[0];
        for (int i = 1; i<10;i++){
            if (nums[i] != f)
                break;
            else
                ans++;
        }

        System.out.println(ans);
    }
    static double getdouble(String gra){
        double ans = 0;

        Queue<Double> q = new LinkedList<>();
        Queue<Double> q1 = new LinkedList<>();

        int i = 0;
        for (;i < gra.length(); i++){
            if (gra.charAt(i) != '.')
                q.add((double)(gra.charAt(i) - '0'));
            else
                break;
        }

        i++;
        for (; i < gra.length(); i++)
            q1.add((double)(gra.charAt(i) - '0'));

        int qs = q.size();
        for (int j = 0; j < qs;j++)
            ans = ans + q.poll()*Math.pow(10,qs-j-1);


        double temp = 0;
        int q1s = q1.size();
        for (int j = 0; j < q1s;j++)
            temp = temp + q1.poll() * Math.pow(10, q1s-j-1);

        return ans + temp/Math.pow(10, q1s);
    }

    static void QuickSort(Double[] nums, int left, int right){

        if (left < right){          //这个是能够继续进行递归的条件

            int index = GetIndex(nums, left, right);
            QuickSort(nums, left, index - 1);   //进行递归
            QuickSort(nums, index + 1, right);
        }

    }

    //如何获得索引值呢，就是整个数组与标定值比较，从右往左
    static int GetIndex(Double[] nums, int left, int right){

        Double temp = nums[left];      //将左边第一个值作为标定值
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
}
