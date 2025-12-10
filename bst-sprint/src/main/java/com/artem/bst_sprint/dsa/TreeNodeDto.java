package com.artem.bst_sprint.dsa;

public class TreeNodeDto {

    private int value;
    private TreeNodeDto left;
    private TreeNodeDto right;

    public TreeNodeDto() {
    }

    public TreeNodeDto(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNodeDto getLeft() {
        return left;
    }

    public void setLeft(TreeNodeDto left) {
        this.left = left;
    }

    public TreeNodeDto getRight() {
        return right;
    }

    public void setRight(TreeNodeDto right) {
        this.right = right;
    }
}