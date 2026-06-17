package Main;

import java.util.List;
import java.util.Scanner;

import Models.Grade;
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
            System.out.println("Add Student ---- Add Teacher ---- Get All Students ---- Get All Teachers \nGet Student By Name ---- Get Teacher By Name ---- Remove Student By Name ---- Remove Teacher By Name  \nAdd Grade ---- Get All Grades ---- Remove Grade By Code ---- Assign Teacher To Grade \nRemove Teacher From Grade ---- Assign Student To Grade ---- Remove Student From Grade \nselectAllStudentsFromGrade");
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
                    findStudentByInput();
                    break;
                case "getteacherbyname":
                    findTeacherByInput();
                    break;
                case "removestudentbyname":
                    removeStudent();
                    break;
                case "removeteacherbyname":
                    removeTeacher();
                    break;  
                case "addgrade":
                    addGrade();
                    break;
                case "getgrades":
                    selectGrades();
                    break;
                case "assignteachertograde":
                    assignTeacherToGrade();
                    break;
                case "removeteacherfromgrade":
                    removeTeacherFromGrade();
                    break;  
                case "assignstudenttograde":
                    assignStudentToGrade();
                    break;
                case "removestudentfromgrade":
                    removeStudentFromGrade();
                    break;
                case "selectallstudentsfromgrade":
                    selectAllStudentsFromGrade();
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
    private Student findStudentByInput(){
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        Student student = schoolServices.getStudentByName(name);
        if (student != null) {
            System.out.println(student.getData());
            return student;
        } else {
            System.out.println("Student Not Found");
            return null;
        }
        
    }
    private Teacher findTeacherByInput(){
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        Teacher teacher = schoolServices.getTeacherByName(name);
        if(teacher != null){
            System.out.println(teacher.getData());
            return teacher;
        }else{
            System.out.println("Teacher Not Found");
            return null;
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
    /*
    Add Grade
Get Grade By Code
Assign Student To Grade
Remove Student From Grade
View Students In Grade
    */

    private void addGrade(){
        Grade grade = new Grade();
        System.out.println("Enter Grade Name ");
        grade.setName(scanner.nextLine());
        System.out.println("Enter Grade Code ");
        grade.setCode(scanner.nextLine());
        schoolServices.addGrade(grade);
    }

    private void selectGrades(){
        for (Grade grade : schoolServices.getAllGrades()) {
            System.out.println("Name: " + grade.getName()+ " Code: " + grade.getCode()
        );
        }
    }
    private Grade getGradeByCode(){
        System.out.println("Enter Grade Code : ");
        String code = scanner.nextLine();
        Grade grade =schoolServices.getGradeByCode(code);
        return grade;
    }

    private void assignStudentToGrade(){
        Grade grade = getGradeByCode();
        Student student = findStudentByInput();
        if (grade == null || student == null) {
            System.out.println("Opration Failed");
            return;
        }
        schoolServices.assignStudentToGrade(grade, student);
        System.out.printf("Student (%s) has been Assigned To Grade (%s) \n",student.getName(), grade.getName());
    }

    private void removeStudentFromGrade(){
        Grade grade = getGradeByCode();
        Student student = findStudentByInput();
        if (grade == null || student == null) {
            System.out.println("Opration Failed");
            return;
        }
        schoolServices.removeStudentFromGrade(grade, student);
        System.out.printf("Student (%s) has been Removed from Grade (%s) \n",student.getName(), grade.getName());
    }
    private void assignTeacherToGrade(){
        Grade grade = getGradeByCode();
        Teacher teacher = findTeacherByInput();
        if (grade == null || teacher == null) {
            System.out.println("Opration Failed");
            return;
        }
        schoolServices.assignTeacherToGrade(grade, teacher);
        System.out.printf("Teacher (%s) has been Assigned To Grade (%s) \n",teacher.getName(), grade.getName());
    }

    private void removeTeacherFromGrade() {
        schoolServices.getAllGrades();   
        Grade grade = getGradeByCode();
        if (grade == null) {
            System.out.println("Opration Failed");
            return;
        }
        schoolServices.removeTeacherFromGrade(grade);
        System.out.printf("Teacher (%s) has been Removed From Grade (%s) \n",grade.getTeacher(), grade.getName());
    }

    private void selectAllStudentsFromGrade(){
        Grade grade = getGradeByCode();
        if(grade == null){
            System.out.println("Grade Not Found");
            return;
        }
        for (Student student : grade.getStudents()) {
            System.out.println(student.getData());            
        }
    }

}