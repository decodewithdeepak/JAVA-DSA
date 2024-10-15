// Composition - 

// ✽ Composition is a relationship where one class (container) contains references to another class (contained) and the contained class cannot exist independently of the container class.
// ✽ This indicates a stronger form of association between the classes.
// ✽ It indicates that the contained class is an integral part of the container class.
// ✽ Represents a "Has-A" or "Part-Of" relationship with exclusive ownership.
// ✽ Bidirectional association.

// Composition Example: Car has an Engine
// Car class has an Engine, and the Engine cannot exist without the Car.

class Engine { // Contained class OR Component class
    void start() {
        System.out.println("Engine is starting...");
    }
}

class Car { // Container class
    Engine engine; // Composition
    
    Car() {
        engine = new Engine(); // Engine is created inside Car
    }
    
    void drive() {
        engine.start();
        System.out.println("Car is driving...");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.drive(); // Output: Engine is starting... Car is driving...
    }
}