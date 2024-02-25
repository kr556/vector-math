package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.LongValue;

import java.nio.Buffer;
import java.nio.LongBuffer;

public class Vector4Funcl extends FunctionVector.LongFunctionVector<Vector4Funcl, Vector4l> {
    public LongValue x, y, z, w;

    public Vector4Funcl() {}

    public Vector4Funcl(Vector4l applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y, () -> applyToFunc.w, () -> applyToFunc.w);
    }

    public Vector4Funcl(LongValue all) {
        this(all, all, all, all);
    }

    public Vector4Funcl(Vector4Funcl copy) {
        set(copy);
    }

    public Vector4Funcl(LongValue x, LongValue y, LongValue z, LongValue w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Long get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            case 2 -> z.val();
            case 3 -> w.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Long value) {
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
    public boolean equals(@NotNull Vector4Funcl value) {
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
    public double distance(Vector4Funcl value) {
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
    public double angle(Vector4Funcl value) {
        return VectorUtils.angle(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val(),
                w.val(), value.w.val());
    }

    @Override
    public double dot(Vector4Funcl value) {
        return VectorUtils.dot(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val(),
                w.val(), value.w.val());
    }

    @Override
    public Vector4Funcl normalize() {
        final double l = len();
        LongValue fx = this.x;
        LongValue fy = this.y;
        LongValue fz = this.z;
        LongValue fw = this.w;
        this.x = () -> (long) (fx.val() / l);
        this.y = () -> (long) (fy.val() / l);
        this.z = () -> (long) (fz.val() / l);
        this.w = () -> (long) (fw.val() / l);
        return this;
    }

    @Override
    public Vector4Funcl normalize(Vector4Funcl pointer) {
        final double l = len();
        pointer.set(
                () -> (long) (this.x.val() / l),
                () -> (long) (this.y.val() / l),
                () -> (long) (this.z.val() / l),
                () -> (long) (this.w.val() / l));
        return pointer;
    }

    @Override
    public LongBuffer get(Buffer pointer) {
        LongBuffer re = (LongBuffer) pointer;
        re.put(0, this.x.val());
        re.put(1, this.y.val());
        re.put(2, this.z.val());
        re.put(3, this.w.val());
        return re;
    }

    @Override
    public Long[] toArray(Long[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        pointer[3] = this.w.val();
        return pointer;
    }

    public void set(LongValue x, LongValue y, LongValue z, LongValue w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Long[] toArray() {
        return new Long[]{
                this.x.val(),
                this.y.val(),
                this.z.val(),
                this.w.val()};
    }

    @Override
    public void set(Vector4Funcl copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
        this.w = copy.w;
    }

    @Override
    public Vector4Funcl clone() {
        return new Vector4Funcl(this);
    }

    @Override
    public long[] toArray(long[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        pointer[3] = this.w.val();
        return pointer;
    }

    @Override
    public Vector4l createPrimitive() {
        return new Vector4l(x.val(), y.val(), z.val(), w.val());
    }

    @Override
    public Vector4l toPrimitive(Vector4l pointer) {
        pointer.set(x.val(), y.val(), z.val(), w.val());
        return pointer;
    }

    @Override
    public LongValue[] toFunctionArray(LongValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        pointer[2] = z;
        pointer[3] = w;
        return pointer;
    }
}
