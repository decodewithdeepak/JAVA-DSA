// Abstract Classes - 
// ✽ An abstract class in Java is a class that cannot be instantiated and is meant to be subclassed by other classes. 
// ✽ We cannot create an object of an abstract class directly.
// ✽ It can contain both abstract methods (methods without a body) and concrete methods (methods with a body). 
// ✽ Abstract classes are used to provide a base structure for other classes to extend and implement the abstract methods.

// ✽ Abstract classes are declared using the 'abstract' keyword.
// ✽ Abstract methods have no body and must be implemented by the subclass.
// ✽ Concrete methods have a body which can be inherited by the subclass.
// ✽ Abstract classes can have constructors to initialize common properties.
// ✽ Abstract classes can have member variables like any other class.


public class AbstractClass {

    static abstract class Animal {
        abstract void sound(); // Abstract method
        void eat() { // Concrete method
            System.out.println("Animal eats food.");
        }
    }
    
    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Dog barks.");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
        d.eat();

        // Abstract class cannot be instantiated
        // Animal a = new Animal(); // Error: Cannot instantiate the type AbstractClasses.Animal

        Animal a = new Dog(); // Implicit casting
        // We can create reference of abstract class and assign subclass object
        a.sound();
        a.eat();
    }
}
