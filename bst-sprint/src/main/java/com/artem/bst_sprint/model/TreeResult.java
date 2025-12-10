package com.artem.bst_sprint.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TreeResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // user input, e.g. "2, 1, 4, 3, 5"
    @Column(nullable = false, length = 500)
    private String numbersInput;

    // JSON string of the tree
    @Column(nullable = false, length = 4000)
    private String jsonTree;

    // timestamp
    private LocalDateTime createdAt;

    public TreeResult() {
    }

    public TreeResult(String numbersInput, String jsonTree) {
        this.numbersInput = numbersInput;
        this.jsonTree = jsonTree;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getNumbersInput() {
        return numbersInput;
    }

    public void setNumbersInput(String numbersInput) {
        this.numbersInput = numbersInput;
    }

    public String getJsonTree() {
        return jsonTree;
    }

    public void setJsonTree(String jsonTree) {
        this.jsonTree = jsonTree;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}