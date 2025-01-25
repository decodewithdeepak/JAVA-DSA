// Wrapper classes are used to convert primitive data types into objects.
// Each primitive data type has a corresponding wrapper class in java.lang package.
// Commonly used classes : Integer, Float, Double, Character, Boolean, etc.

public class WrapperClasses {
    public static void main(String[] args) {
        // Boxing: Explicit conversion of primitive to wrapper object
        int num1 = 10;
        Integer obj1 = Integer.valueOf(num1); // Boxing
        System.out.println("Primitive: " + num1 + ", Object: " + obj1);

        // Autoboxing: Automatic conversion of primitive to wrapper object
        int num2 = 10;
        Integer obj2 = num2; // Autoboxing
        System.out.println("Primitive: " + num2 + ", Object: " + obj2);

        // Unboxing: Explicit conversion of wrapper object to primitive type
        Integer obj3 = Integer.valueOf(20); // Boxing
        // Integer obj3 = new Integer(20); // Deprecated
        int num3 = obj3.intValue(); // Unboxing
        System.out.println("Object: " + obj3 + ", Primitive: " + num3);

        // Auto-unboxing: Automatic conversion of wrapper object to primitive type
        Integer obj4 = 20; // Autoboxing
        int num4 = obj4; // Auto-unboxing
        System.out.println("Object: " + obj4 + ", Primitive: " + num4);
    }
}
