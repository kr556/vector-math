package org.linear.main.matrix;

import org.jetbrains.annotations.NotNull;
import org.linear.main.vector.Vector2f;
import org.linear.main.vector.Vector3f;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;

import java.nio.Buffer;
import java.nio.FloatBuffer;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Matrix2f extends SquareMatrix<Float, Matrix2f>
        implements FloatMatrix<Matrix2f, Matrix2f> {
    public final static Matrix2f NAN = new Matrix2f(
            Float.NaN, Float.NaN,
            Float.NaN, Float.NaN);

    public final static Matrix2f DIAGONAL = new Matrix2f(
            1, 0,
            0, 1);

    public float
            m00, m01,
            m10, m11;

    public Matrix2f(float m00, float m01,
                    float m10, float m11) {
        this.m00 = m00; this.m01 = m01;
        this.m10 = m10; this.m11 = m11;
    }

    public Matrix2f(double m00, double m01,
                    double m10, double m11) {
        this.m00 = (float) m00; this.m01 = (float) m01;
        this.m10 = (float) m10; this.m11 = (float) m11;
    }

    public Matrix2f(Matrix2f copy) {
        set(copy);
    }

    @Override
    public double determinant() {
        return m00 * m11 - m01 * m10;
    }

    public Matrix2f() {}

    @Override
    public void set(Matrix2f copy) {
        this.m00 = copy.m00; this.m01 = copy.m01;
        this.m10 = copy.m10; this.m11 = copy.m11;
    }

    @Override
    public FloatBuffer get(int offset, Buffer pointer) {
        FloatBuffer bf = (FloatBuffer) pointer;
        bf.put(offset    , m00);
        bf.put(offset + 1, m01);
        bf.put(offset + 2, m10);
        bf.put(offset + 3, m11);
        return bf;
    }

    @Override
    public Matrix2f craete() {
        return new Matrix2f(this);
    }

    @Override
    public Matrix2f abs() {
        this.m00 = Math.abs(m00); this.m01 = Math.abs(m01);
        this.m10 = Math.abs(m10); this.m11 = Math.abs(m11);
        return this;
    }

    @Override
    public Matrix2f abs(Matrix2f pointer) {
        pointer.m00 = Math.abs(m00); pointer.m01 = Math.abs(m01);
        pointer.m10 = Math.abs(m10); pointer.m11 = Math.abs(m11);
        return this;
    }

    @Override
    public Matrix2f add(float value) {
        this.m00 += value; this.m01 += value;
        this.m10 += value; this.m11 += value;
        return this;
    }

    @Override
    public Matrix2f add(float value, Matrix2f pointer) {
        pointer.m00 = m00 + value; pointer.m01 = m01 + value;
        pointer.m10 = m10 + value; pointer.m11 = m11 + value;
        return pointer;
    }

    @Override
    public Matrix2f add(Matrix2f value) {
        this.m00 += value.m00; this.m01 += value.m01;
        this.m10 += value.m10; this.m11 += value.m11;
        return this;
    }

    @Override
    public Matrix2f add(Matrix2f value, Matrix2f pointer) {
        pointer.m00 = m00 + value.m00; pointer.m01 = m01 + value.m01;
        pointer.m10 = m10 + value.m10; pointer.m11 = m11 + value.m11;
        return pointer;
    }

    @Override
    public Matrix2f sub(float value) {
        this.m00 -= value; this.m01 -= value;
        this.m10 -= value; this.m11 -= value;
        return this;
    }

    @Override
    public Matrix2f sub(float value, Matrix2f pointer) {
        pointer.m00 = m00 - value; pointer.m01 = m01 - value;
        pointer.m10 = m10 - value; pointer.m11 = m11 - value;
        return pointer;
    }

    @Override
    public Matrix2f sub(Matrix2f value) {
        this.m00 -= value.m00; this.m01 -= value.m01;
        this.m10 -= value.m10; this.m11 -= value.m11;
        return this;
    }

    @Override
    public Matrix2f sub(Matrix2f value, Matrix2f pointer) {
        pointer.m00 = m00 - value.m00; pointer.m01 = m01 - value.m01;
        pointer.m10 = m10 - value.m10; pointer.m11 = m11 - value.m11;
        return pointer;
    }

    @Override
    public Matrix2f mul(double value) {
        this.m00 *= (float) value; this.m01 *= (float) value;
        this.m10 *= (float) value; this.m11 *= (float) value;
        return this;
    }

    @Override
    public Matrix2f div(double value) {
        this.m00 /= (float) value; this.m01 /= (float) value;
        this.m10 /= (float) value; this.m11 /= (float) value;
        return this;
    }

    @Override
    public Matrix2f div(Matrix2f value) {
        this.m00 /= value.m00; this.m01 /= value.m01;
        this.m10 /= value.m10; this.m11 /= value.m11;
        return this;
    }

    @Override
    public Matrix2f mul(Matrix2f value) {
        this.m00 *= value.m00; this.m01 *= value.m01;
        this.m10 *= value.m10; this.m11 *= value.m11;
        return this;
    }

    @Override
    public Matrix2f mul(Matrix2f value, Matrix2f pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0  -> m00; case 1-> m01;
            case 2  -> m10; case 3  -> m11;
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public boolean equals(@NotNull Matrix2f value) {
        return this.m00 == value.m00 &&
               this.m01 == value.m01 &&
               this.m10 == value.m10 &&
               this.m11 == value.m11;
    }

    @Override
    public final boolean isNaN() {
        return Float.isNaN(m00) && Float.isNaN(m01) &&
               Float.isNaN(m10) && Float.isNaN(m11);
    }

    @Override
    public Matrix2f transpose() {
        final float m12 = this.m10;
        final float m21 = this.m01;
        this.m01 = m12;
        this.m10 = m21;
        return this;
    }

    public final Matrix2f mulC(float m00, float m01,
                               float m10, float m11) {
        set(
                this.m00 * m00 + this.m01 * m10, this.m00 * m01 + this.m01 * m11,
                this.m10 * m00 + this.m11 * m10, this.m10 * m01 + this.m11 * m11
        );
        return this;
    }

    @Override
    public Matrix2f mulC(Matrix2f value) {
        return mulC(
                value.m00, value.m01,
                value.m10, value.m11);
    }

    public final Matrix2f mulR(float m00, float m01,
                               float m10, float m11) {
        set(
                m00 * this.m00 + m01 * this.m10, m00 * this.m01 + m01 * this.m11,
                m10 * this.m00 + m11 * this.m10, m10 * this.m01 + m11 * this.m11
        );
        return this;
    }

    @Override
    public Matrix2f mulR(Matrix2f value) {
        return mulR(
                value.m00, value.m01,
                value.m10, value.m11);
    }

    @Override
    public Matrix2f create() {
        return new Matrix2f();
    }

    @PropertiesMethod
    @Override
    public final int columnDimension() {
        return 2;
    }

    @PropertiesMethod
    @Override
    public final int rowDimension() {
        return 2;
    }

    @PropertiesMethod
    @Override
    public int elementsSize() {
        return 4;
    }

    @Final
    @Override
    public Float[] getRow(int index) {
        return switch (index) {
            case 0 -> new Float[]{m00, m01};
            case 1 -> new Float[]{m10, m11};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Final
    @Override
    public Float[] getColumn(int index) {
        return switch (index) {
            case 0 -> new Float[]{m00, m10};
            case 1 -> new Float[]{m01, m11};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Final
    @Override
    public void set(int r, int c, Float value) {
        switch (r) {
            case 0 -> {
                switch (c) {
                    case 0 -> m00 = value;
                    case 1 -> m01 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 1 -> {
                switch (c) {
                    case 0 -> m10 = value;
                    case 1 -> m11 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(float m00, float m01,
                    float m10, float m11) {
        this.m00 = m00; this.m01 = m01;
        this.m10 = m10; this.m11 = m11;
    }

    @Override
    public Float get(int r, int c) {
        return switch (r) {
            case 0 -> switch (c) {
                case 0 -> m00;
                case 1 -> m01;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            case 1 -> switch (c) {
                case 0 -> m10;
                case 1 -> m11;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public Matrix2f cofactor() {
        set(m11, -m01,
                -m10, m00);
        return this;
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.m00;
        pointer[1] = this.m01;
        pointer[2] = this.m10;
        pointer[3] = this.m11;
        return pointer;
    }

    @Override
    public float[] copy(int destPos, float[] pointer) {
        pointer[destPos] = this.m00;
        pointer[1 + destPos] = this.m01;
        pointer[2 + destPos] = this.m10;
        pointer[3 + destPos] = this.m11;
        return pointer;
    }

    public final Matrix2f rotate90() {
        float tmp = m00;
        m00 = m01;
        m01 = -tmp;

        tmp = m10;
        m10 = m11;
        m11 = -tmp;
        return this;
    }

    public final Matrix2f rotate180() {
        m00 = -m00;
        m11 = -m11;
        return this;
    }

    public final Matrix2f rotate270() {
        float tmp = m00;
        m00 = -m01;
        m01 = tmp;

        tmp = m10;
        m10 = -m11;
        m11 = tmp;
        return this;
    }

    public final Matrix2f rotate(double z) {
        return null;
    }

    public final Matrix2f setRotate90() {
        set(
                0, -1,
                1, 0
        );
        return this;
    }

    public final Matrix2f setRotate180() {
        set(
                -1, 0,
                0, -1
        );
        return this;
    }

    public final Matrix2f setRotate270() {
        set(
                0, 1,
                -1, 0
        );
        return this;
    }

    public final Matrix2f setRotate(double z) {
        final float s = (float) sin(z);
        final float c = (float) cos(z);

        set(
                c, -s,
                s, c
        );
        return this;
    }

    public final Matrix2f scale(float x, float y) {
        m00 *= x;
        m11 *= y;
        return this;
    }

    public final Matrix2f scale(Vector2f scales) {
        m00 *= scales.x;
        m11 *= scales.y;
        return this;
    }

    public final Matrix2f scale(float scale) {
        m00 *= scale;
        m11 *= scale;
        return this;
    }

    public final Matrix2f scaleX(float scale) {
        m00 *= scale;
        return this;
    }

    public final Matrix2f scaleY(float scale) {
        m11 *= scale;
        return this;
    }

    public final Matrix2f setScale(float x, float y) {
        set(
                x, 0,
                0, y
        );
        return this;
    }

    public final Matrix2f setScale(Vector3f scales) {
        return setScale(scales.x, scales.y);
    }

    public final Matrix2f setScale(float s) {
        set(
                s, 0,
                0, s
        );
        return this;
    }

    public final Matrix2f setScaleX(float s) {
        set(
                s, 0,
                0, 1
        );
        return this;
    }

    public final Matrix2f setScaleY(float s) {
        set(
                1, 0,
                0, s
        );
        return this;
    }

    public final Matrix2f shear(float x, float y) {
        set(
                m01 + m00 * x,
                m01 * y + m00,
                m11 + m10 * x,
                m11 * y + m10
        );
        return this;
    }

    public final Matrix2f shear(Vector2f shears) {
        return shear(shears.x, shears.y);
    }

    public final Matrix2f setShear(float x, float y) {
        set(
                1, x,
                y, 1
        );
        return this;
    }

    public final Matrix2f setShear(Vector2f shears) {
        return setShear(shears.x, shears.y);
    }
}
