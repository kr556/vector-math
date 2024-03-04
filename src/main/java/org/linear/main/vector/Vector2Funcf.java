package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.FloatValue;

import java.nio.Buffer;
import java.nio.FloatBuffer;

import static java.lang.Math.sqrt;

public class Vector2Funcf extends FunctionVector.FloatFunctionVector<Vector2Funcf, Vector2f> {
    public static final Vector2Funcf NAN = new Vector2Funcf(
            () -> Float.NaN,
            () -> Float.NaN);

    public FloatValue x, y;

    public Vector2Funcf() {}

    public Vector2Funcf(Vector2f applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y);
    }

    public Vector2Funcf(FloatValue all) {
        this(all, all);
    }

    public Vector2Funcf(Vector2Funcf copy) {
        set(copy);
    }

    public Vector2Funcf(FloatValue x, FloatValue y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Float value) {
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
    public boolean equals(@NotNull Vector2Funcf value) {
        return (this.x.val() == value.x.val() &&
                this.y.val() == value.y.val());
    }

    @Override
    public final boolean isNaN() {
        return Float.isNaN(x.val()) && Float.isNaN(y.val());
    }

    @Override
    public final int dimension() {
        return 2;
    }

    @Override
    public double distance(Vector2Funcf value) {
        return VectorUtils.distance(x.val(), value.x.val(), y.val(), value.y.val());
    }

    @Override
    public double len() {
        return VectorUtils.len(x.val(), y.val());
    }

    @Override
    public double angle(Vector2Funcf value) {
        return VectorUtils.angle(x.val(), value.x.val(),
                y.val(), value.y.val());
    }

    @Override
    public double dot(Vector2Funcf value) {
        return VectorUtils.dot(x.val(), value.x.val(),
                y.val(), value.y.val());
    }

    @Override
    public Vector2Funcf normalize() {
        final float l = (float) len();
        FloatValue fx = this.x;
        FloatValue fy = this.y;
        this.x = () -> fx.val() / l;
        this.y = () -> fy.val() / l;
        return this;
    }

    @Override
    public Vector2Funcf normalize(Vector2Funcf pointer) {
        final float l = (float) len();
        pointer.set(
                () -> this.x.val() / l,
                () -> this.y.val() / l);
        return pointer;
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((FloatBuffer) pointer).put(0, this.x.val());
        ((FloatBuffer) pointer).put(1, this.y.val());
        return pointer;
    }

    @Override
    public Float[] toArray(Float[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        return pointer;
    }

    public void set(FloatValue x, FloatValue y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Float[] toArray() {
        return new Float[]{
                this.x.val(),
                this.y.val()};
    }

    @Override
    public void set(Vector2Funcf copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    @Override
    public Vector2Funcf clone() {
        return new Vector2Funcf(this);
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        return pointer;
    }

    @Override
    public float[] copy(int destPos, float[] pointer) {
        pointer[destPos] = this.x.val();
        pointer[1 + destPos] = this.y.val();
        return pointer;
    }

    @Override
    public Vector2f createPrimitive() {
        return new Vector2f(x.val(), y.val());
    }

    @Override
    public Vector2f toPrimitive(Vector2f pointer) {
        pointer.set(x.val(), y.val());
        return pointer;
    }

    @Override
    public FloatValue[] toFunctionArray(FloatValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        return pointer;
    }
}
