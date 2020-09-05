
//**************************************************************************
// 将一个数组进行插入排序
//**************************************************************************


public class InsertSort {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 3, 6, 4, 8, 7, 0, 2, 1, 4};
        InsertSort(nums);
        for (int a : nums)
            System.out.println(a);

    }

    static void InsertSort(int[] nums){

        //选择排序的思想就是每次都把最小的选出来前面,如果是插入计算，不用交换，用前面的值直接覆盖后面
        for (int i = 1; i < nums.length; i++){  //从左往右，第i个元素之前是一个有序的数组i

            int temp = nums[i];     //这个就是需要插入的元素
            int j = i;

            while (j > 0 && temp <= nums[j - 1]){    //右边是一个有序的数列，进行插入计算
                nums[j] = nums[j - 1];          //前面的元素直接覆盖后面
                j--;
            }
            //当插入的元素比前面小
            //if (j != i)     //
            nums[j] = temp;         //直接插入

            }
        }
}
