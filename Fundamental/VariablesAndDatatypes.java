// Notes 3: https://drive.google.com/file/d/1pVqfhoNmOouAoe-rCBGMhwupRHz9yKE3/view
// Variables are used to store data in a program. It is a name given to the reserved memory location.
// Datatypes are used to represent the type of data stored in a variable.

public class VariablesAndDatatypes {
    public static void main(String[] args) {
        // Declaring variables
        int money;
        // Assigning values to variables
        money = 100;
        // Printing variables
        System.out.println(money);
        // Updating variables
        money = 200;
        System.out.println(money);

        // Primitive datatypes
        boolean flag = true; // size 1 bit
        System.out.println(flag);

        char a = 'A'; // size 2 bytes or 16 bits
        System.out.println(a);

        byte b = 126; // size 1 byte or 8 bits 
        System.out.println(b);

        short s = 32000; // size 2 bytes or 16 bits
        System.out.println(s);

        int i = 100000; // size 4 bytes or 32 bits
        System.out.println(i);

        long l = 1000000000L; // size 8 bytes or 64 bits
        System.out.println(l);

        float f = 10.2f; // size 4 bytes or 32 bits
        System.out.println(f);

        double d = 10.2; // size 8 bytes or 64 bits
        System.out.println(d);

        // Non-primitive datatypes
        String str = "Hello World!"; // size depends on the string
        System.out.println(str);

    }
}
