

//**************************************************************************
//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//**************************************************************************


//双指针问题
public class RemoveDuplit {

    public static void main(String[] args){

        int[] A = new int[]{1,1,1,1,1,1};

        int a = removeDuplicates(A);
        System.out.println(a);
    }

    static int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int p1 = 0;     //两个指针的指向
        int p2 = 1;

        //第二个指针一直加
        while (p2 < nums.length){
            if (nums[p2] != nums[p1]){
                nums[p1 + 1] = nums[p2];    //当第二个指针和第一个指针不相等的时候，第一个指针进行变化
                p1++;
            }
            p2++;
        }

        return p1 + 1;


    }

}
