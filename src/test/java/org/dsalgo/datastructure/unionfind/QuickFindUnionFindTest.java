package org.dsalgo.datastructure.unionfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class QuickFindUnionFindTest {

    private UnionFind<Integer> unionFind;

    @Test
    void testUnionFindOperation() {
        List<Integer> objects = List.of(1,2,3,4,5,6,7,8,9);
        unionFind = UnionFind.getQuickFindVariant(objects);
        unionFind.union(1,9);
        Assertions.assertFalse(unionFind.connected(1,2), "1 and 2 should not be connected");
        Assertions.assertTrue(unionFind.connected(1,9), "1 and 9 should be connected");
        unionFind.union(1,2);
        Assertions.assertTrue(unionFind.connected(1,2), "1 and 2 should be connected");
        Assertions.assertTrue(unionFind.connected(2,9), "2, 9 should be connected transitively");

        Assertions.assertThrows(IllegalArgumentException.class, () -> unionFind.union(1, 15));
        Assertions.assertThrows(IllegalArgumentException.class, () -> unionFind.connected(1, 16));
    }

}
