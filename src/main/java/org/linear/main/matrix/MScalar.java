package org.linear.main.matrix;

import org.jetbrains.annotations.NotNull;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;
import org.linear.main.Scalar;

import java.util.Objects;

public final class MScalar<E extends Number> extends Number implements Scalar<E>, Matrix<E, MScalar<E>, MScalar<E>> {
    public E x;

    public MScalar(E value) {
        this.x = value;
    }

    @Override
    public E value() {
        return x;
    }

    @Override
    public E set(E value) {
        this.x = value;
        return x;
    }

    @Override
    public E get(int index) {
        if (index == 1) {
            return x;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public E[] toArray() {
        return (E[]) new Number[]{x};
    }

    @Override
    public void set(MScalar<E> copy) {
        this.x = copy.x;
    }

    @PropertiesMethod
    @Override
    public boolean isScalar() {
        return true;
    }

    @Override
    public boolean equals(@NotNull MScalar<E> value) {
        return Objects.equals(value.x, this.x);
    }

    @Override
    public boolean isNaN() {
        if (x instanceof Float) {
            return ((Float) x).isNaN();
        } else if (x instanceof Double) {
            return ((Double) x).isNaN();
        } else {
            return false;
        }
    }

    @PropertiesMethod
    @Override
    public boolean isSquare() {
        return true;
    }

    @Override
    public int elementsSize() {
        return 1;
    }

    @Override
    public MScalar<E> clone() {
        return (MScalar<E>) new MScalar<>(0);
    }

    @Override
    public MScalar<E> create() {
        return new MScalar<>(x);
    }

    @PropertiesMethod
    @Override
    public int columnDimension() {
        return 1;
    }

    @PropertiesMethod
    @Override
    public int rowDimension() {
        return 1;
    }

    @Final
    @Override
    public E[] getRow(int index) {
        return (E[]) new Number[]{x};
    }

    @Final
    @Override
    public E[] getColumn(int index) {
        return (E[]) new Number[]{x};
    }

    @Final
    @Override
    public void set(int r, int c, E value) {
        if (r == 0 && c == 0) {
            this.x = value;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public int intValue() {
        return x.intValue();
    }

    @Override
    public long longValue() {
        return x.longValue();
    }

    @Override
    public float floatValue() {
        return x.floatValue();
    }

    @Override
    public double doubleValue() {
        return x.doubleValue();
    }

    @Override
    public Class<?> getElementClass() {
        return x.getClass();
    }
}
