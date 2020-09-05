



//**************************************************************************
//如何进行全排列
//**************************************************************************

public class Permutation {

    public static void main(String[] args) {

        char[] ss = new char[]{'+', '-', '*', '/'};
        permutation(ss,0);
    }

    public static void permutation(char[]ss,int i){

        if (ss == null || i < 0 || i > ss.length)
            return;

        if (i == ss.length)
            System.out.println(ss);

        else {
            for (int j = i; j < ss.length; j++){
                char temp = ss[j];  //这个是做选择
                ss[j] = ss[i];
                ss[i] = temp;
                permutation(ss, i + 1);
                temp = ss[j];       //这个是撤销选择
                ss[j] = ss[i];
                ss[i] = temp;
            }
        }
    }
}
