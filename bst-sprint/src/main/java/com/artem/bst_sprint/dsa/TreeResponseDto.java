package com.artem.bst_sprint.dsa;

public class TreeResponseDto {

    private TreeNodeDto root;

    public TreeResponseDto() {
    }

    public TreeResponseDto(TreeNodeDto root) {
        this.root = root;
    }

    public TreeNodeDto getRoot() {
        return root;
    }

    public void setRoot(TreeNodeDto root) {
        this.root = root;
    }
}