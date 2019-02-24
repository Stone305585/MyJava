package interview;

import java.util.Scanner;

/**
 * Created by ASUS on 2016/10/14.
 */
public class BIG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());

        int[] lengths = new int[num];
        int[] res = new int[num];

        int maxLength = 0;
        for (int i = 0; i < num; i++) {
            lengths[i] = sc.nextLine().length();
            if (lengths[i] > maxLength) {
                maxLength = lengths[i];
            }
        }

        int arr[] = new int[maxLength + 1];
        arr[0] = arr[1] = 1;
        for (int i = 2; i <= maxLength; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int j = 0; j < num; j++) {
            System.out.println(arr[lengths[j]]);
        }
    }
}
