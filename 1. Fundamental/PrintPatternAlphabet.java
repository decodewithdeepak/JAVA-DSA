public class PrintPatternAlphabet {
    
    static void printRectangleAlphabeticPattern1(int rows, int columns) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++)
                System.out.print((char)(j + 64)); // 64 is used to convert the ASCII value to character
            System.out.println();
        }
    }

    static void printRectangleAlphabeticPattern2(int rows, int columns) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < columns; j++)
                System.out.print((char)('A' + i + j - 1));
            System.out.println();
        }
    }

    static void printPyramidAlphabeticPattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print((char)(j + 64));
            System.out.println();
        }
    }

    static void printPyramidAlphabeticPattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j <= i)
                    System.out.print((char)(j + 64));
                else
                    System.out.print((char)(2 * i - j + 64));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        // Alphabetic Pattern - Character
        // ASCII value is used to print the character
        // A = 65, B = 66, C = 67, D = 68, E = 69, F = 70, ... Z = 90

        System.out.println("\nRectangle Alphabetic Pattern 1");
        // ABCD
        // ABCD
        // ABCD
        // ABCD
        printRectangleAlphabeticPattern1(4, 4);

        System.out.println("\nRectangle Alphabetic Pattern 2");
        // ABCD
        // BCDE
        // CDEF
        // DEFG
        printRectangleAlphabeticPattern2(4, 4);

        System.out.println("\nPyramid Alphabetic Pattern 1");
        //    A
        //   ABC
        //  ABCDE
        // ABCDEFG
        printPyramidAlphabeticPattern1(4);

        System.out.println("\nPyramid Alphabetic Pattern 2");
        //    A
        //   ABA
        //  ABCBA
        // ABCDCBA
        printPyramidAlphabeticPattern2(4);


                
        // E
        // D E
        // C D E
        // B C D E
        // A B C D E

        // a
        // B c
        // D e F
        // g H i J
        // k L m N o

        // E D C B A
        // D C B A
        // C B A
        // B A
        // A



    }
}
