// super keyword -
// super keyword is used in subclasses to access the immediate superclass members (attributes, methods, constructors).
// Uses of super keyword -
// ✽ To access superclass attribute when subclass has the same attribute.
// ✽ To call superclass method that is overridden in subclass.
// ✽ To explicitly call superclass constructor from subclass constructor.


public class SuperKeyword {
    // made the class static nested as it was interfering with Inheritance.java file in the same directory
    static class Animal {
        String color = "White";
        void sound() {
            System.out.println("Animal makes a sound");
        }
        Animal() {
            System.out.println("Animal class constructor");
        }
    }
    
    static class Dog extends Animal {
        String color = "Black";
        void sound() {
            super.sound(); // calling superclass method
            System.out.println("Dog barks");
        }
        Dog() {
            super(); // calling superclass constructor
            System.out.println("Dog class constructor");
        }
        void display() {
            System.out.println("Color of Dog: " + color);
            System.out.println("Color of Animal: " + super.color); // accessing superclass attribute
        }
    }
    
    public static void main(String[] args) {
        Dog d = new Dog();

        d.sound();
        // Output:
        // Animal class constructor
        // Dog class constructor
        // Animal makes a sound
        // Dog barks

        d.display();
        // Output:
        // Color of Dog: Black
        // Color of Animal: White
    }

}
