package org.linear.main.vector;

import org.linear.main.Arithmetic;
import org.liner.annotation.PropertiesMethod;

public abstract class AbsVector<E extends Number, V extends AbsVector<E, V>>
        implements Vector<E, V>, VectorFunctions<V>, Arithmetic<E, V> {
    public AbsVector() {}

    @Override
    public V mul(V value, V pointer) {
        pointer.set((V) this);
        return pointer.mul(value);
    }

    @Override
    public V mul(double value, V pointer) {
        pointer.set((V) this);
        return pointer.mul(value);
    }

    @Override
    public V div(V value, V pointer) {
        pointer.set((V) this);
        return pointer.div(value);
    }

    @Override
    public V div(double value, V pointer) {
        pointer.set((V) this);
        return pointer.div(value);
    }

    @Override
    public String toString() {
        StringBuilder re = new StringBuilder("{");

        E[] es = toArray();
        for (int i = 0; i < es.length; i++) {
            re.append(es[i]);
            if (i != es.length - 1) re.append(", ");
        }

        return re + "}";
    }

    public abstract V clone();

    @PropertiesMethod
    @Override
    public final boolean isScalar() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof AbsVector<?,?>)) return false;
        return this.equals((V)obj);
    }
}
