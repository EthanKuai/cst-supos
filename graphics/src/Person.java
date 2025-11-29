public class Person {
    public String name;
    private int age;

    public Person() {
        this.name = "";
        this.age = -1;
    }

    public Person(String firstname, String lastname) {
        this.name = firstname + " " + lastname;
        this.age = -1;
    }

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

    public void sings() {
        System.out.println("Sings average");
    }

    @Override
    public String toString() {
        return "Person " + name + ", age " + age;
    }
}
