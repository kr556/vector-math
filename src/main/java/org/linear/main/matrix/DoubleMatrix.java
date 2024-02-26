package org.linear.main.matrix;

import org.linear.main.ArithmeticDouble;
import org.linear.main.ArrayDouble;
import org.liner.annotation.Final;

public interface DoubleMatrix<V extends DoubleMatrix<V, TRNS>, TRNS extends DoubleMatrix<TRNS, V>>
        extends Matrix<Double, V, TRNS>, ArithmeticDouble<V>, ArrayDouble {
    @Override
    default double[] toNewArray() {
        return toArray(new double[elementsSize()]);
    }

    @Override
    default Class<?> getElementClass() {
        return double.class;
    }
}
