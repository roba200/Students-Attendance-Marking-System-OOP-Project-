
public class Student extends Person{
    public Student(String id, String name) {
        super(id, name);
    }
    @Override
    public String getDetails() {
        return getId() +" " +  getName();
    }
}
