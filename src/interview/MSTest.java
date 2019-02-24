package interview;

import java.util.Scanner;

/**
 * Created by ASUS on 2016/10/10.
 */
public class MSTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();

//        List<Integer> list = new ArrayList<Integer>();
//        List<Integer> list1 = new ArrayList<Integer>();
//
//        for (int i = 0; i < N; i++) {
//            int tmp = sc.nextInt();
//            if (i > 0 && list.size() != 0) {
//                int res = tmp + list.get(list.size() - 1);
//                list1.add(res);
//                if (res % 2 == 1) {
//                    list.remove(list.size() - 1);
//                } else {
//                    list.add(tmp);
//                }
//            } else {
//                list.add(tmp);
//            }
//        }



        System.out.print(N.indexOf("ab"));

    }

}
