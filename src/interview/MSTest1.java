package interview;

import java.util.Scanner;

/**
 * Created by ASUS on 2016/10/10.
 */
public class MSTest1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String str = scanner.next();
        char[] strCharArray = str.toCharArray();
        int M = scanner.nextInt();
        String[] strArray = new String[M];
        int[] charArray = new int[26];

        for (int i = 0; i < M; i++) {
            String tmpStr = scanner.next();
            char[] tmp = tmpStr.toCharArray();
            charArray[tmp[0] - 'a'] += 1;
            charArray[tmp[1] - 'a'] += 1;
            strArray[i] = tmpStr;
        }


        System.out.print(deleteIllegal(str, strCharArray, strArray, charArray));
    }

    public static int deleteIllegal(String str, char[] strCharArray, String[] strArray, int[] charArray) {
        int res = 0;
        int M = strArray.length;
        boolean isDelete = false;
        for (int k = 0; k < M; k++) {
            String tmpStr1 = strArray[k];
            char[] tmpArray1 = tmpStr1.toCharArray();
            if (str.contains(tmpStr1)) {
                int index = str.indexOf(tmpStr1);
                if (charArray[tmpArray1[0] - 'a'] == 1 &&
                        charArray[tmpArray1[1] - 'a'] == 1) {
                    res++;
                    strCharArray[index] = '0';
                } else if (charArray[tmpArray1[0] - 'a'] == 1 && charArray[tmpArray1[1] - 'a'] > 1) {
                    res++;
                    strCharArray[++index] = '0';
                } else if (charArray[tmpArray1[0] - 'a'] > 1 && charArray[tmpArray1[1] - 'a'] == 1) {
                    res++;
                    strCharArray[index] = '0';
                } else {
                    res += 2;
                    strCharArray[index] = '0';
                    strCharArray[++index] = '0';
                }

                isDelete = true;
            }

        }

        if(isDelete){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < strCharArray.length; j++) {
                if (strCharArray[j] != '0') {
                    sb.append(strCharArray[j]);
                }
            }

            return res + deleteIllegal(sb.toString(), sb.toString().toCharArray(), strArray, charArray);
        }else {
            return 0;
        }


    }
}