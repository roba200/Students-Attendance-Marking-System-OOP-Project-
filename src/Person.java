public abstract class Person {
    private String id;
    private  String name;
    Person(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public abstract String getDetails();
    //Getters and Setters


}
