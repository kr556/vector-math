package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.linear.main.Throws;

import static java.lang.Math.*;

public final class VectorUtils extends Throws {
    private VectorUtils() {}

    public static Vector2f create2f(float len, double angle) {
        return new Vector2f(
                (float) (len * cos(angle)),
                (float) (len * sin(angle)));
    }

    public static Vector2d create2d(double len, double angle) {
        return new Vector2d(
                len * cos(angle),
                len * sin(angle));
    }

    public static Vector2i create2i(int len, double angle) {
        return new Vector2i(
                (int) (len * cos(angle)),
                (int) (len * sin(angle)));
    }

    public static Vector2l create2l(long len, double angle) {
        return new Vector2l(
                (long) (len * cos(angle)),
                (long) (len * sin(angle)));
    }

    public static double len(double x, double y) {
        return sqrt(square(x, y));
    }

    public static double len(double x, double y, double z) {
        return sqrt(square(x, y, z));
    }

    public static double len(double x, double y, double z, double w) {
        return sqrt(square(x, y, z, w));
    }

    public static double angle(double x0, double x1, double y0, double y1) {
        return angleL(x0, x1, y0, y1, len(x0, y0), len(x1, y1));
    }

    private static double angleL(double x0, double x1, double y0, double y1, double len0, double len1) {
        return acos((x0 * x1 + y0 * y1) / (len0 * len1));
    }

    public static double angle(double x0, double x1, double y0, double y1, double z0, double z1) {
        return angleL(x0, x1, y0, y1, z0, z1, len(x0, y0, z0), len(x1, y1, z1));
    }

    private static double angleL(double x0, double x1, double y0, double y1, double z0, double z1, double len0, double len1) {
        return acos((x0 * x1 + y0 * y1 + z0 * z1) / (len0 * len1));
    }

    public static double angle(double x0, double x1, double y0, double y1, double z0, double z1, double w0, double w1) {
        return angleL(x0, x1, y0, y1, z0, z1, w0, w1,len(x0, y0, z0, w0), len(x1, y1, z1, w0));
    }

    private static double angleL(double x0, double x1, double y0, double y1, double z0, double z1, double w0, double w1, double len0, double len1) {
        return acos((x0 * x1 + y0 * y1 + z0 * z1 + w0 * w1) / (len0 * len1));
    }

    public static double dot(double x0, double x1, double y0, double y1) {
        double len0 = len(x0, y0);
        double len1 = len(x1, y1);
        return len0 * len1 * cos(angleL(x0, x1, y0, y1, len0, len1));
    }

    public static double dot(double x0, double x1, double y0, double y1, double z0, double z1) {
        double len0 = len(x0, y0, z0);
        double len1 = len(x1, y1, z1);
        return len0 * len1 * cos(angleL(x0, x1, y0, y1, z0, z1, len0, len1));
    }

    public static double dot(double x0, double x1, double y0, double y1, double z0, double z1, double w0, double w1) {
        double len0 = len(x0, y0, z0, w0);
        double len1 = len(x1, y1, z1, w1);
        return len0 * len1 * cos(angleL(x0, x1, y0, y1, z0, z1, w0, w1, len0, len1));
    }

    public static double square(double x, double y) {
        return x * x + y * y;
    }

    public static double square(double x, double y, double z) {
        return x * x + y * y + z * z;
    }

    public static double square(double x, double y, double z, double w) {
        return x * x + y * y + z * z + w * w;
    }

    public static double distance(double x0, double x1, double y0, double y1) {
        return len(x1 - x0, y1 - y0);
    }

    public static double distance(double x0, double x1, double y0, double y1, double z0, double z1) {
        return len(x1 - x0, y1 - y0, z1 - z0);
    }

    public static double distance(double x0, double x1, double y0, double y1, double z0, double z1, double w0, double w1) {
        return len(x1 - x0, y1 - y0, z1 - z0, w1 - w0);
    }

    public static double len(float x, float y) {
        return sqrt(square(x, y));
    }

    public static double len(float x, float y, float z) {
        return sqrt(square(x, y, z));
    }

    public static double len(float x, float y, float z, float w) {
        return sqrt(square(x, y, z, w));
    }

    public static double angle(float x0, float x1, float y0, float y1) {
        return angleL(x0, x1, y0, y1, len(x0, y0), len(x1, y1));
    }

    private static double angleL(float x0, float x1, float y0, float y1, float len0, float len1) {
        return acos((x0 * x1 + y0 * y1) / (len0 * len1));
    }

    public static double angle(float x0, float x1, float y0, float y1, float z0, float z1) {
        return angleL(x0, x1, y0, y1, z0, z1, len(x0, y0, z0), len(x1, y1, z1));
    }

