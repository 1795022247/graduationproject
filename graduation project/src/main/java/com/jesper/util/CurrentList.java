package com.jesper.util;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*
并发队列
 */
public class CurrentList {
    public  static AtomicInteger s=new AtomicInteger(0);
    public static AtomicBoolean flag1=new AtomicBoolean(true);

    public   static AtomicInteger count=new AtomicInteger(0);


    public static void inc() throws InterruptedException {
        Thread.sleep(10);
       count.incrementAndGet();

    }
    public static void main(String[] args) throws InterruptedException {
        ToyotaYQ yq = new ToyotaYQ();
        new Thread(yq, "ToyotaYQ_001").start();
        new Thread(yq, "ToyotaYQ_002").start();
        new Thread(yq, "ToyotaYQ_003").start();

//    Thread thread=new Thread(()->{
//        while (flag1.getAndSet(true)){
//
//           s.incrementAndGet();
//        }
//
//    });
//
//    flag1.set(false);

//
//        for (int i=0;i<1000;i++){
//            new  Thread(()-> {
//                try {
//                    CurrentList.inc();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//
//        }
//
//        Thread.sleep(1000);
//    System.out.println(count);

        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean =  ManagementFactory.getThreadMXBean();
        // 获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        // 遍历线程线程，仅打印线程ID和线程名称信息
        for(ThreadInfo threadInfo:threadInfos){
            System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
        }



    }

    static class MQ {
        private static Queue<String> queue = null;

        public static Queue<String> initQueue() {
            if (queue == null) {
                queue = new ConcurrentLinkedQueue<>();
            }
            String tasklist = "JF1GH78F18G036149,JF1SH95F6AG110830,JF1SJ94D7DG010387,JF1SH92F9CG269249,JF1SH92F5BG215090,JF1SH92F5BG222556,JF1SH92F4CG279994,JF1BR96D7CG114298,JF1BR96D0BG078632,JF1SH95F9AG094011,JF1SH98FXAG186997,JF1BM92D8BG022510,JF1BM92DXAG013855,JF1BM94D8EG036618";
            String s[] = tasklist.split(",");

            List<String> list = Arrays.asList(s);

            queue.addAll(list);
            return queue;
        }


    }

    /*
    制单客户端
     */

    static class ToyotaYQ implements Runnable {

        private static final Object lock = new Object();
        private static Queue<String> queue = MQ.initQueue();


        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    String thisVIN = queue.poll();
                    if (thisVIN == null) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "成功制单：" + thisVIN + "。剩余：" + queue.size() + "个任务");
                }
            }

        }
    }
}
