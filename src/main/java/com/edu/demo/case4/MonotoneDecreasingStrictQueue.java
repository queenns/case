package com.edu.demo.case4;

import java.util.ArrayDeque;

/**
 * 严格单调递减队列
 *
 * @Author liu.xiaojian
 * @Date 2021-07-20 17:18
 */
public class MonotoneDecreasingStrictQueue {

    class Node {
        // 累计获取的金币
        int sum = 0;
        // 在index=idx的时候，取得的最大金币为sum
        int idx = 0;

        public Node(int sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }

    // 捡金币算法
    public int maxResult(int[] array, int k) {
        // 严格单调递减队列
        // 记录了每个位置可以收集到的金币及下标
        ArrayDeque<Node> queue = new ArrayDeque<>();

        // 走到i位置时,最大的金币收益
        int ans = 0;

        for (int i = 0; i < array.length; i++) {

            // 出队
            // 对于i而言
            // [i-k, i-1]可以跳到array[i]
            // 最远i-(i-k)=k
            // 超出这个范围的出队
            while (!queue.isEmpty() && i - queue.getFirst().idx > k) {
                queue.removeFirst();
            }

            // 获得位置i时的收益
            if (queue.isEmpty()) {
                ans = array[i];
            } else {
                ans = queue.getFirst().sum + array[i];
            }

            // 入队,当array[i]入队的时候，把小于等于当前收益的踢掉
            // 严格单调递减
            while (!queue.isEmpty() && queue.getLast().sum <= ans) {
                queue.removeLast();
            }

            // 入队
            queue.addLast(new Node(ans, i));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] moneys = new int[]{1, -1, -100, -1000, 100, 3};
        MonotoneDecreasingStrictQueue queue = new MonotoneDecreasingStrictQueue();
        int max = queue.maxResult(moneys, 2);
        System.out.println(max);
    }

}
