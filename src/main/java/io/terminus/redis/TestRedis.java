package io.terminus.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/3/11
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class TestRedis {

    public static void main(String[] args) throws InterruptedException{
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);

        RLock lock = redissonClient.getLock("anyLock");

        new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("1-" + Thread.currentThread().getName());

                try {
                    lock.lock();
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("1-" + Thread.currentThread().getName() + "lock.unlock()");
                    lock.unlock();
                }
            }
        }).start();

        System.out.println("main:" + Thread.currentThread().getName());
        lock.lock();
        System.out.println("main:" + "lock()");
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("unlock before");
            //lock.unlock();
            System.out.println("after before");
        }


    }
}
