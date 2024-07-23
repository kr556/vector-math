package org.linear.main.matrix;

import org.linear.main.ArithmeticFloat;
import org.linear.main.ArrayFloat;
import org.liner.annotation.Final;

import java.nio.Buffer;
import java.nio.FloatBuffer;

public interface FloatMatrix<V extends FloatMatrix<V, TRNS>, TRNS extends FloatMatrix<TRNS, V>>
        extends Matrix<Float, V, TRNS>, ArithmeticFloat<V>, ArrayFloat {
    @Override
    default float[] toNewArray() {
        return toArray(new float[elementsSize()]);
    }

    @Override
    FloatBuffer get(int offset, Buffer pointer);
}
