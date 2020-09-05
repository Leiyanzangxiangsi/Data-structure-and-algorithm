



//**************************************************************************
// 前缀，中缀，后缀表达式
//**************************************************************************


import java.util.*;
import java.lang.Math;

public class Calculate {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        String strExpression = in.nextLine();

        String strE = preExpre(strExpression);

        System.out.println(strE);
        System.out.println(caculte(strE));



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
                    case '/':
                        s3.push(s3.pop() / s3.pop());
                        break;
                    case '+':
                        s3.push(s3.pop() + s3.pop());
                        break;
                    case '-':{
                        s3.push(s3.pop() - s3.pop());
                        break;
                    }
                    default:
                        break;
                }
            }
        }

        return s3.pop();
    }

}
