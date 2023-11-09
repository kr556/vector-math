package org.liner.main.vector;

import org.liner.main.Array;
import org.liner.main.VMLinearNumber;
import org.liner.main.matrix.VectorMatrix;

public sealed interface Vector<E extends Number, V extends Vector<E, V> & Array<E>>
        extends VMLinearNumber<E, V>, VectorFunctions<V>
        permits AbsVector, VScalar {
    int dimensional();

    default void map(VectorForEach<E> map) {
        for (int i = 0; i < dimensional(); i++) {
            set(i, map.set(i));
        }
    }

    interface VectorForEach<E> {
        E set(int i);
    }
}
