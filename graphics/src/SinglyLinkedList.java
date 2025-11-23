public class SinglyLinkedList {
    private int head;
    private boolean empty = false;
    private SinglyLinkedList tail;

    public SinglyLinkedList(int[] a) {
        this(a, 0);
    }

    protected SinglyLinkedList(int[] a, int idx) {
        if (a.length == 0 && idx==0) {
            empty = true;
            head = Integer.MAX_VALUE; // Consistency
            tail = null; // Consistency
        } else {
            this.head = a[idx];

            if (idx == a.length - 1) this.tail = null;
            else this.tail = new SinglyLinkedList(a, idx+1);
        }
    }

    protected SinglyLinkedList(int head, SinglyLinkedList tail) {
        this.head = head;
        this.tail = tail;
    }

    protected SinglyLinkedList getTail() {
        return tail;
    }

    public int getHeadElement() {
        assert (!empty);
        return head;
    }

    public int getNthElement(int n) {
        assert (n>=0 && n<this.getLength());
        assert (!empty);
        if (n==0) return getHeadElement();
        else return tail.getNthElement(n-1);
    }

    public int getLength() {
        if (empty) return 0;
        else if (tail==null) return 1;
        else return 1+tail.getLength();
    }

    // below are my takes on "addition and removal of element"s

    public void pushFront (int val) {
        if (!empty) {
            this.tail = new SinglyLinkedList(this.head, this.tail);
            this.head = val;
        } else {
            this.head = val;
            this.empty = false;
            this.tail = null; // consistency
        }
    }

    public void pushBack (int val) {
        if (empty) {
            this.head = val;
            this.empty = false;
            this.tail = null; // consistency
        }
        else if (this.tail==null) this.tail = new SinglyLinkedList(val, null);
        else this.tail.pushBack(val);
    }

    public void setNthElement(int n, int val) {
        assert (n>=0 && n<this.getLength());
        if (n==0) {
            head=val;
            empty=false;
        }
        else tail.setNthElement(n-1, val);
    }

    public int popBack() {
        assert (!empty);
        if (this.tail==null) { // len 1 list -> empty list
            int out = this.head;
            this.empty = true;
            this.head = Integer.MAX_VALUE; // consistency
            return out;
        } else if (this.tail.getTail()==null) {
            int out = this.tail.getHeadElement();
            this.tail = null;
            return out;
        } else {
            return this.tail.popBack();
        }
    }

    public int popNthElement(int n) {
        assert (n>=0 && n<this.getLength());
        assert (!empty);

        if (n==0) {
            int out = this.head;
            if (this.tail == null) { // only for empty linkedlist case; shouldn't be relied upon usually
                this.empty = true;
                this.head = Integer.MAX_VALUE; // consistency
            } else {
                this.head = this.tail.getHeadElement();
                this.tail = this.tail.getTail();
            }
            return out;
        }
        else if (n == this.getLength()-1) return popBack();
        else return this.tail.popNthElement(n-1);
    }

    public void print() {
        System.out.println("Printing list {");
        for (int i=0; i<this.getLength(); i++) {
            System.out.println(this.getNthElement(i));
        }
        System.out.println("}");
    }

    public boolean detectCycle() {
        SinglyLinkedList ptr1 = this;
        SinglyLinkedList ptr2 = this;
        while (true) {
            ptr1 = ptr1.getTail();
            ptr2 = ptr2.getTail();
            if (ptr1==null || ptr2==null) return false;
            ptr2 = ptr2.getTail();
            if (ptr2 == null) return false;
            if (ptr1 == ptr2) return true;
        }
    }

    public void setTail(SinglyLinkedList tail) { // purely for testing purposes
        this.tail = tail;
    }
}
