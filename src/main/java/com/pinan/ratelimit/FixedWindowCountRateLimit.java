package com.pinan.ratelimit;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName:FixedWindowCountRateLimit
 * @Auther: 26050
 * @Description:计数器限流
 * 1、固定窗口计数器限流
 * @Date: 2023/3/26 09:10
 * @Version: v1.0
 */
public class FixedWindowCountRateLimit {

    private final static long WINDOW_TIME_LIMIT = 1000;
    private final static long WINDOW_COUNT_LIMIT = 50;

    @Data
    static class Window{
        private long startTime;
        private long count;
    }

    Window window = new Window();

    public synchronized boolean limit(){
        //获取当前时间戳
        long curr = System.currentTimeMillis();
        if(window.count == 0){
            window.startTime = curr;
        }
        if((curr - window.startTime) > FixedWindowCountRateLimit.WINDOW_TIME_LIMIT){
            System.out.println("超过时间窗口，开始替换时间");
            window.startTime = curr;
            window.count = 0;
        }
        if(window.count < FixedWindowCountRateLimit.WINDOW_COUNT_LIMIT){
            System.out.println("pass");
            window.count++;
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws BlockException {
        Entry entry = SphU.entry("HelloWorld");
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000), new ThreadFactory() {
            private final AtomicLong count = new AtomicLong();
            public Thread newThread(Runnable r) {
                long c = count.incrementAndGet();
                Thread a = new Thread(r);
                a.setName("test_" + c);
                return a;
            }
        });
        //统计成功
        AtomicLong success = new AtomicLong();
        FixedWindowCountRateLimit limit = new FixedWindowCountRateLimit();
        CountDownLatch latch = new CountDownLatch(1000);
        for(int i=0; i<1000; i++){
            final int index = i;
            try {
                executor.submit(new Runnable() {
                    public void run() {
                        if(index % 5 == 0){
                            try {
                                Thread.sleep(1002);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        boolean flag = limit.limit();
                        if(flag){
                            success.incrementAndGet();
                        }
                        latch.countDown();
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        try {
            latch.await();
            System.out.println("成功次数：" + success.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) / 10 * 10);
        System.out.println(1377 /10);
    }
}
