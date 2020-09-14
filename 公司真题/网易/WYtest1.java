

import java.util.*;

public class WYtest1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> nums0 = new ArrayList<>();
        while (in.hasNextInt())
            nums0.add(in.nextInt());

        int[] nums = new int[nums0.size()];
        int i=0;
        for(int a:nums0)
            nums[i++] = a;

        System.out.println(getmax(nums));

    }

    public static int getmax(int[] nums){

        int temp = 0;
        int max = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] == 0){
                temp++;
            }
            else {
                if (temp>max){
                    max = temp;
                    temp = 0;
                }
            }
        }
        if (max%2==0)
            max = max/2;
        else
            max = (max+1)/2;

        return max;
    }

}
