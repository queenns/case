package com.edu.demo.case4;


/**
 * 计算索引技巧
 */
public abstract class IndexMock {

    /**
     * 循环队列下一个索引算法技巧
     *
     * @param i        当前索引
     * @param capacity 数组容量
     * @return 下一个索引
     */
    public static int beforeMockMod(int i, int capacity) {
        return (i + 1) % capacity;
    }

    /**
     * 循环队列上一个索引算法技巧
     *
     * @param i        当前索引
     * @param capacity 数组容量
     * @return 上一个索引
     */
    public static int afterMockMod(int i, int capacity) {
        return (i - 1 + capacity) % capacity;
    }

    public static void main(String[] args) {
        int beforeMod = beforeMockMod(0, 5);
        int afterMod = afterMockMod(0, 5);
        System.out.println(beforeMod + "," + afterMod);
    }

}
