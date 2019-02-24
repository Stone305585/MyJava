package algs4;

import java.util.Scanner;

/**
 * Created by Stone on 2018/2/22.
 *
 * 整形数组
 * @author Stone<Stone305585@live.com>
 */
public class MySort {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();

        int[] a = new int[length];
        for(int i = 0; i < length; i++) {
            a[i] = sc.nextInt();
        }

//        printArray(a);
        //选择排序
//        selectSort(a);
        //插入排序
        insertSort(a);
    }

    /**
     * 交换顺序
     * @param a   被交换数组
     * @param ori 位置1
     * @param src 位置2
     */
    public static void exch(int[] a, int ori, int src) {
        int temp = a[ori];

        a[ori] = a[src];

        a[src] = temp;
    }

    /**
     * 打印数组
     * @param a 被打印数组
     */
    public static void printArray(int[] a) {
        for( int i = 0; i < a.length; i++ ) {
            System.out.println(a[i]);
        }
    }


    /**
     * 选择排序
     * @param a
     */
    public static void selectSort(int[] a) {

        int length = a.length;

        for( int i = 0; i < length; i++) {
            //选出第一个数与后面依次比较
            int min = i;

            for(int j = i; j < length; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }

            exch(a, i, min);
        }

        printArray(a);
    }

    /**
     * 插入排序
     * @param a
     */
    public static void insertSort(int[] a) {

        //这里的i用于标记需要 比较多少次  数组长度为6，则只需要比较5次
        for( int i = 1; i < a.length; i++ ) {

            for(int j = 0; j < a.length - i; j++) {
                if(a[j] > a[j + 1]) {
                    exch(a, j, j+1);
                }
            }
        }

        printArray(a);
    }
}
