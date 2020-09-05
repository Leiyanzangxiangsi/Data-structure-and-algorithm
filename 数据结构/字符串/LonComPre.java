

//**************************************************************************
//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
//**************************************************************************


import javax.jws.soap.SOAPMessageHandlers;

public class LonComPre {

    public static void main(String[] args) {

        String[] Ss = new String[]{"flower","flow","flight"};

        System.out.println(longestCommonPrefix(Ss));


    }

    static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        String ans;

        ans = strs[0]; //返回的结果，后面的字符串都和这个比


        for (int i = 1; i < strs.length; i++){
            int j = 0;
            for (; j < strs[i].length(); j++){
                if (strs[i].charAt(j) != ans.charAt(j))
                    break; //如果不相等直接条过这次循环
            }

            ans = ans.substring(0, j);
        }
        return ans;
    }
}