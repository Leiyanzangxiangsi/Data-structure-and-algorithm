


//**************************************************************************
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//**************************************************************************

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

// 层访问，广度优先遍历
public class levelOrder {

    public static void main(String[] args) {

        int numCourses;     //课程数量
        int[][] prerequisites; //依赖关系

        //canFinish(numCourses, prerequisites);
    }

    static List<List<Integer>> levelOrder(TreeNode root) {

        //大部分情况要考虑为空的情况
        if (root == null)
            return new ArrayList<>();


        //创建一个二维列表
        List<List<Integer>> ans = new ArrayList<>();
        //广度优先遍历，用到队列
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);        //根节点首先入队

        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();     //列表储存值
            //这里我们还要根据队列的大小去进行输出
            int n = q.size();
            for (int i = 0; i < n; i++){
                TreeNode node = q.poll();        //队列第一个节点出队
                l.add(node.val);                //每一个结点的值都存到列表
                //有节点就加入
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            ans.add(l);
        }

        return ans;

    }
    static class TreeNode {     //节点类
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
