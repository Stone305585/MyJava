package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ASUS on 2016/9/5.
 */
public class jd {

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};

        System.out.print(IsPopOrder(pushA, popA));
//        isLuckNum(1);
//        Scanner sc = new Scanner(System.in);
//
//        while (sc.hasNext()) {
//            int testNum = sc.nextInt();
//            List<Integer> resultList = new ArrayList<Integer>();
//
//            for(int i = 0; i < testNum; i++) {
//                int curNum = sc.nextInt();
//                int curLuckNum = 0;
//                for(int j = 1; j <= curNum; j++) {
//                    if (isLuckNum(j)) {
//                        curLuckNum++;
//                    }
//                }
//                resultList.add(curLuckNum);
//            }
//            for(int m = 0; m < resultList.size(); m++) {
//                System.out.print(resultList.get(m));
//            }
//        }
    }

    public static boolean isLuckNum(int n) {
        int sumDec = 0;
        int sumBin = 0;
        int original = n;

        //求取十进制的和
        while (n != 0) {
            sumDec += n % 10;
            n /= 10;
        }

        //求取二进制的和
        while (original != 0) {
            sumBin++;
            original = original & (original - 1);
        }

        if (sumBin == sumDec) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int cur = 0;
        for (int j = 0; j < popA.length; j++) {
            int head = popA[j];

            if (stack.isEmpty() || stack.peek() != head) {
                for (int i = cur; i < pushA.length; i++) {

                    stack.push(pushA[i]);
                    cur = i + 1;
                    if (pushA[i] == head) {
                        break;
                    }
                }

                if (pushA[cur - 1] == head) {
                    stack.pop();
                } else {
                    return false;
                }

            } else {

                stack.pop();
            }

        }

        return true;
    }

}
