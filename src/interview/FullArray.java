package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by stone on 2016/8/25.
 * 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，
 * 其中有一些位置（不超过 10 个）看不清了，但是牛牛记得这个数列顺序对的数量是 k，顺序对是指
 * 满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
 */
public class FullArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int RES = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] A = new int[n];

            /**
             * 如果数字已经存在，用1标记
             */
            for (int i = 0; i < n; i++) {
                if (sc.nextInt() != 0) {
                    A[i] = 1;
                }
            }

            /**
             * 保存可以用于全排列的数字
             */
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < n; i++) {
                if(A[i] == 0) {
                    list.add(i);
                }
            }

            ArrayList<ArrayList<Integer>> perm = new ArrayList<ArrayList<Integer>>();
            calPerm(perm, list, 0);
            //统计已有数字的顺序对
            int cv = 0;
            for( int i = 0; i < n; i++) {
                if(A[i] != 0 ) {
                    for(int j = i; j < n; j++) {
                        if( A[j] != 0 && A[i] < A[j]) {
                            cv++;
                        }
                    }
                }
            }
            //统计模糊的全排列中的顺序对
            for(ArrayList<Integer> item : perm) {
                //Arrays.copy()这里使用拷贝数组，因为后面会给数组赋值，导致数组中模糊位发生变化。
                if(k == cv + calPairs(item, Arrays.copyOf(A, n))) {
                    RES++;
                }
            }

            System.out.print(RES);
        }

    }

    private static int calPairs(ArrayList<Integer> list, int[] A) {
        int k = 0;
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                //这里给当前A[i]位赋值，求取包含当前赋值模糊位的顺序对。
                //会计算两次，一次是当前模糊位前面的比该位小的，还有事该位后面，比当前位大的。
                //并不会出现重复，因为每次计算后面的时候，后面的模糊位还没有赋值。
                A[i] = list.get(k++);
                for( int j = i+1; j < A.length; j++) {
                    if (A[j] != 0 && A[j] > A[i]) {
                        res++;
                    }
                }

                for(int j = 0; j < i; j++) {
                    if(A[j] != 0 && A[j] < A[i]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 求取全排列放到perm中。
     * @param perm    perm用于存入所有的全排列
     * @param list   用于全排列的数字
     * @param index  当前的置换位。
     */
    private static void calPerm(ArrayList<ArrayList<Integer>> perm, ArrayList<Integer> list, int index) {
        if (index == list.size()) {
            perm.add(new ArrayList<Integer>(list));
        }
        for (int i = index; i < list.size(); i++) {
            //第一次交换后，改变一个位置，求取剩下位置的全排列
            Collections.swap(list, i, index);
            //除去index位的，后面所有数字求取全排列。
            calPerm(perm, list, index+1);
            //每次交换完成后，再次交换回来，以便下次换一个位置去和当前位交换，求取剩下的全排列后，再恢复位置
            //注意这里并不会产生混乱，因为，每次交换后面后会换回来，从最后面一次一次的交换恢复回来最初位置。
            Collections.swap(list, i, index);
        }
    }
}
