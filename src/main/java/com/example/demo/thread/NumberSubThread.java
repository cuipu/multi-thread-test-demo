package com.example.demo.thread;

import com.example.demo.domain.NumberConst;

/*
 *  @program: test-demo
 *  @className: NumberSubThread
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/26 17:47
 */
public class NumberSubThread implements Runnable {

    private Boolean flag = true;
    @Override
    public void run() {
        NumberConst.lock.lock();
        try {

            while (flag) {
                NumberConst.connection.await();
                for (int i = 0; i < 1000; i++) {
                    NumberConst.number--;
                    System.out.println(Thread.currentThread().getName() + " : " + NumberConst.number);
                }
            }

/*            if (NumberConst.number < 0) {
                NumberConst.number--;
                System.out.println(Thread.currentThread().getName() +" : " + NumberConst.number);
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            NumberConst.lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new NumberPlusThread(), "NumberPlusThread").start();
        //new Thread(new NumberSubThread(), "NumberSubThread").start();

        for (int i = 0; i < 10; i++) {
            new Thread(new NumberSubThread(),"NumberSubThread" + i).start();
        }

    }
}