    private static double angleL(float x0, float x1, float y0, float y1, float z0, float z1, float len0, float len1) {
        return acos((x0 * x1 + y0 * y1 + z0 * z1) / (len0 * len1));
    }

    public static double angle(float x0, float x1, float y0, float y1, float z0, float z1, float w0, double w1) {
        return angleL(x0, x1, y0, y1, z0, z1, w0, w1,len(x0, y0, z0, w0), len(x1, y1, z1, w0));
    }

    private static double angleL(float x0, float x1, float y0, float y1, float z0, float z1, float w0, float w1, float len0, float len1) {
        return acos((x0 * x1 + y0 * y1 + z0 * z1 + w0 * w1) / (len0 * len1));
    }

    public static double dot(float x0, float x1, float y0, float y1) {
        double len0 = len(x0, y0);
        double len1 = len(x1, y1);
        return len0 * len1 * cos(angleL(x0, x1, y0, y1, len0, len1));
    }

    public static double dot(float x0, float x1, float y0, float y1, float z0, float z1) {
        double len0 = len(x0, y0, z0);
        double len1 = len(x1, y1, z1);
        return len0 * len1 * cos(angleL(x0, x1, y0, y1, z0, z1, len0, len1));
    }

    public static double dot(float x0, float x1, float y0, float y1, float z0, float z1, float w0, float w1) {
        double len0 = len(x0, y0, z0, w0);
        double len1 = len(x1, y1, z1, w1);
        return len0 * len1 * cos(angleL(x0, x1, y0, y1, z0, z1, w0, w1, len0, len1));
    }

    public static double square(float x, float y) {
        return x * x + y * y;
    }

    public static double square(float x, float y, float z) {
        return x * x + y * y + z * z;
    }

    public static double square(float x, float y, float z, float w) {
        return x * x + y * y + z * z + w * w;
    }

    public static double distance(float x0, float x1, float y0, float y1) {
        return len(x1 - x0, y1 - y0);
    }

    public static double distance(float x0, float x1, float y0, float y1, float z0, float z1) {
        return len(x1 - x0, y1 - y0, z1 - z0);
    }

    public static double distance(float x0, float x1, float y0, float y1, float z0, float z1, float w0, float w1) {
        return len(x1 - x0, y1 - y0, z1 - z0, w1 - w0);
    }

    public static Vector3f normal3f(Vector3f a, Vector3f b, boolean normalize) {
        return normal3f(a, b, new Vector3f(), normalize);
    }

    public static Vector3f normal3f(Vector3f a, Vector3f b, Vector3f pointer, boolean normalize) {
        pointer.set(cross3f(a, b, pointer));
        if (normalize) return pointer.normalize();
        return pointer;
    }

    public static Vector4f normal3f(Vector4f a, Vector4f b, boolean normalize) {
        return normal3f(a, b, new Vector4f(), normalize);
    }

    public static Vector4f normal3f(Vector4f a, Vector4f b, Vector4f pointer, boolean normalize) {
        pointer.set(cross3f(a, b, pointer));
        if (normalize) {
            float w = pointer.w;
            pointer.w = 0;
            pointer.normalize();
            pointer.w = w;
        }
        return pointer;
    }

    public static Vector3d normal3d(Vector3d a, Vector3d b, Vector3d pointer, boolean normalize) {
        pointer.set(cross3d(a, b, pointer));
        if (normalize) return pointer.normalize();
        return pointer;
    }

    public static Vector3d normal3d(Vector3d a, Vector3d b, boolean normalize) {
        return normal3d(a, b, new Vector3d(), normalize);
    }

    public static Vector4d normal3d(Vector4d a, Vector4d b, Vector4d pointer, boolean normalize) {
        pointer.set(cross3d(a, b, pointer));
        pointer.w = 0;
        if (normalize) return pointer.normalize();
        return pointer;
    }

    public static Vector4d normal3d(Vector4d a, Vector4d b, boolean normalize) {
        return normal3d(a, b, new Vector4d(), normalize);
    }

    public static Vector4d cross3d(Vector4d a, Vector4d b) {
        return cross3d(a, b, new Vector4d());
    }

    public static Vector4d cross3d(Vector4d a, Vector4d b, Vector4d pointer) {
        return cross(a.x, a.y, a.z, b.x, b.y, b.z, pointer);
    }

    public static Vector3d cross3d(Vector3d a, Vector3d b) {
        return a.cross(b);
    }

    public static Vector3d cross3d(Vector3d a, Vector3d b, Vector3d pointer) {
        return a.cross(b, pointer);
    }

    public static Vector4f cross3f(Vector4f a, Vector4f b, Vector4f pointer) {
        return cross(
                a.x, a.y, a.z,
                b.x, b.y, b.z, pointer);
    }

