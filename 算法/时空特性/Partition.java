

//找到数组中任意K大的数字
public class Partition {

    public static void main(String[] args) {


        int[] nums = {17,13,3,1,5,3,3,3};
        System.out.println(majorityElement(nums));

    }

    public static int majorityElement(int[] nums) {

        if (nums.length==0)
            return 0;
        int mid = nums.length/2;
        int left = 0;
        int right = nums.length - 1;
        int index = Partition(nums, left, right);

        //中位数的概念嘛？
        while (index != mid){
            if (index > mid)
                index = Partition(nums,left,index - 1);
            else
                index = Partition(nums,index + 1,right);

        }

        int result = nums[index];
        if (!chek(nums, result))
            return 0;
        return result;
    }
    public static boolean chek(int[] nums, int result){

        int times = 0;
        for (int i = 0; i < nums.length;i++){
            if (nums[i] == result)
                times++;
        }
        if (times > nums.length/2)
            return true;
        else
            return false;
    }
    //快排的思想
    public static int Partition(int[] nums, int left, int right){
        int temp = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && nums[j] >= temp)
                j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= temp)
                i++;
            nums[j] = nums[i];
        }
        nums[i] = temp;
        return i;
    }
}
