package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ASUS on 2016/9/23.
 */
public class Didi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        int pre = 0;
        int last = n - 1;

        Integer res = 0;
        while (last >= 0 && array[last] > sum){
            last--;
        }
        while (last >= 0) {

            getRes(array, sum, last, res);
            last--;
        }
        System.out.print(res);
    }

    private static void getRes(int[] array, int sum, int last, Integer res) {
        while(0 <= last && array[last] > sum) {
            last--;
        }

        if(0 <= last && sum == array[last]) {
            res++;
            last--;

        }
        if(last < 0) {
            return;
        }

        if(0 <= last && sum != array[last]) {
            getRes(array, sum - array[last], last - 1, res);
        }



    }

}
