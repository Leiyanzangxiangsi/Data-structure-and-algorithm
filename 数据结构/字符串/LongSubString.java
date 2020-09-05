

//**************************************************************************
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//**************************************************************************

import java.util.Collections;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

//同样是双指针问题
public class LongSubString {

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }


    //求一个字符串中最小子串
    static int lengthOfLongestSubstring(String s) {

        int ans = 0;    //  答案，长度

        //创建一个集合来保持子串
        Set<Character> SubStr = new HashSet<>();
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        int p1 = 0;
        int p2 = 1;

        SubStr.add(s.charAt(0));    //把第一个字母添加进去

        while(p2 < s.length()){
            if (!SubStr.contains(s.charAt(p2))){    //尾指针指向的字母不在子串中
                SubStr.add(s.charAt(p2));
                p2++;
            }
            else {
                SubStr.remove(s.charAt(p1));
                p1++;
            }

            ans = Math.max(ans, SubStr.size()); // 每一轮下来都要子串的长度
        }

        return ans;
    }
}