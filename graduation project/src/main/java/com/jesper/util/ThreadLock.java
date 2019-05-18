package com.jesper.util;

public class ThreadLock {


    public static void main(String[] args) {

        final Object object = new Object();
        final Object object2 = new Object();
        Thread thread = new Thread(() -> {

            synchronized (object) {
                try {
                    System.out.println("锁住了一");
                    Thread.sleep(1000);
                } catch (Exception e) {

                }

                synchronized (object2) {
                    System.out.println("锁住了2");
                }
            }


        });


        Thread thread2 = new Thread(() -> {

            synchronized (object2) {
                try {
                    System.out.println("锁住了二");
                    Thread.sleep(1000);
                } catch (Exception e) {

                }

                synchronized (object) {
                    System.out.println("锁住了1");
                }
            }


        });

        thread.start();
        thread2.start();
    }

}
