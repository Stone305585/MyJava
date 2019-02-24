//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.PrintStream;
//import java.util.Scanner;
//
///**
// * Created by stone on 2016/8/28.
// * Problem A. Sherlock and Parentheses
// * Problem
// * <p>
// * Sherlock and Watson have recently enrolled in a computer programming course. Today, the tutor taught them about the balanced parentheses problem. A string S consisting only of characters ( and/or ) is balanced if:
// * It is the empty string, or:
// * It has the form (S), where S is a balanced string, or:
// * It has the form S1S2, where S1 is a balanced string and S2 is a balanced string.
// * <p>
// * Sherlock coded up the solution very quickly and started bragging about how good he is, so Watson gave him a problem to test his knowledge. He asked Sherlock to generate a string S of L + R characters, in which there are a total of L left parentheses ( and a total of R right parentheses ). Moreover, the string must have as many different balanced non-empty substrings as possible. (Two substrings are considered different as long as they start or end at different indexes of the string, even if their content happens to be the same). Note that S itself does not have to be balanced.
// * <p>
// * Sherlock is sure that once he knows the maximum possible number of balanced non-empty substrings, he will be able to solve the problem. Can you help him find that maximum number?
// * Input
// * <p>
// * The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of one line with two integers: L and R.
// * <p>
// * Output
// * <p>
// * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the answer, as described above.
// * <p>
// * Limits
// * <p>
// * 1 ≤ T ≤ 100.
// * Small dataset
// * <p>
// * 0 ≤ L ≤ 20.
// * 0 ≤ R ≤ 20.
// * 1 ≤ L + R ≤ 20.
// * Large dataset
// * <p>
// * 0 ≤ L ≤ 105.
// * 0 ≤ R ≤ 105.
// * 1 ≤ L + R ≤ 105.
// */
//public class GoogleRoundB1 {
//
//    public static void main(String[] args) {
//        FileInputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("E:\\A-large.in");
//            Scanner sc = new Scanner(inputStream, "UTF-8");
//            PrintStream ps = new PrintStream("E:\\a-large-out.txt");
//            System.setOut(ps);
//            while (sc.hasNextInt()) {
//                int T = sc.nextInt();
//
//                for (int i = 0; i < T; i++) {
//                    int l = sc.nextInt();
//                    int r = sc.nextInt();
//                    System.out.println("Case #" + String.valueOf(i + 1) + ": " + resNum(l, r));
//                }
//
//            }
//
//            sc.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            if (inputStream != null) {
//                try {
//
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//
//    private static long resNum(long left, long right) {
//        long min = Math.min(left, right);//多少对括号
//        return min * (min + 1) / 2;
//    }
//}
