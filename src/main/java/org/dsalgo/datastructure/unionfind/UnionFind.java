package org.dsalgo.datastructure.unionfind;

import java.util.Collection;

public interface UnionFind<T> {

    void union(T p, T q);
    boolean connected(T p, T q);

    static <T> UnionFind<T> getQuickFindVariant(Collection<T> theObjects) {
        return new UnionFindVariants.QuickFindVariant<>(theObjects);
    }

}
