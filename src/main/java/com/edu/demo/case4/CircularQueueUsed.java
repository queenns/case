package com.edu.demo.case4;

import java.util.Arrays;

/**
 * 循环队列,used变量控制指针
 *
 * @Author liu.xiaojian
 * @Date 2021-07-20 10:37
 */
public class CircularQueueUsed {

    private int used = 0;

    // 第一个元素所在位置
    private int first = 0;

    // 元素入队的索引位置
    private int index = 0;

    private int capacity = 0;

    private int[] elements = null;

    public CircularQueueUsed(int k) {
        this.capacity = k;
        elements = new int[k];
    }

    public boolean enQueue(int val) {
        if (isFull()) {
            return false;
        }

        elements[index] = val;

        index = (index + 1) % capacity;

        used++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        elements[first] = -1;

        first = (first + 1) % capacity;

        used--;

        return true;
    }

    public int first() {
        if (isEmpty()) {
            return -1;
        }

        return elements[first];
    }

    public int last() {
        if (isEmpty()) {
            return -1;
        }

        int tail = (index - 1 + capacity) % capacity;

        return elements[tail];
    }

    public boolean isFull() {
        return used == capacity;
    }

    public boolean isEmpty() {
        return used == 0;
    }

    @Override
    public String toString() {
        return "CircularQueueUsed{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }

    public static void main(String[] args) {
        CircularQueueUsed queue = new CircularQueueUsed(5);

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);

        queue.deQueue();

        int first = queue.first();
        System.out.println(first);
        int last = queue.last();
        System.out.println(last);
        System.out.println(queue);
    }
}
