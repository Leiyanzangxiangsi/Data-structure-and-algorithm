

//**************************************************************************
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//**************************************************************************


import java.util.*;
//求两数之和， 这个是典型的哈希查找的问题
public class TwoNumSum {
    public static void main(String[] args){

        //Scanner in = new Scanner(System.in);
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        for (int i : twoSum(nums, target))
            System.out.println(i);

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];

        //用哈希表
        HashMap<Integer, Integer> Cha = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (Cha.containsKey(nums[i])){
                ans[0] = Cha.get(nums[i]);
                ans[1] = i;
                return ans;
            }
            else
                Cha.put(target - nums[i], i);   //将差值和索引加入哈希表
        }
        return null;

    }
}
