package interview;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ASUS on 2017/6/21.
 */
public class JAVA_Integer {

    public static void main(String args[]) {

        Integer a = 1;
        Integer b = 2;
        //默认赋值 127，128为节点，
        Integer c = 128;
        Integer d = 128;
        Integer e = 32;
        Integer f = 32;

        byte tt = 127;

        Long g = 3L;

        //如果cd的值小于128，那么下面两句输出都是true。
        //如果大于127，那么下面第一句false，第二句true。
        System.out.println(c == d);
        System.out.println(c.equals(d));

        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

        /*以上是靠整型数的自动拆装箱实现的，而两者的结果却不相同。

        原因在于，在进行自动拆装箱时，编译器会使用Integer.valueof()来创建Integer实例。

        以下是Integer.valueof()的源代码：

        复制代码
        public static Integer valueOf(int i) {
            assert IntegerCache.high >= 127;
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }
        复制代码
        简单地解释这段代码，就是如果传入的int在IntegerCache.low和IntegerCache.high之间，那就尝试看前面的缓存中有没有打过包的相同的值，如果有就直接返回，否则就创建一个Integer实例。IntegerCache.low 默认是-128；IntegerCache.high默认是127.

                注：如果要比较两个对象的内容是否相同，尽量不使用== 或者!= 来比较，可以使用equal()来实现。*/

    }
}
