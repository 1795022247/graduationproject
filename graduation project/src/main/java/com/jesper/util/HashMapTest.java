package com.jesper.util;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 验证HashMap不是线程安全
 *
 * @author cdfive
 * @date 2019-02-11
 */
public class HashMapTest {
    public static void main(String[] args) throws InterruptedException {
        //final Map<Integer, Integer> map = new HashMap<>();// 结果可能大于1000
        //final Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());// 结果等于1000
        final Map<Integer, Integer> map = new ConcurrentHashMap<>();// 结果等于1000

        // 往map写入1-1000, key和value相同
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    map.put(i, i);
                }
            }
        };

        int threadNum = 10;// 线程数
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(runnable);
            threadList.add(thread);
            Thread.sleep(500);
            System.out.println(thread.getName());
            thread.start();
        }

        // 主线程等待子线程执行完成
        for (Thread thread : threadList) {
            try {

                thread.join();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(map.size());// 结果可能大于1000


        String a = "hello2";
        final String b = "hello";
        String d = "hello";

        String f = "hello" + 2;
        String c = b + 2;
        String e = d + 2;
        System.out.println(e.hashCode());
        System.out.println(a.hashCode());
        System.out.println((a == e));
        System.out.println((a == c));
        System.out.println((a == f));
        Set set=new TreeSet<>();

    }
}