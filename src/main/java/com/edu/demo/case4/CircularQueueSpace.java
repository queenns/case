package com.edu.demo.case4;

import java.util.Arrays;

/**
 * 循环队列,空间变量控制指针
 *
 * @Author liu.xiaojian
 * @Date 2021-07-20 11:03
 */
public class CircularQueueSpace {

    // 队列头部元素索引
    private int first = 0;

    // 队列尾部元素索引
    private int index = 0;

    private int[] elements = null;

    private int capacity = 0;

    public CircularQueueSpace(int k) {
        capacity = k + 1;
        elements = new int[k + 1];
    }

    public boolean enQueue(int val) {
        if (isFull()) {
            return false;
        }

        elements[index] = val;
        index = (index + 1) % capacity;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        elements[first] = -1;
        first = (first + 1) % capacity;
        return true;
    }

    public int first() {
        return isEmpty() ? -1 : elements[first];
    }

    public int last() {
        int tail = (index - 1 + capacity) % capacity;
        return isEmpty() ? -1 : elements[tail];
    }

    public boolean isFull() {
        return (index + 1) % capacity == first;
    }

    public boolean isEmpty() {
        return first == index;
    }

    @Override
    public String toString() {
        return "CircularQueueSpace{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }

    public static void main(String[] args) {
        CircularQueueSpace queue = new CircularQueueSpace(5);

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(7);

        queue.deQueue();

        queue.enQueue(10);

        System.out.println(queue.toString());
    }
}
