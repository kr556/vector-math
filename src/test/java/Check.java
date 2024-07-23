import org.linear.main.matrix.*;
import org.linear.main.vector.*;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;

public class Check {
    public static void main(String[] args) {
        FloatBuffer     fv2f = FloatBuffer.allocate(10);
        FloatBuffer     fv3f = FloatBuffer.allocate(10);
        FloatBuffer     fv4f = FloatBuffer.allocate(10);
        DoubleBuffer    fv2d = DoubleBuffer.allocate(10);
        DoubleBuffer    fv3d = DoubleBuffer.allocate(10);
        DoubleBuffer    fv4d = DoubleBuffer.allocate(10);
        IntBuffer       fv2i = IntBuffer.allocate(10);
        IntBuffer       fv3i = IntBuffer.allocate(10);
        IntBuffer       fv4i = IntBuffer.allocate(10);
        LongBuffer      fv2l = LongBuffer.allocate(10);
        LongBuffer      fv3l = LongBuffer.allocate(10);
        LongBuffer      fv4l = LongBuffer.allocate(10);

        Vector2f v2f = new Vector2f(19);
        Vector3f v3f = new Vector3f(19);
        Vector4f v4f = new Vector4f(19);
        Vector2d v2d = new Vector2d(19);
        Vector3d v3d = new Vector3d(19);
        Vector4d v4d = new Vector4d(19);
        Vector2i v2i = new Vector2i(19);
        Vector3i v3i = new Vector3i(19);
        Vector4i v4i = new Vector4i(19);
        Vector2l v2l = new Vector2l(19);
        Vector3l v3l = new Vector3l(19);
        Vector4l v4l = new Vector4l(19);

        v2f.get(0, fv2f);
        v3f.get(0, fv3f);
        v4f.get(0, fv4f);
        v2d.get(0, fv2d);
        v3d.get(0, fv3d);
        v4d.get(0, fv4d);
        v2i.get(0, fv2i);
        v3i.get(0, fv3i);
        v4i.get(0, fv4i);
        v2l.get(0, fv2l);
        v3l.get(0, fv3l);
        v4l.get(0, fv4l);


        System.out.println(Arrays.toString(fv2f.array()));
        System.out.println(Arrays.toString(fv3f.array()));
        System.out.println(Arrays.toString(fv4f.array()));
        System.out.println(Arrays.toString(fv2d.array()));
        System.out.println(Arrays.toString(fv3d.array()));
        System.out.println(Arrays.toString(fv4d.array()));
        System.out.println(Arrays.toString(fv2i.array()));
        System.out.println(Arrays.toString(fv3i.array()));
        System.out.println(Arrays.toString(fv4i.array()));
        System.out.println(Arrays.toString(fv2l.array()));
        System.out.println(Arrays.toString(fv3l.array()));
        System.out.println(Arrays.toString(fv4l.array()));
    }
}
