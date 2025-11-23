public class S1Q4 {
    public static int sum(int[] a) {
        int sum = 0;
        for (int i: a) {
            sum += i;
        }
        return sum;
    }

    public static int[] cumsum(int[] a) {
        int sum = 0;
        int[] b = new int[a.length];
        for (int i=0; i<a.length; i++) {
            sum += a[i];
            b[i] = sum;
        }
        return b;
    }

    public static int[] positives(int[] a) {
        int length = 0;
        for (int i: a) {
            if (i>=0) length++;
        }

        int[] b = new int[length];
        int j = 0;
        for (int i: a) {
            if (i>=0) b[j++] = i;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,-6,-7,8,-9,0};
        System.out.println(sum(a));

        int[] b = cumsum(a);
        for (int i:b) System.out.println(i);

        int[] c = positives(a);
        for (int i:c) System.out.println(i);
    }
}
