
//**************************************************************************
//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
//编写一个方法，将 B 合并入 A 并排序。初始化 A 和 B 的元素数量分别为 m 和 n。
//**************************************************************************


public class MergeNums {

    public static void main(String[] args){

        int[] A = new int[]{1,2,3,0,0,0};
        int[] B = new int[]{4,5,6};
        int m = 3;
        int n = 3;

        merge(A, m, B, n);
        for (int a : A)
            System.out.println(a);
    }

    static void merge(int[] A, int m, int[] B, int n) {
        while(m > 0 && n > 0){
            //既然A后面又空余，我们就比较AB，前面有数字的项，将较大的放到最后面
            A[m + n - 1] = A[m - 1] > B[n -1] ? A[m-- - 1] : B[n-- - 1];
        }

        while(n > 0){
            A[n - 1] = B[n - 1];
            n--;
        }
    }
}
