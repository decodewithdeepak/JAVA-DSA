// Method Overriding -
// ✽ Child class provides a specific implementation of a method that is already provided by its parent class.
// ✽ Methods of the child class have the same name, same return type, and same parameters as a method in the parent class.
// ✽ @Override annotation is used to override a method. It is optional but recommended for better code readability.
// ✽ Runtime polymorphism (Dynamic method dispatch) - Dynamic or late binding
// ✽ Runtime - Method call is resolved at runtime.

public class MethodOverriding {

    static class Animal {
        void sound() {
            System.out.println("Animal makes a sound.");
        }
    }
    
    static class Dog extends Animal {
        @Override // optional but recommended to improve code readability
        void sound() {
            System.out.println("Dog barks.");
        }
    }

    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound(); // Calls the overriden sound method of Dog class

        // Method call is resolved at runtime.
    }

}
