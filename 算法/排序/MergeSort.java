


//**************************************************************************
// 将一个数组进行归并排序
//**************************************************************************


import java.lang.reflect.Array;
import java.util.Arrays;

//归并排序就是分而自治的，将一个数组分成多份
public class MergeSort {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 3, 6, 4, 8, 7, 0, 2, 1, 4};

                //归并排序

        for (int a : MergeSort(nums))
            System.out.print(a);

    }

    static int[] MergeSort(int[] nums){

        if (nums.length/2 >= 1){         //这个是能够继续进行递归的条件

            int mid = (int) Math.floor(nums.length/2);

            int[] left = Arrays.copyOfRange(nums, 0, mid);
            int[] right = Arrays.copyOfRange(nums, mid, nums.length);

            return Merge(MergeSort(left), MergeSort(right));    //返回排序好的数组
        }

        return nums;    //数组长度小于2，直接返回
    }

    //将两个数组进行归并
    static int[] Merge(int[] Left, int[] Right) {

        //首先申请一个数组，长度为两个数组长度之和
        int[] M = new int[Left.length + Right.length];

        int i = 0;  //三个数组的初始位置
        int j = 0;
        int k = 0;

        while (i < Left.length && j < Right.length)       //如何将两个数组合并是关键,也要确定两个指针
            M[k++] = Left[i] < Right[j] ? Left[i++]:Right[j++];
        // 跳出以后还要把剩余的元素添加到新数组，i小于数组长度说明，左边的数组还没有弄完
        while (i < Left.length)
            M[k++] = Left[i++];

        while (j < Right.length)
            M[k++] = Right[j++];

        return M;

        }
}