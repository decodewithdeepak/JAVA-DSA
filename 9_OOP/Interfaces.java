// Interface - 
// ✽ Interface is a reference type in Java. It is similar to a class. It is a collection of abstract methods.
// ✽ Interface is used to specify methods that a class must implement but do not provide method bodies.
// ✽ Interface 
// ✽ Interface can contain abstract methods, default methods, static methods, and constants.
// ✽ Interfaces cannot be instantiated.
// ✽ Interface does not contain any constructors.
// ✽ Interface can extend multiple interfaces.
// ✽ Inteface can be implemented by a class using the 'implements' keyword.
// ✽ Interfaces are used to achieve multiple inheritance in Java.
// ✽ Interface is used to provide a way to achieve abstraction by specifing what a class must do and not how.
// ✽ A class implements an interface, thereby inheriting the abstract methods of the interface.
// ✽ A class can implement multiple interfaces.

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