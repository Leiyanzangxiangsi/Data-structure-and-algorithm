


//**************************************************************************
// 构造一个平衡二叉树
// 通过各种方法去遍历
// 获得深度，检查是否是平衡二叉树等
//**************************************************************************


import java.util.*;

public class BinaryTree {

    static class TreeNode{         //二叉树的结点类

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v){
            this.val = v;
        }
    }

    public static void main(String[] args) {

        TreeNode root = BuiltTree();
        //System.out.println(maxDepth(root));
        //System.out.println(isSymmetric(root));
        System.out.println(isBalanced(root));

        /*preorderTraversal(root);
        System.out.println('\n');
        preorderTraversalI(root);

        System.out.println('\n');
        inorderTraversal(root);
        System.out.println('\n');
        inorderTraversalI(root);

        System.out.println('\n');
        PostTraversal(root);
        System.out.println('\n');
        PostTraversalI(root);*/
    }

    static TreeNode BuiltTree(){       //简单的构造了一刻二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right =  new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.right =  new TreeNode(5);
        root.right.left =  new TreeNode(5);
        root.right.right =  new TreeNode(4);

        return root;
    }

    static void preorderTraversal(TreeNode root){   //二叉树的前序遍历,先根结点，后左节点，再右结点

        if (root != null){
            System.out.print(root.val );
            System.out.print(' ');
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    static void inorderTraversal(TreeNode root){            //二叉树的中序遍历，左中右
        if (root != null){

            inorderTraversal(root.left);
            System.out.print(root.val );
            System.out.print(' ');
            inorderTraversal(root.right);

        }
    }

    static void PostTraversal(TreeNode root){            //二叉树的后续序遍历，左右中
        if (root != null){
            PostTraversal(root.left);
            PostTraversal(root.right);
            System.out.print(root.val );
            System.out.print(' ');
        }

    }

    // 求二叉树的最大高度：二叉树的最大高度等于左子树和右子树的较大高度+1.
    static int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return Math.max(leftdepth,rightdepth) + 1;
    }

    //判断一根树是不是平衡二叉树,左右结点的最大深度只差不能超过2
    static boolean isBalanced(TreeNode root){
        if (root == null)
            return true;

        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }



    //判断二叉树是不是对称二叉树，主要就是看左子树和右子树是否相等，用双指针法
    static boolean isSymmetric(TreeNode root){
        if (root == null)
            return false;

        return check1(root, root);
    }

    static boolean check (TreeNode left, TreeNode right){

        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    //还有一种迭代方法，用队列，每次入队两个，出队两个
    static boolean check1 (TreeNode left, TreeNode right){

        Queue<TreeNode> q = new LinkedList<>();     //队列
        q.add(left);
        q.add(right);

        while (!q.isEmpty()){
            left = q.poll();
            right = q.poll();

            if (left == null && right == null)
                continue;
            if (left == null || right == null || left.val != right.val)
                return false;

            q.add(left.left);
            q.add(right.right);

            q.add(left.right);
            q.add(right.left);
        }

        return true;
    }

    //通过迭代的方法中序遍历
    static void preorderTraversalI(TreeNode root){
        //先考虑极端情况
        //如果是迭代，就需要用到栈
        if (root == null)
            System.out.print("空树");


        Stack<TreeNode> st = new Stack<>();     //构造一个栈来保存数据,前序的话就是先保存右节点，再保持左节点，出栈顺序刚好相反
        st.push(root);             //根节点入栈

        while (!st.isEmpty()){
            TreeNode node = st.pop();       //栈顶元素出栈

            System.out.print(node.val);
            System.out.print(' ');

            if (node.right != null)     //先入右节点
                st.push(node.right);

            if (node.left != null)     //再入左节点
                st.push(node.left);
        }

    }

    //通过迭代的方法中序遍历
    static void inorderTraversalI(TreeNode root){
        //如果是迭代，就需要用到栈
        if (root == null)
            System.out.print("空树");

        Stack<TreeNode> st = new Stack<>();     //构造一个栈来保存数据

        TreeNode curr = root;       //这是一个尾指针,指向最左边的结点
        while (curr != null || !st.isEmpty()){          //满足一项就好了

            //将左节点全部入栈
            while (curr != null){
                st.push(curr);
                curr = curr.left;
            }

            TreeNode temp = st.pop();       //将左结点全部入栈后，开始出栈
            System.out.print(temp.val);
            System.out.print(' ');
            curr = temp.right;          //左节点为空以后，尾指针开始指向右节点
        }
    }

    //二叉树的后续序遍历，左右中迭代
    static void PostTraversalI(TreeNode root){
        //先考虑极端情况
        //如果是迭代，就需要用到栈
        if (root == null)
            System.out.print("空树");


        Stack<TreeNode> st = new Stack<>();     //构造一个栈来保存数据,前序的话就是先保存右节点，再保持左节点，出栈顺序刚好相反
        st.push(root);             //根节点入栈

        while (!st.isEmpty()){
            TreeNode node = st.pop();       //栈顶元素出栈

            System.out.print(node.val);
            System.out.print(' ');

            if (node.left != null)     //先入右节点
                st.push(node.left);

            if (node.right != null)     //再入左节点
                st.push(node.right);
        }

    }
}
