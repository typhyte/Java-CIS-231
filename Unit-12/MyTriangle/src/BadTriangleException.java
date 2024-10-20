public class BadTriangleException extends Exception {
    private double s1, s2, s3;

    public BadTriangleException(double a1, double a2, double a3) {
        s1 = a1;
        s2 = a2;
        s3 = a3;
    }

    public String toString() {
        return "This triangle is invalid";
    }
}
