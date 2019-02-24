package interview;

import java.util.Scanner;

/**
 * Created by ASUS on 2016/9/5.
 */
public class Jd2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int testCase = sc.nextInt();
            int allSum = 0;
            for(int i = 2; i < testCase; i++) {
                allSum += getSum(testCase, i);
            }
            int div = getSample(allSum, testCase - 2);
            System.out.print(allSum/div + "/" + (testCase - 2)/div);
        }

    }

    private static void myPrint(){}

    private static int getSum(int n, int a) {
        int sum = 0;

        while (n != 0) {
            sum += n % a;
            n /= a;
        }

        return sum;
    }

    /**
     * 求公约数
     */
    private static int getSample(int x, int y) {
        if(y == 0){
            return x;
        } else {
            return getSample(y, x % y);
        }
    }
}
