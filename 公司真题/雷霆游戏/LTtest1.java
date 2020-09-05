
import java.util.Scanner;

public class LTtest1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        char c1;
        char c2;
        int i = 0;
        while (s.charAt(i) != ' ')
            i++;

        String targets = s.substring(0, i);
        c1 = s.charAt(i+1);
        c2 = s.charAt(i+3);


        System.out.println(GetMax(targets, c1, c2));
    }

    public static int GetMax(String targets, char c1, char c2){

        int juli = 'a' - 'A';
        int p1 = 0;
        int p2 = targets.length() - 1;


        while (p1 < targets.length() && !(targets.charAt(p1) == c1 || targets.charAt(p1) == c1+juli || targets.charAt(p1) == c1-juli))
            p1++;

        if (p1 == targets.length())
            return -1;

        while (p2 >= 0 && !(targets.charAt(p2) == c2 || targets.charAt(p2) == c2+juli || targets.charAt(p2) == c2-juli))
            p2--;

        if (p2 < 0)
            return -1;

        int max = Math.abs(p1 - p2);

        p1 = 0;
        p2 = targets.length() - 1;
        while (p1 < targets.length() && !(targets.charAt(p1) == c2 || targets.charAt(p1) == c2+juli || targets.charAt(p1) == c2-juli))
            p1++;

        while (p2 > 0 && !(targets.charAt(p2) == c1 || targets.charAt(p2) == c1+juli || targets.charAt(p2) == c1-juli))
            p2--;


        if (Math.abs(p1 - p2) > max)
            max = Math.abs(p1 - p2);

        return max;
    }
}


