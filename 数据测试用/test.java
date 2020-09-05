import java.util.*;

import java.util.Scanner;
public class test {


    public static void main(String[] args) {
        System.out.println(val());
    }

    public static int val() {

        int num = 5;
        try {
            num = num / 0;
        } catch (Exception e) {
            num = 10;
        } finally {
            num = 15;
        }
        return num;
    }
}
