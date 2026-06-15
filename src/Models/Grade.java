package Models;

import java.util.ArrayList;
import java.util.List;

public class Grade {
    private String name ;
    private String code ;
    private List<Student> students = new ArrayList<>(); 
    private Teacher teacher = new Teacher();
    
    
    public Grade(String name,String code){
        this.name = name;
        this.code = code;
        teacher.setName("temp");
        teacher.setAge(0);
    }
    public Grade(){

    }

    public String getName() {
        return this.name;
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
    public void addStudentToGrade(Student s){
        if (s == null) return ;
        students.add(s);
    }
    public void removeStudentFromGrade(Student s){
        if (s == null) return ;
        students.remove(s);
    }



}
