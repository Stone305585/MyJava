package interview;

import java.util.Scanner;

/**
 * Created by ASUS on 2016/10/14.
 */
public class ZRRX {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String date1 = sc.next();
        String date2 = sc.next();
        boolean isRun = false;

        String[] date1Array = date1.split("-");
        String[] date2Array = date2.split("-");
        int month1 = Integer.valueOf(date1Array[1]);
        int month2 = Integer.valueOf(date2Array[1]);

        int day1 = Integer.valueOf(date1Array[2]);
        int day2 = Integer.valueOf(date2Array[2]);

        int year1 = Integer.valueOf(date1Array[0]);
        int year2 = Integer.valueOf(date2Array[0]);
        int allDays = 0;
        for (int i = year1 + 1; i < year2; i++) {
            if (i % 4 == 0) {
                allDays += 366;
            } else {
                allDays += 365;
            }
        }

        for (int j = month1 + 1; j < 13; j++) {
            if (j == 2 && year1 % 4 == 0) {
                allDays += 29;
            } else if (j == 2) {
                allDays += 28;
            } else if (j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10 || j == 12) {
                allDays += 31;
            } else {
                allDays += 30;
            }
        }

        for (int k = 1; k < month2; k++) {
            if (k == 2 && year2 % 4 == 0) {
                allDays += 29;
            } else if (k == 2) {
                allDays += 28;
            } else if (k == 1 || k == 3 || k == 5 || k == 7 || k == 8 || k == 10 || k == 12) {
                allDays += 31;
            } else {
                allDays += 30;
            }
        }

        if (month1 == 2 && year1 % 4 == 0) {
            allDays +=(29 - day1);
        } else if (month1 == 2) {
            allDays += (28 - day1);
        } else if (month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
            allDays += (31 - day1);
        } else {
            allDays += (30 - day1);
        }
        allDays += day2;

        System.out.print(allDays);

    }

}
