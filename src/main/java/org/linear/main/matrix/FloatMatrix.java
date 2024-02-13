package org.linear.main.matrix;

import org.linear.main.ArithmeticFloat;
import org.linear.main.ArrayFloat;
import org.liner.annotation.Final;

public interface FloatMatrix<V extends FloatMatrix<V, TRNS>, TRNS extends FloatMatrix<TRNS, V>>
        extends Matrix<Float, V, TRNS>, ArithmeticFloat<V>, ArrayFloat {
    @Override
    default float[] toNewArray() {
        return toArray(new float[elementsSize()]);
    }
}
