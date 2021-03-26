package com.example.demo.domain;

import com.example.demo.node.Node;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

/*
 *  @program: test-demo
 *  @className: FirstLastLinkList
 *  @Description: 相比于单链表，双端链表在插入和删除等操作时进行了一点小的修改，体现在吧last移动的处理上
 *  @author: Mr.Cui
 *  @Date: 2021/3/25 14:55
 */
public class FirstLastLinkList <E>{

    private Node<E> first;

    private Node<E> last;

    public FirstLastLinkList() {
        first = null;
        last = null;
    }

    public FirstLastLinkList(Node<E> first, Node<E> last) {
        this.first = first;
        this.last = last;
    }

    public void insertFirst(E value){
        Node newNode = new Node(value);
        if (isEmpty()){
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    //尾节点插入
    public void insertLast(long value) {
        Node aNode = new Node(value);
        if (isEmpty()) {
            first = aNode;
        }
        else {
            last.next = aNode;
        }
        last = aNode;
    }

    //删除头节点
    public Node deleteFirst() {
        Node tmp = first;
        if (first.next == null) {
            last = null;
        }
        first = tmp.next;
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

}
