public class MyTriangle {
    private double s1, s2, s3;

    public MyTriangle(double a1, double a2, double a3) throws BadTriangleException {
        s1 = a1;
        s2 = a2;
        s3 = a3;

        if ((s1 + s2 <= s3) || (s1 + s3 <= s2) || (s2 + s3 <= s1)) {
            throw new BadTriangleException(a1, a2, a3);
        }
    }

    public double getPerimeter() {
        return s1+s2+s3;
    }
}
