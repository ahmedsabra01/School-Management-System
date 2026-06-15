package Models;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Student> students = new ArrayList<>();
    private List<Teacher>teachers = new ArrayList<>();
    private List<Grade>grades = new ArrayList<>();
    public School(String name, String address, String phoneNumber) {
        this.name = name;
        this.phoneNumber= phoneNumber;
        this.address = address;
    }
    public School(){

    }
    //el Section bta3 elsetters we el getters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //el Section bta3 elTeachers
    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public void removeTeacher(Teacher teacher){
        teachers.remove(teacher);
    }

    //el Section bta3 el Grades 
    public List<Grade> getGrades() {
        return new ArrayList<>(this.grades);
    }
    public void addGrade(Grade grade){
        grades.add(grade);
    }
    public void removeGrade(Grade grade){
        grades.remove(grade);
    }

    //el Section bta3 elStudents 
    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(Student student){
        students.remove(student);
    }


}
