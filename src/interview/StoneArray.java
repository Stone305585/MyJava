package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by stone on 2016/7/24.
 * 数组类算法
 */
public class StoneArray {
    //---------------找出数组中只出现过一次的数------------------

    /**
     * 找出数组中只出现过一次的数字
     *
     * @param data
     * @param length
     * @return
     */
    public int FindNumAppearOnce(int data[], int length) {
        int resultExclusiveOR = 0;

        //求取数组中所有数字的异或
        for (int i = 0; i < length; i++) {
            resultExclusiveOR ^= data[i];
        }
        return resultExclusiveOR;
    }

    /**
     * 找出数字num的二进制中  从右边数  最后一位是1的位置
     *
     * @param num
     * @return
     */
    private int FindFirstBitis1(int num) {
        int indexBit = 0;
        while (((num & 1) == 0) && indexBit < 32) {
            num >>= 1;
            indexBit++;
        }
        return indexBit;
    }

    /**
     * 验证数字num中 第bitIndex是否为1
     *
     * @param num
     * @param bitIndex
     * @return
     */
    private boolean isBit1(int num, int bitIndex) {
        num = num >> bitIndex;
        return (num & 1) == 1;
    }


    /**
     * 找出递增数组data中，和为sum的一组数字。
     *
     * @param data
     * @param sum
     * @return
     */
    private boolean getNumsWithSum(int[] data, int sum) {
        boolean found = false;
        int a = 0;
        int b = data.length;

        if (data.length <= 1)
            return false;

        while (a < b) {
            int sumTemp = data[a] + data[b];
            //当前和小，增加前一个指针。
            if (sumTemp < sum) {
                a++;
            } else if (sumTemp == sum) {
                found = true;
                return found;
                //当前和大，减小后一个指针
            } else {
                b--;
            }
        }

        found = false;
        return found;
    }

