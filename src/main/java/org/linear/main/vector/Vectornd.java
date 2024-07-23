package org.linear.main.vector;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.*;
import static java.lang.System.arraycopy;

public class Vectornd extends PrimitiveVector<Double, Vectornd> implements DoubleVector<Vectornd> {
    public static Vectornd nan(int dimension) {
        Vectornd re = new Vectornd(new double[dimension]);
        Arrays.fill(re.v, Double.NaN);
        return re;
    }

    public final double[] v;

    private final int dim;

    public Vectornd(Vectornd copy, double[] v) {
        this.v = new double[v.length];
        set(copy);
        this.dim = v.length;
    }

    public Vectornd(Double... v) {
        this.v = new double[v.length];
        this.dim = this.v.length;

        for (int i = 0; i < v.length; i++) {
            this.v[i] = v[i];
        }
    }

    public Vectornd(double... v) {
        this.v = new double[v.length];
        arraycopy(v, 0, this.v, 0,  v.length);
        this.dim = this.v.length;
    }

    public Vectornd() {
        this.v = new double[0];
        this.dim = 0;
    }

    public Vectornd(int dimensional) {
        this.v = new double[dimensional];
        this.dim = this.v.length;
        Arrays.fill(v, 0);
    }

    @Override
    public Vectornd add(double value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] += value;
        }

        return this;
    }

    @Override
    public Vectornd add(double value, Vectornd pointer) {
        if (this.dim != pointer.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value;
        }

        return this;
    }

    @Override
    public Vectornd add(Vectornd value) {
        if (this.dim != value.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            this.v[i] += value.v[i];
        }

        return this;
    }

    @Override
    public Vectornd add(Vectornd value, Vectornd pointer) {
        if (this.dim != value.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value.v[i];
        }

        return pointer;
    }

    @Override
    public Vectornd sub(double value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] -= value;
        }

        return this;
    }

    @Override
    public Vectornd sub(double value, Vectornd pointer) {
        if (this.dim != pointer.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] - value;
        }

        return pointer;
    }

    @Override
    public Vectornd sub(Vectornd value) {
        if (this.dim != value.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            this.v[i] -= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornd sub(Vectornd value, Vectornd pointer) {
        if (this.dim != value.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] - value.v[i];
        }

        return pointer;
    }

    @Override
    public Vectornd mul(double value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value;
        }

        return this;
    }

    @Override
    public Vectornd mul(double value, Vectornd pointer) {
        if (this.dim != pointer.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] * value;
        }

        return pointer;
    }

    @Override
    public Vectornd mul(Vectornd value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornd mul(Vectornd value, Vectornd pointer) {
        if (this.dim != pointer.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] * value.v[i];
        }

        return pointer;
    }

    @Override
    public Vectornd div(double value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value;
        }

        return this;
    }

    @Override
    public Vectornd div(double value, Vectornd pointer) {
        if (this.dim != pointer.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] / value;
        }

        return pointer;
    }

    @Override
    public Vectornd div(Vectornd value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornd div(Vectornd value, Vectornd pointer) {
        if (this.dim != pointer.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value.v[i];
        }

        return pointer;
    }

    @Override
    public double distance(Vectornd value) {
        if (this.dim != value.dim) throw new ArrayIndexOutOfBoundsException();
        double[] x = new double[dim];

        for (int i = 0; i < dimension(); i++) {
            x[i] = x[i] - value.v[i];
        }

        return new Vectornd(x).len();
    }

    @Override
    public double len() {
        double sum = 0;

        for (double f : v) {
            sum += f * f;
        }

        return sqrt(sum);
    }

    @Override
    public double dot(Vectornd value) {
        if (this.dim != value.dim) throw new ArrayIndexOutOfBoundsException();

        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vectornd normalize() {
        div((float) len());
        return this;
    }

    @Override
    public Vectornd normalize(Vectornd pointer) {
        if (this.dim != pointer.dim) throw new ArrayIndexOutOfBoundsException();

        pointer.set(this);
        pointer.normalize();
        return pointer;
    }

    @Override
    public double angle(Vectornd value) {
        if (this.dimension() != value.dim) throw new ArrayIndexOutOfBoundsException();

        return acos(IntStream.range(0, dimension()).mapToDouble(i -> this.v[i] * value.v[i]).sum() / (this.len() * value.len()));
    }

    @Override
    public Double get(int index) {
        return v[index];
    }

    @Override
    public void set(int index, Double value) {
        this.v[index] = value;
    }

    @Override
    public boolean equals(Vectornd value) {
        if (this.dim != value.dim) return false;
        for (int i = 0; i < dim; i++) {
            if (this.v[i] != value.v[i]) return false;
        }
        return true;
    }

    @Override
    public final boolean isNaN() {
        for (double v : v) {
            if (Double.isNaN(v)) return true;
        }
        return false;
    }

    @Override
    public final int dimension() {
        return dim;
    }

    public double[] getElements() {
        return v;
    }

    public void set(double... fs) {
        if (fs.length != 0) {
            if (fs.length < dim) {
                arraycopy(fs, 0, this.v, 0, fs.length);
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    public void set(int index, double f) {
        this.v[index] = f;
    }

    @Override
    public DoubleBuffer get(int offset, Buffer pointer) {
        DoubleBuffer bf = (DoubleBuffer) pointer;
        for (int i = 0; i < dimension(); i++) {
            bf.put(i + offset, v[i]);
        }
        return bf;
    }

    @Override
    public Double[] toArray(Double[] pointer) {
        if (pointer.length != dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            pointer[i] = v[i];
        }

        return pointer;
    }

    @Override
    public Double[] toArray() {
        Double[] re = new Double[dimension()];
        return toArray(re);
    }

    @Override
    public String toString() {
        return Arrays.toString(v)
                .replace("[", "{")
                .replace("]", "}");
    }

    @Override
    public void set(Vectornd copy) {
        if (dim != copy.dim) throw new ArrayIndexOutOfBoundsException();
        arraycopy(copy.v, 0, this.v, 0, dim);
    }

    @Override
    public Vectornd clone() {
        return new Vectornd(v);
    }

    @Override
    public Vectornd abs() {
        for (int i = 0; i < dimension(); i++) {
            this.v[i] = Math.abs(this.v[i]);
        }

        return this;
    }

    @Override
    public Vectornd abs(Vectornd pointer) {
        if (dim != pointer.dim) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < dimension(); i++) {
            pointer.v[i] = Math.abs(this.v[i]);
        }

        return pointer;
    }

    @Override
    public double[] toArray(double[] pointer) {
        if (dim != pointer.length) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < dim; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }

    @Override
    public double[] copy(int destPos, double[] pointer) {
        arraycopy(v, 0, pointer, destPos, dim);
        return pointer;
    }
}