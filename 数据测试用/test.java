
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for (int i=0;i<n;i++)
//            nums[i] = in.nextInt();

        int[] nums = {1, 2, 3, 4, 5, 6};

        List<Integer> l = new ArrayList<>();
        for (int a : nums)
            l.add(a);

        l.remove(3);
        System.out.println(l.toString());

        for (int i = 0; i < l.size(); i = i + 2)
            l.remove(i);
        System.out.println(l.toString());
    }

}