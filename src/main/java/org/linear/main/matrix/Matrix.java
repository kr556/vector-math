package org.linear.main.matrix;

import org.jetbrains.annotations.NotNull;
import org.linear.main.vector.*;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;
import org.linear.main.Linear;

import java.nio.Buffer;
import java.util.Arrays;

/**
 * @param <E>    Elements type.
 * @param <V>    Mine type
 * @param <TRNS> Transposed matrix type.
 */
public interface Matrix<E extends Number, V extends Matrix<E, V, TRNS>, TRNS extends Matrix<E, TRNS, V>>
        extends Linear<E, V> {
    V create();

    /**
     * Get dimension of a column of this matrix.
     * For example, its matrix a column dimension is 3.
     * <pre>
     *     [C00, C01]
     *     [C10, C11]
     *     [C20, C21]
     * </pre>
     * @return A column dimension.
     */
    @PropertiesMethod
    int columnDimension();

    /**
     * Get dimension of a row of this matrix.
     * For example, its matrix a row dimension is 2.
     * <pre>
     *     [C00, C01]
     *     [C10, C11]
     *     [C20, C21]
     * </pre>
     * @return A row dimension.
     */
    @PropertiesMethod
    int rowDimension();

    @Final
    E[] getRow(int index);

    @Final
    E[] getColumn(int index);

    @Final
    void set(int r, int c, E value);

    @PropertiesMethod
    boolean isSquare();

    @PropertiesMethod
    default boolean isVector() {
        return false;
    }

    @PropertiesMethod
    int elementsSize();

    @Final
    @Override
    default E[] toArray(E[] pointer) {
        if (pointer == null) return null;

        for (int i = 0; i < elementsSize(); i++) {
            pointer[i] = get(i);
        }

        return pointer;
    }

    @Final
    @Override
    default Buffer get(Buffer pointer) {
        E[] es = toArray();

        // TODO
//        System.out.println(Arrays.toString(es));
        return null;
    }

    @Override
    default void set(int index, @NotNull E value) {
        int rows = index / columnDimension();
        set(rows, index - rowDimension() * rows, value);
    }

    @FunctionalInterface
    interface MatrixElementMapper<E> {
        E set(int row, int column, E element);
    }

    @FunctionalInterface
    interface MatrixMapper<E> {
        E set(int row, int column);
    }
}
