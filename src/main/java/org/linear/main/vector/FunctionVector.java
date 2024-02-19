package org.linear.main.vector;

import org.linear.main.*;
import org.linear.main.value.*;

/**
 * @param <E> The Primitive value type of elements.
 * @param <F> The Functions tyoe of elements.
 * @param <V> This type.
 * @param <VAL> A type of Vector with primitive values corresponding to this.
 */
public abstract class FunctionVector<E extends Number, F extends FunctionValue, V extends FunctionVector<E, F, V, VAL>, VAL extends Vector<E, VAL> & VectorFunctions<E, VAL> & Arithmetic<E, VAL>>
        implements Vector<E, V>, VectorFunctions<E, V> {
    public abstract VAL createPrimitive();
    public abstract VAL toPrimitive(VAL pointer);

    public abstract F[] toFunctionArray(F[] pointer);

    public F[] toFunctionArray() {
        return (F[]) new FunctionValue[dimension()];
    }

    @Override
    public String toString() {
        E[] a = toArray();
        if (a == null) return "null";

        int iMax = a.length - 1;
        if (iMax == -1) return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append('}').toString();
            b.append(", ");
        }
    }

    public static abstract class FloatFunctionVector<V extends FloatFunctionVector<V, VAL>, VAL extends FloatVector<VAL> & VectorFunctions<Float, VAL> & ArithmeticFloat<VAL>>
            extends FunctionVector<Float, FloatValue,  V, VAL> implements ArrayFloat {
        @Override
        public float[] toNewArray() {
            return toArray(new float[dimension()]);
        }
    }

    public static abstract class DoubleFunctionVector<V extends DoubleFunctionVector<V, VAL>, VAL extends DoubleVector<VAL> & VectorFunctions<Double, VAL> & ArithmeticDouble<VAL>>
            extends FunctionVector<Double, DoubleValue, V, VAL> implements ArrayDouble {
        @Override
        public double[] toNewArray() {
            return toArray(new double[dimension()]);
        }
    }

    public static abstract class IntFunctionVector<V extends IntFunctionVector<V, VAL>, VAL extends IntVector<VAL> & VectorFunctions<Integer, VAL> & ArithmeticInt<VAL>>
            extends FunctionVector<Integer, IntValue, V, VAL> implements ArrayInt {
        @Override
        public int[] toNewArray() {
            return toArray(new int[dimension()]);
        }
    }

    public static abstract class LongFunctionVector<V extends LongFunctionVector<V, VAL>, VAL extends LongVector<VAL> & VectorFunctions<Long, VAL> & ArithmeticLong<VAL>>
            extends FunctionVector<Long, LongValue, V, VAL> implements ArrayLong {
        @Override
        public long[] toNewArray() {
            return toArray(new long[dimension()]);
        }
    }
}
