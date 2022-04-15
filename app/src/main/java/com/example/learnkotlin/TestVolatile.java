package com.example.learnkotlin;

public class TestVolatile {
    static boolean flag;
    void test(){
        new Thread1().start();
        new Thread2().start();
    }
    static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
                if (flag) {
                    flag = false;
                    System.out.println("####Thread1 set flag to false");
                }
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                if (!flag) {
                    flag = true;
                    System.out.println("####Thread2 set flag to true");
                }
            }
        }
    }
}
