package org.linear.main.matrix;

import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;

public abstract class SquareMatrix<E extends Number, V extends SquareMatrix<E, V>>
        extends PrimitiveMatrix<E, V, V> {
    @Final
    public abstract double determinant();

    public V invert() {
        double det = determinant();
        if (det != 0) {
            return cofactor().mul(1 / det);
        }

        return null;
    }

    public abstract V cofactor();

    public V cofactor(V pointer) {
        pointer.set((V) this);

        return pointer.cofactor();
    }

    @Override
    public V add(V value, V pointer) {
        pointer.set((V) this);
        return add(value);
    }

    @Override
    public V sub(V value, V pointer) {
        pointer.set((V) this);
        return pointer.sub(value);
    }

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

    public V invert(V pointer) {
        pointer.set((V) this);
        pointer.invert();
        return pointer;
    }

    public abstract V mulC(V value);

    public V mulC(V value, V pointer) {
        pointer.set((V) this);
        pointer.mulC(value);
        return pointer;
    }

    public abstract V mulR(V value);

    public V mulR(V value, V pointer) {
        pointer.set((V) this);
        pointer.mulR(value);
        return pointer;
    }

    @PropertiesMethod
    public final boolean isSquare() {
        return true;
    }
}
