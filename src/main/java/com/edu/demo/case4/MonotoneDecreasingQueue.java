package com.edu.demo.case4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单调递减队列
 *
 * @Author liu.xiaojian
 * @Date 2021-07-20 11:44
 */
public class MonotoneDecreasingQueue {

    private ArrayDeque<Integer> queue = new ArrayDeque<>();

    public void push(int val) {
        while (!queue.isEmpty() && queue.getLast() < val) {
            queue.removeLast();
        }
        queue.addLast(val);
    }

    public void pop(int val) {
        if (!queue.isEmpty() && queue.getFirst() == val) {
            queue.removeFirst();
        }
    }

    public int[] maxSlideWindow(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            push(nums[i]);
            if (i < (k - 1)) {
                continue;
            }
            results.add(queue.getFirst());
            pop(nums[i - k + 1]);
        }
        return results.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int maxResult(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return 0;
        }

        final int length = array.length;
        int[] tmps = new int[length];

        MonotoneDecreasingQueue queue = new MonotoneDecreasingQueue();

        for (int i = 0; i < length; i++) {
            if (i - k > 0) {
                queue.pop(tmps[i - k - 1]);
            }

            int old = queue.queue.isEmpty() ? 0 : queue.queue.getFirst();
            tmps[i] = old + array[i];

            queue.push(tmps[i]);
        }

        return tmps[length - 1];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, -99, -1000, 1, 4};
        MonotoneDecreasingQueue queue = new MonotoneDecreasingQueue();
        int[] maxs = queue.maxSlideWindow(array, 3);
        System.out.println(Arrays.toString(maxs));

        int[] moneys = new int[]{1, -1, -100, -1000, 100, 3};
        int max = queue.maxResult(moneys, 2);
        System.out.println(max);
    }

}
