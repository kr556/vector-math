package org.linear.main.matrix;

import java.util.Arrays;

import static java.lang.System.arraycopy;

/**
 * Matrix of 2 row, n column.
 * <pre>
 *     [M00, M01, M02, ... , M0n]
 *     [M10, M11, M12, ... , M1n]
 * </pre>
 */
@Deprecated //unfinished
public class Matrix2xnf extends PrimitiveMatrix<Float, Matrix2xnf, Matrixnx2f>
        implements FloatMatrix<Matrix2xnf, Matrixnx2f> {
    public final float[] r0;
    public final float[] r1;

    public Matrix2xnf(float... m) {
        if (m.length % 2 == 0) {
            int mLen = m.length / 2;

            r0 = new float[mLen];
            r1 = new float[mLen];

            arraycopy(m, 0, r0, 0, mLen);
            arraycopy(m, mLen, r1, 0, mLen);
        } else throw new UnsupportedOperationException("length of array of a arg is not even number.");
    }

    public Matrix2xnf(float[] r0, float[] r1) {
        if (r0.length != r1.length) {
            final int len = r0.length;

            this.r0 = new float[len];
            this.r1 = new float[len];

            arrayToThis(r0, r1, len);
        } else throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void set(Matrix2xnf copy) {

    }

    @Override
    public Matrix2xnf add(Matrix2xnf value) {
        return null;
    }

    @Override
    public Matrix2xnf add(Matrix2xnf value, Matrix2xnf pointer) {
        return null;
    }

    @Override
    public Matrix2xnf sub(Matrix2xnf value) {
        return null;
    }

    @Override
    public Matrix2xnf sub(Matrix2xnf value, Matrix2xnf pointer) {
        return null;
    }

    @Override
    public Matrix2xnf mul(Matrix2xnf value) {
        return null;
    }

    @Override
    public Matrix2xnf mul(double value) {
        return null;
    }

    @Override
    public Matrix2xnf mul(double value, Matrix2xnf pointer) {
        return null;
    }

    @Override
    public Matrix2xnf div(double value) {
        return null;
    }

    @Override
    public Matrix2xnf div(double value, Matrix2xnf pointer) {
        return null;
    }

    @Override
    public Matrix2xnf mul(Matrix2xnf value, Matrix2xnf pointer) {
        return null;
    }

    @Override
    public Matrix2xnf div(Matrix2xnf value) {
        return null;
    }

    @Override
    public Matrix2xnf div(Matrix2xnf value, Matrix2xnf pointer) {
        return null;
    }

    @Override
    public Matrix2xnf abs() {
        return null;
    }

    @Override
    public Matrix2xnf abs(Matrix2xnf pointer) {
        return null;
    }

    @Override
    public Matrix2xnf add(float value) {
        return null;
    }

    @Override
    public Matrix2xnf add(float value, Matrix2xnf pointer) {
        return null;
    }

    @Override
    public Matrix2xnf sub(float value) {
        return null;
    }

    @Override
    public Matrix2xnf sub(float value, Matrix2xnf pointer) {
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
    public boolean equals(Matrix2xnf value) {
        return false;
    }

    @Override
    public boolean isNaN() {
        return false;
    }

    @Override
    public Matrix2xnf craete() {
        return null;
    }

    @Override
    public Matrix2xnf create() {
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
        return null;
    }

    @Override
    public Matrixnx2f transpose() {
        return new Matrixnx2f(r0, r1);
    }

    @Override
    public String toString() {
        return Arrays.toString(r0) + "\n" + Arrays.toString(r1);
    }

    private void arrayToThis(float[] r0, float[] r1, int len) {
        arraycopy(r0, 0, this.r0, 0, len);
        arraycopy(r1, 0, this.r1, 0, len);
    }

    private void arrayToThis(float[] cAll, int len) {
        arraycopy(cAll, 0, this.r0, 0, len);
        arraycopy(cAll, len, this.r1, 0, len);
    }
}
