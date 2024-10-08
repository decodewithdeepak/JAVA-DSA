// Abstract Classes - 
// ✽ Classes that cannot be instantiated but can be subclassed by other classes.
// ✽ Abstract classes can have abstract methods (methods without body) and concrete methods (methods with body).
// ✽ Abstract methods must be implemented by the subclass using method overriding.
// ✽ Abstract classes define a common template or blueprint for the subclasses.
// ✽ Abstract classes can have constructors and member variables.

public class AbstractClasses {

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
        // Dog d = new Dog();
        // d.sound();
        // d.eat();

        // Abstract class cannot be instantiated
        // Animal a = new Animal(); // Error: Cannot instantiate the type AbstractClasses.Animal

        Animal a = new Dog(); 
        // We can create reference of abstract class and assign subclass object
        a.sound();
        a.eat();
    }
}
