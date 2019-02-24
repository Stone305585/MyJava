//import java.util.Scanner;
//
///**
// * Created by ASUS on 2016/9/23.
// */
//public class Wangyi {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
////
//        if((n & 1) == 1) {
//            System.out.print(n + Math.pow(2, getOneNums(n, 1)));
//        } else {
//            int zeroNum =
//        }
//
//        for (int i = n + 1; ; i++) {
//            if (getOneNums(i) == num) {
//                System.out.print(i);
//                break;
//            }
//        }
//
//
//    }
//    private static int getOneNums(int a, int b) {
//        int res = 0;
//        int c = 1;
//        if(b == 0) {
//            //0
//            while ((c ^ a) != 0) {
//                res++;
//                c <<= 1;
//            }
//        } else {
//            //1
//
//            while ((c & a) != 0){
//                res++;
//                c <<= 1;
//            }
//        }
//
//        return res;
//    }
////
////    private static boolean isSample(int a) {
////        if ((a & 3) == 1) {
////            return true;
////        }
////        return false;
////
////    }
//
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////
////        String str = sc.nextLine();
////        Set<String> set = new HashSet<String>();
////
////        for(int i = 0; i < str.length() - 1; i++) {
////            for(int j = i + 2; j <= str.length(); ) {
////                String subStr = str.substring(i, j);
////                if(isBest(subStr))
////                    set.add(subStr);
////                j += 2;
////            }
////        }
////
////        System.out.print(set.size());
////    }
////
////    public static boolean isBest(String s) {
////        int mid = s.length() / 2;
////        char[] array = s.toCharArray();
////
////        for(int i = 0; i < mid; i++) {
////            if(array[i] != array[mid + i]) {
////                return false;
////            }
////        }
////        return true;
////    }
//}
