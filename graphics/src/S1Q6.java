public class S1Q6 {
    public static void main(String args[]) {
        int[] a = {1,2,3};
        SinglyLinkedList lst = new SinglyLinkedList(a);
        lst.print();

        System.out.println("Popping");
        System.out.println(lst.popBack());
        lst.pushFront(21);
        lst.print();
        lst.popNthElement(2);
        lst.print();
        lst.pushBack(10);
        lst.print();
        lst.setNthElement(0,19);
        lst.print();

        System.out.println(lst.detectCycle());
        lst.getTail().getTail().setTail(lst);
        System.out.println(lst.detectCycle());
    }
}
