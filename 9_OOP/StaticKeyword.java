// Static keyword is a keyword in java that can be used with variables, methods, blocks and nested classes. 

// static variables - A variable that is shared among all instances of a class. It is initialized only once, at the start of the execution.
// static methods - A method that belongs to the class rather than any object of the class. It can be called without creating an object of the class.
// static blocks - A block of code that is executed only once when the class is loaded into memory. It is the block of code that firstly executes in any java program.
// static nested classes - A class that is a member of another class. It can be accessed without creating an object of the outer class. 
// static class is used to run the class in a single file without interfering with other classes in the same package.

// this keyword - used to refer current class instance variable (to avoid confusion between class instance variable and method parameter)
// final keyword - used to make constant (cannot change value of final variable) | used to prevent method overriding | used to prevent inheritance
// static keyword - used to make class level variable | used to call method without creating object | used to make static block | used to make static nested class


public class StaticKeyword {
    
    // static nested class - to run in a single file without interfering with other classes in the same package
    static class Student {
        String name;
        int rollno;

        // this Keyword - used to refer current class instance variable
        Student(String name, int rollno) {
            this.name = name;
            this.rollno = rollno;
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

    // static block - executed only once when the class is loaded into memory
    static {
        System.out.println("Static block");
    }

    public static void main(String[] args) {
        
        Student s1 = new Student("Deepak", 223100);
        System.out.println(s1.name + " " + s1.rollno);

        // final Keyword
        // s1.maxMarks = 200; // Error - cannot change value of final variable
        
        // static Keyword
        // System.out.println(s1.school); 
        System.out.println(Student.school);
        // static variable can be accessed using class name without creating object

        // static method
        Student.change();
        System.out.println(Student.school);
        // static method can be called using class name without creating object
        

    }
}
