package org.linear.main.matrix;

import java.util.Arrays;

import static java.lang.System.arraycopy;

/**
 * Matrix of n row, 2 column.
 * <pre>
 *     [M10, M01]
 *     [M20, M11]
 *     [M30, M21]
 *     [..., ...]
 *     [Mn0, Mn1]
 * </pre>
 */
@Deprecated //unfinished
public class Matrixnx2f extends AbsMatrix<Float, Matrixnx2f, Matrix2xnf> implements FloatMatrix<Matrixnx2f, Matrix2xnf> {
    public final float[] c0;
    public final float[] c1;

    public Matrixnx2f(float... m) {
        if (m.length % 2 == 0) {
            final int mLen = m.length / 2;

            c0 = new float[mLen];
            c1 = new float[mLen];

            arrayToThis(m, mLen);
        } else throw new UnsupportedOperationException("length of array of a arg is not even number.");
    }

    public Matrixnx2f(float[] c0, float[] c1) {
        if (c0.length != c1.length) {
            final int len = c0.length;

            this.c0 = new float[len];
            this.c1 = new float[len];

            arrayToThis(c0, c1, len);
        } else throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void set(Matrixnx2f copy) {
        if (c0.length != copy.c0.length || c1.length != copy.c1.length)
            throw new ArrayIndexOutOfBoundsException();

        arrayToThis(copy.c0, copy.c1, c0.length);
    }

    @Override
    public Matrixnx2f add(Matrixnx2f value) {
        return null;
    }

    @Override
    public Matrixnx2f add(Matrixnx2f value, Matrixnx2f pointer) {
        return null;
    }

    @Override
    public Matrixnx2f sub(Matrixnx2f value) {
        return null;
    }

    @Override
    public Matrixnx2f sub(Matrixnx2f value, Matrixnx2f pointer) {
        return null;
    }

    @Override
    public Matrixnx2f mul(Matrixnx2f value) {
        return null;
    }

    @Override
    public Matrixnx2f mul(double value) {
        return null;
    }

    @Override
    public Matrixnx2f mul(double value, Matrixnx2f pointer) {
        return null;
    }

    @Override
    public Matrixnx2f div(double value) {
        return null;
    }

    @Override
    public Matrixnx2f div(double value, Matrixnx2f pointer) {
        return null;
    }

    @Override
    public Matrixnx2f mul(Matrixnx2f value, Matrixnx2f pointer) {
        return null;
    }

    @Override
    public Matrixnx2f div(Matrixnx2f value) {
        return null;
    }

    @Override
    public Matrixnx2f div(Matrixnx2f value, Matrixnx2f pointer) {
        return null;
    }

    @Override
    public Matrixnx2f abs() {
        return null;
    }

    @Override
    public Matrixnx2f abs(Matrixnx2f pointer) {
        return null;
    }

    @Override
    public Matrixnx2f add(float value) {
        return null;
    }

    @Override
    public Matrixnx2f add(float value, Matrixnx2f pointer) {
        return null;
    }

    @Override
    public Matrixnx2f sub(float value) {
        return null;
    }

    @Override
    public Matrixnx2f sub(float value, Matrixnx2f pointer) {
        return null;
    }

    @Override
    public Float get(int index) {
        return null;
    }

    @Override
    public float[] toArray(float[] pointer) {
        return new float[0];
    }

    @Override
    public boolean equals(Matrixnx2f value) {
        return false;
    }

    @Override
    public boolean isNaN() {
        return false;
    }

    @Override
    public Matrixnx2f craete() {
        return null;
    }

    @Override
    public Matrixnx2f create() {
        return null;
    }

    @Override
    public int columnDimension() {
        return 0;
    }

    @Override
    public int rowDimension() {
        return 0;
    }

    @Override
    public Float[] getRow(int index) {
        return new Float[0];
    }

    @Override
    public Float[] getColumn(int index) {
        return new Float[0];
    }

    @Override
    public void set(int r, int c, Float value) {

    }

    @Override
    public boolean isSquare() {
        return false;
    }

    @Override
    public int elementsSize() {
        return 0;
    }

    @Override
    public Float get(int r, int c) {
        switch (c) {
            case 0 : return c0[r];
            case 1 : return c1[r];
            default : throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Matrix2xnf transpose() {
        return new Matrix2xnf(c0, c1);
    }

    @Override
    public String toString() {
        return Arrays.toString(c0) + "\n" + Arrays.toString(c1);
    }

    private void arrayToThis(float[] c0, float[] c1, int len) {
        arraycopy(c0, 0, this.c0, 0, len);
        arraycopy(c1, 0, this.c1, 0, len);
    }

    private void arrayToThis(float[] cAll, int len) {
        arraycopy(cAll, 0, this.c0, 0, len);
        arraycopy(cAll, len, this.c1, 0, len);
    }
}
