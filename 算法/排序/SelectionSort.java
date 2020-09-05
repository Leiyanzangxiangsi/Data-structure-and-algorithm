

//**************************************************************************
// 将一个数组进行选择排序
//**************************************************************************

public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 3, 6, 4, 8, 7, 0, 2, 1, 4};
        SelectionSort(nums);
        for (int a : nums)
            System.out.println(a);

    }

    static void SelectionSort(int[] nums){

        //选择排序的思想就是每次都把最小的选出来前面
        for (int i = 0; i < nums.length; i++){
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < min){
                    min = nums[j];
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

    }

}
