

//并查集的实现



public class UnionSet {
    //使用数组存储每一个英雄的上级领导
    private int[] s;
    private int[] rank;
    //我们用一个数组rank[]记录每个根节点对应的树的深度（如果不是根节点，其rank相当于以它作为根节点的子树的深度）。
    // 一开始，把所有元素的rank（秩）设为1。
    //记录江湖中英雄的数量


    public UnionSet(int numElements){
        //构造函数，负责初始化并查集
        s = new int[numElements];
        rank = new int[numElements];
        // 一开始每个人都自成一派
        for (int i = 0; i < s.length;i++){
            //每个江湖人的上级都是自己
            s[i] = i;
            rank[i] = 1;
        }

    }

    public void unionByHeight(int i, int j){
        //联合操作
        int root1 = find(i);    //先找到两个元素的根节点
        int root2 = find(j);
        if (rank[root1] <= rank[root2])
            s[root1] = root2;
        else
            s[root2] = root1;
        if (rank[root1] == rank[root2] && root1!=root2)
            rank[root2]++;
    }

    public int find(int x){
        //查找
        if (s[x] == x)
            return x;       //返回门派的根
        else{
            s[x] = find(s[x]);  //父节点设为根节点
            return s[x];        //使用路径压缩
        }
    }
}
