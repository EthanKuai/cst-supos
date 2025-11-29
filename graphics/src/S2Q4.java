import java.util.Vector;
public class S2Q4 {
    public static void main(String[] args) {
        Vector<Person> lst = new Vector<>(); //...

        for (Person p : lst) p.sings();

        // vs

        for (Person p: lst) {
            if (p instanceof Person) ((Person) p).sings();
            else if (p instanceof Singer) ((Singer) p).sings();
            else if (p instanceof Actor) ((Actor) p).sings();
            else if (p instanceof Idol) ((Idol) p).sings();
            else if (p instanceof Scientist) ((Scientist) p).sings();
        }
    }
}
