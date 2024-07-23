package org.linear.main.vector;

import org.linear.main.ArithmeticFloat;
import org.linear.main.ArrayFloat;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public interface FloatVector<V extends FloatVector<V>>
        extends Vector<Float, V>, ArithmeticFloat<V>, ArrayFloat {
    @Override
    default float[] toNewArray() {
        return toArray(new float[dimension()]);
    }

    @Override
    FloatBuffer get(int offset, Buffer pointer);
}
