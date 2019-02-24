package interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ASUS on 2017/6/28.
 *
 * 该类为采用了ReentrantLock的有界队列，当队列满时会阻塞插入方法，队列空时阻塞删除方法。
 */
public class BoundedQueue<T> {

    private Object[] items;

    //记录添加的下标，删除的下标和当前的数量
    private int addIndex, removeIndex, count;

    //锁
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size) {
        items = new Object[size];
    }

    /**
     * 增加元素
     * @param t
     * @throws InterruptedException
     */
    public void add(T t) throws InterruptedException{

        lock.lock();

        try {

            while (count == items.length) {
                notFull.await();
            }

            items[addIndex] = t;
            if(++addIndex == items.length) {
                addIndex = 0;
            }
            ++count;

            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }

    /**
     * 从头部开始删除元素
     * @return
     * @throws InterruptedException
     */
    public T remove() throws InterruptedException {

        lock.lock();

        try {
            while (removeIndex == 0) {
                notEmpty.wait();
            }

            Object x = items[removeIndex];
            if( ++removeIndex == items.length) {
                removeIndex = 0;
            }
            --count;

            notFull.signal();
            return (T)x;
        } finally {
            lock.unlock();
        }

    }
}
