package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

import static java.lang.Math.*;

public class Vector4f extends PrimitiveVector<Float, Vector4f> implements FloatVector<Vector4f> {
    public float x, y, z, w;

    public static final Vector4f NAN = new Vector4f(Float.NaN, Float.NaN, Float.NaN, Float.NaN);

    public Vector4f() {}

    public Vector4f(float all) {
        this(all, all, all, all);
    }

    public Vector4f(Vector4f copy) {
        set(copy);
    }

    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Float get(int index) {
        switch (index) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            case 3: return w;
            default: throw new UnsupportedOperationException();
        }
    }

    @Override
    public void set(int index, @NotNull Float value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            case 3 -> this.w = value;
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector4f value) {
        return (this.x == value.x &&
                this.y == value.y &&
                this.z == value.z &&
                this.w == value.w);
    }

    @Override
    public final boolean isNaN() {
        return Float.isNaN(x) && Float.isNaN(y) && Float.isNaN(z) && Float.isNaN(w);
    }

    @Override
    public final int dimension() {
        return 4;
    }

    @Override
    public Vector4f add(float value) {
        this.x += value;
        this.y += value;
        this.z += value;
        this.w += value;
        return this;
    }

    @Override
    public Vector4f add(float value, Vector4f pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        pointer.z = this.z + value;
        pointer.w = this.w + value;
        return pointer;
    }

    @Override
    public Vector4f add(Vector4f value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        this.w += value.w;
        return this;
    }

    @Override
    public Vector4f add(Vector4f value, Vector4f pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        pointer.z = this.z + value.z;
        pointer.w = this.w + value.w;
        return pointer;
    }

    @Override
    public Vector4f sub(float value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        this.w -= value;
        return this;
    }

    @Override
    public Vector4f sub(float value, Vector4f pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector4f sub(Vector4f value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        this.w -= value.w;
        return this;
    }

    @Override
    public Vector4f sub(Vector4f value, Vector4f pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector4f mul(double value) {
        this.x *= (float) value;
        this.y *= (float) value;
        this.z *= (float) value;
        this.w *= (float) value;
        return this;
    }

    @Override
    public Vector4f mul(Vector4f value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        this.w *= value.w;
        return this;
    }

    @Override
    public Vector4f mul(Vector4f value, Vector4f pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector4f div(double value) {
        this.x /= (float) value;
        this.y /= (float) value;
        this.z /= (float) value;
        this.w /= (float) value;
        return this;
    }

    @Override
    public Vector4f div(Vector4f value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        this.w /= value.w;
        return this;
    }

    @Override
    public Vector4f div(Vector4f value, Vector4f pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public double distance(Vector4f value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        double z = value.z - this.z;
        double w = value.w - this.w;
        return sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public double len() {
        return sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public double dot(Vector4f value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vector4f normalize() {
        double len = len();
        this.x /= (float) len;
        this.y /= (float) len;
        this.z /= (float) len;
        this.w /= (float) len;
        return this;
    }

    @Override
    public Vector4f normalize(Vector4f pointer) {
        pointer.set(this);
        return pointer.normalize();
    }

    @Override
    public double angle(Vector4f value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z + this.w * value.w) / (this.len() * value.len()));
    }

    @Override
    public FloatBuffer get(int offset, Buffer pointer) {
        FloatBuffer bf = (FloatBuffer) pointer;
        bf.put(offset    , this.x);
        bf.put(offset + 1, this.y);
        bf.put(offset + 2, this.z);
        bf.put(offset + 3, this.w);
        return bf;
    }

    @Override
    public Float[] toArray(Float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        pointer[3] = this.w;
        return pointer;
    }

    public void set(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Float[] toArray() {
        return new Float[]{
                this.x,
                this.y,
                this.z,
                this.w};
    }

    @Override
    public void set(Vector4f copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
        this.w = copy.w;
    }

    @Override
    public Vector4f clone() {
        return new Vector4f(this);
    }

    @Override
    public Vector4f abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    @Override
    public Vector4f abs(Vector4f pointer) {
        pointer.set(this);
        return pointer.abs();
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        pointer[3] = this.w;
        return pointer;
    }

    @Override
    public float[] copy(int destPos, float[] pointer) {
        pointer[destPos] = this.x;
        pointer[1 + destPos] = this.y;
        pointer[2 + destPos] = this.z;
        pointer[3 + destPos] = this.w;
        return pointer;
    }
}
