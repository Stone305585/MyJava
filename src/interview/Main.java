package interview;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String inputStr = cin.nextLine();
        if(isNumeric(inputStr)) {
            System.out.println(convertToStr(inputStr));
        } else {
            System.out.println(convertToNum(inputStr));
        }
        cin.close();
    }

    /**
     * 转换数字为字母字符串
     * @param numStr  输入的数字
     * @return
     */
    public static String convertToStr(String numStr) {

        int num = Integer.valueOf(numStr);
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.insert(0, String.valueOf((char)('a' + num % 26 - 1)));
            num = num / 26;
        }

        return sb.toString();
    }

    /**
     * 转换字母字符串为十进制数字
     * @param letterStr  输入的数字
     * @return
     */
    public static String convertToNum(String letterStr) {

        char[] charArray = letterStr.toCharArray();

        int ans = 0;

        for(int i = 0; i < charArray.length; i++) {

            ans = (charArray[i] - 'a' + 1) + ans * 26;
        }
        return String.valueOf(ans);
    }

    /**
     * 校验是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
