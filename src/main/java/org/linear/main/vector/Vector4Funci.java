package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.IntValue;

import java.nio.Buffer;
import java.nio.IntBuffer;

public class Vector4Funci extends FunctionVector.IntFunctionVector<Vector4Funci, Vector4i> {
    public IntValue x, y, z, w;

    public Vector4Funci() {}

    public Vector4Funci(Vector4i applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y, () -> applyToFunc.w, () -> applyToFunc.w);
    }

    public Vector4Funci(IntValue all) {
        this(all, all, all, all);
    }

    public Vector4Funci(Vector4Funci copy) {
        set(copy);
    }

    public Vector4Funci(IntValue x, IntValue y, IntValue z, IntValue w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Integer get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            case 2 -> z.val();
            case 3 -> w.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Integer value) {
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
    public boolean equals(@NotNull Vector4Funci value) {
        return (this.x.val() == value.x.val() &&
                this.y.val() == value.y.val() &&
                this.z.val() == value.z.val() &&
                this.w.val() == value.w.val());
    }

    @Override
    public final boolean isNaN() {
        return false;
    }

    @Override
    public final int dimension() {
        return 4;
    }

    @Override
    public double distance(Vector4Funci value) {
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
    public double angle(Vector4Funci value) {
        return VectorUtils.angle(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val(),
                w.val(), value.w.val());
    }

    @Override
    public double dot(Vector4Funci value) {
        return VectorUtils.dot(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val(),
                w.val(), value.w.val());
    }

    @Override
    public Vector4Funci normalize() {
        final double l = len();
        IntValue fx = this.x;
        IntValue fy = this.y;
        IntValue fz = this.z;
        IntValue fw = this.w;
        this.x = () -> (int) (fx.val() / l);
        this.y = () -> (int) (fy.val() / l);
        this.z = () -> (int) (fz.val() / l);
        this.w = () -> (int) (fw.val() / l);
        return this;
    }

    @Override
    public Vector4Funci normalize(Vector4Funci pointer) {
        final double l = len();
        pointer.set(
                () -> (int) (this.x.val() / l),
                () -> (int) (this.y.val() / l),
                () -> (int) (this.z.val() / l),
                () -> (int) (this.w.val() / l));
        return pointer;
    }

    @Override
    public IntBuffer get(Buffer pointer) {
        IntBuffer re = (IntBuffer) pointer;
        re.put(0, this.x.val());
        re.put(1, this.y.val());
        re.put(2, this.z.val());
        re.put(3, this.w.val());
        return re;
    }

    @Override
    public Integer[] toArray(Integer[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        pointer[3] = this.w.val();
        return pointer;
    }

    public void set(IntValue x, IntValue y, IntValue z, IntValue w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Integer[] toArray() {
        return new Integer[]{
                this.x.val(),
                this.y.val(),
                this.z.val(),
                this.w.val()};
    }

    @Override
    public void set(Vector4Funci copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
        this.w = copy.w;
    }

    @Override
    public Vector4Funci clone() {
        return new Vector4Funci(this);
    }

    @Override
    public int[] toArray(int[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        pointer[3] = this.w.val();
        return pointer;
    }

    @Override
    public int[] copy(int destPos, int[] pointer) {
        pointer[destPos] = this.x.val();
        pointer[1 + destPos] = this.y.val();
        pointer[2 + destPos] = this.z.val();
        pointer[3 + destPos] = this.w.val();
        return pointer;
    }

    @Override
    public Vector4i createPrimitive() {
        return new Vector4i(x.val(), y.val(), z.val(), w.val());
    }

    @Override
    public Vector4i toPrimitive(Vector4i pointer) {
        pointer.set(x.val(), y.val(), z.val(), w.val());
        return pointer;
    }

    @Override
    public IntValue[] toFunctionArray(IntValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        pointer[2] = z;
        pointer[3] = w;
        return pointer;
    }
}
