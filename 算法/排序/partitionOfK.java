



public class partitionOfK {

    public static void main(String[] args) {

        int[] numbers = new int[]{9, 3, 6, 4, 8, 7, 0, 2, 1, 4};

        //归并排序

        System.out.println(partitionOfK(numbers, 0, numbers.length - 1, 5));

    }

    public static int partitionOfK(int[] numbers, int start, int end, int k){

        if(k < 0 || numbers.length == 0|| start < 0 || end >= numbers.length || k > end)
            return 0;

        int key = numbers[start];
        int low = start;
        int high = end;
        while (low < high){
            while (low < high && numbers[high] >= key)
                high--;
            numbers[low] = numbers[high];
            while (low < high && numbers[low] <= key)
                low++;
            numbers[high] = numbers[low];
        }

        numbers[low] = key;
        if (low < k)
            return partitionOfK(numbers, start + 1, end, k);
        else if (low > k)
            return partitionOfK(numbers, start, end - 1, k);
        else
            return numbers[low];
        }
}

