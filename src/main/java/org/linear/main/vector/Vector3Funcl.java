package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.LongValue;

import java.nio.Buffer;
import java.nio.LongBuffer;

public class Vector3Funcl extends FunctionVector.LongFunctionVector<Vector3Funcl, Vector3l> {
    public LongValue x, y, z;

    public Vector3Funcl() {}

    public Vector3Funcl(Vector3l applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y, () -> applyToFunc.z);
    }

    public Vector3Funcl(LongValue all) {
        this(all, all, all);
    }

    public Vector3Funcl(Vector3Funcl copy) {
        set(copy);
    }

    public Vector3Funcl(LongValue x, LongValue y, LongValue z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Long get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            case 2 -> z.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Long value) {
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
    public boolean equals(@NotNull Vector3Funcl value) {
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
    public double distance(Vector3Funcl value) {
        return VectorUtils.distance(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public double len() {
        return VectorUtils.len(x.val(), y.val(), z.val());
    }

    @Override
    public double angle(Vector3Funcl value) {
        return VectorUtils.angle(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public double dot(Vector3Funcl value) {
        return VectorUtils.dot(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public Vector3Funcl normalize() {
        final double l = len();
        LongValue fx = this.x;
        LongValue fy = this.y;
        LongValue fz = this.z;
        this.x = () -> (long) (fx.val() / l);
        this.y = () -> (long) (fy.val() / l);
        this.z = () -> (long) (fz.val() / l);
        return this;
    }

    @Override
    public Vector3Funcl normalize(Vector3Funcl pointer) {
        final double l = len();
        pointer.set(
                () -> (long) (this.x.val() / l),
                () -> (long) (this.y.val() / l),
                () -> (long) (this.z.val() / l));
        return pointer;
    }

    @Override
    public LongBuffer get(int offset, Buffer pointer) {
        LongBuffer bf = (LongBuffer) pointer;
        bf.put(offset    , this.x.val());
        bf.put(offset + 1, this.y.val());
        bf.put(offset + 2, this.z.val());
        return bf;
    }

    @Override
    public Long[] toArray(Long[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        return pointer;
    }

    public void set(LongValue x, LongValue y, LongValue z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Long[] toArray() {
        return new Long[]{
                this.x.val(),
                this.y.val(),
                this.z.val()};
    }

    @Override
    public void set(Vector3Funcl copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    @Override
    public Vector3Funcl clone() {
        return new Vector3Funcl(this);
    }

    @Override
    public long[] toArray(long[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        return pointer;
    }

    @Override
    public long[] copy(int destPos, long[] pointer) {
        pointer[destPos] = this.x.val();
        pointer[1 + destPos] = this.y.val();
        pointer[2 + destPos] = this.z.val();
        return pointer;
    }

    @Override
    public Vector3l createPrimitive() {
        return new Vector3l(x.val(), y.val(), z.val());
    }

    @Override
    public Vector3l toPrimitive(Vector3l pointer) {
        pointer.set(x.val(), y.val(), z.val());
        return pointer;
    }

    @Override
    public LongValue[] toFunctionArray(LongValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        pointer[2] = z;
        return pointer;
    }
}
