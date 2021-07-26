package com.edu.demo.case5;

import java.util.Queue;

/**
 * @Author liu.xiaojian
 * @Date 2021-07-22 13:50
 */
public class PriorityQueue {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights == null || heights.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new java.util.PriorityQueue<>((v1, v2) -> v2 - v1);

        int queueCount = 0;
        int index = 0;
        int beforeHeight = heights[0];

        for (int i = 1; i < heights.length; i++) {
            final int currentHeight = heights[i];
            if (beforeHeight >= currentHeight) {
                index = i;
            } else {
                final int delta = currentHeight - beforeHeight;
                queue.offer(delta);
                queueCount += delta;

                while (queueCount > bricks && ladders > 0) {
                    queueCount -= queue.peek();
                    queue.poll();
                    ladders--;
                }

                if (queueCount <= bricks) {
                    index = i;
                } else {
                    break;
                }
            }
            beforeHeight = currentHeight;
        }
        return index;
    }

    public int[] getLeastNumbers(int[] array, int k) {
        if (k <= 0 || array == null || array.length == 0) {
            return new int[0];
        }
        Queue<Integer> queue = new java.util.PriorityQueue<>((v1, v2) -> v2 - v1);

        for (int element : array) {
            queue.offer(element);
            while (queue.size() > k) {
                queue.poll();
            }
        }

        int[] results = new int[k];
        int index = 0;
        while (queue.size() > 0) {
            results[index++] = queue.poll();
        }
        return results;
    }

    public static void main(String[] args) {
        /*int[] A = {9, 2, 34, 2, 6, 3, 7};
        PriorityQueue queue = new PriorityQueue();
        int[] leastNumbers = queue.getLeastNumbers(A, 3);
        System.out.println(Arrays.toString(leastNumbers));*/

        PriorityQueue queue = new PriorityQueue();
        int[] B = {3, 1, 2, 6, 20, 10, 20};
        int index = queue.furthestBuilding(B, 5, 1);
        System.out.println(index);
    }

}
