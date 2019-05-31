package io.terminus.thread;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/3/12
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class TestObjWait {

    public static void main(String[] args) throws Exception{
        final Object obj = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run(){
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                try {
                    obj.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        Thread.sleep(1000);
        synchronized (obj){
            obj.notify();
        }
    }
}