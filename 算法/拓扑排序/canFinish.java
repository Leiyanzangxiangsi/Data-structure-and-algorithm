

//**************************************************************************
//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
//在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
//**************************************************************************

//课程表问题，拓扑排序+广度优先遍历

import java.util.*;

public class canFinish {

    static List<List<Integer>> edges;  //一个有向图
    static int[] indeg;

    public static void main(String[] args) {

        int numCourses;     //课程数量
        int[][] prerequisites; //依赖关系

        //canFinish(numCourses, prerequisites);

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        edges = new ArrayList<List<Integer>>();     //一个图

        for (int i = 0; i < numCourses; ++i) {      //初始化图的每一个结点
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];            //入度

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);    //这个地方是关键，怎么把数字变成字符串形？
            ++indeg[info[0]];                   //
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);             //将入度为0的结点入队
            }
        }

        int visited = 0;                    //遍历的结点个数
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }

}




