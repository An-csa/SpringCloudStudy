package com.example.configserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class demo {


    void demo1() {
        synchronized (demo.class) {
            System.out.println("xxxxxxx");
        }
    }

    void demo2() {
        lock.lock();//加锁
        lock.unlock();//解锁
    }

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    void demo3() {
        readWriteLock.readLock().lock();
        readWriteLock.readLock().unlock();
        readWriteLock.readLock().tryLock();
        readWriteLock.writeLock().lock();
        readWriteLock.writeLock().unlock();

    }

    private ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    void demo4() {
        threadLocal.set("sss");
        threadLocal.get();
        threadLocal.remove();
    }

    private static volatile Object a;

    void demo5() throws InterruptedException {
        notify();
        notifyAll();
        wait();
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    void demo6() throws InterruptedException {
        condition1.await();
        condition1.signal();
        condition1.signalAll();
        condition2.await();
        condition2.signal();

    }

    private CountDownLatch countDownLatch = new CountDownLatch(5);

    void demo7() throws InterruptedException {
        countDownLatch.await();
    }

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
}
