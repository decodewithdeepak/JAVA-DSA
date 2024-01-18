// Constructor is a special method that is used to initialize objects.
// Constructor name = Class name
// Constructor - no return type

public class Constructor {
    public static void main(String[] args) {
        
        // Constructor without parameters
        class Student {
            String name;
            int rollno;

            // Constructor
            Student() {
                name = "Deepak";
                rollno = 223100;
            }

            void desc() {
                System.out.println("My name is " + name + ", Rollno. " + rollno);
            }
        }

        Student student1 = new Student(); // Creating an object of class
        student1.desc(); // Calling a method

        // Constructor with parameters
        class HostellerStudent {
            String name;
            int rollno;

            // Constructor
            HostellerStudent(String n, int r) {
                name = n;
                rollno = r;
            }

            void desc() {
                System.out.println("My name is " + name + ", Rollno. " + rollno);
            }
        }

        HostellerStudent hstudent1 = new HostellerStudent("Ritvik", 223101); // Creating an object of class
        hstudent1.desc(); // Calling a method


    }
}
