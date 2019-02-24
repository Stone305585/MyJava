//package algs4.draw;
//
//import edu.princeton.cs.algs4.StdDraw;
//import edu.princeton.cs.algs4.StdRandom;
//
//import java.util.Arrays;
//
///**
// * Created by Stone on 2017/10/16.
// *
// * @author Stone<Stone305585@live.com>
// */
//public class LogFunction {
//
//    public static void main( String args[] ) {
//        /**
//         * 绘制指数函数
//         */
////        int N = 100;
////        StdDraw.setXscale(0, N);
////        StdDraw.setYscale(0, N*N);
////        StdDraw.setPenRadius(.01);
////
////        for(int i = 0; i <= N; i++) {
////            StdDraw.point(i, i);
////            StdDraw.point(i, i*i);
////            StdDraw.point(i, Math.log(i));
////        }
//
////        drawRand();
//        //测试负数的右移，负数在计算机中已补码的形式存在。先转为补码再计算。
//        int a = -9;
//        int b = a >> 1;
//        System.out.print(b);
//
//        try {
//            YYY y = null;
//
//            throw new RuntimeException();
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    /**
//     * 绘制随机数序列
//     */
//    public static void drawRand() {
//        int N = 50;
//        double[] a = new double[N];
//        for (int i = 0; i < N; i++) {
//            a[i] = StdRandom.random();
//        }
//        Arrays.sort(a);
//        for(int i = 0; i < N; i++) {
//            double x = 1.0 * i/N;
//            double y = a[i]/2.0;
//            double rw = 0.5/N;
//            double rh = a[i]/2.0;
//            StdDraw.filledRectangle(x, y, rw, rh);
//        }
//    }
//}
