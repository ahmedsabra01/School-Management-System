package Models;

import java.util.ArrayList;
import java.util.List;

public class Grade {
    private String name ;
    private String code ;
    private List<Student> students = new ArrayList<>(); 
    private Teacher teacher;
    
    
    public Grade(String name,String code){
        this.name = name;
        this.code = code;

    }
    public Grade(){

    }

    public String getName() {
        return this.name;
    }
    public void setStudents(List<Student> students) {
        if (students == null) return;
        this.students = students;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void assignTeacher(Teacher teacher) {
        if (teacher == null)return;
        this.teacher = teacher;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
    public void addStudent(Student student){
        if (student == null) return ;
        students.add(student);
    }
    public void removeStudent(Student student){
        if (student == null) return ;
        students.remove(student);
    }




}
