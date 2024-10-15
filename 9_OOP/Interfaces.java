// Interface - 
// ✽ An interface in Java is a blueprint of a class that contains abstract methods (by default) and constant variables. 
// ✽ A class that implements an interface must provide implementations for all the abstract methods defined in the interface using the 'implements' keyword and overriding the methods.
// ✽ Interfaces are used to achieve abstraction and multiple inheritance in Java.
// ✽ Interfaces are declared using the 'interface' keyword.

// Characteristics of Interface:
// ✽ All methods in an interface are abstract unless declared as default or static.
// ✽ Interfaces cannot be instantiated that means we cannot create objects of an interface directly.
// ✽ Interfaces do not contain constructors.
// ✽ All variables in an interface are public, static, and final by default.
// ✽ A class cannot extend multiple classes due to the diamond problem, but it can implement multiple interfaces.
// ✽ An interface can extend multiple interfaces.
// ✽ Interfaces can have methods with a body using default or static keywords.


public class Interfaces  {

    interface Animal {
        void eat(); // abstract methods
        void sleep();
    }

    static class Dog implements Animal {
        @Override // optional
        public void eat() {
            System.out.println("Dog is eating");
        }

        @Override // optional
        public void sleep() {
            System.out.println("Dog is sleeping");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.sleep();
    }
    
}