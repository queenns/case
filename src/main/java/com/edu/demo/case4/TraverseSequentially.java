package com.edu.demo.case4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 有序遍历
 *
 * @Author liu.xiaojian
 * @Date 2021-07-20 10:24
 */
public class TraverseSequentially {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 10;

        TreeNode left1 = new TreeNode();
        left1.val = 8;

        TreeNode right1 = new TreeNode();
        right1.val = 9;

        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode();
        left2.val = 6;

        TreeNode right2 = new TreeNode();
        right2.val = 7;

        left1.left = left2;
        left1.right = right2;

        TreeNode left3 = new TreeNode();
        left3.val = 10;

        TreeNode right3 = new TreeNode();
        right3.val = 11;

        left2.left = left3;
        left2.right = right3;

        List<List<Integer>> results = levelOrder(root);
        System.out.println(results);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        List<List<Integer>> results = new LinkedList<>();

        while (queue.size() > 0) {
            final int size = queue.size();
            List<Integer> linked = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                linked.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            results.add(linked);
        }

        return results;
    }

}
