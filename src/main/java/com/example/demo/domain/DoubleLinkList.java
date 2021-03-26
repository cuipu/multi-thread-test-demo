package com.example.demo.domain;

import com.example.demo.node.DoubleNode;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

/*
 *  @program: test-demo
 *  @className: DoubleLinkList
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/25 15:03
 */
public class DoubleLinkList<E> {

    private DoubleNode<E> first;

    private DoubleNode<E> last;

    public DoubleLinkList() {
        first = null;
        last = null;
    }

    //插入节点，在头结点之后插入
    public void insertFirst(E value) {
        DoubleNode aNode = new DoubleNode(value);

        //为空，设置尾节点为新增加的节点
        if (isEmpty()) {
            last = aNode;
        }
        //链表不为空的时候，把插入前第一个节点的previous指向新节点
        else {
            first.previous = aNode;
        }
        aNode.next = first;
        first = aNode;
    }

    //尾节点插入
    public void insertLast(long value) {
        DoubleNode aNode = new DoubleNode(value);
        if (isEmpty()) {
            first = aNode;
        }
        else {
            last.next = aNode;
            aNode.previous = last;
        }
        last = aNode;
    }

    //删除头节点
    public DoubleNode deleteFirst() {
        DoubleNode tmp = first;
        if (first.next == null) {
            last = null;
        }
        else {
            //这里因为存在双指针，所以需要吧后面节点的指向前面节点的那个指针置空
            first.next.previous = null;
        }
        first = tmp.next;
        return tmp;
    }

    //删除尾节点
    public DoubleNode deleteLast() {
        DoubleNode tmp = last;
        if (first.next == null) {
            first = null;
        }
        else {
            //意思同上
            last.previous.next = null;
        }
        last = last.previous;
        return last;
    }

    //显示方法
    public void display() {
        DoubleNode now = first;
        while(now != null) {
            now.display();
            now = now.next;
        }
        System.out.println();
    }

}
