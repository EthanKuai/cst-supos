public class S1Q2 {
    public static void main(String[] args) {
        int primitive = 10;
        System.out.println(primitive);

        String s = "Hello";
        String reference = s;
        System.out.println(reference);

        Person classObject = new Person("John",21);
        System.out.println(classObject);
        System.out.println(classObject.getAge());
    }
}
