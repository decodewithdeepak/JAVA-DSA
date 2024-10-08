// Memory Structure in Java - Stack, Heap, Class Area, Method Area
// Stack Memory - Local variables, method calls, reference variables
// Heap Memory - Objects, instance variables
// Class Area - Class level data, static variables
// Method Area - Method level data, static methods

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


