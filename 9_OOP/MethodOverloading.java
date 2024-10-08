// Method Overloading - 
// ✽ Same method name with different parameters
// ✽ Return type can be different
// ✽ Compile time polymorphism (Static method dispatch) - Static or early binding
// ✽ Compile time - Method call is resolved at compile time.

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));
        System.out.println(calc.add(2, 3, 4));
        System.out.println(calc.add(2.5, 3.5));

        // Method call is resolved at compile time.
        
    }
}
