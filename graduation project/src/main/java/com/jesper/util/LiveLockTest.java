package com.jesper.util;

import jdk.nashorn.internal.runtime.ECMAException;

public class LiveLockTest {

    //*餐具类
    static class Spoon {
        Dinner owner;

        //获取拥有者
        public String getOwnerName() {
            return owner.getName();
        }

        //设置拥有者
        public void setOwner(Dinner diner) {
            this.owner = diner;
        }

        public Spoon(Dinner diner) {
            this.owner = diner;
        }

        //表示正在用餐
        public void use() {
            System.out.println(owner.getName() + " use this spoon and finish eat.");
        }


    }

    //用餐
    static class Dinner {

        private boolean isHung;//是否饿了
        private String name;

        public Dinner(boolean isHung, String name) {
            this.isHung = isHung;
            this.name = name;
        }

        public boolean isHung() {
            return isHung;
        }

        public void setHung(boolean hung) {
            isHung = hung;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public void eatWith(Dinner dinner, Spoon spoon) {

            try {
                synchronized (spoon) {
                    while (isHung) {
                        while (!spoon.getOwnerName().equals(name)) {
                            spoon.wait();
                        }
                        if (dinner.isHung) {
                            System.out.println("I am " + name + ", and my " + dinner.getName() + " is hungry, I should give it to him(her).\n");
                            spoon.setOwner(dinner);
                            spoon.notifyAll();

                        } else {
                            spoon.use();
                            spoon.setOwner(dinner);
                            isHung = false;
                        }
                        Thread.sleep(500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        final Dinner has = new Dinner(true, "has");
        final Dinner wife = new Dinner(true, "wife");


        final Spoon spoon = new Spoon(wife);

        Thread thread=new Thread(){
            public void run(){
                has.eatWith(wife,spoon);
            }

        };
        thread.start();

        Thread wi=new Thread(){
            public void run(){
                wife.eatWith(wife,spoon);
            }

        };
        wi.start();

        try{
            Thread.sleep(10000);

        }catch (Exception e){
            e.printStackTrace();
        }
        thread.interrupt();
        wi.interrupt();
        try{
            thread.join();
            wi.join();

        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
