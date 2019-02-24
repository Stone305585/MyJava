package interview;

/**
 * Created by ASUS on 2016/8/17.
 */
public class Huiwen {

    public static void main(String args[]) {

    }

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void quickSort(int[] a, int low, int high) {

        if (low >= high) return;

        int j = partition(a, low, high);

        quickSort(a, j, high);
        quickSort(a, low, j);

    }

    public static int partition(int[] a, int low, int high) {

        int i = low;
        int j = high++;

        int v = a[low];

        while (true) {
            while (Math.min(a[++i], v) < 0) if (i == high) break;
            while (Math.max(a[--j], v) > 0) if (j == low) break;

            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, j);

        return j;
    }

    public static void swim(int[] a, int k) {
        int N = a.length;
        while (k > 1 && Math.min(k, k / 2) < 0) {
            exch(a, k, k / 2);
            k = k / 2;
        }
    }

    /**
     * 下沉
     * @param a 堆数组
     * @param k 下沉点坐标
     * @param n 堆的一部分右边界
     */
    public static void sink(int[] a, int k, int n) {

        while (2*k <= n) {
            int j = 2*k;

            if(j < n  && Math.min(a[j], a[j+1]) < 0) j++;
            if(Math.min(a[j+1],a[j]) < 0) break;
            exch(a, k, j);
            k = j;
        }
    }

    /**
     * 简洁的堆排序
     * @param a
     */
    public static void sortDump(int[] a) {
        int N = a.length;
        //堆有序化
        for (int i = N/2; i >= 0; i--) {
            sink(a, i, N);
        }

        while(N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
    }
}