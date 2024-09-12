// Object Reference

public class A {
    int val = 10;

    void display() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {

        // System.out.println(val); // Error: Cannot make a static reference to the non-static field val
        
        A a1 = new A();
        System.out.println(a1); // A@5acf9800 - hashcode (memory address)
        System.out.println(a1.val); // 10

        A a2 = new A();
        System.out.println(a2); // A@5acf9800 - hashcode (memory address)
        System.out.println(a2.val); // 10

        // Checking if a1 and a2 are pointing to the same object
        System.out.println(a1 == a2); // false

        // Mofying a2
        a2.val = 20;
        System.out.println("After modifying");
        System.out.println(a2.val); // 20
        System.out.println(a1.val); // 10

        // Changing the reference
        a1 = a2; // a1 and a2 are pointing to the same object - same memory address (Shallow Copy)
        System.out.println("After changing the reference");
        System.out.println(a1.val); // 20
        System.out.println(a2.val); // 20

        // Changing a1
        a1.val = 30;
        System.out.println("After changing a1");
        System.out.println(a1.val); // 30
        System.out.println(a2.val); // 30

        // Deep Copy
        A a3 = new A();
        a3 = a2.clone(); // why not deep copy
        a3.val = 40;

        // Display method
        // display(); // Error: Cannot make a static reference to the non-static method display() from the type A
        a1.display(); // Hello
        

    }
}
