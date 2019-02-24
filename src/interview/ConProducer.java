package interview;

import java.util.PriorityQueue;

/**
 * Created by stone on 2016/3/11.
 */
public class ConProducer {
    private int queuesize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queuesize);

    public static void main(String[] args) {
        ConProducer test = new ConProducer();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        producer.start();
        consumer.start();

    }

    /**
     * 消费者线程
     */
    class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            queue.wait();
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    //每次移走队列队首元素
                    queue.poll();
                    queue.notify();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                }
            }
        }
    }


    /**
     * 生产者线程
     */
    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == queuesize) {
                        try{
                            System.out.println("队列满，等待有空余空间");
                            queue.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                    System.out.println("向队列中插入一个元素，队列剩余空间：" + (queuesize - queue.size()));
                }
            }
        }
    }
}

