package com.artem.bst_sprint.dsa;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeService {

    // parses users input (string into list of integers)
    public List<Integer> parseInput(String input) {
        List<Integer> result = new ArrayList<>();

        if (input == null || input.isBlank()) {
            return result;
        }

        String[] parts = input.split(",");

        for (String p : parts) {
            String trimmed = p.trim();
            if (!trimmed.isEmpty()) {
                int number = Integer.parseInt(trimmed);
                result.add(number);
            }
        }

        return result;
    }

    // inserts values into a BST
    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.getValue()) {
            root.setLeft(insert(root.getLeft(), value));
        } else {
            root.setRight(insert(root.getRight(), value));
        }

        return root;
    }

    // builds an entire BST from a list of numbers
    public TreeNode buildTree(List<Integer> numbers) {
        TreeNode root = null;

        for (int num : numbers) {
            root = insert(root, num);
        }

        return root;
    }
}