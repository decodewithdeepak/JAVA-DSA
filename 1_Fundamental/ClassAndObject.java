// Notes 9 : https://drive.google.com/file/d/18pGYaDvF7i2ync4m39kbgn1cStxgLj4X/view

// A Class is a user-defined data-type which has data members and member functions. It is a logical entity.
// A class can also be understood as a group of objects that have common properties. 
// It is a template or blueprint from which objects are created.

// An Object is an identifiable entity with some characteristics and behaviour.
// It represents a real-life entity. 
// It is the most basic unit of object-oriented programming. 
// Object is also identified as an instance of a Class which means that when a class is defined, 
// no memory is allocated but when it is instantiated (i.e. an object is created) memory is allocated.

// Object has three characteristics -
// Identity - Unique name of the object
// State - Attributes of an object
// Behavior - methods or logic executed on the object

// For Example - car
// Identity - Name of car or model no
// State - Color, Engine, etc
// Behavior - car speed, etc

// Characteristics of a class:
// Class consists of attributes or methods which can be executed by objects(instance of the class)
// Components of a class : A class needs to have all of these for its existence.
// + Access Modifiers - scope of class where it can be used (public, private, protected)
// + class keyword - used to create a class
// + Class name - Name of class
// + Body - The body of class which consists of attributes, objects, methods and so on


// Note : It is better to keep classes outside of main method or in a separate file.

public class ClassAndObject {
    public static void main(String[] args) {

        // Syntax:
        // class <ClassName> {
        // // body of class (attributes, methods, constructors, etc.)
        // }

        // ClassName ObjectName = new ClassName(); // Creating an object of class


        class MyClass { // Creating a class
            int x = 5; // Attributes
        }

        MyClass obj = new MyClass(); // Creating an object of class
        System.out.println(obj.x); // Accessing class attributes


        class Details { // Creating a class
            String name = "Deepak";
            int age = 20;
        }

        Details obj1 = new Details(); // Creating an object of class
        System.out.println("Name: " + obj1.name); // Accessing attributes
        System.out.println("Age: " + obj1.age);


        class Person { // Class
            String name = "Deepak"; // Attributes
            String occupation = "Software Developer";

            public void bio() { // Method
                System.out.println(name + " is a " + occupation);
            }
        }

        Person person1 = new Person(); // Object
        person1.bio();

        person1.name = "Ritvik"; // Changing attributes
        person1.occupation = "Student";
        person1.bio();

        
        class Student {
            String name = "Deepak"; // Attributes
            int rollno = 223100;

            void desc() { // Method (function)
                System.out.println("My name is " + name + " Rollno. " + rollno);
            }
        }

        Student student1 = new Student(); // Creating an object of class
        student1.desc(); // Calling a method


        class Car { // Class
            String name;
            String color;
            int speed;

            public void info() { // Method
                System.out.println("Name: " + name);
                System.out.println("Color: " + color);
                System.out.println("Speed: " + speed);
            }
        }

        Car car1 = new Car(); // Object
        car1.name = "BMW";
        car1.color = "Black";
        car1.speed = 200;
        car1.info();

        
    }
}
