package com.jesper.util;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobin {


    private static Map<String, Integer> serviceWeightMap = new HashMap<String, Integer>();

    static {

        serviceWeightMap.put("192.168.1.100", 1);
        serviceWeightMap.put("192.168.1.101", 1);
        serviceWeightMap.put("192.168.1.102", 4);
        serviceWeightMap.put("192.168.1.103", 1);
        serviceWeightMap.put("192.168.1.104", 1);
        serviceWeightMap.put("192.168.1.105", 3);
        serviceWeightMap.put("192.168.1.106", 1);
        serviceWeightMap.put("192.168.1.107", 2);
        serviceWeightMap.put("192.168.1.108", 1);
        serviceWeightMap.put("192.168.1.109", 1);
        serviceWeightMap.put("192.168.1.110", 1);
        serviceWeightMap.put("192.168.1.100", 1);
        serviceWeightMap.put("192.168.1.111", 1);
        serviceWeightMap.put("192.168.1.122", 4);
        serviceWeightMap.put("192.168.1.133", 1);
        serviceWeightMap.put("192.168.1.144", 1);
        serviceWeightMap.put("192.168.1.155", 3);
        serviceWeightMap.put("192.168.1.166", 1);
        serviceWeightMap.put("192.168.1.177", 2);
        serviceWeightMap.put("192.168.1.188", 1);
        serviceWeightMap.put("192.168.1.199", 1);
        serviceWeightMap.put("192.168.1.122", 1);
    }


    private static AtomicInteger pos = new AtomicInteger(0);
    private static AtomicInteger j = new AtomicInteger(2);

    public static String testRoundRobin() {

        // 重新创建一个map，避免出现由于服务器上线和下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serviceWeightMap);
        //取得IP地址list
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        //keyList的长度为20
        String server = null;


        if (pos.get() >= keySet.size()) {
            System.out.println("第" + j + "次轮播" + j);
            j.incrementAndGet();
            pos.getAndSet(0);
        }


        server = keyList.get(pos.get());
        pos.incrementAndGet();
        return server + pos.get() + "-------------";
    }

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();



        //ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 82; i++) {


            Thread thread = new Thread(() -> {
                String s = new RoundRobin().testRoundRobin();
                System.out.println(Thread.currentThread().getName() + s);
            });

            list.add(thread);
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).start();
        }

    }
}
