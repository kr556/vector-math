import org.linear.aid.LinearMath;
import org.linear.main.ArithmeticGeneric;
import org.linear.main.matrix.*;
import org.linear.main.vector.Vector2d;
import org.linear.main.vector.Vector3d;
import org.linear.main.vector.Vector4d;

import java.util.Arrays;

public class Test00  {
    public static void main(String[] args) {
        SquareMatrix<Double, ?> md = new Matrix4d(

        );

        Vector3d a = new Vector3d(1, 0, 0);
        Vector3d b = new Vector3d(0, 1, 0);

        System.out.println(LinearMath.normal3d(a, b, true));
    }
}
