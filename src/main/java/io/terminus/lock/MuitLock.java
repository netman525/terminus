package io.terminus.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/4/3
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class MuitLock {

    /**
     * 内部类,自定义同步器
     */
    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 是否处于占用状态
         *
         * @return
         */
        @Override
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int acquires){
            // Otherwise unused
            assert acquires == 1;
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int releases){
            // Otherwise unused
            assert releases == 1;
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 返回一个Condition，每个condition都包含了一个condition队列
         *
         * @return
         */
        Condition newCondition(){ return new ConditionObject(); }
    }

    /**
     * 仅需要将操作代理到Sync上即可
     */
    private final Sync sync = new Sync();

    public void lock(){ sync.acquire(1); }

    public boolean tryLock(){ return sync.tryAcquire(1); }

    public void unlock(){ sync.release(1); }

    public Condition newCondition(){ return sync.newCondition(); }

    public boolean isLocked(){ return sync.isHeldExclusively(); }

    public boolean hasQueuedThreads(){ return sync.hasQueuedThreads(); }

    public void lockInterruptibly() throws InterruptedException{
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException{
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }
}
