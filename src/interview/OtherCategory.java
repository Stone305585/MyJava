package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by ASUS on 2016/8/11.
 * 其他的算法
 */
public class OtherCategory {
    /**
     * We are playing the Guess Game. The game is as follows:
     * <p>
     * I pick a number from 1 to n. You have to guess which number I picked.
     * <p>
     * Every time you guess wrong, I'll tell you whether the number is higher or lower.
     * <p>
     * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
     * <p>
     * -1 : My number is lower
     * 1 : My number is higher
     * 0 : Congrats! You got it!
     * ----------------------------避免相加后超出范围，而用start+(end - start)/2----------------------------------
     * Considering the big integer,we should get it in this way.
     * int mid = start+(end - start)/2;
     * instead of
     * int mid = (start+end)/2;
     * --------------------------------------------------------------
     *
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        return myGuess(1, n);

        //-----------------非递归方式-----同样为避免越界！！！！-------------------------
/*        int i = 1, j = n;
        while(i < j) {
            int mid = i + (j - i) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) == 1) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;*/
    }

    private int myGuess(int start, int end) {
        if (start >= end)
            return start;
        int mid = start + (end - start) / 2;
        int resCompare = guess(mid);
        if (resCompare == 1) {
            return myGuess(mid + 1, end);
        } else if (resCompare == -1) {
            return myGuess(start, mid);
        } else
            return mid;


//        return num;
//
//
//        switch (resCompare) {
//            case -1:
//                curLowInteger = num;
//                res = myGuess(n, (num + curHighInteger) / 2);
//                break;
//            case 0:
//                res = num;
//                break;
//            case 1:
//                curHighInteger = num;
//                res = myGuess(n, (num + curLowInteger) / 2);
//                break;
//        }
//
//        return res;
    }

    private int guess(int num) {
        return 0;
    }

    /**
     * Given two strings s and t, determine if they are isomorphic.
     * <p>
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * <p>
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character but a character may map to itself.
     * <p>
     * For example,
     * Given "egg", "add", return true.
     * <p>
     * Given "foo", "bar", return false.
     * <p>
     * Given "paper", "title", return true.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        HashMap<Character, Character> sMap = new HashMap<Character, Character>();
        HashMap<Character, Character> tMap = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(sArray[i])) {
                if (sMap.get(sArray[i]) != tArray[i]) {
                    return false;
                }
            } else {
                sMap.put(sArray[i], tArray[i]);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            if (tMap.containsKey(tArray[j])) {
                if (tMap.get(tArray[j]) != sArray[j]) {
                    return false;
                }
            } else {
                tMap.put(tArray[j], sArray[j]);
            }
        }

        return true;
    }

    /**
     * leetcode223
     */
    private int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);

        int minTop = Math.min(D, H);
        int maxBot = Math.max(B, F);
        int minRight = Math.min(C, G);
        int maxLeft = Math.max(A, E);
        int overLap = 0;

        if (maxBot < minTop && minRight > maxLeft) {
            overLap = (minTop - maxBot) * (minRight - maxLeft);
        }

        return areaA + areaB - overLap;
    }

    /**
     * LeetCode 290
     *
     * @param pattern
     * @param str
     * @return
     */
    private boolean wordPattern(String pattern, String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        String[] letters = new String[26];
        String[] strArray = str.split(" ");
        HashSet<String> strSet = new HashSet<String>();

        if (pattern.length() != strArray.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char item = pattern.charAt(i);
            String s = letters[item - 'a'];
            if (s == null) {
                if (strSet.contains(strArray[i])) {
                    return false;
                } else {
                    strSet.add(strArray[i]);
                    letters[item - 'a'] = strArray[i];
                }

            } else {
                if (!s.equals(strArray[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 两个相同数字间位置间隔不超过k
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (intMap.containsKey(nums[i])) {
                if (i - intMap.get(nums[i]) <= k) {
                    return true;
                }
            }
            intMap.put(nums[i], i);
        }

        return false;

    }

    public static String countAndSay(int a) {

        if (a == 1) {
            return "1";
        }
        String s = "1";
        while (a > 1) {
//            if (Long.valueOf(s) > Integer.MAX_VALUE)
//                return null;
            s = aaa(s);
            a--;
        }

        return s;

    }

    private static String aaa(String n) {

        char[] nArray = n.toCharArray();
        int cNum = 0;
        char c = nArray[0];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nArray.length; i++) {
            if (c == nArray[i]) {
                cNum++;
            } else {
                sb.append(cNum + "" + c);
                c = nArray[i];
                cNum = 1;
            }
        }

        sb.append(cNum + "" + c);
        return sb.toString();
    }

    public static void main(String[] strs) {
        String s = countAndSay(4);
        System.out.print(s);
    }
}
