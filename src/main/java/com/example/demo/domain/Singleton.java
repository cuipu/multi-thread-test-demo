package com.example.demo.domain;

/*
 *  @program: test-demo
 *  @className: Singleton
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/25 15:37
 */
public class Singleton {

    private static volatile Singleton singleton = null;

    private Singleton() {

    }

    public synchronized Singleton getInstance() {
        if (null == singleton) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");    //系统的最大空间
        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");  //系统的空闲空间
        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");  //当前可用的总空间
        System.out.println();
    }
}
