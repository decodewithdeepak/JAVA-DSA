// Constructor is a special method that is used to initialize objects.
// Constructor is called when an object of a class is created.
// Constructor name = Class name
// Constructor - no return type

// Types of Constructor- 
// 1. Default Constructor
// 2. Parameterized Constructor

public class Constructor {

    public static class Student {
        String name;
        int rollno;
        double percent;

        // Default Constructor
        Student() {
            System.out.println("Default Constructor");
        }

        // Parameterized Constructor
        // Student( String n, int r, double p) {
        //     name = n;
        //     rollno = r;
        //     percent = p;
        // }

        // this Keyword - used to refer current class instance variable
        Student(String name, int rollno, double percent) {
            this.name = name;
            this.rollno = rollno;
            this.percent = percent;
        }

        // final Keyword - used to make constant
        final int maxMarks = 100;

        // static Keyword - used to make class level variable
        // String school = "ABC School";
        static String school = "ABC School";

        // static method - can be called without creating object
        static void change() {
            school = "XYZ School";
        }

    }
    
    public static void main(String[] args) {
        
        // Default Constructor
        Student s1 = new Student();
        s1.name = "Deepak";
        s1.rollno = 223100;
        s1.percent = 90.5;
        System.out.println(s1.name + " " + s1.rollno + " " + s1.percent);
        
        // Parameterized Constructor
        Student s2 = new Student("Divya", 223101, 95.5);
        System.out.println(s2.name + " " + s2.rollno + " " + s2.percent);

        // final Keyword
        // s2.maxMarks = 200; // Error - cannot change value of final variable
        
        // static Keyword
        // System.out.println(s2.school); 
        System.out.println(Student.school);
        // static variable can be accessed using class name without creating object

        // static method
        Student.change();
        System.out.println(Student.school);
        // static method can be called using class name without creating object

    }
}
