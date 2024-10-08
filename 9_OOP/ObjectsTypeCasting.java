public class ObjectsTypeCasting {

    static class Animal {
        void sound() {
            System.out.println("Animal makes a sound.");
        }
    }

    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Dog barks.");
        }
    }

    public static void main(String[] args) {
        Animal a = new Dog(); // Implicit Upcasting - Parent class reference variable can hold the object of child class.
        Dog d = (Dog) a; // Explicit Downcasting - Parent class reference variable can be typecasted to child class reference variable.   
        
        a.sound(); // Dog barks.
        d.sound(); // Dog barks.
        
    }
}
