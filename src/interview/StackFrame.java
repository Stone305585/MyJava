package interview;

/**
 * Created by Stone on 2018/5/17.
 *
 * @author Stone<Stone305585@live.com>
 */
public class StackFrame {

    public static void main(String[] args) throws Exception {

        Test t;
        {
            t = new Test();

            t = null;
        }

        Thread.sleep(10000);
        System.gc();

        System.out.println(t);
    }

    public static class Test {



    }

}