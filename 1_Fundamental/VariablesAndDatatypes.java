// Notes 3: https://drive.google.com/file/d/1pVqfhoNmOouAoe-rCBGMhwupRHz9yKE3/view
// Variables are used to store data in a program. It is a name given to the reserved memory location.
// Datatypes are used to represent the type of data stored in a variable.

public class VariablesAndDatatypes {
    public static void main(String[] args) {

        // Primitive datatypes - boolean, byte, char, short, int, long, float, double
        // Non-primitive datatypes - String, Array, Class, Interface, etc.

        /*
        Datatype |       Size       | Range                | Default Value
        ---------------------------------------------------|---------------
        boolean  | 1 bit            | true or false        | false
        byte     | 1 byte (8 bit)   | -128 to 127          | 0
        char     | 2 bytes (16 bit) | 0 to 65,536          | '\u0000' (null)
        short    | 2 bytes (16 bit) | -2^15 to 2^15-1      | 0
        int      | 4 bytes (32 bit) | -2^31 to 2^31-1      | 0
        long     | 8 bytes (64 bit) | -2^63 to 2^63-1      | 0L
        float    | 4 bytes (32 bit) | 3.4e-038 to 3.4e+038 | 0.0f
        double   | 8 bytes (64 bit) | 1.7e-308 to 1.7e+308 | 0.0d
        */

        // Size of char is 2 bytes in JAVA because it stores Unicode characters (16-bit characters)
        // Size of char is 1 byte in C/C++ because it stores ASCII characters (8-bit characters)

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
        boolean flag = true;
        System.out.println(flag);

        char a = 'A'; // Single quotes are used for single characters
        System.out.println(a);

        char c = '4';
        System.out.println(c); // 4
        // char c = '48'; // Error - Invalid character constant - Single quotes are used for single characters
        char ch = 48;
        System.out.println(ch); // 0

        // Total ASCII characters - 128 (0 to 127) => https://www.alpharithms.com/wp-content/uploads/340/ascii-table-alpharithms-2048x1220.jpg
        // 0 - NULL ... 32 - SPACE
        // 33 - ! ... 47 - /
        // 48 - 0 ... 57 - 9
        // 65 - A ... 90 - Z
        // 97 - a ... 122 - z
        // 123 - { ... 127 - DEL

        byte b = 126;
        System.out.println(b);

        short s = 32000;
        System.out.println(s);

        int i = 100000;
        System.out.println(i);

        long l = 1000000000L;
        System.out.println(l);

        float f = 10.2f;
        System.out.println(f);

        double d = 10.2;
        System.out.println(d);

        // Non-primitive datatypes
        String str = "Hello World!"; // Double quotes are used for strings
        System.out.println(str);
        System.out.println(str.length()); // 12

        int[] arr = {1, 2, 3, 4, 5};
        for (int x : arr) {
            System.out.print(x + " "); // 1 2 3 4 5
        }
        System.out.println();

        System.out.println(arr.length); // 5

        

    }
}
