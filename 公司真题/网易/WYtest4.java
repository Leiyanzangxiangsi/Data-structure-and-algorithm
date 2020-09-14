



import java.util.*;

public class WYtest4 {

    static int[] fa;
    static int[] rank;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String A = in.nextLine();
        String B = in.nextLine();

        int[] numsA = new int[(A.length()+1)/2];
        int[] numsB = new int[(B.length()+1)/2];

        int n = numsA.length+numsB.length;   //订单,多少个呢？

        int m = in.nextInt();   //m个关系
        int[][] guanxi = new int[m][2];

        fa = new int[n + 1];        //根结点
        rank = new int[n + 1];      //树深

        for (int i = 0;i<=n;i++){
            fa[i] = i;
            rank[i] = 1;
        }

        for (int i = 0;i < m;i++){
            guanxi[i][0] = in.nextInt();
            guanxi[i][1] = in.nextInt();
        }

        for (int i = 0;i < m;i++)
            merge(guanxi[i][0], guanxi[i][1]);  //将两个订单的关系联合起来

        System.out.println(Arrays.toString(fa));
        HashSet<Integer> h = new HashSet<>();   //并查森林树有多少颗

        for (int i =1;i <= n;i++)
            h.add(find(i));

        System.out.println(h.size());
    }

    public static void merge(int i, int j){
        int root1 = find(i);
        int root2 = find(j);


        if (rank[root1] <= rank[root2])
            fa[root1] = root2;
        else
            fa[root2] = root1;

        if (rank[root1] == rank[root2] && root1 != root2)
            rank[root2]++;
    }

    public static int find(int x){
        if (x == fa[x])
            return x;
        else {
            fa[x] = find(fa[x]);    //路径压缩
            return fa[x];
        }
    }


}
