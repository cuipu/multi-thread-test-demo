package com.example.demo.thread;

import com.example.demo.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.ref.SoftReference;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 *  @program: test-demo
 *  @className: TestThread
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/25 9:52
 */
@Component
@Scope("prototype")
@Slf4j
public class AccountOperator implements Runnable{

    private LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue<>();

    private Account account;

    public AccountOperator() {

    }

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();


    public AccountOperator(Account account) {
        this.account = account;
    }
    /**
    公平锁和非公平锁
    锁Lock分为 公平锁 和 非公平锁，

    公平锁表示线程获取锁的的顺序是按照线程加锁的顺序来分配的
    非公平锁随机获得
    * */
    //private Lock lock = new ReentrantLock(false);
    //private Condition condition = lock.newCondition();

    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();




    @Override
    public void run() {
        threadLocal.set(Integer.valueOf(Thread.currentThread().getName()));


/*        synchronized (account){
            account.deposit(100);
            account.withdraw(500);//取钱
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }*/
        //lock.lock();
        reentrantReadWriteLock.writeLock().lock();
        try {
            account.deposit(0);
            account.withdraw(500);//取钱
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());

            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());

            //condition.await();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //lock.unlock();
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public static void main1(String[] args) {
        Account account = new Account("zhang san", 10000.0f);
        AccountOperator accountOperator = new AccountOperator(account);

        final int THREAD_NUM = 5;
        Thread threads[] = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new Thread(accountOperator, "" + i);
            threads[i].start();
        }
    }

    public static void main2(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            treeMap.put(random.nextInt(1000),random.nextInt(1000) + "");
        }
        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();
        entries.forEach(integerStringEntry -> System.out.println("key: "+ integerStringEntry.getKey()  + " --- value: " +  integerStringEntry.getValue()));
        //System.out.println("key:{0}","test");
        StringBuffer sb = new StringBuffer();
    }

    public static void main3(String[] args) {
        String a = "abc";
        String b = "a" + "bc";

        String c = new String("abc");

        System.out.println(a == b);
        System.out.println(a == c);


        System.out.println(a.hashCode());
        System.out.println(c.hashCode());

        LinkedList linkedList = new LinkedList();
    }

    public static void main(String[] args) {

        SoftReference<byte[]> softReference = new SoftReference<byte[]>(new byte[1024*1024*10]);
        //System.setProperties(new Properties());
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());

        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(softReference.get());

    }


}
