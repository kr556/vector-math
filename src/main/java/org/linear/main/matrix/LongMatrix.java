package org.linear.main.matrix;

import org.linear.main.ArithmeticLong;
import org.linear.main.ArrayLong;
import org.liner.annotation.Final;

import java.nio.Buffer;
import java.nio.LongBuffer;

public interface LongMatrix<V extends LongMatrix<V, TRNS>, TRNS extends LongMatrix<TRNS, V>>
        extends Matrix<Long, V, TRNS>, ArithmeticLong<V>, ArrayLong {
    @Override
    default long[] toNewArray() {
        return toArray(new long[elementsSize()]);
    }

    @Override
    LongBuffer get(int offset, Buffer pointer);
}
