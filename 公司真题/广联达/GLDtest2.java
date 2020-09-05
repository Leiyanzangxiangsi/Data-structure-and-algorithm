
import java.util.Arrays;
import java.util.Scanner;

public class GLDtest2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] nums = new int[4];
        for (int i = 0; i<4;i++)
            nums[i] = in.nextInt();

        //QuickSort(nums,0,nums.length-1);
        change(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void change(int[] nums){

        while (!(nums[0] == nums[1] && nums[0] == nums[2] && nums[0] == nums[3])){
            //QuickSort(nums,0,3);
            int sum = nums[0] + nums[1]+ nums[2]+ nums[3];
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            while (sum > 0){
                if (a < nums[0]){ if (sum>=1){a++;sum--;}}
                else{ if (sum>=2){a++;sum-=2;}}

                if (b < nums[1]){ if (sum>=1){b++;sum--;}}
                else{ if (sum>=2){b++;sum-=2;}}

                if (c < nums[2]){ if (sum>=1){c++;sum--;}}
                else{ if (sum>=2){c++;sum-=2;}}

                if (d < nums[3]){ if (sum>=1){d++;sum--;}}
                else{ if (sum>=2){d++;sum-=2;}}
            }
            nums[0] = a;
            nums[1] = b;
            nums[2] = c;
            nums[3] = d;
            //if (!(nums[0] == nums[1] && nums[0] == nums[2] && nums[0] == nums[3]))
        }
    }

}


