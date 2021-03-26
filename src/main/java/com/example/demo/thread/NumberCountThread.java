package com.example.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  @program: test-demo
 *  @className: NumberCountThread
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/26 14:26
 */
public class NumberCountThread implements Runnable{

    private static Integer num = 0;
    // 必须加上static关键字，表示类级别共享
    // final修饰的变量是常量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能让其指向另一个对象。
    private static final Lock lock = new ReentrantLock();
    //private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    Condition condition = lock.newCondition();

    @Override
    public void run() {
        lock.lock();
        //reentrantReadWriteLock.writeLock().lock();
        try {
            //lock.tryLock(1, TimeUnit.SECONDS);
            for (int i = 0; i < 10000; i++) {
                NumberCountThread.num ++;

//                synchronized (NumberCountThread.class){
//                    NumberCountThread.num ++;
//                }
                System.out.println(Thread.currentThread().getName() +" : " + num);
            }
            condition.await();
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            //reentrantReadWriteLock.writeLock().unlock();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new NumberCountThread(),"Thread: " + i).start();
        }

        Thread.sleep(3000);
        System.out.println(NumberCountThread.num);
    }
}
