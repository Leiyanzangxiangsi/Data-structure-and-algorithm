
public class MNsortmerge {

    static char[] track;    //路径

    public static void main(String[] args) {
        int n = 5;      //总个数
        char[] c = {'a', 'c', 'd', 'e', 'j'};   //实际数组

//        int[] a= new int[5];
//        for (int i=0;i<n;i++)
//            a[i]

        int m = 3;              //路径最多允许多少个结点
        track = new char[m];    //创建路径
        sortmerge(n, m, c);
    }

    static void sortmerge(int n, int m, char[] c) {
        int i, k;
        for (i = m; i <= n; i++) {
            track[m - 1] = c[i - 1];        //进行选择
            if (m > 1)
                sortmerge(i - 1, m - 1, c); //继续组合
            else {
                for (k = 0; k < track.length; k++)
                    System.out.print(track[k] + " ");
                System.out.println();
            }
        }
    }
}
