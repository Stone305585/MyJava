package interview;

import java.util.Scanner;

/**
 * Created by ASUS on 2016/8/23.
 * 华为准备测试题
 */
public class DP {

    public static void main(String[] args) {

        //输出 ascii码加5的值
        /*System.out.println(StringASCII("abcd"));
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一串小写字母：");
        String str = in.next();
        System.out.println(StringASCII(str));
        in.close();*/

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] inputArray = new int[length];

        for(int i = 0; i < length; i++) {
            inputArray[i] = sc.nextInt();
        }

        getMax2Integer(inputArray);
    }


    /**
     * 输出 ascii码加5的值
     * @param str
     * @return
     */
    public static String StringASCII(String str) {
        StringBuffer result = new StringBuffer();
        // 将字符串转换成数组
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char arr = (char) (array[i] + 5);
            if (arr > 'z') {
                arr = (char)('a' + (arr - 'z') - 1);
            }
            result.append(arr);
        }
        return result.toString();
    }

    public static void getMax2Integer(int[] inArray) {
        int littleOne = inArray[0];
        int bigOne = inArray[0];

        for( int i = 0; i < inArray.length; i++ ) {
            //开始比较过滤出两个比较大的值
            if(inArray[i] > littleOne && inArray[i] != bigOne) {
                littleOne = inArray[i];
                if(littleOne > bigOne) {
                    bigOne    = bigOne ^ littleOne;
                    littleOne = bigOne ^ littleOne;
                    bigOne    = bigOne ^ littleOne;
                }
            }
        }

        int[] a = new int[2];
        a[0] = littleOne;
        a[1] = bigOne;

        System.out.println(a[0]);
        System.out.println(a[1]);

    }
}
