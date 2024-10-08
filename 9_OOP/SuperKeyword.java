// super keyword -
// super is used to access the immediate parent class properties (attributes and methods).
// super() is used to invoke the immediate parent class constructor.

public class SuperKeyword {
    // made the class static nested as it was interfering with Inheritance.java file in the same directory
    static class Animal {
        void sound() {
            System.out.println("Animal makes a sound.");
        }
    
        Animal() {
            System.out.println("Animal class constructor.");
        }
    }
    
    static class Dog extends Animal {
        void sound() {
            super.sound(); // Calls the sound() method of Animal class
            System.out.println("Dog barks.");
        }
    
        Dog() {
            super(); // Calls the constructor of Animal class
            System.out.println("Dog class constructor.");
        }
    }
    
    public static void main(String[] args) {
        Dog dog = new Dog(); // Calls the constructor of Dog class and Animal class
        dog.sound(); // Calls the overridden method

        // Output:
        // Animal class constructor
        // Dog class constructor
        // Animal makes a sound
        // Dog barks
    }

}
