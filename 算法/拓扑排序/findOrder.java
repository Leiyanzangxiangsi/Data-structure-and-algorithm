

//**************************************************************************
//现在你总共有 n 门课需要选，记为 0 到 n-1。
//在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
//给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
//可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

//**************************************************************************

import java.util.*;

public class findOrder {

    public static void main(String[] args) {

        int numCourses;     //课程数量
        int[][] prerequisites; //依赖关系

        //findOrder(numCourses, prerequisites);

    }

    static int[] findOrder(int numCourses, int[][] prerequisites) {

        //第一步：拓扑排序，将有向图构造成拓扑序列

        //首先创建节点个数,多少门课程就有多少个节点
        node[] numNode = new node[numCourses];

        //创建入度,每一个节点入度为0(每一门课程入度为0)
        int[] rudu = new int[numCourses];

        for (int i = 0; i<numCourses; i++)
            numNode[i] = new node(i);   //初始化结点


        //遍历每一个边长
        for (int[] x : prerequisites){
            //访问这条边的每一个节点，将节点的下一个指向和节点入度统计
            for (int j = 1; j < x.length; j++){
                //首先更新入度
                rudu[x[j - 1]]++;

                //获取该节点的指向数据，并更新
                ArrayList<Integer> zhongjie = numNode[x[j]].next;
                zhongjie.add(x[j-1]);

                //将节点指向加入
                numNode[x[j]].setNext(zhongjie);
            }
        }

        //接下来就是广度优先遍历,用到队列
        Queue<node> q = new LinkedList<>();
        //将入度为0的节点入队
        for (int i = 0; i<numCourses; i++){
            if (rudu[i] == 0)
                q.add(numNode[i]);
        }

        int ans2 = 0;    //计数，出队次数
        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            node jie = q.poll();    //结点出队
            ans2++;                  //进行统计
            ans.add(jie.value);

            //这是一个列表，里面
            ArrayList<Integer> zhixiang = jie.next;
            for (int k = 0; k < zhixiang.size(); k++){
                rudu[zhixiang.get(k)]--;    //入度减1

                if (rudu[zhixiang.get(k)] == 0)     //将入度为0的结点入队
                    q.add(numNode[zhixiang.get(k)]);
            }

        }

        if (ans2 == numCourses){
            int[] ans1 = new int[ans.size()];
            for (int a = 0; a < ans.size(); a++)
                ans1[a] = ans.get(a);
            return ans1;
        }
        else
            return new int[0];


    }

    static class node{      //节点类
        private int value;  //节点值
        private ArrayList<Integer> next;    //节点指向

        public node(int v){                 //构造函数
            this.value = v;
            this.next = new ArrayList<>();   //列表要初始化为空
        }

        public void setNext(ArrayList<Integer> n){
            this.next = n;
        }
    }
}
