package interview;

/**
 * Created by ASUS on 2016/7/26.
 * 二进制相关算法
 */
public class BinaryNum {

    public static void main(String[] args) {
        System.out.print(sum(18, 6));
    }

    /**
     * 使用二进制位运算处理 两个数的加法
     * @param a
     * @param b
     * @return
     */
    private static int sum(int a, int b) {
        int sum;
        int carry;

        do{
            sum = a ^ b;
            carry = (a & b) << 1;
            b = carry;
            a = sum;

            //只要两个数的 & 运算不为 0 就一直 求取 ^ 和 & 运算  最后得到的^ 结果为最终结果。
            //这里的意思是不产生进位为止
        }while (b != 0);

        return sum;
    }
}
