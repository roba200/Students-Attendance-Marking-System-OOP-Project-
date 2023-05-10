import java.util.ArrayList;
import java.util.List;

public class Course {
    private Teacher teacher;
    private String code;
    private String name;
   // private String teacher;
    private List<Student> studentsEnrolled;
    private List<String> attendanceRecord;

    public Course(String code, String name, Teacher teacher){
        this.teacher = teacher;
        this.code = code;
        this.name = name;
        this.studentsEnrolled = new ArrayList<>();
        this.attendanceRecord = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }


}
