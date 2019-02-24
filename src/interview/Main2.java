package interview;

import java.util.*;

/**
 * Created by ASUS on 2016/8/2.
 */
public class Main2 {
    public static void main(String[] args) {

        int[] aArray = new int[]{1,2,6,7,4,6,3,6,6,6,8,9,23,123,798};
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < aArray.length; i++) {
            list.add(aArray[i]);
        }
        deleteNode(list);

        for(int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j) + "-->>");
        }
    }

    private static void deleteNode(List<Integer> list) {
        int deleteNum = 0;
        int length = list.size();

        for(int i = 0; i < length; i++) {
            if(list.get(i - deleteNum) == 6) {
                list.remove(i - deleteNum);
                deleteNum++;
            }
        }
    }

    public static int getIndex1(int length, int des, List<Integer> list) {
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int middle = (end - start) / 2 + start; // 直接使用(high + low) / 2 可能导致溢出
            if (list.get(middle) == des)
                System.out.print(des);
                //在左半边
            else if (list.get(middle) > des)
                end = middle - 1;
                //在右半边
            else
                start = middle + 1;
        }
        return -1;
    }

    public static int getIndex(List<Integer> list, int start, int end, int des) {
        int mid = (end - start) / 2 + start;
        if (list.get(mid) == des) {
            return mid;
        }
        if (list.get(mid) > des) {
            return getIndex(list, start, mid - 1, des);
        } else if (list.get(mid) < des) {
            return getIndex(list, mid + 1, end, des);
        } else {
            return -1;
        }
    }

    public static int[][] floyd(int n, int[][] path, int dist[][]) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                path[i][j] = i;// 表示 i -> j 前驱为 i
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][k] = i;
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        return path;
    }

    public static void printPath(int from,int[][] path, int to) {
        /*
         * 这是倒序输出，若想正序可放入栈中，然后输出。
         *
         * 这样的输出为什么正确呢？个人认为用到了最优子结构性质，
         * 即最短路径的子路径仍然是最短路径
         */
        while (path[from][to] != from) {
            System.out.print(path[from][to] + "");
            to = path[from][to];
        }
    }

    public static int getSum1(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int c = ((a & b) << 1);
            a ^= b;
            b = c;
        }
        return a;
    }

    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        result = result & -result;

        for (int j = 0; j < nums.length; j++) {
            if ((result & nums[j]) != 0)
                res[0] = res[0] ^ nums[j];
            else
                res[1] = res[1] ^ nums[j];

        }
        Map<String, String> m = new HashMap<String, String>();
        Set<String> s = new HashSet<String>();

        return res;


    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set1 = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                set1.add(nums2[j]);
            }
        }

        int[] res = new int[set1.size()];
        int i = 0;
        for (int item : set1) {
            res[i++] = item;
        }
        return res;
    }

}
