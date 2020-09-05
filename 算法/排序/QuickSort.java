

//**************************************************************************
// 将一个数组进行快速排序
//**************************************************************************

public class QuickSort {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 3, 6, 4, 8, 7, 0, 2, 1, 4};
        QuickSort(nums, 0, nums.length - 1);
        for (int a : nums)
            System.out.print(a);

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

}
