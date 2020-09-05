import java.util.Scanner;

public class GLDtest1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        int sum = 0;
        for (int i = 0; i < s1.length();i++){
            if (s1.charAt(i) == s2.charAt(i))
                sum += 20;
            else if (sum != 0)
                    sum -= 10;
        }

        System.out.println(sum);
    }
}
