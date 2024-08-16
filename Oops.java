package Java;

public class Oops {
    public static void main(String args[]){
        Student s1 = new Student();
        s1.tmark = 295;
        s1.roll_no = 22010041046L;
        s1.marks[0]= 100;
        s1.marks[1]= 100;
        s1.marks[2]= 95;        
        Student s2 = new Student(295);
        Student s3 = new Student(22010041036L);
        Student copy = new Student(s1);

    }
}
class Student{
    int tmark;
    long roll_no;
    int marks[];
    Student(){
        marks = new int[3];
        System.out.println("This is default constructor");
    }
    Student(int tmark){
        marks = new int[3];
        this.tmark = tmark;
    }
    Student(long roll_no){
        marks = new int[3];
        this.roll_no = roll_no;
    }
    //this copy constructor is used for shallow copy
    // Student (Student s1){    
    //     marks = new int[3];
    //     this.tmark = s1.tmark;
    //     this.roll_no = s1.roll_no;
    //     this.marks= s1.marks;
    // }
    //this copy constructor is used for deep copy
    Student(Student s1){
        marks = new int[3];
        this.tmark = s1.tmark;
        this.roll_no = s1.roll_no;
        for(int i = 0; i<marks.length; i++){
            this.marks[i] = s1.marks[i];
        }
    }


}
