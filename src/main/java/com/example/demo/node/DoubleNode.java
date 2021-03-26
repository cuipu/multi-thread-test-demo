package com.example.demo.node;

/*
 *  @program: test-demo
 *  @className: DoubleNode
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/25 15:01
 */
public class DoubleNode <E>{

    public E data;

    public DoubleNode<E> previous;

    public DoubleNode<E> next;

    public DoubleNode(E data) {
        this.data = data;
    }

    //显示方法
    public void display() {
        System.out.print(data + " ");
    }

}