    public static Vector3f cross3f(Vector3f a, Vector3f b, Vector3f pointer) {
        return cross(
                a.x, a.y, a.z,
                b.x, b.y, b.z, pointer);
    }

    private static Vector4d cross(double ax, double ay, double az,
                                  double bx, double by, double bz, Vector4d pointer) {
        pointer.set(
                ay * bz - az * by,
                az * bx - ax * bz,
                ax * by - ay * bx,
                1);
        return pointer;
    }

    private static Vector3d cross(double ax, double ay, double az,
                                  double bx, double by, double bz, Vector3d pointer) {
        pointer.set(
                ay * bz - az * by,
                az * bx - ax * bz,
                ax * by - ay * bx);
        return pointer;
    }

    private static Vector4f cross(float ax, float ay, float az,
                                  float bx, float by, float bz, Vector4f pointer) {
        pointer.set(
                ay * bz - az * by,
                az * bx - ax * bz,
                ax * by - ay * bx,
                1);
        return pointer;
    }

    private static Vector3f cross(float ax, float ay, float az,
                                  float bx, float by, float bz, Vector3f pointer) {
        pointer.set(
                ay * bz - az * by,
                az * bx - ax * bz,
                ax * by - ay * bx);
        return pointer;
    }

    @SafeVarargs
    public static Vector<Float, ?> joinFloat(Vector<Float, ?>... values) {
        if (values == null || values.length == 0 || values[0] == null) return null;
        int allLen = 0;
        int dimMax = 0;
        Float[] all;

        int dimTmp;
        for (Vector<Float, ?> vec : values) {
            if (dimMax < (dimTmp = vec.dimension())) dimMax = dimTmp;
            allLen += dimTmp;
        }

        all = new Float[allLen];
        Vector<Float, ?> tmp;
        Float[] vArr = new Float[dimMax];
        int dim;
        int n = 0;
        int i;
        for (Vector<Float, ?> value : values) {
            dim = (tmp = value).dimension();
            tmp.toArray(vArr);
            for (i = 0; i < dim; i++) {
                Float f = vArr[i];
                all[n++] = f;
            }
        }

        return (Vector<Float, ?>) asVec(all, allLen);
    }

    @SafeVarargs
    public static Vector<Double, ?> joinDouble(Vector<Double, ?>... values) {
        if (values == null || values.length == 0 || values[0] == null) return null;
        int allLen = 0;
        int dimMax = 0;
        Double[] all;

        int dimTmp;
        for (Vector<Double, ?> vec : values) {
            if (dimMax < (dimTmp = vec.dimension())) dimMax = dimTmp;
            allLen += dimTmp;
        }

        all = new Double[allLen];
        Vector<Double, ?> tmp;
        Double[] vArr = new Double[dimMax];
        int dim;
        int n = 0;
        int i;
        for (Vector<Double, ?> value : values) {
            dim = (tmp = value).dimension();
            tmp.toArray(vArr);
            for (i = 0; i < dim; i++) {
                Double f = vArr[i];
                all[n++] = f;
            }
        }

        return (Vector<Double, ?>) asVec(all, allLen);
    }

    @SafeVarargs
    public static Vector<Integer, ?> joinInt(Vector<Integer, ?>... values) {
        if (values == null || values.length == 0 || values[0] == null) return null;
        int allLen = 0;
        int dimMax = 0;
        Integer[] all;

        int dimTmp;
        for (Vector<Integer, ?> vec : values) {
            if (dimMax < (dimTmp = vec.dimension())) dimMax = dimTmp;
            allLen += dimTmp;
        }

        all = new Integer[allLen];
        Vector<Integer, ?> tmp;
        Integer[] vArr = new Integer[dimMax];
        int dim;
        int n = 0;
        int i;
        for (Vector<Integer, ?> value : values) {
            dim = (tmp = value).dimension();
            tmp.toArray(vArr);
            for (i = 0; i < dim; i++) {
                Integer f = vArr[i];
                all[n++] = f;
            }
        }

        return (Vector<Integer, ?>) asVec(all, allLen);
    }

    @SafeVarargs
    public static Vector<Long, ?> joinLong(Vector<Long, ?>... values) {
        if (values == null || values.length == 0 || values[0] == null) return null;
        int allLen = 0;
        int dimMax = 0;
        Long[] all;

        int dimTmp;
        for (Vector<Long, ?> vec : values) {
            if (dimMax < (dimTmp = vec.dimension())) dimMax = dimTmp;
            allLen += dimTmp;
        }

        all = new Long[allLen];
        Vector<Long, ?> tmp;
        Long[] vArr = new Long[dimMax];
        int dim;
        int n = 0;
        int i;
        for (Vector<Long, ?> value : values) {
            dim = (tmp = value).dimension();
            tmp.toArray(vArr);
            for (i = 0; i < dim; i++) {
                Long f = vArr[i];
                all[n++] = f;
            }
        }

        return (Vector<Long, ?>) asVec(all, allLen);
    }

