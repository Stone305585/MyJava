package leetcode;

/**
 * Created by Stone on 2019/2/12.
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author Stone<Stone305585@live.com>
 * @date 2019-02-24
 */
public class LeetCode7 {

    public static int reverse(int x) {

        String xStr = String.valueOf(x);

        char[] array = xStr.toCharArray();
        int length = array.length;

        boolean isN = array[0] == '-';

        char[] arrayReverse = new char[length];

        if (isN) {
            arrayReverse[0] = '-';
        }
        for (int i = isN ? 1 : 0; i < arrayReverse.length; i++) {
            arrayReverse[i] = array[length - i - (isN ? 0 : 1)];
        }
        String resStr = new String(arrayReverse);

        long temp = Long.valueOf(resStr);

        if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
            return 0;
        }

        int res = Integer.valueOf(resStr);
        return res * (isN ? -1 : 1);
    }

    public static void main (String[] args) {

        System.out.println(reverse(-2147483648));
    }
}
