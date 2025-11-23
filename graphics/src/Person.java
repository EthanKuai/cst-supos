public class Person {
    public String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.setAge(age);
    }

    public void setAge(int age) {
        if (age >=0 && age <= 100) this.age = age;
    }

    public int getAge() {
        return age;
    }
}
