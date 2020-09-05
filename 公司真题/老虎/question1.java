import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class question1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        //System.out.println(s);
        s = s.substring(1,s.length() - 1);
        //System.out.println(s);
        System.out.println(frequencySort(s));
    }

    /**
     * 按频率高低打印
     *
     * @param s string字符串 输入字符
     * @return string字符串
     */
    // 以空间换时间
    public static String frequencySort(String s) {
        // write code here
        //
        HashMap<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counts.put(s.substring(i, i+1), counts.getOrDefault(s.substring(i, i+1), 0) + 1);   //各个字母已经统计
        }


        String[] ans = new String[counts.size()];       //用来存储字符串

        Set<String> keys = counts.keySet();
        int i = 0;
        for (String c : keys){
            String s1 = c;
            for (int j = 0; j < counts.get(c) - 1;j++){
                s1 = s1 + c;
            }
            ans[i] = s1;
            i++;
        }

        quicksort(ans, 0, ans.length - 1);

        String ans0 = ans[0];
        for (int j = 1; j < ans.length;j++)
            ans0 = ans0 + ans[j];

        return "\"" + ans0 + "\"";
    }

    public static void quicksort(String[] ans, int left, int right){

        if (left < right){
            int index = getindex(ans, left, right);
            quicksort(ans,left,index-1);
            quicksort(ans,index+1,right);
        }
    }

    public static int getindex(String[] ans, int left, int right){

        String temp = ans[left];
        int i = left;
        int j = right;

        while (i < j){
            while (i < j && ans[j].length() <= temp.length())
                j--;
            ans[i] = ans[j];

            while (i < j && ans[i].length() >= temp.length())
                i++;
            ans[j] = ans[i];
        }
        ans[i] = temp;
        return i;
    }
}