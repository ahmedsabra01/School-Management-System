package Models;

public class Student extends Person {
    private String parentPhoneNumber;

    public Student(int id ,String name , int age ,String parentPhoneNumber){
        super(name,age); 
        this.parentPhoneNumber =parentPhoneNumber;
    }
    public Student(){

    }

    public String getParentPhoneNumber() {
        return this.parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    @Override
    public String getData(){
        return "Student Name :"+this.getName() +"\nAge :"+ this.getAge()+ "\nParent No#: "+this.getParentPhoneNumber();
    }

}
