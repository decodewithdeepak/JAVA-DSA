// Composition - In composition, the contained object cannot exist independently.

// ✽ A stronger form of association where one class is composed of another class, and the contained class cannot exist independently of the container class.
// ✽ Relationship where the child cannot exist independently of the parent.
// ✽ Represents a "Has-A" or "Part-Of" relationship with exclusive ownership.
// ✽ Bidirectional association.

// Composition Example: Car has an Engine
// Car has an Engine, and the engine cannot exist without the car.

class Engine { // Contained class
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