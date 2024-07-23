package org.linear.main.vector;

import org.linear.main.ArithmeticLong;
import org.linear.main.ArrayLong;

import java.nio.Buffer;
import java.nio.LongBuffer;

public interface LongVector<V extends LongVector<V>>
        extends Vector<Long, V>, ArithmeticLong<V>, ArrayLong {

    @Override
    default long[] toNewArray() {
        return toArray(new long[dimension()]);
    }

    @Override
    LongBuffer get(int offset, Buffer pointer);
}
