package interview;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by stone on 2016/3/11.
 */
public class ConProducer1 {
    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public static void main(String[] args)  {
        ConProducer1 test = new ConProducer1();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread{

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while(true){
                lock.lock();
                try {
                    while(queue.size() == 0){
                        try {
                            System.out.println("队列空，等待数据");
                            notEmpty.await();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();                //每次移走队首元素
                    notFull.signal();

                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                } finally{
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread{

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while(true){
                lock.lock();
                try {
                    while(queue.size() == queueSize){
                        try {
                            System.out.println("队列满，等待有空余空间");
                            notFull.await();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);        //每次插入一个元素
                    notEmpty.signal();

                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
                } finally{
                    lock.unlock();
                }
            }
        }
    }

    //由下面的日志可以看出  notEmpty.signal()不一定什么时候被唤醒，也许队列大小是10000的话中间就会被唤醒，
    // 这个值比较小的话，也许很快就满了，wait了才能唤醒下一个等待线程
    /**
     * 队列满，等待有空余空间
     从队列取走一个元素，队列剩余9个元素
     从队列取走一个元素，队列剩余8个元素
     从队列取走一个元素，队列剩余7个元素
     从队列取走一个元素，队列剩余6个元素
     从队列取走一个元素，队列剩余5个元素
     从队列取走一个元素，队列剩余4个元素
     向队列取中插入一个元素，队列剩余空间：5
     向队列取中插入一个元素，队列剩余空间：4
     向队列取中插入一个元素，队列剩余空间：3
     向队列取中插入一个元素，队列剩余空间：2
     向队列取中插入一个元素，队列剩余空间：1
     向队列取中插入一个元素，队列剩余空间：0
     队列满，等待有空余空间
     从队列取走一个元素，队列剩余9个元素
     从队列取走一个元素，队列剩余8个元素
     从队列取走一个元素，队列剩余7个元素
     从队列取走一个元素，队列剩余6个元素
     从队列取走一个元素，队列剩余5个元素
     从队列取走一个元素，队列剩余4个元素
     从队列取走一个元素，队列剩余3个元素
     从队列取走一个元素，队列剩余2个元素
     从队列取走一个元素，队列剩余1个元素
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     向队列取中插入一个元素，队列剩余空间：9
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     向队列取中插入一个元素，队列剩余空间：9
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     向队列取中插入一个元素，队列剩余空间：9
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     向队列取中插入一个元素，队列剩余空间：9
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     向队列取中插入一个元素，队列剩余空间：9
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     向队列取中插入一个元素，队列剩余空间：9
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     向队列取中插入一个元素，队列剩余空间：9
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     向队列取中插入一个元素，队列剩余空间：9
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     向队列取中插入一个元素，队列剩余空间：9
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     向队列取中插入一个元素，队列剩余空间：9
     从队列取走一个元素，队列剩余0个元素
     队列空，等待数据
     */
}