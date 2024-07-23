package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.LongBuffer;

import static java.lang.Math.cos;
import static java.lang.Math.sqrt;

public class Vector2f extends PrimitiveVector<Float, Vector2f> implements FloatVector<Vector2f> {
    public static final Vector2f NAN = new Vector2f(Float.NaN, Float.NaN);

    public float x, y;

    public Vector2f() {}

    public Vector2f(float all) {
        this(all, all);
    }

    public Vector2f(Vector2f copy) {
        set(copy);
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0 -> x;
            case 1 -> y;
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Float value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector2f value) {
        return (this.x == value.x &&
                this.y == value.y);
    }

    @Override
    public final boolean isNaN() {
        return Float.isNaN(x) && Float.isNaN(y);
    }

    @Override
    public final int dimension() {
        return 2;
    }

    @Override
    public Vector2f add(float value) {
        this.x += value;
        this.y += value;
        return this;
    }

    @Override
    public Vector2f add(float value, Vector2f pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        return pointer;
    }

    @Override
    public Vector2f add(Vector2f value) {
        this.x += value.x;
        this.y += value.y;
        return this;
    }

    @Override
    public Vector2f add(Vector2f value, Vector2f pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        return pointer;
    }

    @Override
    public Vector2f sub(float value) {
        this.x -= value;
        this.y -= value;
        return this;
    }

    @Override
    public Vector2f sub(float value, Vector2f pointer) {
        pointer.x = this.x - value;
        pointer.y = this.y - value;
        return pointer;
    }

    @Override
    public Vector2f sub(Vector2f value) {
        this.x -= value.x;
        this.y -= value.y;
        return this;
    }

    @Override
    public Vector2f sub(Vector2f value, Vector2f pointer) {
        pointer.x = this.x - value.x;
        pointer.y = this.y - value.y;
        return pointer;
    }

    @Override
    public Vector2f mul(double value) {
        this.x *= (float) value;
        this.y *= (float) value;
        return this;
    }

    @Override
    public Vector2f mul(Vector2f value) {
        this.x *= value.x;
        this.y *= value.y;
        return this;
    }

    @Override
    public Vector2f mul(Vector2f value, Vector2f pointer) {
        pointer.x = this.x * value.x;
        pointer.y = this.y * value.y;
        return pointer;
    }

    @Override
    public Vector2f div(double value) {
        this.x /= (float) value;
        this.y /= (float) value;
        return this;
    }

    @Override
    public Vector2f div(Vector2f value) {
        this.x /= value.x;
        this.y /= value.y;
        return this;
    }

    @Override
    public Vector2f div(Vector2f value, Vector2f pointer) {
        pointer.x = this.x / value.x;
        pointer.y = this.y / value.y;
        return pointer;
    }

    @Override
    public double distance(Vector2f value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        return sqrt(x * x + y * y);
    }

    @Override
    public double len() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public double dot(Vector2f value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vector2f normalize() {
        return null;
    }

    @Override
    public Vector2f normalize(Vector2f pointer) {
        return null;
    }

    public double angle() {
        return Math.acos(this.y / this.len());
    }

    @Override
    public double angle(Vector2f value) {
        return Math.abs(this.angle() - value.angle());
    }

    @Override
    public FloatBuffer get(int offset, Buffer pointer) {
        FloatBuffer bf = (FloatBuffer) pointer;
        bf.put(offset    , this.x);
        bf.put(offset + 1, this.y);
        return bf;
    }

    @Override
    public Float[] toArray(Float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        return pointer;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Float[] toArray() {
        return new Float[]{
                this.x,
                this.y};
    }

    @Override
    public void set(Vector2f copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    @Override
    public Vector2f clone() {
        return new Vector2f(this);
    }

    @Override
    public Vector2f abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    @Override
    public Vector2f abs(Vector2f pointer) {
        pointer.x = Math.abs(this.x);
        pointer.y = Math.abs(this.y);
        return pointer;
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        return pointer;
    }

    @Override
    public float[] copy(int destPos, float[] pointer) {
        pointer[destPos] = this.x;
        pointer[1 + destPos] = this.y;
        return pointer;
    }
}
