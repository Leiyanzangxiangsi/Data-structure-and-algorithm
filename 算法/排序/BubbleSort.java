


//**************************************************************************
// 将一个数组进行冒泡排序
//**************************************************************************




public class BubbleSort {
    public static void main(String[] args){

        int[] nums = new int[]{9,3,6,4,8,7,0,2,1,4};
        BubbleSort(nums);
        for (int a : nums)
            System.out.println(a);

    }

    static void BubbleSort(int[] nums){

        //冒泡排序就是比较相邻元素
        for (int i = 0; i < nums.length - 1; i++){      //需要比较n - 1次
            boolean flagcomp = false;   //判断有没有进行比较
            for (int j = 0; j < nums.length - i - 1; j++){      //将大的元素不断往上冒泡
                if (nums[j] > nums[j + 1]){
                    flagcomp = true;
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j + 1] = temp;
                }
            }
            if (!flagcomp)
                break;  //没有比较就直接跳出循环
        }
    }
}
