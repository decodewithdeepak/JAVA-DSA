// Inheritance in JAVA
// ✽ Inheritance allows new class to inherit the attributes and methods of existing class.
// ✽ The new class is called derived class or subclass or child class.
// ✽ The existing class is called base class or superclass or parent class.
// ✽ Inheritance is used for code reusability and method overriding.
// ✽ Extends keyword is used to inherit the properties of a class.

// Types of Inheritance in JAVA -
// 1. Single Inheritance - One child class inherits from one parent class.
// 2. Multilevel Inheritance - One class inherits from another class and that class inherits from another class.
// 3. Hierarchical Inheritance - Multiple classes inherit from one class.
// 4. Multiple Inheritance (Not supported in JAVA) - One class inherits from multiple classes.
// 5. Hybrid Inheritance (Not supported in JAVA) - Combination of two or more types of inheritance.

// In JAVA, we can achieve multiple inheritance using interfaces.


class Animal {
    void sound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks.");
    }
}

// Note: - We will make the class nested static so that we can run the program without compiling the Animal class first.
// This will help to avoid the conlict with other classes having the same name in the same package.

public class Inheritance {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound(); // Inherited method
        dog.bark(); // Own method
    }
}