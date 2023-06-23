package org.dsalgo.datastructure.unionfind;

import java.util.HashMap;
import java.util.Map;

public class UnionFindVariants {

    /**
     * This variant of Union Find  have O(n) complexity for each union operation, O(1) complexity of each connected operation
     * O(n) complexity for Creating a Union Find Structure
     * @param <T>
     */
    static class QuickFindVariant<T> implements UnionFind<T> {

        private final int [] indexArray;
        private final Map<T, Integer> objectKeyIndex;

        public QuickFindVariant(Iterable<T> theObjects) {
            objectKeyIndex = new HashMap<>();
            int index = 0;
            for(var t: theObjects) {
                objectKeyIndex.put(t, index++);
            }
            indexArray = new int[index];

            for(int i =0; i < index; i++) {
                indexArray[i] = i;
            }
        }

        @Override
        public void union(T p, T q) {
            var pIndex = objectKeyIndex.get(p);
            var qIndex = objectKeyIndex.get(q);
            if(pIndex == null || qIndex == null) throw new IllegalArgumentException("Either p or q is not present in the original elements");
            int pParent = indexArray[pIndex];
            int qParent = indexArray[qIndex];
            indexArray[pIndex] = qParent;
            for(int i = 0; i < indexArray.length; i++) {
                if(indexArray[i] == pParent) indexArray[i] = qParent;
            }
        }

        @Override
        public boolean connected(T p, T q) {
            var pIndex = objectKeyIndex.get(p);
            var qIndex = objectKeyIndex.get(q);
            if(pIndex == null || qIndex == null) throw new IllegalArgumentException("Either p or q is not present in the original elements");
            return indexArray[pIndex] == indexArray[qIndex];
        }
    }
}
