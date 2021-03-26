package com.example.demo.domain;

import com.example.demo.node.Node;

/*
 *  @program: test-demo
 *  @className: MyLinkList
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/25 14:51
 */
public class MyLinkList<E> {

    private Node<E> first;

    public MyLinkList(Node<E> first) {
        this.first = first;
    }

    public void insertFirst(E value){
        Node newNode = new Node(value);
        newNode.next = first;
        first = newNode;
    }

    //删除头节点
    public Node deleteFirst() {
        Node tmp = first.next;
        first = tmp;
        return tmp;
    }


    //显示方法
    public void display() {
        Node now = first;
        while(now != null) {
            now.display();
            now = now.next;
        }
        System.out.println();
    }

    //查找方法
    public Node find(E value) {
        Node now = first;
        while(now.data != value) {
            if(now.next == null) {
                return null;
            }
            now = now.next;
        }
        return now;
    }




}
