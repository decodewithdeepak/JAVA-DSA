// Final Keyword- Used to prevent inheritance, method overriding, and reassignment of variables.
// ✽ Final class - A class that cannot be subclassed or inherited.
// ✽ Final method - A method that cannot be overridden by the subclass.
// ✽ Final variable - A variable that cannot be reassigned after initialization.

final class FinalClass {
    // Class implementation
}

class SubClass extends FinalClass { } // Error - cannot inherit from final class
// This will cause a compile-time error

class Animal {
    final void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() { // Error - cannot override final method
        System.out.println("Dog barks");
    }
    // This will cause a compile-time error
}


public class FinalKeyword {
        
    public static void main(String[] args) {
        final int x = 10;
        x = 20; // Error - cannot reassign final variable
        // This will cause a compile-time error
    }

}
