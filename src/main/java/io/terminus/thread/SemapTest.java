package io.terminus.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/4/22
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class SemapTest {

    private static Semaphore semaphore = new Semaphore(0);

    private static Lock lock = new ReentrantLock();

    public static void main(String[] agrs) throws InterruptedException{

        semaphore.tryAcquire();
        System.out.println("X----->");
        semaphore.release();
        System.out.println("Y----->");



        lock.lock();

        lock.tryLock();


        lock.unlock();


    }
}
