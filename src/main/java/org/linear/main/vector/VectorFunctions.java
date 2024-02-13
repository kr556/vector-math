package org.linear.main.vector;

import org.linear.main.Arithmetic;

public interface VectorFunctions<E extends Number, V extends Vector<E, V> & Arithmetic<E, V> & VectorFunctions<E, V>> {
    double distance(V value);

    double len();

    double angle(V value);

    double dot(V value);

    default V cross(V value) {
        throw new UnsupportedOperationException();
    }

    default V cross(V value, V pointer) {
        pointer.set((V) this);
        return pointer.cross(value);
    }

    V normalize();

    V normalize(V pointer);
}
