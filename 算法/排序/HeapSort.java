

//**************************************************************************
// 将一个数组进行堆排序
//**************************************************************************

//1、堆的根结点大于左右结点
//2、对于大顶堆，arr[i] >= arr[2*i + 1] && arr[i] >= arr[2*i + 1];
//3、堆的第一个非叶子结点为leng/2 — 1;


public class HeapSort {


    public static void main(String[] args) {

        int[] nums = new int[]{9, 3, 6, 4, 8, 7, 0, 2, 1, 4};

        for (int a : HeapSort(nums))
            System.out.print(a);

    }

    static int[] HeapSort(int[] nums) {

        //创建一个数组来返回
        int[] ans = new int[nums.length];
        //首先根据数组构建大顶堆
        int len = nums.length;

        MaxHeap(nums, len);     //首先构造最大堆

//        for (int i = 0; i < len; i++){
//            swap(nums,0, len - i - 1);      //将根节点和最后一个结点交换
//            ans[i] = nums[len - i - 1];
//            MaxHeap(nums, len - i - 1);
//        }

        return nums;


    }

    static void MaxHeap(int[] nums, int len){        //根据数组构建大顶堆

        for (int feiyezi = (int) Math.floor(len/2) - 1; feiyezi >= 0; feiyezi--){       //从第一个非叶子结点开始构造
                gouzhao(nums, feiyezi, len);
        }

    }

    static void gouzhao(int[] nums, int jiedian, int len){
        int left = 2*jiedian + 1;   //左结点
        int right = 2*jiedian + 2;

        int largest = jiedian;   //最大值指针首先指向非叶子结点

        if (left < len && nums[left] > nums[largest])       //将大的结点前移
            largest = left;

        if (right < len && nums[right] > nums[largest])
            largest = right;


        if (largest != jiedian){
            swap(nums, jiedian, largest);           //如果进行的交换，那么就要将叶子节点在构造
            gouzhao(nums, largest, len);            //交换的结点再去构造

        }

    }

    static void swap(int[] nums, int i, int j){     //将数组内的两个元素调换位置
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}