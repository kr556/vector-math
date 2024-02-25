package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.value.FloatValue;

import java.nio.Buffer;
import java.nio.FloatBuffer;

public class Vector3Funcf extends FunctionVector.FloatFunctionVector<Vector3Funcf, Vector3f> {
    public static Vector3Funcf NAN = new Vector3Funcf(() -> Float.NaN);

    public FloatValue x, y, z;

    public Vector3Funcf() {}

    public Vector3Funcf(Vector3f applyToFunc) {
        this(() -> applyToFunc.x, () -> applyToFunc.y, () -> applyToFunc.z);
    }

    public Vector3Funcf(FloatValue all) {
        this(all, all, all);
    }

    public Vector3Funcf(Vector3Funcf copy) {
        set(copy);
    }

    public Vector3Funcf(FloatValue x, FloatValue y, FloatValue z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0 -> x.val();
            case 1 -> y.val();
            case 2 -> z.val();
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Float value) {
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
    public boolean equals(@NotNull Vector3Funcf value) {
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
    public double distance(Vector3Funcf value) {
        return VectorUtils.distance(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public double len() {
        return VectorUtils.len(x.val(), y.val(), z.val());
    }

    @Override
    public double angle(Vector3Funcf value) {
        return VectorUtils.angle(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public double dot(Vector3Funcf value) {
        return VectorUtils.dot(x.val(), value.x.val(),
                y.val(), value.y.val(),
                z.val(), value.z.val());
    }

    @Override
    public Vector3Funcf normalize() {
        final float l = (float) len();
        FloatValue fx = this.x;
        FloatValue fy = this.y;
        FloatValue fz = this.z;
        this.x = () -> fx.val() / l;
        this.y = () -> fy.val() / l;
        this.z = () -> fz.val() / l;
        return this;
    }

    @Override
    public Vector3Funcf normalize(Vector3Funcf pointer) {
        final float l = (float) len();
        pointer.set(
                () -> this.x.val() / l,
                () -> this.y.val() / l,
                () -> this.z.val() / l);
        return pointer;
    }

    @Override
    public FloatBuffer get(Buffer pointer) {
        FloatBuffer re = (FloatBuffer) pointer;
        re.put(0, this.x.val());
        re.put(1, this.y.val());
        re.put(2, this.z.val());
        return re;
    }

    @Override
    public Float[] toArray(Float[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        return pointer;
    }

    public void set(FloatValue x, FloatValue y, FloatValue z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Float[] toArray() {
        return new Float[]{
                this.x.val(),
                this.y.val(),
                this.z.val()};
    }

    @Override
    public void set(Vector3Funcf copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    @Override
    public Vector3Funcf clone() {
        return new Vector3Funcf(this);
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.x.val();
        pointer[1] = this.y.val();
        pointer[2] = this.z.val();
        return pointer;
    }

    @Override
    public Vector3f createPrimitive() {
        return new Vector3f(x.val(), y.val(), z.val());
    }

    @Override
    public Vector3f toPrimitive(Vector3f pointer) {
        pointer.set(x.val(), y.val(), z.val());
        return pointer;
    }

    @Override
    public FloatValue[] toFunctionArray(FloatValue[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        pointer[2] = z;
        return pointer;
    }
}
