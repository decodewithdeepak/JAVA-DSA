// Notes: https://drive.google.com/file/d/1FoIV8VADMjIOQU6Yf6_kSrEOH4-PGun2/view

public class OOPsBasics {

    public static class Car {
        String name; // Attributes
        String color;
        int speed;

        void info() { // Method
            System.out.println("Name: " + name);
            System.out.println("Color: " + color);
            System.out.println("Speed: " + speed);
        }
    }


    public static class Student {
        String name; // Attributes
        int rollno;
        double percent;
    }

    public static void details(Student s) { // Passing object as an argument
        System.out.println("Name: " + s.name);
        System.out.println("Rollno: " + s.rollno);
        System.out.println("Percentage: " + s.percent);
    }

    public static void change(Student s) {
        s.percent = 95.5;
    }


    public static void main(String[] args) {
        
        // Class inside main method (not recommended as it is locally scoped)
        class Person { // Class
            String name = "Deepak"; // Attributes
            String occupation = "Software Developer";

            void bio() { // Method
                System.out.println(name + " is a " + occupation);
            }
        }


        Person p1 = new Person(); // Creating an object of class
        p1.bio(); // Calling a method


        // We should create classes outside of main method
        Car c1 = new Car(); // Creating an object
        c1.name = "BMW";
        c1.color = "Black";
        c1.speed = 200;

        // c1.info(); // Calling a method


        Student s1 = new Student(); // Creating an object
        s1.name = "Deepak"; // Assigning values to attributes
        s1.rollno = 223100;
        s1.percent = 90.5;

        // System.out.println("Name: " + s1.name);
        // System.out.println("Rollno: " + s1.rollno);
        // System.out.println("Percentage: " + s1.percent);

        // details(s1); // Passing object as an argument

        // s1.percent = 85.5; // Changing attributes
        // details(s1);

        // Class is reference type so it is passed by reference - changes will be reflected
        // System.out.println("Before: " + s1.percent);
        // change(s1);
        // System.out.println("After: " + s1.percent);

        
        // Class in a different file - Employee.java
        Employee e1 = new Employee();
        e1.name = "Deepak";
        e1.id = 223100;
        e1.salary = 50000;

        // e1.details();
        // e1.change();
        // e1.details();


        // Default values of attributes in a class
        class Test {
            int a;
            double b;
            String c;
            boolean d;
        }

        Test t1 = new Test();
        System.out.println("a: " + t1.a);
        System.out.println("b: " + t1.b);
        System.out.println("c: " + t1.c);
        System.out.println("d: " + t1.d);




        

    }
}
