package com.example.demo.domain;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  @program: test-demo
 *  @className: NumberConst
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/26 17:39
 */
public class NumberConst {

    public static Integer number = 0;

    public static Lock lock = new ReentrantLock();

    public static Condition connection = lock.newCondition();
}
