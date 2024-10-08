// Class - A blueprint or template for creating objects
// Object - An instance of a class
// Attributes - Data members of a class (variables) - State or Characteristics of an object
// Methods - Functions defined in a class - Behavior or Actions of an object



public class ClassAndObject {

    static class Car { // made nested static for simplicity
        // Attributes
        String color;
        int maxSpeed;
    
        // Constructor
        Car(String color, int maxSpeed) {
            this.color = color;
            this.maxSpeed = maxSpeed;
        }
    
        // Methods
        void startEngine() {
            System.out.println("Engine started");
        }
    
        void stopEngine() {
            System.out.println("Engine stopped");
        }
    }

    public static void main(String[] args) {
        // Creating an object of the Car class
        
        Car c1 = new Car("Red", 200);
        // Car - Class
        // c1 - Reference variable
        // new - Keyword to create an object in heap memory
        // Car() - Constructor call
        // "Red", 200 - Arguments to the constructor
        // new Car("Red", 200) - Object creation

        // c1 - Reference variable - Stack memory
        // new Car("Red", 200) - Object - Heap memory
        // c1 is pointing to the object in heap memory

        System.out.println("Color: " + c1.color);
        System.out.println("Max Speed: " + c1.maxSpeed);

        c1.startEngine();
    }
}
