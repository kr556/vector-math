package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.DoubleValue;

import java.nio.Buffer;
import java.nio.DoubleBuffer;

import static java.lang.Math.sqrt;

public class Vector2Funcd extends FunctionVector.DoubleFunctionVector<Vector2Funcd, Vector2d> {
    public static final Vector2Funcd NAN = new Vector2Funcd(
            () -> Double.NaN,
            () -> Double.NaN);

    public DoubleValue x, y;

    public Vector2Funcd() {}

    public Vector2Funcd(Vector2d applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y);
    }

    public Vector2Funcd(DoubleValue all) {
        this(all, all);
    }

    public Vector2Funcd(Vector2Funcd copy) {
        set(copy);
    }

    public Vector2Funcd(DoubleValue x, DoubleValue y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Double get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Double value) {
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
    public boolean equals(@NotNull Vector2Funcd value) {
        return (this.x.val() == value.x.val() &&
                this.y.val() == value.y.val());
    }

    @Override
    public final boolean isNaN() {
        return Double.isNaN(x.val()) && Double.isNaN(y.val());
    }

    @Override
    public final int dimension() {
        return 2;
    }

    @Override
    public double distance(Vector2Funcd value) {
        return VectorUtils.distance(x.val(), value.x.val(), y.val(), value.y.val());
    }

    @Override
    public double len() {
        return VectorUtils.len(x.val(), y.val());
    }

    @Override
    public double angle(Vector2Funcd value) {
        return VectorUtils.angle(x.val(), value.x.val(), y.val(), value.y.val());
    }

    @Override
    public double dot(Vector2Funcd value) {
        return VectorUtils.dot(x.val(), value.x.val(), y.val(), value.y.val());
    }

    @Override
    public Vector2Funcd normalize() {
        final double l = len();
        DoubleValue fx = this.x;
        DoubleValue fy = this.y;
        this.x = () -> fx.val() / l;
        this.y = () -> fy.val() / l;
        return this;
    }

    @Override
    public Vector2Funcd normalize(Vector2Funcd pointer) {
        final double l = len();
        pointer.set(
                () -> this.x.val() / l,
                () -> this.y.val() / l);
        return pointer;
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((DoubleBuffer) pointer).put(0, this.x.val());
        ((DoubleBuffer) pointer).put(1, this.y.val());
        return pointer;
    }

    @Override
    public Double[] toArray(Double[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        return pointer;
    }

    public void set(DoubleValue x, DoubleValue y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Double[] toArray() {
        return new Double[]{
                this.x.val(),
                this.y.val()};
    }

    @Override
    public void set(Vector2Funcd copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    @Override
    public Vector2Funcd clone() {
        return new Vector2Funcd(this);
    }

    @Override
    public double[] toArray(double[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        return pointer;
    }

    @Override
    public Vector2d createPrimitive() {
        return new Vector2d(x.val(), y.val());
    }

    @Override
    public Vector2d toPrimitive(Vector2d pointer) {
        pointer.set(x.val(), y.val());
        return pointer;
    }

    @Override
    public DoubleValue[] toFunctionArray(DoubleValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        return pointer;
    }
}
