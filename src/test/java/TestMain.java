import org.linear.main.matrix.*;
import org.linear.main.vector.*;

public class TestMain {
    public static void main(String[] args) {
        Vector2d v = new Vector2d(1, 1);
        Matrix2d m = new Matrix2d(Matrix2d.DIAGONAL)
                .shear(0., 0.5);

        System.out.println(MatrixUtils.transformation(m, v));
    }
}
