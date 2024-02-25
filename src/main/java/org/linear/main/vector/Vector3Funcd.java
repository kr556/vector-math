package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.DoubleValue;

import java.nio.Buffer;
import java.nio.DoubleBuffer;

public class Vector3Funcd extends FunctionVector.DoubleFunctionVector<Vector3Funcd, Vector3d> {
    public static Vector3Funcd NAN = new Vector3Funcd(() -> Double.NaN);

    public DoubleValue x, y, z;

    public Vector3Funcd() {}

    public Vector3Funcd(Vector3d applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y, () -> applyToFunc.z);
    }

    public Vector3Funcd(DoubleValue all) {
        this(all, all, all);
    }

    public Vector3Funcd(Vector3Funcd copy) {
        set(copy);
    }

    public Vector3Funcd(DoubleValue x, DoubleValue y, DoubleValue z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Double get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            case 2 -> z.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Double value) {
        switch (index) {
            case 0 -> this.x = () -> value;
            case 1 -> this.y = () -> value;
            case 2 -> this.z = () -> value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean isScalar() {
        return false;
    }

    @Override
    public boolean equals(@NotNull Vector3Funcd value) {
        return (this.x.val() == value.x.val() &&
                this.y.val() == value.y.val() &&
                this.z.val() == value.z.val());
    }

    @Override
    public final boolean isNaN() {
        return equals(NAN);
    }

    @Override
    public final int dimension() {
        return 3;
    }

    @Override
    public double distance(Vector3Funcd value) {
        return VectorUtils.distance(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public double len() {
        return VectorUtils.len(x.val(), y.val(), z.val());
    }

    @Override
    public double angle(Vector3Funcd value) {
        return VectorUtils.angle(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public double dot(Vector3Funcd value) {
        return VectorUtils.dot(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public Vector3Funcd normalize() {
        final double l = len();
        DoubleValue fx = this.x;
        DoubleValue fy = this.y;
        DoubleValue fz = this.z;
        this.x = () -> fx.val() / l;
        this.y = () -> fy.val() / l;
        this.z = () -> fz.val() / l;
        return this;
    }

    @Override
    public Vector3Funcd normalize(Vector3Funcd pointer) {
        final double l = len();
        pointer.set(
                () -> this.x.val() / l,
                () -> this.y.val() / l,
                () -> this.z.val() / l);
        return pointer;
    }

    @Override
    public DoubleBuffer get(Buffer pointer) {
        DoubleBuffer re = (DoubleBuffer) pointer;
        re.put(0, this.x.val());
        re.put(1, this.y.val());
        re.put(2, this.z.val());
        return re;
    }

    @Override
    public Double[] toArray(Double[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        return pointer;
    }

    public void set(DoubleValue x, DoubleValue y, DoubleValue z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Double[] toArray() {
        return new Double[]{
                this.x.val(),
                this.y.val(),
                this.z.val()};
    }

    @Override
    public void set(Vector3Funcd copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    @Override
    public Vector3Funcd clone() {
        return new Vector3Funcd(this);
    }

    @Override
    public double[] toArray(double[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        return pointer;
    }

    @Override
    public Vector3d createPrimitive() {
        return new Vector3d(x.val(), y.val(), z.val());
    }

    @Override
    public Vector3d toPrimitive(Vector3d pointer) {
        pointer.set(x.val(), y.val(), z.val());
        return pointer;
    }

    @Override
    public DoubleValue[] toFunctionArray(DoubleValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        pointer[2] = z;
        return pointer;
    }
}
