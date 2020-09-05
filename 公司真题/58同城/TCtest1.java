
import java.util.*;

public class TCtest1 {
    /**
     *
     * @param values string字符串ArrayList<ArrayList<>>
     * @return string字符串ArrayList
     */
    public ArrayList<String> findCommonString (ArrayList<ArrayList<String>> values) {
        // write code here

        int len = values.size();    //有多少个列表
        ArrayList<String> ans = new ArrayList<>();
        int j = 0;
        for(ArrayList<String> AS : values){
            for (String s : AS){
                j++;
            }
            break;
        }

        String[] S0 = new String[j];
        j = 0;
        for(ArrayList<String> AS : values){
            for (String s : AS){
                S0[j] = s;
                j++;

            }
            break;
        }

        for (String s0 : S0){
            int i = 0;
            for (ArrayList<String> AS : values){
                if (AS.contains(s0))
                    i++;
                else
                    break;
            }
            if (i == len)
                ans.add(s0);
        }

        return ans;
    }
}
