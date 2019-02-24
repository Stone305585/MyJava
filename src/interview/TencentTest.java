package interview;

import java.util.Scanner;

public class TencentTest {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] steps = new int[3];
        int[] gameStarts = new int[5];

        for (int i = 0; i < 3; i++) {
            steps[i] = sc.nextInt();
        }

        for (int j = 0; j < 5; j++) {
            gameStarts[j] = sc.nextInt();
            int res = getRes(1, steps, gameStarts[j], 0, 0);

            System.out.println("------>" + res);
        }


    }


    private static int getRes(int index, int[] steps, int start, int total1, int total2) {


        int[] res = new int[]{2, 2, 2};

        for (int i = 0; i < steps.length; i++) {
            if (start >= steps[i]) {

                total1 += index % 2 == 0 ? 0 : steps[i];
                total2 += index % 2 == 1 ? 0 : steps[i];

                int temp = getRes(++index, steps, start - steps[i], total1, total2);
                res[i] = temp;

            } else {
                int temp;
                if (total1 % 2 == total2 % 2) {
                    temp = 0;
                } else if (total1 % 2 == 1 && total2 % 2 == 0) {
                    temp = 1;
                } else {
                    temp = -1;
                }

                res[i] = temp;
            }
        }

        for(int k = 0; k < res.length; k++) {
            if(res[k] == 1) {
                return 1;
            }
        }

        for(int k1 = 0; k1 < res.length; k1++) {
            if(res[k1] == 0) {
                return 0;
            }
        }

        return -1;

    }

}