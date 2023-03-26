package com.pinan.test.lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private ReentrantLock lock = new ReentrantLock();

    private int i = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10,
                50, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), new ThreadFactory() {

            private final AtomicInteger count = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                int c = count.incrementAndGet();
                Thread a = new Thread(r);
                a.setName("test_" + c);
                System.out.println(a.getName());
                return a;
            }
        });
        //ExecutorService t = Executors.newFixedThreadPool(10);

        ReentrantLockTest test = new ReentrantLockTest();
        CountDownLatch latch = new CountDownLatch(1000);
        for(int k = 0; k<1000; k++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    test.add();
                    latch.countDown();
                }
            });
        }
        latch.await();
        System.out.println(test.i);
    }

    public  void add(){
        lock.lock();
        try {
            i++;
        }finally {
            lock.unlock();
        }
    }
}
