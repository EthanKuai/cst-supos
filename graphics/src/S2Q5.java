public class S2Q5 {
}

class Employee {
    public int employeeID;
    private float salary;
    public void setSalary(float s) {
        if (s>0) this.salary=s;
    }
    public float getSalary() {
        return this.salary;
    }
}

interface Ninja {
    public void sneak();
    //...
}

class NinjaEmployee extends Employee implements Ninja {
    public void sneak() {
        System.out.println("Employee sneaking around");
    }
    //...
}