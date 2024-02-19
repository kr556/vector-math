package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.LongValue;

import java.nio.Buffer;
import java.nio.LongBuffer;

public class Vector2Funcl extends FunctionVector.LongFunctionVector<Vector2Funcl, Vector2l> {
    public LongValue x, y;

    public Vector2Funcl() {}

    public Vector2Funcl(Vector2l applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y);
    }

    public Vector2Funcl(LongValue all) {
        this(all, all);
    }

    public Vector2Funcl(Vector2Funcl copy) {
        set(copy);
    }

    public Vector2Funcl(LongValue x, LongValue y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Long get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Long value) {
        switch (index) {
            case 0 -> this.x = () -> value;
            case 1 -> this.y = () -> value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean isScalar() {
        return false;
    }

    @Override
    public boolean equals(@NotNull Vector2Funcl value) {
        return (this.x.val() == value.x.val() &&
                this.y.val() == value.y.val());
    }

    @Override
    public final boolean isNaN() {
        return false;
    }

    @Override
    public final int dimension() {
        return 2;
    }

    @Override
    public double distance(Vector2Funcl value) {
        return VectorUtils.distance(x.val(), value.x.val(), y.val(), value.y.val());
    }

    @Override
    public double len() {
        return VectorUtils.len(x.val(), y.val());
    }

    @Override
    public double angle(Vector2Funcl value) {
        return VectorUtils.angle(x.val(), value.x.val(), y.val(), value.y.val());
    }

    @Override
    public double dot(Vector2Funcl value) {
        return VectorUtils.dot(x.val(), value.x.val(), y.val(), value.y.val());
    }

    @Override
    public Vector2Funcl normalize() {
        final double l = len();
        LongValue fx = this.x;
        LongValue fy = this.y;
        this.x = () -> (long) (fx.val() / l);
        this.y = () -> (long) (fy.val() / l);
        return this;
    }

    @Override
    public Vector2Funcl normalize(Vector2Funcl pointer) {
        final double l = len();
        pointer.set(
                () -> (long) (this.x.val() / l),
                () -> (long) (this.y.val() / l));
        return pointer;
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((LongBuffer) pointer).put(0, this.x.val());
        ((LongBuffer) pointer).put(1, this.y.val());
        return pointer;
    }

    @Override
    public Long[] toArray(Long[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        return pointer;
    }

    public void set(LongValue x, LongValue y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Long[] toArray() {
        return new Long[]{
                this.x.val(),
                this.y.val()};
    }

    @Override
    public void set(Vector2Funcl copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    @Override
    public Vector2Funcl clone() {
        return new Vector2Funcl(this);
    }

    @Override
    public long[] toArray(long[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        return pointer;
    }

    @Override
    public Vector2l createPrimitive() {
        return new Vector2l(x.val(), y.val());
    }

    @Override
    public Vector2l toPrimitive(Vector2l pointer) {
        pointer.set(x.val(), y.val());
        return pointer;
    }

    @Override
    public LongValue[] toFunctionArray(LongValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        return pointer;
    }
}
