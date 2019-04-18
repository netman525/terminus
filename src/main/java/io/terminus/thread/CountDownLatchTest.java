package io.terminus.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/3/12
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class CountDownLatchTest {

    public static void main(String[] args){
        try {
            timeTasks(5, new Runnable() {
                @Override
                public void run(){
                    System.out.println(Thread.currentThread().getName() + ":XXXXXX");
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static long timeTasks(int nThreads,final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate =  new CountDownLatch(nThreads);
        for(int i = 0 ; i < nThreads ; i++){
            Thread t = new Thread(){
                @Override
                public void run(){
                    try {
                        System.out.println(Thread.currentThread().getName() + ":start");
                        startGate.await();
                        System.out.println(Thread.currentThread().getName() + ":end");
                        try {
                            task.run();
                        }finally {
                            System.out.println(Thread.currentThread().getName() + "-start");
                            endGate.countDown();
                            System.out.println(Thread.currentThread().getName() + "-end");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        long start = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long end = System.currentTimeMillis();
        return end - start;
    }
}
