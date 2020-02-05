package accomodationsystem;

public class Student {
    private int studentNumber;
    private String firstName;
    private String lastName;
    
    public Student(int studentNumber, String firstName, String lastName){
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public int getStudentNumber(){
        return studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" + "studentNumber=" + studentNumber + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
    
}
