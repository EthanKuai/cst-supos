import java.util.Vector;

public class Stack<E> {
    private Vector<E> v;

    public Stack() {
        v = new Vector<>();
    }

    public Stack(Vector<E> v) {
        this.v = v;
    }

    public void push(E e) {
        v.add(e);
    }

    public E pop() {
        assert (!this.isEmpty());
        return v.removeLast();
    }

    public E tail() {
        assert (!this.isEmpty());
        return v.lastElement();
    }

    public int size() {
        return v.size();
    }

    public boolean isEmpty() {
        return v.isEmpty();
    }

    public void print() {
        System.out.print("Stack:");
        for (E e : v) System.out.print(e + " ");
        System.out.println();
    }
}
