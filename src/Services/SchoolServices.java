package Services;


import java.util.List;

import Models.Grade;
import Models.School;
import Models.Student;
import Models.Teacher;

public class SchoolServices {
    private final School school;
    public SchoolServices(School school) {
        this.school = school;
    }

    public School getSchool() {
        return this.school;
    }
    private String normalize(String text){
        return text.toLowerCase().trim().replace(" ","");
    }

    public void addTeacher(Teacher teacher){
        this.school.addTeacher(teacher);
    }
    public void addGrade(Grade grade){
        this.school.addGrade(grade);
    }

    public Teacher getTeacherByName(String name){
        for(Teacher teacher : school.getTeachers()){
            if(normalize(teacher.getName()).equals(normalize(name))){
                return teacher;
            }
        }
        return null;
    }

    public Grade getGradeByCode(String code){
        for(Grade grade : school.getGrades()){
            if(normalize(grade.getCode()).equals(normalize(code))){
                return grade;
            }
        }
        return null;
    }

    public void addStudent(Student student){
        this.school.addStudent(student);
    }

    public Student getStudentByName(String name){
        for(Student student:school.getStudents()){
            if (normalize(student.getName()).equals(normalize(name))) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents(){
        //return Collections.unmodifiableList(school.getStudents());  //3l4an lw rg3tha 3ltool momkn 7d y3mly clear flazem arg3ha kda aw momken arg3 new list<> 
        return school.getStudents();  // ro7t 5leet el getStudents trg3ly new ArrayList 3l4an tkoon m7mya we ab2a 3mlt encapsulation
    }
    public List<Teacher>getAllTeachers(){
        return school.getTeachers();
    }

         
    public void removeStudent(Student student){
        if (student == null)return;
        school.removeStudent(student);
    }

    // public void removeTeacherByName(String name){
    //     school.getTeachers().removeIf(teacher->teacher.getName().equalsIgnoreCase(name));
    // }

    public void removeTeacher(Teacher teacher){
        if (teacher == null)return;
        school.removeTeacher(teacher);
    }


    // public void removeGradeByCode(String code){
    //     school.getGrades().removeIf(grade -> grade.getCode().equalsIgnoreCase(code));
    // }
    
    public void removeGrade(Grade grade){
        if(grade == null)return;
        school.removeGrade(grade);
    }
    public void assignStudentToGrade(Grade grade , Student Student){
        grade.addStudent(Student);
    }
    public void removeStudentFromGrade(Grade grade , Student Student){
        grade.removeStudent(Student);
    }
    public void assignTeacherToGrade(Grade grade , Teacher teacher){
        grade.assignTeacher(teacher);
    }

    /*
    Add Grade
Get Grade By Code
Assign Student To Grade
Remove Student From Grade
View Students In Grade
    */
}
