package org.linear.main.matrix;

import org.linear.main.vector.*;

public class MatrixUtils {
    protected MatrixUtils() {}

    public static double det2(double m00, double m01,
                              double m10, double m11) {
        return m00 * m11 - m01 * m11;
    }

    public static double det3(double m00, double m01, double m02,
                              double m10, double m11, double m12,
                              double m20, double m21, double m22) {
        return m00 * m11 * m22 +
               m01 * m12 * m20 +
               m02 * m10 * m21 -
               m02 * m11 * m20 -
               m00 * m12 * m21 -
               m01 * m10 * m22;
    }

    public static double det4(double m00, double m01, double m02, double m03,
                              double m10, double m11, double m12, double m13,
                              double m20, double m21, double m22, double m23,
                              double m30, double m31, double m32, double m33) {
        return (m00 * m11 - m01 * m10) * (m22 * m33 - m23 * m32)
               - (m00 * m12 - m02 * m10) * (m21 * m33 - m23 * m31)
               + (m00 * m13 - m03 * m10) * (m21 * m32 - m22 * m31)
               + (m01 * m12 - m02 * m11) * (m20 * m33 - m23 * m30)
               - (m01 * m13 - m03 * m11) * (m20 * m32 - m22 * m30)
               + (m02 * m13 - m03 * m12) * (m20 * m31 - m21 * m30);
    }

    public static Matrix2f diagonal2f() {
        return Matrix2f.DIAGONAL.craete();
    }

    public static Matrix2d diagonal2d() {
        return Matrix2d.DIAGONAL.craete();
    }

    public static Matrix3f diagonal3f() {
        return Matrix3f.DIAGONAL.clone();
    }

    public static Matrix3d diagonal3d() {
        return Matrix3d.DIAGONAL.clone();
    }

    public static Matrix4f diagonal4f() {
        return Matrix4f.DIAGONAL.clone();
    }

    public static Matrix4d diagonal4d() {
        return Matrix4d.DIAGONAL.clone();
    }

    public static Matrix2f create(float m00, float m01,
                                  float m10, float m11) {
        return new Matrix2f(m00, m01, m10, m11);
    }

    public static Matrix2d create(double m00, double m01,
                                 double m10, double m11) {
        return new Matrix2d(m00, m01, m10, m11);
    }

    public static Matrix3f create(float m00, float m01, float m02,
                                  float m10, float m11, float m12,
                                  float m20, float m21, float m22) {
        return new Matrix3f(m00, m01, m02, m10, m11, m12, m20, m21, m22);
    }

    public static Matrix3d create(double m00, double m01, double m02,
                                  double m10, double m11, double m12,
                                  double m20, double m21, double m22) {
        return new Matrix3d(m00, m01, m02, m10, m11, m12, m20, m21, m22);
    }

