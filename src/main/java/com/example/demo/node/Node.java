package com.example.demo.node;

import lombok.Data;

/*
 *  @program: test-demo
 *  @className: Node
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/25 14:48
 */
@Data
public class Node<E> {

    public E data;

    public Node<E> next;

    public Node() {
    }

    public Node(E data) {
        this.data = data;
    }

    public Node(E item, Node<E> next) {
        this.data = item;
        this.next = next;
    }


    //显示方法
    public void display() {
        System.out.print(data.toString() + " ");
    }

}
