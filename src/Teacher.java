
public class Teacher extends Person {
    public Teacher(String id,String name ) {
        super(id, name);
    }
    @Override
    public String getDetails() {
        return getId() +" " +  getName();
    }
}
