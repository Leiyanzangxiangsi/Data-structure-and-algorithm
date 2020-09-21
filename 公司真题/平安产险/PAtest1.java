import java.util.*;


public class PAtest1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        double m = getm(a,b,c);
        System.out.printf("%.2f", m);

    }

    public static double getm(int a ,int b, int c){

        double m = 0;

        double fenzi = Math.max(a+b,Math.max(b,c));
        double fenmu = Math.max(c+b,Math.max(a,c)) + Math.max(c+b,Math.max(a,b));

        if (fenmu == 0)
            System.out.println("分母为零");
        else
            m = fenzi/fenmu;

        return m;
    }
}
