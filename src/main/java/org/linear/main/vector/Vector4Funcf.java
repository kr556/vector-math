package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.FloatValue;

import java.nio.Buffer;
import java.nio.FloatBuffer;

public class Vector4Funcf extends FunctionVector.FloatFunctionVector<Vector4Funcf, Vector4f> {
    public static Vector4Funcf NAN = new Vector4Funcf(() -> Float.NaN);

    public FloatValue x, y, z, w;

    public Vector4Funcf() {}

    public Vector4Funcf(Vector4f applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y, () -> applyToFunc.z, () -> applyToFunc.w);
    }

    public Vector4Funcf(FloatValue all) {
        this(all, all, all, all);
    }

    public Vector4Funcf(Vector4Funcf copy) {
        set(copy);
    }

    public Vector4Funcf(FloatValue x, FloatValue y, FloatValue z, FloatValue w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            case 2 -> z.val();
            case 3 -> w.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Float value) {
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
    public boolean equals(@NotNull Vector4Funcf value) {
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
    public double distance(Vector4Funcf value) {
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
    public double angle(Vector4Funcf value) {
        return VectorUtils.angle(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val(),
                w.val(), value.w.val());
    }

    @Override
    public double dot(Vector4Funcf value) {
        return VectorUtils.dot(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val(),
                w.val(), value.w.val());
    }

    @Override
    public Vector4Funcf normalize() {
        final float l = (float) len();
        FloatValue fx = this.x;
        FloatValue fy = this.y;
        FloatValue fz = this.z;
        FloatValue fw = this.w;
        this.x = () -> fx.val() / l;
        this.y = () -> fy.val() / l;
        this.z = () -> fz.val() / l;
        this.w = () -> fw.val() / l;
        return this;
    }

    @Override
    public Vector4Funcf normalize(Vector4Funcf pointer) {
        final float l = (float) len();
        pointer.set(
                () -> this.x.val() / l,
                () -> this.y.val() / l,
                () -> this.z.val() / l,
                () -> this.w.val() / l);
        return pointer;
    }

    @Override
    public FloatBuffer get(int offset, Buffer pointer) {
        FloatBuffer re = (FloatBuffer) pointer;
        re.put(offset    , this.x.val());
        re.put(offset + 1, this.y.val());
        re.put(offset + 2, this.z.val());
        re.put(offset + 3, this.w.val());
        return re;
    }

    @Override
    public Float[] toArray(Float[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        pointer[3] = this.w.val();
        return pointer;
    }

    public void set(FloatValue x, FloatValue y, FloatValue z, FloatValue w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Float[] toArray() {
        return new Float[]{
                this.x.val(),
                this.y.val(),
                this.z.val(),
                this.w.val()};
    }

    @Override
    public void set(Vector4Funcf copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
        this.w = copy.w;
    }

    @Override
    public Vector4Funcf clone() {
        return new Vector4Funcf(this);
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        pointer[3] = this.w.val();
        return pointer;
    }

    @Override
    public float[] copy(int destPos, float[] pointer) {
        pointer[destPos] = this.x.val();
        pointer[1 + destPos] = this.y.val();
        pointer[2 + destPos] = this.z.val();
        pointer[3 + destPos] = this.w.val();
        return pointer;
    }

    @Override
    public Vector4f createPrimitive() {
        return new Vector4f(x.val(), y.val(), z.val(), w.val());
    }

    @Override
    public Vector4f toPrimitive(Vector4f pointer) {
        pointer.set(x.val(), y.val(), z.val(), w.val());
        return pointer;
    }

    @Override
    public FloatValue[] toFunctionArray(FloatValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        pointer[2] = z;
        pointer[3] = w;
        return pointer;
    }
}
