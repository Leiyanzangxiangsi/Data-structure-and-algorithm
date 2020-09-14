

//并查集的实现



public class UnionSet {

    private int[] fa;
    private int[] rank;
    //我们用一个数组rank[]记录每个根节点对应的树的深度（如果不是根节点，其rank相当于以它作为根节点的子树的深度）。
    // 一开始，把所有元素的rank（秩）设为1。


    public UnionSet(int numElements){
        //构造函数，负责初始化并查集
        fa = new int[numElements];
        rank = new int[numElements];
        // 一开始每个人都自成一派
        for (int i = 0; i < fa.length;i++){
            //每个江湖人的上级都是自己
            fa[i] = i;
            rank[i] = 1;
        }

    }

    public void unionByHeight(int i, int j){
        //联合操作
        int root1 = find(i);    //先找到两个元素的根节点
        int root2 = find(j);
        if (rank[root1] <= rank[root2])
            fa[root1] = root2;
        else
            fa[root2] = root1;
        if (rank[root1] == rank[root2] && root1!=root2)
            rank[root2]++;
    }

    public int find(int x){
        //查找
        if (fa[x] == x)
            return x;       //返回门派的根
        else{
            fa[x] = find(fa[x]);  //父节点设为根节点
            return fa[x];        //使用路径压缩
        }
    }
}
