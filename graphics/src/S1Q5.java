public class S1Q5 {
    public static void vectorAdd (int[] v, int[] dv) {
        v[0] += dv[0];
        v[1] += dv[1];
    }

    public static void main(String[] args) {
        int[] v = {0, 2};
        int[] dv = {1, 1};
        vectorAdd(v, dv);

        for (int i: v) System.out.println(i);
    }
}
