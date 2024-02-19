package org.linear.main;

import org.linear.main.matrix.Matrix;
import org.linear.main.vector.*;

public final class LinearMath {
    private LinearMath() {}

    public static <E extends Number> boolean canCalculate(Matrix<E, ?, ?> matrix, Vector<E, ?> vector) {
        return matrix.rowDimension() == vector.dimension();
    }

    public static <E extends Number> boolean canCalculate(Vector<E, ?> vector, Matrix<E, ?, ?> matrix) {
        return vector.dimension() == matrix.columnDimension();
    }
}
