package interview;

/**
 * Created by ASUS on 2016/8/29.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{2, 13, 5, 1, 2, 0, 37, 33, 2, 13, 4, 7, 0, 23, 2, 3, 3, 34};
//        quickSort1(a, 0, a.length - 1);
//        insertSort(a);
        chooseSort(a);
        for (int i = 0; i < a.length - 1; i++) {
            System.out.println(a[i]);
        }
    }

    public static void quickSort(int[] array) {
        if (array != null) {
            quicksort(array, 0, array.length - 1);
        }
    }

    /**
     * 快速排序
     *
     * @param array
     * @param start
     * @param end
     */
    private static void quicksort(int[] array, int start, int end) {
        if (start >= end || array == null) {
            return;
        }

        int p = partition(array, start, end);
        quicksort(array, p + 1, end);
        quicksort(array, start, p - 1);
    }

    /**
     * 这种写法不如  《算法 第四版》 上面的写法容易理解，主要问题出在 array[i] <= pivot  这里需要等号，不然第一个元素和自己比
     * 较就会有问题，不如书上写法容易理解
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (array[i] <= pivot && i < end) {
                i++;
            }
            while (array[j] > pivot && j >= start) {
                j--;
            }

            if (i < j) {
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }

        }
//
//        if(i != start) {
//            array[i] = array[i] ^ array[start];
//            array[start] = array[i] ^ array[start];
//            array[i] = array[i] ^ array[start];
//        }
//
//        return i;
        if (j != start) {
            array[j] = array[j] ^ array[start];
            array[start] = array[j] ^ array[start];
            array[j] = array[j] ^ array[start];

        }

        return j;
    }

    /**
     * 比较好理解
     *
     * @param array
     * @param start
     * @param end
     */
    private static void quickSort1(int[] array, int start, int end) {
        int i = start;
        int j = end;

        if (array == null || array.length == 0) {
            return;
        }
        while (i < j) {
            while (i < j && array[i] <= array[j]) {
                i++;
            }
            if (i < j) {
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }
            while (i < j && array[j] > array[i]) {
                j--;
            }
            if (i < j) {
                array[j] = array[j] ^ array[i];
                array[i] = array[j] ^ array[i];
                array[j] = array[j] ^ array[i];
            }
        }

        if (i - start > 1) {
            quickSort1(array, start, i - 1);
        }
        if (end - i > 1) {
            quickSort1(array, i + 1, end);
        }

    }

    /**
     * 插入排序
     */
    private static int[] insertSort(int[] array) {

        int length = array.length;
        for (int i = 0; i < length; i++) {
            int temp = array[i];
            int j = 0;

            for (j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }

        return array;
    }

    /**
     * 选择排序
     */
    private static int[] chooseSort(int[] array) {

        int length = array.length;
        for (int i = 0; i < length; i++) {

            int min = array[i];
            int minIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (min > array[j]) {
                    minIndex = j;
                    min = array[j];
                }
            }

            array[minIndex] = array[i];
            array[i] = min;
        }
        return array;
    }

    /**
     * 冒泡
     *
     * @param array
     * @return
     */
    private static int[] bubbleSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

    /**
     * 归并
     */
    private static void merSort(int[] array, int left, int right) {

        while (left < right) {
            int middle = (left + right) / 2;
            merSort(array, left, middle);
            merSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int third = left;
        int tmp = left;
        int mid = middle + 1;
        int[] tmpArray = new int[array.length];

        while (left < middle && mid < right) {
            if (array[left] < array[mid]) {
                tmpArray[third++] = tmpArray[left++];
            } else {
                tmpArray[third++] = tmpArray[mid++];
            }

            while (left <= middle) {
                tmpArray[third++] = array[left++];
            }

            while (mid <= right) {
                tmpArray[third++] = array[mid++];
            }

            while (tmp <= right) {
                array[tmp] = tmpArray[tmp++];
            }
        }
    }
}