    public static Matrix4f create(float m00, float m01, float m02, float m03,
                                  float m10, float m11, float m12, float m13,
                                  float m20, float m21, float m22, float m23,
                                  float m30, float m31, float m32, float m33) {
        return new Matrix4f(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
    }

    public static Matrix4d create(double m00, double m01, double m02, double m03,
                                  double m10, double m11, double m12, double m13,
                                  double m20, double m21, double m22, double m23,
                                  double m30, double m31, double m32, double m33) {
        return new Matrix4d(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
    }

    public static Vector2f transformation(Matrix3f matrix, Vector2f vector) {
        vector.set(
                matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02,
                matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12
        );
        return vector;
    }

    public static Vector2d transformation(Matrix3d matrix, Vector2d vector) {
        vector.set(
                matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02,
                matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12
        );
        return vector;
    }

    public static Vector2i transformation(Matrix3f matrix, Vector2i vector) {
        vector.set(
                (int)(matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02),
                (int)(matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12)
        );
        return vector;
    }

    public static Vector2l transformation(Matrix3d matrix, Vector2l vector) {
        vector.set(
                (long)(matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02),
                (long)(matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12)
        );
        return vector;
    }

    public static Vector3f transformation(Matrix4f matrix, Vector3f vector) {
        vector.set(
                matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02 * vector.z + matrix.m03,
                matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12 * vector.z + matrix.m13,
                matrix.m20 * vector.x + matrix.m21 * vector.y + matrix.m22 * vector.z + matrix.m23
        );
        return vector;
    }

    public static Vector3d transformation(Matrix4d matrix, Vector3d vector) {
        vector.set(
                matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02 * vector.z + matrix.m03,
                matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12 * vector.z + matrix.m13,
                matrix.m20 * vector.x + matrix.m21 * vector.y + matrix.m22 * vector.z + matrix.m23
        );
        return vector;
    }

    public static Vector3i transformation(Matrix4f matrix, Vector3i vector) {
        vector.set(
                (int)(matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02 * vector.z + matrix.m03),
                (int)(matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12 * vector.z + matrix.m13),
                (int)(matrix.m20 * vector.x + matrix.m21 * vector.y + matrix.m22 * vector.z + matrix.m23)
        );
        return vector;
    }

    public static Vector3l transformation(Matrix4d matrix, Vector3l vector) {
        vector.set(
                (long)(matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02 * vector.z + matrix.m03),
                (long)(matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12 * vector.z + matrix.m13),
                (long)(matrix.m20 * vector.x + matrix.m21 * vector.y + matrix.m22 * vector.z + matrix.m23)
        );
        return vector;
    }

    public static Vector2f transformation(Vector2f vector,Matrix3f matrix) {
        vector.set(
                matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20,
                matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21
        );
        return vector;
    }

    public static Vector2d transformation(Vector2d vector, Matrix3d matrix) {
        vector.set(
                matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20,
                matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21
        );
        return vector;
    }

    public static Vector2i transformation(Vector2i vector,Matrix3f matrix) {
        vector.set(
                (int)(matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20),
                (int)(matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21)
        );
        return vector;
    }

    public static Vector2l transformation(Vector2l vector, Matrix3d matrix) {
        vector.set(
                (long)(matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20),
                (long)(matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21)
        );
        return vector;
    }

    public static Vector3f transformation(Vector3f vector, Matrix4f matrix) {
        vector.set(
                matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z + matrix.m30,
                matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z + matrix.m31,
                matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z + matrix.m32
        );
        return vector;
    }

    public static Vector3d transformation(Vector3d vector, Matrix4f matrix) {
        vector.set(
                matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z + matrix.m30,
                matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z + matrix.m31,
                matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z + matrix.m32
        );
        return vector;
    }

    public static Vector3i transformation(Vector3i vector, Matrix4f matrix) {
        vector.set(
                (int)(matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z + matrix.m30),
                (int)(matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z + matrix.m31),
                (int)(matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z + matrix.m32)
        );
        return vector;
    }

    public static Vector3l transformation(Vector3l vector, Matrix4d matrix) {
        vector.set(
                (long)(matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z + matrix.m30),
                (long)(matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z + matrix.m31),
                (long)(matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z + matrix.m32)
        );
        return vector;
    }

    public static Vector2f transformation(Matrix2f matrix, Vector2f vector) {
        vector.set(
                matrix.m00 * vector.x + matrix.m01 * vector.y,
                matrix.m10 * vector.x + matrix.m11 * vector.y
        );
        return vector;
    }

    public static Vector2d transformation(Matrix2d matrix, Vector2d vector) {
        vector.set(
                matrix.m00 * vector.x + matrix.m01 * vector.y,
                matrix.m10 * vector.x + matrix.m11 * vector.y
        );
        return vector;
    }

    public static Vector2i transformation(Matrix2f matrix, Vector2i vector) {
        vector.set(
                (int)(matrix.m00 * vector.x + matrix.m01 * vector.y),
                (int)(matrix.m10 * vector.x + matrix.m11 * vector.y)
        );
        return vector;
    }

    public static Vector2l transformation(Matrix2d matrix, Vector2l vector) {
        vector.set(
                (long)(matrix.m00 * vector.x + matrix.m01 * vector.y),
                (long)(matrix.m10 * vector.x + matrix.m11 * vector.y)
        );
        return vector;
    }

    public static Vector3f transformation(Matrix3f matrix, Vector3f vector) {
        vector.set(
                matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02 * vector.z,
                matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12 * vector.z,
                matrix.m20 * vector.x + matrix.m21 * vector.y + matrix.m22 * vector.z
        );
        return vector;
    }

    public static Vector3d transformation(Matrix3d matrix, Vector3d vector) {
        vector.set(
                matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02 * vector.z,
                matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12 * vector.z,
                matrix.m20 * vector.x + matrix.m21 * vector.y + matrix.m22 * vector.z
        );
        return vector;
    }

    public static Vector3i transformation(Matrix3f matrix, Vector3i vector) {
        vector.set(
                (int)(matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02 * vector.z),
                (int)(matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12 * vector.z),
                (int)(matrix.m20 * vector.x + matrix.m21 * vector.y + matrix.m22 * vector.z)
        );
        return vector;
    }

    public static Vector3l transformation(Matrix3d matrix, Vector3l vector) {
        vector.set(
                (long)(matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02 * vector.z),
                (long)(matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12 * vector.z),
                (long)(matrix.m20 * vector.x + matrix.m21 * vector.y + matrix.m22 * vector.z)
        );
        return vector;
    }

    public static Vector4f transformation(Matrix4f matrix, Vector4f vector) {
        return matrix.transformation(vector);
    }

    public static Vector4d transformation(Matrix4d matrix, Vector4d vector) {
        return matrix.transformation(vector);
    }

    public static Vector4i transformation(Matrix4f matrix, Vector4i vector) {
        vector.set(
                (int)(matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02 * vector.z + matrix.m03 * vector.w),
                (int)(matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12 * vector.z + matrix.m13 * vector.w),
                (int)(matrix.m20 * vector.x + matrix.m21 * vector.y + matrix.m22 * vector.z + matrix.m23 * vector.w),
                (int)(matrix.m30 * vector.x + matrix.m31 * vector.y + matrix.m32 * vector.z + matrix.m33 * vector.w)
        );
        return vector;
    }

    public static Vector4l transformation(Matrix4d matrix, Vector4l vector) {
        vector.set(
                (long)(matrix.m00 * vector.x + matrix.m01 * vector.y + matrix.m02 * vector.z + matrix.m03 * vector.w),
                (long)(matrix.m10 * vector.x + matrix.m11 * vector.y + matrix.m12 * vector.z + matrix.m13 * vector.w),
                (long)(matrix.m20 * vector.x + matrix.m21 * vector.y + matrix.m22 * vector.z + matrix.m23 * vector.w),
                (long)(matrix.m30 * vector.x + matrix.m31 * vector.y + matrix.m32 * vector.z + matrix.m33 * vector.w)
        );
        return vector;
    }

    public static Vector2f transformation(Vector2f vector, Matrix2f matrix) {
        vector.set(
                matrix.m00 * vector.x + matrix.m01 * vector.y,
                matrix.m01 * vector.x + matrix.m11 * vector.y
        );
        return vector;
    }

    public static Vector2d transformation(Vector2d vector, Matrix2d matrix) {
        vector.set(
                matrix.m00 * vector.x + matrix.m10 * vector.y,
                matrix.m01 * vector.x + matrix.m11 * vector.y
        );
        return vector;
    }

    public static Vector2i transformation(Vector2i vector, Matrix2f matrix) {
        vector.set(
                (int)(matrix.m00 * vector.x + matrix.m10 * vector.y),
                (int)(matrix.m01 * vector.x + matrix.m11 * vector.y)
        );
        return vector;
    }

    public static Vector2l transformation(Vector2l vector, Matrix2d matrix) {
        vector.set(
                (long)(matrix.m00 * vector.x + matrix.m10 * vector.y),
                (long)(matrix.m01 * vector.x + matrix.m11 * vector.y)
        );
        return vector;
    }

    public static Vector3f transformation(Vector3f vector,Matrix3f matrix) {
        vector.set(
                matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z,
                matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z,
                matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z
        );
        return vector;
    }

    public static Vector3d transformation(Vector3d vector, Matrix3d matrix) {
        vector.set(
                matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z,
                matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z,
                matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z
        );
        return vector;
    }

    public static Vector3i transformation(Vector3i vector,Matrix3f matrix) {
        vector.set(
                (int)(matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z),
                (int)(matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z),
                (int)(matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z)
        );
        return vector;
    }

    public static Vector3l transformation(Vector3l vector, Matrix3d matrix) {
        vector.set(
                (long)(matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z),
                (long)(matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z),
                (long)(matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z)
        );
        return vector;
    }

    public static Vector4f transformation(Vector4f vector, Matrix4f matrix) {
        vector.set(
                matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z + matrix.m30 * vector.w,
                matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z + matrix.m31 * vector.w,
                matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z + matrix.m32 * vector.w,
                matrix.m03 * vector.x + matrix.m13 * vector.y + matrix.m23 * vector.z + matrix.m33 * vector.w
        );
        return vector;
    }

    public static Vector4d transformation(Vector4d vector, Matrix4f matrix) {
        vector.set(
                matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z + matrix.m30 * vector.w,
                matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z + matrix.m31 * vector.w,
                matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z + matrix.m32 * vector.w,
                matrix.m03 * vector.x + matrix.m13 * vector.y + matrix.m23 * vector.z + matrix.m33 * vector.w
        );
        return vector;
    }

    public static Vector4i transformation(Vector4i vector, Matrix4f matrix) {
        vector.set(
                (int)(matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z + matrix.m30 * vector.w),
                (int)(matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z + matrix.m31 * vector.w),
                (int)(matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z + matrix.m32 * vector.w),
                (int)(matrix.m03 * vector.x + matrix.m13 * vector.y + matrix.m23 * vector.z + matrix.m33 * vector.w)
        );
        return vector;
    }

    public static Vector4l transformation(Vector4l vector, Matrix4d matrix) {
        vector.set(
                (long)(matrix.m00 * vector.x + matrix.m10 * vector.y + matrix.m20 * vector.z + matrix.m30 * vector.w),
                (long)(matrix.m01 * vector.x + matrix.m11 * vector.y + matrix.m21 * vector.z + matrix.m31 * vector.w),
                (long)(matrix.m02 * vector.x + matrix.m12 * vector.y + matrix.m22 * vector.z + matrix.m32 * vector.w),
                (long)(matrix.m03 * vector.x + matrix.m13 * vector.y + matrix.m23 * vector.z + matrix.m33 * vector.w)
        );
        return vector;
    }


    public static <E extends  Number,MAT extends PrimitiveMatrix<E,MAT, MAT >, VEC extends PrimitiveVector<E, VEC>> VEC transformation(MAT matrix, VEC vector) {
        if (matrix instanceof SquareMatrix<?,?>) {
            if (matrix.rowDimension() == vector.dimension()) {
                MAT mTmp = matrix.craete();
                MAT mAns = matrix.craete();

                mTmp.map((r, c) -> vector.get(r));

                mAns.mul(mTmp);

                vector.map(i -> mAns.get(mAns.posToIndex(i, 0)));

                return vector;
            }
        }

        throw new UnsupportedOperationException(" : The matrix is not square.");
    }

    public static <E extends  Number,MAT extends PrimitiveMatrix<E,MAT, MAT>, VEC extends PrimitiveVector<E, VEC>> VEC transformation(MAT matrix, VEC vector, VEC pointer) {
        if (matrix instanceof SquareMatrix<?,?>) {
            if (matrix.rowDimension() - 1 == vector.dimension()) {
                MAT mTmp = (matrix).craete();
                MAT mAns = (matrix).craete();

                mTmp.map((r, c) -> vector.get(r));

                (mAns).mul(mTmp);

                pointer.map(i -> mAns.get(mAns.posToIndex(i, 0)));

                return pointer;
            }
        }

        throw new UnsupportedOperationException(" : The matrix is not square.");
    }
}
