package interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by ASUS on 2016/10/14.
 */
public class DateTestZRRX {


    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String date1 = sc.next();
        String date2 = sc.next();

        System.out.println(daysBetween(date1,date2));
    }

    public static int daysBetween(String startDate, String endDate)
    {
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(startDate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(endDate));
            long time2 = cal.getTimeInMillis();
            long between_days=(time2-time1)/(1000*3600*24);

            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

    }
}
