package Java;

public class Oops {
    public static void main(String args[]){
        Student s1 = new Student();
        Student s2 = new Student(95);
        Student s3 = new Student(22010041036L);
    }
}
class Student{
    int mark;
    long roll_no;
    Student(){
        System.out.println("This is default constructor");
    }
    Student(int mark){
        this.mark = mark;
    }
    Student(long roll_no){
        this.roll_no = roll_no;
    }

}
