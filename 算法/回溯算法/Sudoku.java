

//**************************************************************************
// 数独问题
//**************************************************************************



public class Sudoku {

    static int len = 9;                         //数组长度
    static int[][] nums = new int[len][len];    //数组
    static boolean flag = false;

    public static void main(String[] args) {

        nums[1][2] = 3;
        nums[5][3] = 9;
        nums[8][8] = 1;
        nums[4][4] = 4;
        suduku(0);


    }

    public static void suduku(int count){

        if (flag)
            return;

        if (count == len*len){  //只需要一个结果
            printa();
            flag = true;
        }

        int  i = count/9;   //列
        int  j  = count%9;   //行

        if(nums[i][j] == 0) {
            for(int n = 1; n <= 9; n++) {
                nums[i][j] =  n;    //将1到9依次填到数组每一行中
                if(!Isvaild(count))  //这个值不冲突
                    suduku(count+1);
            }
            nums[i][j] = 0;
        }
        else
            suduku(count+1);
    }

    public static boolean Isvaild(int count){

        int i = count/9;
        int j = count%9;

        //检测行
        for(int iter = 0; iter!=j; iter++) {
            if(nums[i][iter] == nums[i][j]) {
                return true;
            }
        }

        //检测列
        for(int iter = 0; iter!=i; iter++) {
            if(nums[iter][j]==nums[i][j]) {
                return true;
            }
        }

        //检测九宫
        for(int p = i/3*3; p < (i/3+1)*3; p++) {
            for(int q = j/3*3; q < (j/3+1)*3; q++) {
                if(p==i && j==q) {
                    continue;
                }
                if(nums[p][q]==nums[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printa(){
        System.out.println("数度的解集为:");
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
