package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.DoubleValue;

import java.nio.Buffer;
import java.nio.DoubleBuffer;

public class Vector4Funcd extends FunctionVector.DoubleFunctionVector<Vector4Funcd, Vector4d> {
    public static Vector4Funcd NAN = new Vector4Funcd(() -> Double.NaN);

    public DoubleValue x, y, z, w;

    public Vector4Funcd() {}

    public Vector4Funcd(Vector4d applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y, () -> applyToFunc.z, () -> applyToFunc.w);
    }

    public Vector4Funcd(DoubleValue all) {
        this(all, all, all, all);
    }

    public Vector4Funcd(Vector4Funcd copy) {
        set(copy);
    }

    public Vector4Funcd(DoubleValue x, DoubleValue y, DoubleValue z, DoubleValue w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Double get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            case 2 -> z.val();
            case 3 -> w.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Double value) {
        switch (index) {
            case 0 -> this.x = () -> value;
            case 1 -> this.y = () -> value;
            case 2 -> this.z = () -> value;
            case 3 -> this.w = () -> value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean isScalar() {
        return false;
    }

    @Override
    public boolean equals(@NotNull Vector4Funcd value) {
        return (this.x.val() == value.x.val() &&
                this.y.val() == value.y.val() &&
                this.z.val() == value.z.val() &&
                this.w.val() == value.w.val());
    }

    @Override
    public final boolean isNaN() {
        return equals(NAN);
    }

    @Override
    public final int dimension() {
        return 4;
    }

    @Override
    public double distance(Vector4Funcd value) {
        return VectorUtils.distance(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val(),
                w.val(), value.w.val());
    }

    @Override
    public double len() {
        return VectorUtils.len(x.val(), y.val(), z.val(), w.val());
    }

    @Override
    public double angle(Vector4Funcd value) {
        return VectorUtils.angle(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val(),
                w.val(), value.w.val());
    }

    @Override
    public double dot(Vector4Funcd value) {
        return VectorUtils.dot(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val(),
                w.val(), value.w.val());
    }

    @Override
    public Vector4Funcd normalize() {
        final double l = len();
        DoubleValue fx = this.x;
        DoubleValue fy = this.y;
        DoubleValue fz = this.z;
        DoubleValue fw = this.w;
        this.x = () -> fx.val() / l;
        this.y = () -> fy.val() / l;
        this.z = () -> fz.val() / l;
        this.w = () -> fw.val() / l;
        return this;
    }

    @Override
    public Vector4Funcd normalize(Vector4Funcd pointer) {
        final double l = len();
        pointer.set(
                () -> this.x.val() / l,
                () -> this.y.val() / l,
                () -> this.z.val() / l,
                () -> this.w.val() / l);
        return pointer;
    }

    @Override
    public DoubleBuffer get(Buffer pointer) {
        DoubleBuffer re = (DoubleBuffer) pointer;
        re.put(0, this.x.val());
        re.put(1, this.y.val());
        re.put(2, this.z.val());
        re.put(3, this.w.val());
        return re;
    }

    @Override
    public Double[] toArray(Double[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        pointer[3] = this.w.val();
        return pointer;
    }

    public void set(DoubleValue x, DoubleValue y, DoubleValue z, DoubleValue w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Double[] toArray() {
        return new Double[]{
                this.x.val(),
                this.y.val(),
                this.z.val(),
                this.w.val()};
    }

    @Override
    public void set(Vector4Funcd copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
        this.w = copy.w;
    }

    @Override
    public Vector4Funcd clone() {
        return new Vector4Funcd(this);
    }

    @Override
    public double[] toArray(double[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        pointer[3] = this.w.val();
        return pointer;
    }

    @Override
    public double[] copy(int destPos, double[] pointer) {
        pointer[destPos] = this.x.val();
        pointer[1 + destPos] = this.y.val();
        pointer[2 + destPos] = this.z.val();
        pointer[3 + destPos] = this.w.val();
        return pointer;
    }

    @Override
    public Vector4d createPrimitive() {
        return new Vector4d(x.val(), y.val(), z.val(), w.val());
    }

    @Override
    public Vector4d toPrimitive(Vector4d pointer) {
        pointer.set(x.val(), y.val(), z.val(), w.val());
        return pointer;
    }

    @Override
    public DoubleValue[] toFunctionArray(DoubleValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        pointer[2] = z;
        pointer[3] = w;
        return pointer;
    }
}
