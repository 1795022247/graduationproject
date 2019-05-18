package com.jesper.util;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrintDemo2 {


//    public static void main(String[] args) {
//        final ThreadPrintDemo2 demo2 = new ThreadPrintDemo2();
//        Thread t1 = new Thread(demo2::print1);
//        Thread t2 = new Thread(demo2::print2);
//
//        t1.start();
//        t2.start();
//    }
//
//    public synchronized void print2() {
//        for (int i = 1; i <= 100; i += 2) {
//            System.out.println(i);
//            this.notify();
//            try {
//                this.wait();
//                Thread.sleep(100);// 防止打印速度过快导致混乱
//            } catch (InterruptedException e) {
//                // NO
//            }
//        }
//    }
//
//    public synchronized void print1() {
//        for (int i = 0; i <= 100; i += 2) {
//            System.out.println(i);
//            this.notify();
//            try {
//                this.wait();
//                Thread.sleep(100);// 防止打印速度过快导致混乱
//            } catch (InterruptedException e) {
//                // NO
//            }
//        }
//    }




    /*
    使用CAS 实现
     */
//    static AtomicInteger cxsNum = new AtomicInteger(0);
//    static volatile boolean flag = false;
//    public static void main(String[] args) {
//        Thread t1=new Thread(()->{
//
//            for (; 100 > cxsNum.get(); ) {
//                if (!flag && (cxsNum.get()==0||cxsNum.incrementAndGet()%2==0)){
//
//                    try {
//                        Thread.sleep(100);// 防止打印速度过快导致混乱
//                    } catch (InterruptedException e) {
//                        //NO
//                    }
//
//                    System.out.println(cxsNum.get());
//                    flag=true;
//                }
//            }
//        });
//
//
//        Thread t2 = new Thread(() -> {
//            for (; 100 > cxsNum.get(); ) {
//                if (flag && (cxsNum.incrementAndGet() % 2 != 0)) {
//                    try {
//                        Thread.sleep(100);// 防止打印速度过快导致混乱
//                    } catch (InterruptedException e) {
//                        //NO
//                    }
//
//                    System.out.println(cxsNum.get());
//                    flag = false;
//                }
//            }
//        }
//        );
//
//
//        t1.start();
//        t2.start();
//
//
//    }

    static volatile   int num = 0;
    static  volatile  boolean flag = false;



        public static void main(String[] args) {
            Thread t1=new Thread(()->{
                for(;num<100;){
                    if(!flag&&(++num%2==0)){
                        System.out.println(Thread.currentThread().getName()+"--------"+num);
                        flag=true;
                    }
                }

            });

            Thread t2=new Thread(()->{
                for(;num<100;){
                    if(flag&&(++num%2!=0)){
                        System.out.println(Thread.currentThread().getName()+"--------"+num);
                        flag=false;
                    }
                }

            });

            t2.start();
            t1.start();


    }


}
