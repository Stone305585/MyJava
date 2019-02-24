package interview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by ASUS on 2016/8/28.
 */
public class GoogleRoundB2 {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("E:\\B-small-attempt2.in");
            Scanner sc = new Scanner(inputStream, "UTF-8");
            PrintStream ps = new PrintStream("E:\\b-small-out.txt");
            System.setOut(ps);
            while (sc.hasNextInt()) {
                int T = sc.nextInt();

                for (int i = 0; i < T; i++) {
                    int A = sc.nextInt();
                    int B = sc.nextInt();
                    long N = sc.nextInt();
                    int K = sc.nextInt();
                    System.out.println("Case #" + String.valueOf(i + 1) + ": " + getResNum(A, B, N, K));
                }

            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static int getResNum(int A, int B, long N, int K) {
        int resNum = 0;
        for (long m = 1; m <= N; m++) {
            for (long n = 1; n <= N; n++) {
                long curRes = 0;
                long curA = 1;

                labelA:
                for (int i = 1; i <= A; i++) {
                    curA *= m;

                    if (curA >= Double.MAX_VALUE / m) {
                        break;
                    }
                    long curB = 1;
                    for (int j = 1; j <= B; j++) {
                        curB *= n;

                        if (curB >= Double.MAX_VALUE / n) {
                            continue labelA;
                        }
                        if (curA >= Double.MAX_VALUE - curB) {
                            break labelA;
                        }
                        curRes = curA + curB;

                    }
                }

                if (m != n && curRes % K == 0) {
                    resNum++;
                }
            }
        }

        return resNum % 1000000007;

    }

}
