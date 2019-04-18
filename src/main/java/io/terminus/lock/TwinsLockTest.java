package io.terminus.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;


/**
 * @param
 * @author
 */
public class TwinsLockTest {

    @Test
    public void test(){

        final Lock lock = new TwinsLock();

        class Worker extends Thread {

            private int i;

            public Worker(int i){
                System.out.println("Worker(i) : " + i);
                this.i = i;
                System.out.println("Worker(this.i) : " + this.i);
            }
            @Override
            public void run(){
                while (true) {
//                    lock.lock();
                    try {
                        Thread.sleep(1000L);
                        System.out.println(this.i + ":" + Thread.currentThread().getName() + ":Worker-start");
                        System.out.println(this.i + ":" + Thread.currentThread().getName() + ":Worker");
                        System.out.println(this.i + ":" + Thread.currentThread().getName() + ":Worker-end");
                        Thread.sleep(1000L);
                    } catch (Exception ex) {

                    } finally {
//                        lock.unlock();
                    }
                }
            }

            public int getI(){
                return i;
            }

            public void setI(int i){
                this.i = i;
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("i:" + i);
            Worker w = new Worker(i);
            w.start();
        }

        new Thread() {
            @Override
            public void run(){
                while (true) {
                    try {
                        Thread.sleep(200L);
                        System.out.println("Main");
                    } catch (Exception ex) {

                    }
                }
            }
        }.start();

        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}