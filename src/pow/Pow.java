package pow;

public class Pow {

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        boolean neg = false;
        if (n < 0) {
            neg = true;
            n = -n;
        }
        int k = n / 2;
        int l = n - k * 2;
        double t1 = pow(x, k);
        double t2 = pow(x, l);
        if (!neg) {
            return t1 * t1 * t2;
        } else {
            return 1.0 / (t1 * t1 * t2);
        }
    }

}
