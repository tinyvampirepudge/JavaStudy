package com.qding.javastudy.thread;

import java.util.concurrent.TimeUnit;

public class InterruptedTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadSleep = new Thread(new SleepRunnable(), "SleepThread");
        threadSleep.setDaemon(true);
        Thread threadBusy = new Thread(new BusyRunnable(), "BusyThread");
        threadBusy.setDaemon(true);

        threadSleep.start();
        threadBusy.start();

        // 休眠5秒，让threadSleep和threadBusy充分运行
        TimeUnit.SECONDS.sleep(5);

        threadSleep.interrupt();
        threadBusy.interrupt();
        System.out.println("threadSleep interrupted is:" + threadSleep.isInterrupted());
        System.out.println("threadBusy interrupted is:" + threadBusy.isInterrupted());

        // 防止threadSleep和threadBusy立刻退出
        TimeUnit.SECONDS.sleep(2);
    }

    private static class SleepRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("SleepRunnable#run");
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class BusyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

}
