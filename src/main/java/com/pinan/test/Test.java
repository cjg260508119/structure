package com.pinan.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadFactory() {

            private final AtomicInteger count = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                int c = count.incrementAndGet();
                Thread a = new Thread(r);
                a.setName("test_" + c);
                return a;
            }
        });
        Test test = new Test();
        for(int i=0; i<100; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    test.testLock();
                }
            });
        }
    }

    public void testLock(){
        synchronized (this){
            try {
                Thread.sleep(5000);
                System.out.println("test........");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
