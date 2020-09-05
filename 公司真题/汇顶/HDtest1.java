import java.util.Scanner;


public class HDtest1{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int nums = in.nextInt();
        if (nums%2 == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");

    }
}
