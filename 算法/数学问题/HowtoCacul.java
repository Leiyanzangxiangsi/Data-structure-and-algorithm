


//**************************************************************************
// 在括号里填上+-*/
// 在问号里填一个数，使得三个等式相等
//6()8()3()2()7=?
//7()3()5()4()2=?
//9()4()3()6()1=?
//**************************************************************************


import java.util.Stack;

public class HowtoCacul {

    //这是一个静态变量啊
    static String[] ssl = new String[24];  //所有的排列情况
    static int K = 0;

    //求全排列
    public static void permutation(char[]ss, int i){

        if (ss == null || i < 0 || i > ss.length)
            return;

        if (i == ss.length){
            //System.out.println(ss);
            ssl[K++] = new String(ss);
        }

        else {
            for (int j = i; j < ss.length; j++){
                char temp = ss[j];
                ss[j] = ss[i];
                ss[i] = temp;
                permutation(ss, i + 1);
                temp = ss[j];
                ss[j] = ss[i];
                ss[i] = temp;
            }
        }
    }

    public static void main(String[] args) {

        char[] fuhao = new char[]{'+', '-', '*', '/'};
        permutation(fuhao, 0);


        caculte1();

    }

    // 不可重复
    public static double caculte1() {

        char[] shizi1 = new char[]{'6', ' ', '8', ' ', '3', ' ', '2', ' ', '7'};
        char[] shizi2 = new char[]{'7', ' ', '3', ' ', '5', ' ', '4', ' ', '2'};
        char[] shizi3 = new char[]{'9', ' ', '4', ' ', '3', ' ', '6', ' ', '1'};


        for (int i = 0; i < 24; i++){


            String s1 = jiaru(shizi1, ssl[i].charAt(0), ssl[i].charAt(1), ssl[i].charAt(2), ssl[i].charAt(3));
            String s2 = jiaru(shizi2, ssl[i].charAt(0), ssl[i].charAt(1), ssl[i].charAt(2), ssl[i].charAt(3));
            String s3 = jiaru(shizi3, ssl[i].charAt(0), ssl[i].charAt(1), ssl[i].charAt(2), ssl[i].charAt(3));
            System.out.println(s1 + "=" + caculte(preExpre(s1)));
            System.out.println(s2 + "=" + caculte(preExpre(s2)));
            System.out.println(s3 + "=" + caculte(preExpre(s3)));

            System.out.println("==================");
        }


        return 0;
    }

    // 可重复
    public static double caculte(){

        char[] fuhao = new char[]{'+', '-', '*', '/'};
        char[] shizi1 = new char[]{'6', ' ', '8', ' ', '3', ' ', '2', ' ', '7'};
        char[] shizi2 = new char[]{'7', ' ', '3', ' ', '5', ' ', '4', ' ', '2'};
        char[] shizi3 = new char[]{'9', ' ', '4', ' ', '3', ' ', '6', ' ', '1'};

        int n = 4;
        for (int i = 0; i < n;i++){
            for (int j = 0; j < n;j++){
                for (int k = 0; k < n;k++){
                    for (int l = 0; l < n;l++){

                        String s1 = jiaru(shizi1, fuhao[i], fuhao[j], fuhao[k], fuhao[l]);
                        String s2 = jiaru(shizi2, fuhao[i], fuhao[j], fuhao[k], fuhao[l]);
                        String s3 = jiaru(shizi3, fuhao[i], fuhao[j], fuhao[k], fuhao[l]);
                        System.out.println(s1 + "=" + caculte(preExpre(s1)));
                        System.out.println(s2 + "=" + caculte(preExpre(s2)));
                        System.out.println(s3 + "=" + caculte(preExpre(s3)));

                        System.out.println("==================");
                    }
                }
            }
        }

        return 0;
    }

    public static String preExpre(String strExpression)       //求前缀表达式，不带负数
    {

        Stack<Character> s1 = new Stack<>();    //辅助栈
        Stack<Character> s2 = new Stack<>();    //主栈

        for (int i = strExpression.length() - 1; i >= 0; i--){

            char c = strExpression.charAt(i);   // 从右往左

            if (c >= '0' && c <= '9')    //数字直接入主栈
                s2.push(c);

            else {

                switch (c) {
                    case '}':
                        s1.push(c);
                        break;
                    case ']':
                        s1.push(c);
                        break;
                    case ')':
                        s1.push(c);
                        break;
                    case '*':
                    case '/':
                        s1.push(c);
                        break;
                    case '+':
                    case '-': {
                        while (!s1.isEmpty() && (s1.peek() == '*' || s1.peek() == '/')) s2.push(s1.pop());
                        s1.push(c);
                        break;
                    }
                    case '(': {
                        while (s1.peek() != ')') s2.push(s1.pop());
                        s1.pop();
                        break;
                    }    //右括号要释放掉
                    case '[': {
                        while (s1.peek() != ']') s2.push(s1.pop());
                        s1.pop();
                        break;
                    }    //右括号要释放掉
                    case '{': {
                        while (s1.peek() != '}') s2.push(s1.pop());
                        s1.pop();
                        break;
                    }    //右括号要释放掉

                    default:{
                        System.out.println("存在非法字符");
                        break;
                    }
                }

            }
        }

        while (!s1.isEmpty())
            s2.push(s1.pop());

        //将前缀表达式正常输出
        char[] Expression = new char[s2.size()];
        int k = 0;
        for (char c:s2)
            Expression[k++] = c;

        return new String(Expression);
    }

    public static double caculte(String Expression){

        // 用于计算,肯定不是整形，浮点型
        Stack<Double> s3 = new Stack<>();

        for (int i = 0; i < Expression.length(); i++) {

            char c = Expression.charAt(i);

            //System.out.println(c);


            if (c >= '0' && c <= '9')    //数字直接入主栈
                s3.push((double)(c - '0'));

            else {
                switch (c) {
                    case '*':
                        s3.push(s3.pop() * s3.pop());
                        break;
                    case '/':{
                        double a = s3.pop();
                        double b = s3.pop();
                        if (b == 0)
                            s3.push(9999.0);
                        else
                            s3.push(a / b);
                        break;
                    }
                    case '+':
                        s3.push(s3.pop() + s3.pop());
                        break;
                    case '-':
                        s3.push(s3.pop() - s3.pop());
                        break;
                    default:
                        break;
                }
            }
        }

        return s3.pop();
    }

    public static String jiaru(char[] dengshi, char a, char b, char c, char d){
        dengshi[1] = a;
        dengshi[3] = b;
        dengshi[5] = c;
        dengshi[7] = d;

        return new String(dengshi);
    }


}
