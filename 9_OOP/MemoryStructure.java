// Memory Structure in Java - Stack, Heap, Class (Method) Area, PC Register, Native Method Stack
// Stack Memory - Primitive datatypes, Local variables, method calls, reference variables (Static memory allocation)
// Heap Memory - Derived datatypes, Objects via new keyword, instance variables (Dynamic memory allocation)
// Class (Method) Area - Class level data, static variables, method code, runtime constant pool
// PC Register - Program Counter Register, holds the address of the currently executing instruction
// Native Method Stack - Native method information and memory for native methods (C, C++ code)

public class MemoryStructure {
    public static void main(String[] args) {
        // Stack Memory
        int a = 10; // local variables are stored in stack
        int b = 20;
        int res = add(a, b); // method call


        // Heap Memory
        Student s1 = new Student("Deepak", 101); // object is stored in heap
    }

    public static int add(int a, int b) {
        int c = a + b; // local variables are stored in stack
        return c;
    }

    static class Student {
        String name; // instance variables are stored in heap
        int rollno;
        
        Student(String name, int rollno) {
            this.name = name;
            this.rollno = rollno;
        }
    }
}


