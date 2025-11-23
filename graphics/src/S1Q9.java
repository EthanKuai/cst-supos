public class S1Q9 {
    public static void main(String[] args) {
        Stack<Double> s = new Stack<>();
        s.push(0.5);
        s.push(1.5);
        s.print();
        System.out.println(s.tail());
        System.out.println(s.pop());
        s.print();
    }
}
