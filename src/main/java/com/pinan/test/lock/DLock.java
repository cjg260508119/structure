package com.pinan.test.lock;

public class DLock {

    private String A = "A";

    private String B = "B";


    public static void main(String[] args){
        new DLock().lock();
    }

    private void lock(){
        //线程A
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try{
                        Thread.sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("test-a");
                    }
                }
            }
        });

        //线程B
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    try{
                        Thread.sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (A){
                        System.out.println("test-b");
                    }
                }
            }
        });
        a.start();
        b.start();
    }
}
