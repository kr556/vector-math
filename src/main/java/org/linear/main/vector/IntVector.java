package org.linear.main.vector;

import org.linear.main.ArithmeticInt;
import org.linear.main.ArrayInt;

import java.nio.Buffer;
import java.nio.IntBuffer;

public interface IntVector<V extends IntVector<V>>
        extends Vector<Integer, V>, ArithmeticInt<V>, ArrayInt {
    @Override
    default int[] toNewArray() {
        return toArray(new int[dimension()]);
    }

    @Override
    IntBuffer get(int offset, Buffer pointer);
}
