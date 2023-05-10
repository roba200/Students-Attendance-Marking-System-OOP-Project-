import java.io.FileWriter;
import java.time.LocalTime;
import java.util.List;

public class TextFile {
    List<Course> courses;
    List<Student> students;
    List<LocalTime> times;

    TextFile(List<Course> courses, List<Student> students, List<LocalTime> times){
        this.courses = courses;
        this.students = students;
        this.times = times;
    }

    void genarateFile(String fileName, Course course){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("Student attendance report of "+ course.getCode()+"\n");
            fileWriter.write("\n");
            fileWriter.write("Time\t\tStudent ID\t\tStudent Name\n");
            fileWriter.write("\n");

            for (int i= 0; i<times.size(); i++){
                fileWriter.write(times.get(i).toString() + '\t');
                fileWriter.write(students.get(i).getId() + "\t\t");
                fileWriter.write(students.get(i).getName());
                fileWriter.write('\n');
            }
            fileWriter.write("\n");
            fileWriter.write("Total Attendance Count: " + students.size());
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error : " + e.toString());
        }

    }


}
