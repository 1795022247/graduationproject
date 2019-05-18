package com.jesper.util;

import java.util.*;

/**
 * Created by jiangyunxiong on 2018/4/14.
 */
public class Timers implements Runnable {

    public  static  class Aut{

        private String sname;
        private Integer s;

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public Integer getS() {
            return s;
        }

        public void setS(Integer s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return "Aut{" +
                    "sname='" + sname + '\'' +
                    ", s=" + s +
                    '}';
        }
    }


    @Override
    public void run() {
        System.out.println("计数器线程已启动....");

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                RunnableThreadWebCount.showthread();
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 1000, 3000);
    }

    public static void main(String[] args) {
        String s = new String("11111111111111");
        StringBuffer s1 = new StringBuffer("11111111111111");

        Map<String, Object> map = new HashMap<String, Object>();

//        map.put("1","11111111111111");
//        map.put("1","11111111111111");
//        System.out.println(map.size());
//        System.out.println(map.get("2").hashCode());
//        System.out.println(map.get("1").hashCode()==map.get("2").hashCode());
//        System.out.println(map.get("1").equals(map.get("2")));

        Set<String> names = new HashSet<>();

        map.put("zhangsan", 1000);
        map.put("lisi", 2000);
        map.put("wangwu", 10000);
        names.addAll(map.keySet());
        Iterator it = names.iterator();
        System.out.println(it.hasNext());
//        while (it.hasNext()) {
//            String str = (String) it.next();
//            System.out.print(str + "\t");
//
//            String value = (String) map.get(str);
//            System.out.println(value);
//        }
        Aut [] ob= (Aut[]) names.toArray();

        for(int i=0;i<ob.length;i++){
            System.out.println(ob[i].toString());
        }
       // Integer
        System.out.println(ob[0]);
        System.out.println(names.toArray().length);




//        System.out.println(s1);
//        System.out.println(s);
//        System.out.println(s.hashCode()+"----"+s1.hashCode());
//        System.out.println(s1.equals(s));
    }
}
