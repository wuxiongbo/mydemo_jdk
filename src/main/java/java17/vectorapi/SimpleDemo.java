package java17.vectorapi;

public class SimpleDemo {

    public static int[] simpleSum(int[] a, int[] b) {
        var c = new int[a.length];
        for (var i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

}
