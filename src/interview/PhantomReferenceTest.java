package interview;

/**
 * Created by Stone on 2018/5/17.
 *
 * @author Stone<Stone305585@live.com>
 */
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class PhantomReferenceTest {

    public static void main(String[] args) throws Exception {
        final ReferenceQueue<Test> queue = new ReferenceQueue<Test>();
        Thread moniterThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 监视线程，随时检查引用队列，一旦发现引用就会打印出来
                for (;;) {
                    Reference<? extends Test> ref = queue.poll();
                    if (ref != null) {
                        System.out.printf("%s加入引用队列%n", ref.getClass().getSimpleName());
                    }
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }

        });
        moniterThread.start();
        Test test1 = new Test();
        Test test2 = new Test();
        WeakReference<Test> weakReference = new WeakReference<Test>(test1, queue);
        PhantomReference<Test> phantomReference = new PhantomReference<Test>(test2, queue);
        // 去除强引用
        test1 = null;
        test2 = null;
        System.out.println(">> 第一次gc <<");
        System.gc();
        // 这里等待一段时间，保证引用进入队列，和finalize()方法执行
        Thread.sleep(100);
        System.out.println("\n>> 第二次gc <<");
        System.gc();
        assert weakReference != null && phantomReference != null;
        moniterThread.interrupt();
    }

    public static class Test {



    }

}