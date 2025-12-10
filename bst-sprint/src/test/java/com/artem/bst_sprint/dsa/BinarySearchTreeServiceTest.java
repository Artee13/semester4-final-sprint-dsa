package com.artem.bst_sprint.dsa;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeServiceTest {

    private final BinarySearchTreeService service = new BinarySearchTreeService();

    @Test
    void parseInput_parsesCorrectly() {
        List<Integer> numbers = service.parseInput("1, 4,2, 5 , 3");
        assertEquals(List.of(1, 4, 2, 5, 3), numbers);
    }

    @Test
    void buildTree_buildsCorrectStructure() {
        List<Integer> numbers = List.of(2, 1, 4, 3, 5);
        TreeNode root = service.buildTree(numbers);

        assertEquals(2, root.getValue());
        assertEquals(1, root.getLeft().getValue());
        assertEquals(4, root.getRight().getValue());
        assertEquals(3, root.getRight().getLeft().getValue());
        assertEquals(5, root.getRight().getRight().getValue());
    }
}