import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AttendanceManager {
    private List<Course> courses;
    public  List<Student> students;
    public List<LocalTime> times;
    public AttendanceManager(){
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.times = new ArrayList<>();
    }

    public void markAttendance(Course course, Student student , LocalDate localDate, LocalTime localTime){
        courses.add(course);
        students.add(student);
        times.add(localTime);
        System.out.println("--------------------------------------------------");
        System.out.println("Date: " + localDate.toString());
        System.out.println("Time: " + localTime.toString());
        System.out.println("Student ID & Name: " + student.getDetails());
        //System.out.println("Student ID: " + student.getId());
        System.out.println("Course: "+ course.getCode());
        System.out.println("Attendance Marked");
        System.out.println("--------------------------------------------------");
        //System.out.println(localDate.toString()+ " "+localTime.toString() + " "+"Attendance Marked " + course.getCode() + " " + student.getId());

    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<LocalTime> getTimes() {
        return times;
    }

    public List<Student> getStudents() {
        return students;
    }

    int studentCount(){
        return students.size();
    }

    public void viewAttendance (Course course){
        LocalDate localDate = LocalDate.now();
        System.out.println("////Student Attendance Report on "+localDate.toString()+"////");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.printf("Time\t\tStudent Number\t\tStudent Name\n");
        System.out.println("--------------------------------------------------");
        for(int i =0; i<courses.size(); i++){
            if(courses.get(i).equals(course)){
                System.out.print(times.get(i).withNano(0)+"\t"+ students.get(i).getId()+"\t\t\t"+students.get(i).getName()+"\n");

            }
        }
    }
}
