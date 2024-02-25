package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.IntValue;

import java.nio.Buffer;
import java.nio.IntBuffer;

public class Vector3Funci extends FunctionVector.IntFunctionVector<Vector3Funci, Vector3i> {
    public IntValue x, y, z;

    public Vector3Funci() {}

    public Vector3Funci(Vector3i applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y, () -> applyToFunc.z);
    }

    public Vector3Funci(IntValue all) {
        this(all, all, all);
    }

    public Vector3Funci(Vector3Funci copy) {
        set(copy);
    }

    public Vector3Funci(IntValue x, IntValue y, IntValue z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Integer get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            case 2 -> z.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Integer value) {
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
    public boolean equals(@NotNull Vector3Funci value) {
        return (this.x.val() == value.x.val() &&
                this.y.val() == value.y.val() &&
                this.z.val() == value.z.val());
    }

    @Override
    public final boolean isNaN() {
        return false;
    }

    @Override
    public final int dimension() {
        return 3;
    }

    @Override
    public double distance(Vector3Funci value) {
        return VectorUtils.distance(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public double len() {
        return VectorUtils.len(x.val(), y.val(), z.val());
    }

    @Override
    public double angle(Vector3Funci value) {
        return VectorUtils.angle(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public double dot(Vector3Funci value) {
        return VectorUtils.dot(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public Vector3Funci normalize() {
        final double l = len();
        IntValue fx = this.x;
        IntValue fy = this.y;
        IntValue fz = this.z;
        this.x = () -> (int) (fx.val() / l);
        this.y = () -> (int) (fy.val() / l);
        this.z = () -> (int) (fz.val() / l);
        return this;
    }

    @Override
    public Vector3Funci normalize(Vector3Funci pointer) {
        final double l = len();
        pointer.set(
                () -> (int) (this.x.val() / l),
                () -> (int) (this.y.val() / l),
                () -> (int) (this.z.val() / l));
        return pointer;
    }

    @Override
    public IntBuffer get(Buffer pointer) {
        IntBuffer re = (IntBuffer) pointer;
        re.put(0, this.x.val());
        re.put(1, this.y.val());
        re.put(2, this.z.val());
        return re;
    }

    @Override
    public Integer[] toArray(Integer[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        return pointer;
    }

    public void set(IntValue x, IntValue y, IntValue z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Integer[] toArray() {
        return new Integer[]{
                this.x.val(),
                this.y.val(),
                this.z.val()};
    }

    @Override
    public void set(Vector3Funci copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    @Override
    public Vector3Funci clone() {
        return new Vector3Funci(this);
    }

    @Override
    public int[] toArray(int[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        return pointer;
    }

    @Override
    public Vector3i createPrimitive() {
        return new Vector3i(x.val(), y.val(), z.val());
    }

    @Override
    public Vector3i toPrimitive(Vector3i pointer) {
        pointer.set(x.val(), y.val(), z.val());
        return pointer;
    }

    @Override
    public IntValue[] toFunctionArray(IntValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        pointer[2] = z;
        return pointer;
    }
}