    /**
     * 返回数组中除val以外数字的长度，并把所有val移动到数组尾部
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int head = 0;
        int tail = nums.length - 1;
        int otherLength = 0;

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }

        while (head < tail) {
            if (nums[tail] == val) {
                otherLength++;
                tail--;
            } else {
                if (nums[head] == val) {
                    otherLength++;
                    int temp = nums[tail];
                    nums[tail] = val;
                    nums[head] = temp;
                    tail--;
                }
                head++;
            }
        }

        return nums.length - otherLength;
    }


    //--------------------Pascal's Triangle--------------------
    //                              1
    //                             / \
    //                            1   1
    //                           / \ / \
    //                          1   2   1
    //                         / \ / \ / \
    //                        1   3   3   1
    //
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();

        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    row.add(1);
                } else
                    row.add(pascal.get(i - 1 - 1).get(j - 1 - 1) + pascal.get(i - 1 - 1).get(j - 1));
            }
            pascal.add(row);
        }
        return pascal;
    }

    //                   1              ----
    //                  1 1             ----
    //                 1 1 1
    //                1 2 1             ----
    //               1 1 2 1
    //              1 3 3 1             ----
    //             1 1 3 3 1            下面的算法每次在最前面加一个元素1，后面的元素保持不变，然后逐个改变其值
    //            1 4 6 4 1             ----
    //
    //
    //
    private List<List<Integer>> anotherGenerate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }

    //给出数字n，输出Pascal三角的第n行
    private List<Integer> getPascalRow(int n) {
        List<Integer> rowList = new ArrayList<Integer>();
        int[] row = new int[n + 1];

        row[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                row[j] = row[j] + row[j - 1];
            }
        }

        for (int a = 0; a < row.length; a++) {
            rowList.add(row[a]);
        }
        return rowList;
    }

    //--------------------Pascal's Triangle--------------------

    //clean array no matter what you leave.
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++)
            if (nums[j] > nums[i])
                nums[++i] = nums[j];
        return i + 1;
    }

    //using with extra space
    public static boolean check(int x) {
        String temp = Integer.toString(x);
        boolean flag = true;
        for (int i = 0; i < temp.length() / 2; i++) {
            char a = temp.charAt(i);
            char b = temp.charAt(temp.length() - i - 1);
            if (a != b) {
                flag = false;
            }
        }
        return flag;
    }

    //using without extra space
    public static boolean check2(int x) {
        if (x < 0)
            return false;
        int n = 1;
        int temp = x;
        while (temp / 10 != 0) {
            temp = temp / 10;
            n++;
        }
        for (int i = 0; i < n / 2; i++) {
            int a = i;
            int b = n - 1 - i;
            if (getInt(x, a) != getInt(x, b)) {
                return false;
            }
        }
        return true;
    }

    // 比如 896698 这个数字，要获取百位，用896698除以100，得到8966然后取余10得到6，即为百位的数值
    private static int getInt(int x, int i) {
        int a = (int) Math.pow(10, i);
        return (x / a) % 10;
    }

    //---------------------------------------图 九宫格-----------------------
    public boolean isValidSudoku(char[][] board) {
        boolean[] boxContains0 = new boolean[9];
        boolean[] boxContains1 = new boolean[9];
        boolean[] boxContains2 = new boolean[9];
        for (int i = 0; i < 9; i++) {
            boolean[] rowContains = new boolean[9];
            boolean[] colContains = new boolean[9];
            for (int j = 0; j < 9; j++) {
                int loc = board[i][j] - '1';
                //board[i][j] != '.'
                if (board[i][j] != '.') {
                    int temp = j / 3;
                    if (temp == 0) {
                        if (!boxContains0[loc]) boxContains0[loc] = true;
                        else return false;
                    } else if (temp == 1) {
                        if (!boxContains1[loc]) boxContains1[loc] = true;
                        else return false;
                    } else if (temp == 2) {
                        if (!boxContains2[loc]) boxContains2[loc] = true;
                        else return false;
                    }

                    if (!rowContains[loc]) rowContains[loc] = true;
                    else return false;
                }
                //board[j][i] != '.'
                loc = board[j][i] - '1';
                if (board[j][i] != '.') {
                    if (!colContains[loc]) colContains[loc] = true;
                    else return false;
                }
            }
            if (i % 3 == 2) {
                boxContains0 = new boolean[9];
                boxContains1 = new boolean[9];
                boxContains2 = new boolean[9];
            }
        }
        return true;
    }

    private void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int length = nums1.length;
        while (n > 0 && m > 0) {
            int a = nums1[m - 1];
            int b = nums2[n - 1];
            nums1[--length] = a > b ? nums1[--m] : nums2[--n];
        }

        while (n > 0) {
            nums1[--length] = nums2[--n];
        }
        while (m > 0) {
            nums1[--length] = nums1[--m];
        }

        if (length - m - n > 0) {
            shiftArray(length - m - n, nums1);
        }
    }

    private void shiftArray(int shiftPos, int[] array) {
        for (int i = 0; i < array.length - shiftPos; i++) {
            array[i] = array[shiftPos + i];
        }
    }

    /**
     * 素数。质数。http://www.2cto.com/kf/201604/499297.html
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        //2,3,5,7,11,13,17
        //20  5；
        //init check  n
        boolean[] a = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!a[i]) {
                for (int j = i; i * j < n; j++) {
                    a[i * j] = true;
                }
            }
        }
        int c = 0;

        for (int i = 2; i < n; i++) {
            if (a[i] == false) ++c;
        }
        return c;
    }

    /**
     * ZigZag Conversation
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        char[] sArray = s.toCharArray();
        int j = 0;
        int a = numRows;
        StringBuilder sb = new StringBuilder();
        numRows = (2*numRows - 2);

        for (int i = 0; i < a; i++) {
            if((i == 0 || i == a - 1)) {
                while ((j * numRows + i) < s.length()) {
                    sb.append(sArray[j * numRows + i]);
                    j++;
                }
            } else {
                while (j * numRows + i < s.length()) {
                    sb.append(sArray[j * numRows + i]);
                    if (numRows * (j + 1) - i < s.length())
                        sb.append(sArray[numRows * (j + 1) - i]);
                    j++;
                }
            }

            j = 0;
        }

        return sb.toString();
    }

    public static void main(String strs[]) {
//        System.out.print(convert("ABC", 3));
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if(m > n){
            System.out.print("no");
        }
        List<Integer> result = getNum(m, n);
        if(result.size() == 0) {
            System.out.print("no");
        } else {

            for(int i = 0; i < result.size(); i++) {
                System.out.print(String.valueOf(i) + (i == result.size() - 1 ? "" : " "));
            }

        }

    }

    /**
     * 反转数字
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            //防止int越界
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x /= 10;
        }

        return result;
    }

    /**
     * 二维数组查找
     */
    public boolean twoDimensionFind(int[][] array, int target) {
        int colLength = array[0].length;
        int rowLength = array.length;
        int right = colLength;
        int down = rowLength;
        Stack<Integer> stack = new Stack<Integer>();
        //竖向 行的循环
        for(int i = 0; i < down; i++) {
            //横向列的循环
            for(int j = 0; j < right; j++) {
                if(target > array[i][j]) {
                } else if(target < array[i][j]){
                    right = j;
                } else {
                    return true;
                }
            }
        }

        return false;
    }


    public static String getSum(int m, int n) {
        double a = n;
        float sum = 0;

        for(int i = 0; i < m; i++) {
            sum += a;
            a = Math.sqrt(a);
        }
        String df = String.format("%.2f", sum);
        return df;
    }


    public static List<Integer> getNum(int m, int n) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = m; i <= n; i++) {
            if(isFlower(i)){
                list.add(i);
            }
        }
        return list;
    }

    public static boolean isFlower(int a) {
        int sum = 0;
        int original = a;
        while(a != 0) {
            int s = a % 10;
            sum += Math.pow(s, 3);
            a /= 10;
        }
        if(sum == original){
            return true;
        } else {
            return false;
        }

    }
}
