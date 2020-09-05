



//**************************************************************************
// 判断两个矩阵是否相交
//**************************************************************************

public class Overlap {

    public static void main(String[] args) {

        Rect rc1 = new Rect(0,0,10,10);
        Rect rc2 = new Rect(11,11,2,2);
        if (isOverlap(rc1, rc2))
            System.out.println("矩阵相交");
        else
            System.out.println("矩阵不相交");

    }

    /*
     * @brief 判断两个轴对齐的矩形是否重叠
     * @param rc1 第一个矩阵的位置
     * @param rc2 第二个矩阵的位置
     * @return 两个矩阵是否重叠（边沿重叠，也认为是重叠）
     */
    public static boolean isOverlap(Rect rc1, Rect rc2) {

        //
        if (rc1.x + rc1.width  > rc2.x &&
                rc2.x + rc2.width  > rc1.x &&

                rc1.y + rc1.height > rc2.y &&
                rc2.y + rc2.height > rc1.y)
            return true;
        else
            return false;
    }

    // 矩阵类
    static class Rect{
        int x;          //矩形左上角x坐标
        int y;          //矩形左上角y坐标
        int width;      //矩形宽度
        int height;     //矩形高度

        Rect(int x, int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height= height;
        }
    }
}


