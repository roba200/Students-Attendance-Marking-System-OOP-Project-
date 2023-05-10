import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

       Scanner scanner =  new Scanner(System.in);


        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|||||| Student Attendance Marking System ||||||");
        System.out.println("------------------------------------------------------------------------");

        System.out.print("Enter the password to log in to the system: ");
        String pw= scanner.nextLine();


        if (pw.equals("123")) {
            cli();

        }else {
            System.out.println("Password in wrong !");
        }

    }

    public static void cli(){
        AttendanceManager attendanceManager = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);
        LocalDate localDate = LocalDate.now();

        Teacher[] teachers = {new Teacher("000","Dr. H.K.Salainda Premadhasa"),new Teacher("001","Dr. B.M Thosini Kumarika"),new Teacher("002","Dr. Kasun Piyumal"),new Teacher("003","Dr. K.D.B.H Gunawardhana"),new Teacher("004","Dr. Sujeewa Wijesiri")};
        Student[] students ={new Student("EC/2020/003", "D.G.P Deemantha"),new Student("EC/2020/060", "N.L.D.H Shehan"),new Student("EC/2020/066", "U.M.T Yashodha"),new Student("EC/2020/019", "M.T.S.K Madurapperuma"),new Student("EC/2020/008", "E.T.M Senananda"),new Student("EC/2020/014", "T.M.S.D.Thilakarathna")};
        Course[] courses ={ new Course("BECS 12233","Data Communications and Networks", teachers[0]),new Course("BECS 12243","Object Oriented Programming", teachers[1]),new Course("BECS 12443","Digital Electronics",teachers[2]),new Course("BECS 12451","Digital Electronics Laboratory", teachers[2]),new Course("BECS 12462","Mechanics and Properties of Materials", teachers[3]),new Course("BECS 12623","Calculus",teachers[4])};

        //////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println("Select a Course: (Enter Number and Press Enter)");


        for (int i = 0; i < courses.length; i++) {
            System.out.println(i + ":" + courses[i].getName());
        }
        System.out.println("--------------------------------------------------");
        System.out.print("Enter a Selection : ");
        int courseSelection = scanner.nextInt();
        System.out.println("--------------------------------------------------");
        System.out.println("Selected Course : " + courses[courseSelection].getName() + " " + courses[courseSelection].getCode());
        System.out.println("--------------------------------------------------");
        System.out.println("0:Mark Attendance");
        System.out.println("1:Course Details");
        System.out.println("--------------------------------------------------");

        int selection = scanner.nextInt();
        if (selection == 0) {
            Scanner read = new Scanner(System.in);
            String cont = "q";
            while (cont.equals("q")) {
                System.out.println("(Enter 'q' to Stop Marking Attendance)");
                System.out.print("Enter Student Number(XX/20XX/XXX) :");
                String inputId = read.nextLine();
                if (checkStudentExists(students, inputId) == true) {
                    LocalTime localTime = LocalTime.now();
                    attendanceManager.markAttendance(courses[courseSelection], students[getStudentIndex(inputId, students)], localDate, localTime.withNano(0));
                } else if (inputId.equals("q")) {
                    break;
                } else {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Error: Student does not exists");
                    System.out.println("--------------------------------------------------");
                }

            }
            System.out.println("--------------------------------------------------");
            System.out.println("0:View Attendance");
            System.out.println("1:Go to Main Menu");
            System.out.println("--------------------------------------------------");
            int sec = scanner.nextInt();
            if (sec == 0) {
                attendanceManager.viewAttendance(courses[courseSelection]);
                System.out.println();
                System.out.println("Students Count: "+ attendanceManager.studentCount());
                double f = ((attendanceManager.studentCount() / (double)students.length)*100);
                System.out.println("Total Number of Students: " + students.length);
                System.out.print("Attendance Percentage: ");
                System.out.printf("%.2f", f);
                System.out.println(" %");


            } else if (sec == 1) {
                cli();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("0: Generate Report");
            System.out.println("--------------------------------------------------");
            int sec2 = scanner.nextInt();
            if (sec2 == 0) {
                LocalTime localTime = LocalTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm-ss");
                String formattedTime = localTime.format(formatter);
                TextFile text = new TextFile(attendanceManager.getCourses(), attendanceManager.getStudents(), attendanceManager.getTimes());
                text.genarateFile(courses[courseSelection].getCode() + " " + localDate + " " + formattedTime.toString() + " report.txt", courses[courseSelection]);
                System.out.println("The report was generted Successfully !");
                System.out.println("--------------------------------------------------");
                System.out.println("0:Back to main menu ");
                System.out.println("1:Exit ");
                System.out.println("--------------------------------------------------");

                int selection3 = scanner.nextInt();
                if(selection3==0){
                    cli();
                } else if (selection3==1) {

                }else {
                    System.out.println("Error: Wrong Input");
                }


            }


        } else if (selection == 1) {
            System.out.println("--------------------------------------------------");
            System.out.println("Course Code : " + courses[courseSelection].getCode());
            System.out.println("Tutor ID & Tutor: " + courses[courseSelection].getTeacher().getDetails());
            System.out.println("--------------------------------------------------");
            System.out.println("0:Go Back");
            System.out.println("--------------------------------------------------");
            int selection2=scanner.nextInt();
            if (selection2==0){
                cli();
            }else {
                System.out.println("Error! : Wrong Input");
            }
            System.out.println("--------------------------------------------------");
        }
    }

    public static boolean checkStudentExists(Student[] students, String inputId){
        boolean exists = false;
        for (int i=0; i<students.length; i++){

            if(students[i].getId().equals(inputId)){
                exists = true;
            }
        }
        return exists;
    }

    public static int getStudentIndex(String inputId, Student[] students){
        int counter = 0;
        for (int i=0; i<students.length; i++){
            counter++;
            if(students[i].getId().equals(inputId)){
                break;
            }
        }
        return counter - 1;
    }

}