package interview;

import java.util.Scanner;

/**
 * Created by ASUS on 2016/10/14.
 */
public class ZRRX1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());

        String[] strings = new String[num];
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            String[] strArray = str.split(" ");
            StringBuffer sb = new StringBuffer();
            for (int j = strArray.length - 1; j >= 0; j--) {
                sb.append(strArray[j]);
                if(j != 0)
                    sb.append(" ");
            }
            strings[i] = sb.toString();
        }

        for (int k = 0; k < num; k++) {
            System.out.println(strings[k]);
        }
    }

}
