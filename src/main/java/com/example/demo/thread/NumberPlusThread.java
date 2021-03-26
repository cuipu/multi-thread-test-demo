package com.example.demo.thread;

import com.example.demo.domain.NumberConst;

/*
 *  @program: test-demo
 *  @className: NumberPlusThread
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/26 17:38
 */
public class NumberPlusThread implements Runnable{

    @Override
    public void run() {
        NumberConst.lock.lock();
        try {
            for (int i = 0; i <= 1000; i++) {
                NumberConst.number ++;
                System.out.println(Thread.currentThread().getName() + " : " + NumberConst.number);
            }
            NumberConst.connection.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            NumberConst.lock.unlock();
        }
    }
}
