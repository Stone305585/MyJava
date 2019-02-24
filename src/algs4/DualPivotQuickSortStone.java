package algs4;

/**
 * Created by Stone on 2017/10/16.
 *
 * @author Stone<Stone305585@live.com>
 */
public class DualPivotQuickSortStone {
    //对外公开的两个sort方法
    public static void sort(int[] a) {
        sort(a, 0, a.length);
    }
    public static void sort(int[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        dualPivotQuicksort(a, fromIndex, toIndex - 1, 3);
    }
    //对数组的边界检测
    private static void rangeCheck(int length, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex > toIndex");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > length) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }
    //交换数组中两个元素
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /**
     * 双轴快排的具体实现
     * @param a     待排序数组
     * @param left  数组需排序上界
     * @param right 数组需排序下界
     * @param div   理解为从何位置取轴
     */
    private static void dualPivotQuicksort(int[] a, int left,int right, int div) {
        int len = right - left;
        //数组长度如果很小（27），则直接用插入排序对其排序
        if (len < 27) {
            for (int i = left + 1; i <= right; i++) {
                for (int j = i; j > left && a[j] < a[j - 1]; j--) {
                    swap(a, j, j - 1);
                }
            }
            return;
        }
        //取到位于1/div和div-1/div位置的点，并用他们来做轴
        int third = len / div;
        int m1 = left + third;
        int m2 = right - third;
        if (m1 <= left) {
            m1 = left + 1;
        }
        if (m2 >= right) {
            m2 = right - 1;
        }
        //确保left是小的，right是大的
        if (a[m1] < a[m2]) {
            swap(a, m1, left);
            swap(a, m2, right);
        }
        else {
            swap(a, m1, right);
            swap(a, m2, left);
        }
        // 两个轴
        int pivot1 = a[left];
        int pivot2 = a[right];
        // 代表比p1小和比p2大的两个指针
        int less = left + 1;
        int great = right - 1;
        // 开始取出less到great之间的未知大小数据，与两个轴比较
        // 并且将数据放入正确的区域后调整各个指针
        for (int k = less; k <= great; k++) {
            //如果取出的数比p1小，那么直接到less左侧，并且less右移
            if (a[k] < pivot1) {
                swap(a, k, less++);
            }
            //如果取出的数比p2大，那么首先确定great左侧没有比p2大的数
            //然后与great位置的数字交换，great左移
            //此时，great交换的数字肯定是比p2小或者相等的（首先确定过）
            //那么此时再与p1相比，处理这个数的区间
            else if (a[k] > pivot2) {
                while (k < great && a[great] > pivot2) {
                    great--;
                }
                swap(a, k, great--);
                if (a[k] < pivot1) {
                    swap(a, k, less++);
                }
            }
            //如果这个数比p1大但是比p2小，则不需要交换，只需将k指针右移
        }
        //将p1与less左侧的第一个数交换
        swap(a, less - 1, left);
        //将p2与great右侧的第一个数交换
        swap(a, great + 1, right);
        // 计算出在两轴大小之间的个数
        int dist = great - less;
        //如果这个数很小（13），那么取轴的点向两边偏
        if (dist < 13) {
            div++;
        }
        // 对三个子区间分别排序，因为less-1和great+1是轴，已经排好了序
        // 所以不需要比较
        dualPivotQuicksort(a, left, less - 2, div);
        dualPivotQuicksort(a, great + 2, right, div);
        // 如果在中间区间的数字很多，那么排除掉一些相等的元素再进行排序
        if (dist > len - 13 && pivot1 != pivot2) {
            for (int k = less; k <= great; k++) {
                if (a[k] == pivot1) {
                    swap(a, k, less++);
                }
                else if (a[k] == pivot2) {
                    swap(a, k, great--);
                    if (a[k] == pivot1) {
                        swap(a, k, less++);
                    }
                }
            }
        }
        // 对中间的区间排序
        if (pivot1 < pivot2) {
            dualPivotQuicksort(a, less, great, div);
        }
    }
}
