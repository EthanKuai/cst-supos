public class FitnessTeacher extends AbstractPerson implements Teacher,Athlete {
    public FitnessTeacher(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public void teaching() {
        System.out.println("teaching fitness education");
    }

    @Override
    public void training() {
        System.out.println("training");
    }
}
