package org.linear.main.matrix;

import org.linear.main.Arithmetic;
import org.linear.main.Linear;

public interface MatrixFunctions<E extends Number, V extends MatrixFunctions<E, V, TRNS>, TRNS extends MatrixFunctions<E, TRNS, V>>
        extends Linear<E, V>, Arithmetic<E, V> {
    E get(int r, int c);

    TRNS transpose();

    default TRNS transpose(TRNS pointer) {
        pointer.set((TRNS) this);
        return (TRNS) pointer.transpose();
    }
}
