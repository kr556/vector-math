package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

import static java.lang.Math.*;

public class Vector3f extends PrimitiveVector<Float, Vector3f> implements FloatVector<Vector3f> {
    public float x, y, z;

    private static final Vector3f NAN = new Vector3f(Float.NaN, Float.NaN, Float.NaN);

    public Vector3f() {}

    public Vector3f(float all) {
        this(all, all, all);
    }

    public Vector3f(Vector3f copy) {
        set(copy);
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Float get(int index) {
        switch (index) {
            case 0 : return x;
            case 1 : return y;
            case 2 : return z;
            default : throw new UnsupportedOperationException();
        }
    }

    @Override
    public void set(int index, @NotNull Float value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector3f value) {
        return (this.x == value.x &&
                this.y == value.y &&
                this.z == value.z);
    }

    @Override
    public final boolean isNaN() {
        return Float.isNaN(x) && Float.isNaN(y) && Float.isNaN(z);
    }

    @Override
    public final int dimension() {
        return 3;
    }

    @Override
    public Vector3f add(float value) {
        this.x += value;
        this.y += value;
        this.z += value;
        return this;
    }

    @Override
    public Vector3f add(float value, Vector3f pointer) {
        pointer.set(this);
        return pointer.add(value);

    }

    @Override
    public Vector3f add(Vector3f value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        return this;
    }

    @Override
    public Vector3f add(Vector3f value, Vector3f pointer) {
        pointer.set(this);
        return pointer.add(value);

    }

    @Override
    public Vector3f sub(float value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        return this;
    }

    @Override
    public Vector3f sub(float value, Vector3f pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector3f sub(Vector3f value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        return this;
    }

    @Override
    public Vector3f sub(Vector3f value, Vector3f pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector3f mul(double value) {
        this.x *= (float) value;
        this.y *= (float) value;
        this.z *= (float) value;
        return this;
    }

    @Override
    public Vector3f mul(Vector3f value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        return this;
    }

    @Override
    public Vector3f mul(Vector3f value, Vector3f pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector3f div(double value) {
        this.x /= (float) value;
        this.y /= (float) value;
        this.z /= (float) value;
        return this;
    }

    @Override
    public Vector3f div(Vector3f value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        return this;
    }

    @Override
    public Vector3f div(Vector3f value, Vector3f pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public double distance(Vector3f value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        double z = value.z - this.z;
        return sqrt(x * x + y * y + z * z);
    }

    @Override
    public double len() {
        return sqrt(x * x + y * y + z * z);
    }

    @Override
    public double dot(Vector3f value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vector3f cross(Vector3f value) {
        set(
                this.y * value.z - this.z * value.y,
                this.z * value.x - this.x * value.z,
                this.x * value.y - this.y * value.x);
        return this;
    }

    @Override
    public Vector3f normalize() {
        double len = len();
        this.x /= (float) len;
        this.y /= (float) len;
        this.z /= (float) len;
        return this;
    }

    @Override
    public Vector3f normalize(Vector3f pointer) {
        pointer.set(this);
        return pointer.normalize();
    }

    @Override
    public double angle(Vector3f value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z) / (this.len() * value.len()));
    }

    @Override
    public FloatBuffer get(int offset, Buffer pointer) {
        FloatBuffer bf = (FloatBuffer) pointer;
        bf.put(offset    , this.x);
        bf.put(offset + 1, this.y);
        bf.put(offset + 2, this.z);
        return bf;
    }

    @Override
    public Float[] toArray(Float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }

    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Float[] toArray() {
        return new Float[]{
                this.x,
                this.y,
                this.z};
    }

    @Override
    public void set(Vector3f copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    @Override
    public Vector3f clone() {
        return new Vector3f(this);
    }

    @Override
    public Vector3f abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    @Override
    public Vector3f abs(Vector3f pointer) {
        pointer.set(this);
        return pointer.abs();

    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }

    @Override
    public float[] copy(int destPos, float[] pointer) {
        pointer[destPos] = this.x;
        pointer[1 + destPos] = this.y;
        pointer[2 + destPos] = this.z;
        return pointer;
    }
}
