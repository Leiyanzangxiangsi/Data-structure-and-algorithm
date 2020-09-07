




//图的构造以及遍历
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author linziyu
 *基于构造好的矩阵进行图结构的建立
 */
//无向图的构造
public class ZXtest2 {
//    //显然是无向图的构造
//    public static void LGraph(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int numV = s.nextInt();
//        int numE = s.nextInt();
//        int cishu = s.nextInt();
//
//        LGraph g = new LGraph(numV);
//        for (int i = 0; i < numE; i++) {    //通过读取输入创建各边，插入图中
//            LGraph.Edge e = new LGraph.Edge(s.nextInt() - 1, s.nextInt() - 1, s.nextInt());
//            g.insertEdge(e);
//        }
//
//
//        for (int i = 0; i < cishu; i++){
//            int start = s.nextInt() - 1;
//            int end = s.nextInt() - 1;
//
//            g.DIJKSTRA(start);
//
//            if (g.distance[end] == 10000)
//                System.out.println(-1);
//            else
//                System.out.println(g.distance[end]);
//        }
//    }
}

//class LGraph{
//    // 图的边
//    static class Edge {
//        int v1;     //边的第一个结点
//        int v2;     //边的第二个结点
//        int weight; //权重
//        Edge next;  //与v1连接的下一条边
//
//        /* Constructor */
//        public Edge(int v1, int v2, int weight) {
//            this.v1 = v1;
//            this.v2 = v2;
//            this.weight = weight;
//            next = null;    //它指向的下一条边初始化为空。
//        }
//    }
//
//    // 头结点类，也就是有多少个结点，就有多少个头
//    static class Head {
//        //int data; //顶点存储的数据。也可以是其他数据类型。（可选）
//        Edge next;  //指向的下一个边
//
//        /* Constructor */
//        public Head() {
//            next = null;
//        }
//    }
//
//    int numV;           //图的结点个数
//    int numE;           //图的边个数
//    Head[] graph;       //图的头结点数组，看看有多少个头结点，每一个头结点都是一个链表
//    boolean[] visited;  //图的结点是否被访问
//
//    /* Constructor */
//    public LGraph(int numV) {    //图的构造
//        this.numV = numV;
//
//        numE = 0;                   //边数
//        graph = new Head[numV];     //头结点数组初始化
//        visited = new boolean[numV];
//        distance = new int[numV];	//存放v.d
//        prenode = new int[numV];	//存放前驱节点
//
//        for (int v = 0; v < numV; v++) {
//            graph[v] = new Head();    //初始化各个顶点
//            visited[v] = false;        //每个顶点都初始化为未访问
//        }
//    }
//
//    //最重要的就是插入过程了，怎么把边插入到各个链表里面
//    public void insertEdge(Edge edge) {
//
//        //edge.v1相当于一个索引，如果不是数字，可以用一个哈希表存储
//        //v1连接的边的下一个边不为空
//        if (graph[edge.v1].next != null) {
//            edge.next = graph[edge.v1].next;
//        }
//        graph[edge.v1].next = edge;    //将新边插在v1顶点的头结点后
//
////        /* 如果是无向图，反向也要插入*/
////        Edge edge2 = new Edge(edge.v2, edge.v1, edge.weight);//创建一个和新边一样的边实例
////
////        if (graph[edge.v1].next != null) {
////            edge2.next = graph[edge2.v1].next;
////        }
////        graph[edge2.v1].next = edge2;
//
//        numE++;
//    }
//
//
//    //    LinkedList<Edge>[] edgeLinks;
////    private int numV;	//顶点数
////    private int edgeNum;	//边数
//    int[] distance;	//存放v.d
//    int[] prenode;	//存放前驱节点
//
//    LinkedList<Integer> S;	//已经求到最短路径的顶点集合
//    LinkedList<Integer> Q;	//尚未求到最短路径的顶点集合
//    public static final int INF = 10000;	//无穷大
//    public static final int NIL = -1;	//表示不存在
//
//
//    /**
//     * 对最短路径估计和前驱节点进行初始化
//     *
//     * @param start
//     */
//    public void INITIALIZE_SINGLE_SOURCE(int start) {
//        for (int i = 0; i < numV; i++) {
//            distance[i] = INF;
//            prenode[i] = NIL;
//        }
//        distance[start] = 0;
//    }
//
//    /**
//     * 松弛
//     *
//     * @param edge
//     */
//    public void RELAX(Edge edge) {
//        int v1 = edge.v1;
//        int v2 = edge.v2;
//        int w = edge.weight;
//        if (distance[v2] > distance[v1] + w) {
//            distance[v2] = distance[v1] + w;
//            prenode[v2] = v1;
//        }
//    }
//
//    /**
//     * Dijkstra算法实现
//     *
//     * @param start
//     */
//    public void DIJKSTRA(int start) {
//
//        INITIALIZE_SINGLE_SOURCE(start);
//
//        S = new LinkedList<>();
//        Q = new LinkedList<>();
//        for (int i = 0; i < numV; i++) {
//            Q.add(i);
//        }
//
//        while (!Q.isEmpty()) {
//            int u = EXTRACT_MIN(Q);
//            S.add(u);
//            LinkedList<Edge> list = getEdge(u);
//            while (!list.isEmpty()) {
//                Edge edge = list.pop();
//                RELAX(edge);
//            }
//        }
//
//    }
//
//    public LinkedList<Edge> getEdge(int start){
//        LinkedList<Edge> ans = new LinkedList<>();
//        for (Edge e = graph[start].next; e != null; e = e.next)
//            ans.add(e);
//
//        return ans;
//    }
//
//    public int EXTRACT_MIN(LinkedList<Integer> q) {
//
//        if (q.isEmpty())
//            return -1;
//        int min = q.getFirst();
//        for (int i = 0; i < q.size(); i++) {
//            int v = q.get(i);
//            if (distance[min] > distance[v]) {
//                min = v;
//            }
//        }
////        int min2 = min;
//        q.remove(q.indexOf(min));
//        return min;
//    }
//}
//下午，在弄一下，字符串的，看看行不行