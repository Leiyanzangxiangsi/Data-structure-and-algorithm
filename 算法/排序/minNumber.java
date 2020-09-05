

//**************************************************************************
// 将一个数组的最小组合
//**************************************************************************




public class minNumber {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 3, 6, 4, 8, 7, 0, 2, 1, 4};

        System.out.println(minNumber(nums));

    }

    static String minNumber(int[] nums) {

        //
        String ans = "";

        String[] snum = new String[nums.length];

        //首先要把数组里的数字转换为字符串
        for (int i = 0; i < nums.length; i++)
            snum[i] = Integer.toString(nums[i]);


        QuickSort(snum, 0, snum.length - 1);

        for (int i = 0; i < snum.length; i++)
            ans = ans + snum[i];

        return ans;
    }

    static void QuickSort(String[] snum, int left, int right){

        if (left < right){

            int Index = GetIndex(snum, left ,right);
            QuickSort(snum, left, Index - 1);
            QuickSort(snum, Index + 1, right);
        }


    }

    static int GetIndex(String[] snum, int left, int right){

        int i = left;
        int j = right;

        String temp = snum[left];       //将第一个值作为基准值

        while (i < j){

            while (i < j && (snum[j] + temp).compareTo(temp + snum[j]) >= 0)    //把大于基准值的值放右边
                j--;

            snum[i] = snum[j];

            while(i < j && (snum[i] + temp).compareTo(temp + snum[i]) <= 0)     //把小于基准值放左边
                i++;

            snum[j] = snum[i];
        }

        snum[i] = temp;

        return i;
    }

}
