package Java;

public class Oops {
    public static void main(String args[]){
        Student s1 = new Student();
        s1.mark = 95;
        s1.roll_no = 22010041046L;
        Student s2 = new Student(95);
        Student s3 = new Student(22010041036L);
        Student copy = new Student(s1);
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
    Student (Student s1){
        this.mark = s1.mark;
        this.roll_no = s1.roll_no;
    }

}
