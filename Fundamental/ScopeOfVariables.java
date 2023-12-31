// Notes 11 : https://drive.google.com/file/d/1tjpiT1wwfGVtPzy6voW4t5bToIuxQoVJ/view

// Scope of variables : A region from where a variable can be accessed.

// 1. Local variables : declared inside a method, constructor or block.
// 2. Global variables : declared inside a class but outside a method, constructor or block.
// 3. Instance variables : declared inside a class but outside a method, constructor or block.
// 4. Static variables : declared inside a class but outside a method, constructor or block with static keyword.

public class ScopeOfVariables {
    
    // Global variable
    static int global = 10;

    public static void main(String[] args) {
        // Local variable
        int local = 20;
        System.out.println("Local variable: " + local);
        System.out.println("Global variable: " + global);
        
        // Instance variable
        ScopeOfVariables obj = new ScopeOfVariables();
        System.out.println("Instance variable: " + obj.global);
        
        // Static variable
        System.out.println("Static variable: " + global);

        
        for (int i = 0; i < 5; i++) {
            System.out.println("Local variable inside for loop: " + i);
        }
        // System.out.println("Local variable outside for loop: " + i); // Error: i cannot be resolved to a variable




    }

}
