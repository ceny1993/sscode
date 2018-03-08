package thejava.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by chensongkui on 2017/12/22.
 */
public class SyncTest {

    static class Sync extends AbstractQueuedSynchronizer{
        @Override
        public boolean tryAcquire(int acquires){
            if(compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Sync sync = new Sync();
        System.out.println("test");
        sync.acquire(1);
        System.out.println("test1");
        sync.acquire(2);//被自己阻塞，484傻
        System.out.println("test2");
    }
}
