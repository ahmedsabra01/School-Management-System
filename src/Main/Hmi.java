package Main;

import java.util.List;
import java.util.Scanner;
import Models.Person;
import Models.Student;
import Models.Teacher;
import Services.SchoolServices;

public class Hmi {
    // private static SchoolServices schoolServices;
    // private static final Scanner scanner = new Scanner(System.in);
    private final SchoolServices schoolServices;
    private final Scanner scanner ;
    public Hmi(SchoolServices schoolServices,Scanner scanner) {
        this.schoolServices = schoolServices;
        this.scanner = scanner;
    }
    public  void Start() {
        System.out.println("Welcome to "+schoolServices.getSchool().getName()+" in " +schoolServices.getSchool().getAddress() +"you can contact us with this phone number "+schoolServices.getSchool().getPhoneNumber());
        String action;
        do {
            System.out.println("What do you want to do?");
            System.out.println("Add Student ---- Add Teacher ---- Get All Students ---- Get All Teachers ---- Get Student By Name ---- Get Teacher By Name ---- Remove Student By Name ---- Remove Teacher By Name");
            action = scanner.nextLine().toLowerCase().trim().replace(" ", "");;

            switch (action) {
                case "addstudent":
                    addStudent();
                    break;
                case "addteacher":
                    addTeacher();
                    break;
                case "getallstudents":
                    getAllStudents();
                    break;
                case "getallteachers":
                    getAllTeachers();
                    break;
                case "getstudentbyname":
                    getStudent();
                    break;
                case "getteacherbyname":
                    getTeacher();
                    break;
                case "removestudentbyname":
                    removeStudent();
                    break;
                case "removeteacherbyname":
                    removeTeacher();
                    break;    
                default:
                    break;
            }

            
        } while (!action.toLowerCase().equals("exit"));
    
    }


    private  void addStudent(){
        Student student = new Student();
        addPersonData(student);
        schoolServices.addStudent(student);

    }
    private void addTeacher(){
        Teacher teacher = new Teacher();
        addPersonData(teacher);
        schoolServices.addTeacher(teacher);

    }

    private void addPersonData(Person person){
        System.out.println("Enter Name");
        person.setName(scanner.nextLine());
        System.out.println("Enter Age");
        person.setAge(Integer.parseInt(scanner.nextLine()));
        if(person instanceof Teacher){
            System.out.println("Enter Teacher Salary"); 
            ((Teacher)person).setSalary(Float.parseFloat(scanner.nextLine()));
        }else if (person instanceof Student) {
            System.out.println("Enter Student Parent PhoneNumber");
            ((Student)person).setParentPhoneNumber(scanner.nextLine());
        }
        
    }


    private void getAllStudents(){
        List<Student> students = schoolServices.getAllStudents();
        for (Student student : students) {
            System.out.println(student.getData());  
        }
    }

        private void getAllTeachers(){
        List<Teacher> teachers = schoolServices.getAllTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getData());  
        }
    }
    private void getStudent(){
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        Student student = schoolServices.getStudentByName(name);
        if (student != null) {
            System.out.println(student.getData());
        } else {
            System.out.println("Student Not Found");
        }
        
    }
    private void getTeacher(){
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        Teacher teacher = schoolServices.getTeacherByName(name);
        if(teacher != null){
            System.out.println(teacher.getData());
        }else{
             System.out.println("Teacher Not Found");
        }
        
    }
    private void removeStudent(){
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        Student student = schoolServices.getStudentByName(name);
        if (student != null) {
            schoolServices.removeStudent(student);
            System.out.println("Student Removed");
        } else {
            System.out.println("Student Not Found");
        }
    }

    private void removeTeacher(){
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        Teacher teacher = schoolServices.getTeacherByName(name);
        if (teacher!=null) {
            schoolServices.removeTeacher(teacher);
            System.out.println("Teacher Removed");
        } else {
            System.out.println("Teacher Not Found");
        }
    }

}