import org.linear.main.vector.Vector3d;

public class Test {
    public static void main(String[] args) {
        Vector3d a = new Vector3d(1, 3, 4);
        Vector3d b = new Vector3d(5, 77, 8);
        Vector3d p = new Vector3d();

        Vector3d n = a.cross(b, p);

        System.out.println(n);

        System.out.println(a.dot(n));
        System.out.println(b.dot(n));
    }

    static Vector3d normal(Vector3d a,Vector3d b,Vector3d c) {
        Vector3d ca = new Vector3d(
                c.x - b.x,
                c.y - b.y,
                c.z - b.z
        );
        Vector3d cb = new Vector3d(
                c.x - a.x,
                c.y - a.y,
                c.z - a.z
        );

        return cross(ca, cb);
    }

    public static Vector3d cross(Vector3d a,Vector3d b) {
        return new Vector3d(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x
        );
    }
}
