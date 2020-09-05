

//**************************************************************************
// 将一个数组进行希尔排序
//**************************************************************************


public class ShellSort {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 3, 6, 4, 8, 7, 0, 2, 1, 4};
        ShellSort(nums);
        for (int a : nums)
            System.out.println(a);

    }

    static void ShellSort(int[] nums){


        int n = nums.length;
        // int d = n / 2;                  //先确定增量
        int d = 1;
        while (d < n)
            d = 3*d + 1;

        while (d > 0){     //当增量大于1的时候，就一直进行插入排序

            for (int i = d; i < n; i++){   //对后面每一组进行排序，相当于分组

                int temp = nums[i];
                int j = i - d;                  //指向后面的元素

                while (j >= 0 && temp <= nums[j]){
                    nums[j + d] = nums[j];
                    j = j - d;
                }

                nums[j + d] = temp;
            }

            d = (int)Math.floor(d/3);
        }



/*
        while (d >= 1){     //当增量大于1的时候，就一直进行插入排序

            for (int i = d; i < n; i++){   //对后面每一组进行排序，相当于分组

                int temp = nums[i];
                int j = i - d;                  //指向后面的元素

                while (j >= 0 && temp <= nums[j]){
                    nums[j + d] = nums[j];
                    j = j - d;
                }

                nums[j + d] = temp;
            }

            d = d / 2;
        }
 */



    }

}
/*
希尔排序的思想：
1.把序列按一定间隔分组，对每组都使用插入排序
2.随着间隔减小，一直到1，使这个序列有序
3.d也叫增量，一是对半取，二是初始为1,然后 3*h + 1循环;
 */