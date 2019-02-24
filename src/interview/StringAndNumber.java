package interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zhaohe on 2016/7/12.
 */
public class StringAndNumber {

    public static void main(String[] args){
//        System.out.print(addBinary("0", "0"));
        System.out.print(compareVersion("1", "1.1"));
    }

    /**
     * 打印1~n位的所有数字    比如n=4，打印1~9999；
     * @param n
     */
    public static void print1ToMaxNDigits(int n){
        if(n < 0){
            return;
        }
        char[] nArray = new char[n];
        int index = 0;

        for(int i = 0; i < 10; i++){
            nArray[0] = (char)(i + '0');
            Print1ToMaxOfNDiditsRecursively(nArray, n, index);
        }
    }

    /**
     * 递归打印，退出递归的标志是当前设置数字的index位 == 长度length
     * @param nArray
     * @param length
     * @param index
     */
    public static void Print1ToMaxOfNDiditsRecursively(char[] nArray, int length, int index){

        if(index == length - 1){
            printStringToDigit(nArray);
            return;
        }

        for(int i = 0; i < 10; i++){
            nArray[index + 1] = (char)('0' + i);
            Print1ToMaxOfNDiditsRecursively(nArray, length, index + 1);
        }
    }

    public static void printStringToDigit(char[] nArray){
        boolean isBeginZero = true;
        for(int i = 0; i < nArray.length; i++){
            if(isBeginZero && nArray[i] != '0'){
                isBeginZero = false;
            }

            if(!isBeginZero)
                System.out.print(nArray[i]);
        }

        System.out.print("\t");
    }


    public static String addBinary(String a, String b) {
        int pre = 0;
        String longStr = a;
        String shortStr = b;
        if(a.length() < b.length()) {
            longStr = b;
            shortStr = a;
        }
        char[] result = new char[longStr.length() + 1];
        char[] aArray = longStr.toCharArray();
        char[] bArray = shortStr.toCharArray();
        for(int i = aArray.length - 1; i >= 0; i--) {
            if((aArray.length - i - 1) < bArray.length) {
                char temp = (char)(aArray[i] + bArray[(bArray.length - (aArray.length - i - 1) - 1)] - '0' + pre);
                if ( temp > '1' ) {
                    pre = 1;
                    result[i + 1] = temp == '2' ? '0' : '1';

                } else {
                    result[i + 1] = temp;
                    pre = 0;
                }
            } else {
                if( aArray[i] + pre > '1' ) {
                    pre = 1;
                    result[i + 1] = '0';
                } else {
                    result[i + 1] = (char) (aArray[i] + pre);
                    pre = 0;
                }
            }
        }

        if(pre == 1) {
            result[0] = '1';
            return String.valueOf(result);
        } else {
            return String.valueOf(result).substring(1);
        }

    }

    /**
     * 28. Implement strStr()  QuestionEditorial Solution  My Submissions
     Total Accepted: 121948
     Total Submissions: 472887
     Difficulty: Easy
     Implement strStr().

     Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

     Subscribe to see which companies asked this question
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if(needle.length() == 0) {
            return 0;
        }
        char[] hayArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int pre = 0;

        for(int i = 0; i < hayArray.length; i++) {
            if(hayArray[i] == needleArray[pre]) {
                int a = 0;
                while (pre < needleArray.length && i < hayArray.length) {
                    if(hayArray[i] != needleArray[pre]){
                        pre = 0;
                        break;
                    }
                    pre++;
                    i++;
                    a++;
                }
                if(pre == needleArray.length) {
                    return i - needleArray.length;
                } else {
                    i = i - a;
                }
            }
        }

        return -1;
    }

    /**
     * 比较版本号
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        String[] ver1Array = version1.split("\\.");
        String[] ver2Array = version2.split("\\.");

        int length = Math.min(ver1Array.length, ver2Array.length);
        for(int i = 0; i < length; i++) {
            if(Integer.valueOf(ver1Array[i]) < Integer.valueOf(ver2Array[i])) {
                return -1;
            } else if (Integer.valueOf(ver1Array[i]) > Integer.valueOf(ver2Array[i])) {
                return 1;
            }
        }

        if(ver1Array.length == ver2Array.length) {
            return 0;
        } else if(ver1Array.length > ver2Array.length){
            for(int i = length; i < ver1Array.length; i++) {
                if(Integer.valueOf(ver1Array[i]) != 0) {
                    return 1;
                }
            }
            return 0;
        } else {
            for(int i = length; i < ver2Array.length; i++) {
                if(Integer.valueOf(ver2Array[i]) != 0) {
                    return -1;
                }
            }
            return 0;
        }

    }

    /**
     * 字符串转数字  只转换字符串中出现的数字
     * @param str
     * @return
     */
    public int myAtoi(String str)
    {
        int result = 0;
        boolean isNegative = false;
        char[] array = str.toCharArray();
        int index = 0;

        if(array.length == 0)
        {
            return 0;
        }

        while(index < array.length)         //skip whitespace
        {
            if(array[index] != ' ')
            {
                break;
            }
            index++;
        }

        if(array[index] == '+' || array[index] == '-')      //handle sign + and -
        {
            if(array[index] == '-')
            {
                isNegative = true;
            }
            index++;
        }

        for(int i = index ; i < array.length ; i++)
        {
            if(array[i] >= '0' && array[i] <= '9')
            {
                int addValue = array[i] - '0';

                /**
                 * result > Integer.MAX_VALUE / 10         是标准的检测  整数在乘10后  是否溢出的式子。
                 */
                if(result > Integer.MAX_VALUE / 10)         //overflow
                {
                    if(isNegative)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
                else if (result == Integer.MAX_VALUE / 10)
                {
                    if(isNegative)
                    {
                        // treat it as postive number, -MIN_VALUE =  MAX_VALUE + 1
                        if(addValue >= (Integer.MAX_VALUE - result * 10 + 1))
                        {
                            return Integer.MIN_VALUE;
                        }
                    }
                    else
                    {
                        if(addValue >= (Integer.MAX_VALUE - result * 10 ))
                        {
                            return Integer.MAX_VALUE;
                        }
                    }
                }

                result = result * 10 + addValue;
            }
            else
            {
                break;
            }
        }

        if(isNegative)
        {
            result = -result;
        }

        return result;
    }

    public int longestPalindrome(String s) {
        char[] strArray = s.toCharArray();
        int[] res = new int[26];
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(strArray[i])) {
                int tmp = map.get(strArray[i]) + 1;
                map.put(strArray[i], tmp);
            } else {
                map.put(strArray[i], 1);
            }
        }

        boolean hasodd = false;
        int num = 0;
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            int value = entry.getValue();
            if(value % 2 == 1 && !hasodd) {
                hasodd = true;
                num++;
            }
            if(value % 2 == 0) {
                num += value;
            }
        }
        return num;

    }

}