    public static Vector<?, ?> asVector(Number[] elements) {
        return asVec(elements, elements.length);
    }

    private static Vector<?, ?> asVec(@NotNull Number[] all, int len) {
        if (all.length == 0) throwArrEmpty();
        if (len == 1) new VScalar<>(all[0]);
        if (all[0] instanceof Float) {
            return switch (len) {
                case 2 -> new Vector2f((float) all[0], (float) all[1]);
                case 3 -> new Vector3f((float) all[0], (float) all[1], (float) all[2]);
                case 4 -> new Vector4f((float) all[0], (float) all[1], (float) all[2], (float) all[3]);
                default -> {
                    Vectornf re = new Vectornf(len);
                    for (int i = 0; i < len; i++) {
                        re.set(i, (Float) all[i]);
                    }
                    yield re;
                }
            };
        } else if (all[0] instanceof Double) {
            return switch (len) {
                case 2 -> new Vector2d((double) all[0], (double) all[1]);
                case 3 -> new Vector3d((double) all[0], (double) all[1], (double) all[2]);
                case 4 -> new Vector4d((double) all[0], (double) all[1], (double) all[2], (double) all[3]);
                default -> {
                    Vectornd re = new Vectornd(len);
                    for (int i = 0; i < len; i++) {
                        re.set(i, (Double) all[i]);
                    }
                    yield re;
                }
            };
        } else if (all[0] instanceof Integer) {
            return switch (len) {
                case 2 -> new Vector2i((int) all[0], (int) all[1]);
                case 3 -> new Vector3i((int) all[0], (int) all[1], (int) all[2]);
                case 4 -> new Vector4i((int) all[0], (int) all[1], (int) all[2], (int) all[3]);
                default -> {
                    Vectornf re = new Vectornf(len);
                    for (int i = 0; i < len; i++) {
                        re.set(i, (Integer) all[i]);
                    }
                    yield re;
                }
            };
        } else if (all[0] instanceof Long) {
            return switch (len) {
                case 2 -> new Vector2l((long) all[0], (long) all[1]);
                case 3 -> new Vector3l((long) all[0], (long) all[1], (long) all[2]);
                case 4 -> new Vector4l((long) all[0], (long) all[1], (long) all[2], (long) all[3]);
                default -> {
                    Vectornl re = new Vectornl(len);
                    for (int i = 0; i < len; i++) {
                        re.set(i, (Long) all[i]);
                    }
                    yield re;
                }
            };
        } else {
            throw new IllegalArgumentException(": unsuport type.");
        }
    }

    public static Vector<Float, ?> asVector(float[] arr) {
        if (arr.length == 0) throwArrEmpty();
        return switch (arr.length) {
            case 1 -> new VScalar<>(arr[0]);
            case 2 -> new Vector2f(arr[0], arr[1]);
            case 3 -> new Vector3f(arr[0], arr[1], arr[2]);
            case 4 -> new Vector4f(arr[0], arr[1], arr[2], arr[3]);
            default -> new Vectornf(arr);
        };
    }

    public static Vector<Integer, ?> asVector(int[] arr) {
        if (arr.length == 0) throwArrEmpty();
        return switch (arr.length) {
            case 1 -> new VScalar<>(arr[0]);
            case 2 -> new Vector2i(arr[0], arr[1]);
            case 3 -> new Vector3i(arr[0], arr[1], arr[2]);
            case 4 -> new Vector4i(arr[0], arr[1], arr[2], arr[3]);
            default -> new Vectorni(arr);
        };
    }

    public static Vector<Double, ?> asVector(double[] arr) {
        if (arr.length == 0) throwArrEmpty();
        return switch (arr.length) {
            case 1 -> new VScalar<>(arr[0]);
            case 2 -> new Vector2d(arr[0], arr[1]);
            case 3 -> new Vector3d(arr[0], arr[1], arr[2]);
            case 4 -> new Vector4d(arr[0], arr[1], arr[2], arr[3]);
            default -> new Vectornd(arr);
        };
    }

    public static Vector<Long, ?> asVector(long[] arr) {
        if (arr.length == 0) throwArrEmpty();
        return switch (arr.length) {
            case 1 -> new VScalar<>(arr[0]);
            case 2 -> new Vector2l(arr[0], arr[1]);
            case 3 -> new Vector3l(arr[0], arr[1], arr[2]);
            case 4 -> new Vector4l(arr[0], arr[1], arr[2], arr[3]);
            default -> new Vectornl(arr);
        };
    }

    public static boolean equalsDimensional(Vector<?, ?> v1, Vector<?, ?> v2) {
        return v1.dimension() == v2.dimension();
    }
}
