package org.linear.main.matrix;

import org.linear.main.ArithmeticDouble;
import org.linear.main.ArrayDouble;
import org.liner.annotation.Final;

import java.nio.Buffer;
import java.nio.DoubleBuffer;

public interface DoubleMatrix<V extends DoubleMatrix<V, TRNS>, TRNS extends DoubleMatrix<TRNS, V>>
        extends Matrix<Double, V, TRNS>, ArithmeticDouble<V>, ArrayDouble {
    @Override
    default double[] toNewArray() {
        return toArray(new double[elementsSize()]);
    }

    @Override
    DoubleBuffer get(int offset, Buffer pointer);
}
