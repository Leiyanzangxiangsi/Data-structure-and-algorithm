import java.util.Scanner;

public class XMtest1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            System.out.println(Ifture(in.next()));
        }

    }

    public static int Ifture(String mima){

        boolean xiaoxie = false;
        boolean daxie = false;
        boolean shuzi = false;
        boolean fuhao = false;
        if(mima.length() <8 || mima.length() >120)
            return 1;

        for (int i=0;i<mima.length();i++){
            char c = mima.charAt(i);
            if (c>='0' && c<='9')
                shuzi = true;
            else if(c>='a' && c<='z')
                xiaoxie = true;
            else if(c>='A' && c<='Z')
                daxie = true;
            else
                fuhao = true;

        }

        if (fuhao&&daxie&&xiaoxie&&shuzi)
            return 0;
        else
            return 2;
    }

}
