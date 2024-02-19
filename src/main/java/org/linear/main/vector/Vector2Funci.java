package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.IntValue;

import java.nio.Buffer;
import java.nio.IntBuffer;

public class Vector2Funci extends FunctionVector.IntFunctionVector<Vector2Funci, Vector2i> {
    public IntValue x, y;

    public Vector2Funci() {}

    public Vector2Funci(Vector2i applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y);
    }

    public Vector2Funci(IntValue all) {
        this(all, all);
    }

    public Vector2Funci(Vector2Funci copy) {
        set(copy);
    }

    public Vector2Funci(IntValue x, IntValue y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Integer value) {
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
    public boolean equals(@NotNull Vector2Funci value) {
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
    public double distance(Vector2Funci value) {
        return VectorUtils.distance(x.val(), value.x.val(), y.val(), value.y.val());
    }

    @Override
    public double len() {
        return VectorUtils.len(x.val(), y.val());
    }

    @Override
    public double angle(Vector2Funci value) {
        return VectorUtils.angle(x.val(), value.x.val(), y.val(), value.y.val());
    }

    @Override
    public double dot(Vector2Funci value) {
        return VectorUtils.dot(x.val(), value.x.val(), y.val(), value.y.val());
    }

    @Override
    public Vector2Funci normalize() {
        final double l = len();
        IntValue fx = this.x;
        IntValue fy = this.y;
        this.x = () -> (int) (fx.val() / l);
        this.y = () -> (int) (fy.val() / l);
        return this;
    }

    @Override
    public Vector2Funci normalize(Vector2Funci pointer) {
        final double l = len();
        pointer.set(
                () -> (int) (this.x.val() / l),
                () -> (int) (this.y.val() / l));
        return pointer;
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((IntBuffer) pointer).put(0, this.x.val());
        ((IntBuffer) pointer).put(1, this.y.val());
        return pointer;
    }

    @Override
    public Integer[] toArray(Integer[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        return pointer;
    }

    public void set(IntValue x, IntValue y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer[] toArray() {
        return new Integer[]{
                this.x.val(),
                this.y.val()};
    }

    @Override
    public void set(Vector2Funci copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    @Override
    public Vector2Funci clone() {
        return new Vector2Funci(this);
    }

    @Override
    public int[] toArray(int[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        return pointer;
    }

    @Override
    public Vector2i createPrimitive() {
        return new Vector2i(x.val(), y.val());
    }

    @Override
    public Vector2i toPrimitive(Vector2i pointer) {
        pointer.set(x.val(), y.val());
        return pointer;
    }

    @Override
    public IntValue[] toFunctionArray(IntValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        return pointer;
    }
}
