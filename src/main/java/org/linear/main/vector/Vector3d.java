package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

import static java.lang.Math.*;

public class Vector3d extends PrimitiveVector<Double, Vector3d> implements DoubleVector<Vector3d> {
    public double x, y, z;

    public static final Vector3d NAN = new Vector3d(Double.NaN, Double.NaN, Double.NaN);

    public Vector3d() {}

    public Vector3d(double all) {
        this(all, all, all);
    }

    public Vector3d(Vector3d copy) {
        set(copy);
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Double get(int index) {
        switch (index) {
            case 0 : return x;
            case 1 : return y;
            case 2 : return z;
            default : throw new UnsupportedOperationException();
        }
    }

    @Override
    public void set(int index, @NotNull Double value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector3d value) {
        return (this.x == value.x &&
                this.y == value.y &&
                this.z == value.z);
    }

    @Override
    public final boolean isNaN() {
        return Double.isNaN(x) && Double.isNaN(y) && Double.isNaN(z);
    }

    @Override
    public final int dimension() {
        return 3;
    }

    @Override
    public Vector3d add(double value) {
        this.x += value;
        this.y += value;
        this.z += value;
        return this;
    }

    @Override
    public Vector3d add(double value, Vector3d pointer) {
        pointer.set(this);
        return pointer.add(value);

    }

    @Override
    public Vector3d add(Vector3d value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        return this;
    }

    @Override
    public Vector3d add(Vector3d value, Vector3d pointer) {
        pointer.set(this);
        return pointer.add(value);

    }

    @Override
    public Vector3d sub(double value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        return this;
    }

    @Override
    public Vector3d sub(double value, Vector3d pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector3d sub(Vector3d value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        return this;
    }

    @Override
    public Vector3d sub(Vector3d value, Vector3d pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector3d mul(double value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        return this;
    }

    @Override
    public Vector3d mul(double value, Vector3d pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector3d mul(Vector3d value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        return this;
    }

    @Override
    public Vector3d mul(Vector3d value, Vector3d pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector3d div(double value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        return this;
    }

    @Override
    public Vector3d div(double value, Vector3d pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Vector3d div(Vector3d value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        return this;
    }

    @Override
    public Vector3d div(Vector3d value, Vector3d pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public double distance(Vector3d value) {
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
    public double dot(Vector3d value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vector3d cross(Vector3d value) {
        set(
                this.y * value.z - this.z * value.y,
                this.z * value.x - this.x * value.z,
                this.x * value.y - this.y * value.x);
        return this;
    }

    @Override
    public Vector3d normalize() {
        double len = len();
        this.x /= len;
        this.y /= len;
        this.z /= len;
        return this;
    }

    @Override
    public Vector3d normalize(Vector3d pointer) {
        pointer.set(this);
        return pointer.normalize();
    }

    @Override
    public double angle(Vector3d value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z) / (this.len() * value.len()));
    }

    @Override
    public DoubleBuffer get(int offset, Buffer pointer) {
        DoubleBuffer bf = (DoubleBuffer) pointer;
        bf.put(offset    , this.x);
        bf.put(offset + 1, this.y);
        bf.put(offset + 2, this.z);
        return bf;
    }

    @Override
    public Double[] toArray(Double[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Double[] toArray() {
        return new Double[]{
                this.x,
                this.y,
                this.z};
    }

    @Override
    public void set(Vector3d copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    @Override
    public Vector3d clone() {
        return new Vector3d(this);
    }

    @Override
    public Vector3d abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    @Override
    public Vector3d abs(Vector3d pointer) {
        pointer.set(this);
        return pointer.abs();

    }

    @Override
    public double[] toArray(double[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }

    @Override
    public double[] copy(int destPos, double[] pointer) {
        return new double[0];
    }
}
