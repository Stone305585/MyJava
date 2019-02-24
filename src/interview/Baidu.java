package interview;

import java.util.Scanner;

/**
 * Created by ASUS on 2016/9/20.
 */
public class Baidu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (M != 0) {
            int temp = M % N;
            if (temp > 9) {
                sb.append((char)('a' + temp - 10));
            } else
                sb.append(String.valueOf(temp));
            M /= N;
        }

        char[] aArray = sb.toString().toCharArray();
        int length = aArray.length;
        for (int i = 0; i < length; i++) {
            System.out.print(aArray[length - i - 1]);

        }


    }

    private int getMin(int[] array, int m, int length) {
        int div = length / m;
        for (int i = 0; i < length; i++) {

        }

        return 0;

    }

    private void baidu1(Scanner sc) {
        String s = sc.nextLine();
        int length = 1;//当前重复串的长度。
        char[] sArray = s.toCharArray();
        int sLength = sArray.length;
        char curChar = sArray[0];
        int[] res = new int[26];

        for (int i = 1; i < sLength; i++) {
            //等于前一个字符串
            if (curChar == sArray[i]) {
                length++;
            } else {
                //当前字母出现过
                if (res[curChar - 'a'] != 0) {
                    if (res[curChar - 'a'] < length) {
                        res[curChar - 'a'] = length;
                    }
                } else {
                    res[curChar - 'a'] = length;
                }
                curChar = sArray[i];
                length = 1;
            }
        }
        //当前字母出现过
        if (res[curChar - 'a'] != 0) {
            if (res[curChar - 'a'] < length) {
                res[curChar - 'a'] = length;
            }
        } else {
            res[curChar - 'a'] = length;
        }


        int resNum = 0;
        for (int i = 0; i < 26; i++) {
            resNum += res[i];
        }

        System.out.print(resNum);
    }
}
