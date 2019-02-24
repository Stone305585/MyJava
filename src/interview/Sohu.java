package interview;

import java.util.Scanner;

/**
 * Created by ASUS on 2016/9/21.
 */
public class Sohu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();
        int m = sc.nextInt();
        int original = m;

        char[] array = N.toCharArray();
        int length = array.length;

        boolean delete = false;
        while (m > 0) {
            for (int i = 0; i < length; i++) {
                if (i + 1 < length) {
                    //当前数字小于后者
                    if (array[i] < array[i + 1]) {
                        array[i] = 'x';
                        delete = true;
                        m--;
                        break;
                    }
                }

            }

            if (!delete) {
                break;
            }
            delete = false;
        }


        //转移删掉的数字到最后
        char[] newArray = new char[length];
        int b = 0;
        for (int a = 0; a < length; a++) {
            if (array[a] != 'x') {
                newArray[b] = array[a];
                b++;
            }
        }


        //输出
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < array.length - original; j++) {
            res.append(newArray[j]);
        }
        System.out.print(res.toString());

    }

}
