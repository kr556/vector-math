package org.linear.main.vector;

import org.linear.main.ArithmeticDouble;
import org.linear.main.ArrayDouble;

public interface DoubleVector<V extends DoubleVector<V>>
        extends Vector<Double, V>, ArithmeticDouble<V>, ArrayDouble {
    @Override
    default double[] toNewArray() {
        return toArray(new double[dimension()]);
    }

    @Override
    default Class<?> getElementClass() {
        return double.class;
    }
}
