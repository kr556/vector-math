import org.linear.main.matrix.*;
import org.linear.main.vector.*;

public class TestMain {
    public static void main(String[] args) {
        Vector2f v = new Vector2f(1, 1);
        Matrix2f m = new Matrix2f(Matrix2f.DIAGONAL)
                .shear(0.F, 0.5F);

        System.out.println(MatrixUtils.transformation(m, v));
    }
}
