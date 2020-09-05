

//**************************************************************************
// 将一个数组进行计数排序
//**************************************************************************


//计数排序适合数组里面的值相差不大


public class CountingSort {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 3, 6, 4, 8, 7, 0, 2, 1, 4};
        CountingSort(nums);

        for (int a : nums)
            System.out.print(a);

    }

    static void CountingSort(int[] nums){

        int max = GetMax(nums);
        int min = GetMin(nums);

        int[] B = new int[max - min + 1];   //新建数组

        for (int a : nums)
            B[a - min] = B[a - min] + 1;    //索引值次数填入

        int c = 0; //用来计数的

        for (int i = 0; i<B.length; i++){
            while (B[i] > 0){
                nums[c] = i + min;
                c++;
                B[i] = B[i] - 1;
            }
        }
    }

    static int GetMax(int nums[]){
        int max = nums[0];
        for (int a : nums){
            if (a > max)
                max = a;
        }
        return max;
    }

    static int GetMin(int nums[]){
        int min = nums[0];
        for (int a : nums){
            if (a < min)
                min = a;
        }
        return min;
    }

}
