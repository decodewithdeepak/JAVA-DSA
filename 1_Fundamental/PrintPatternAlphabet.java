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

    static void printPyramidAlphabeticPattern3(int n) {
        for (int i = 0; i < n; i++) {
            char ch = (char) ('E' - i);
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }    

    static void printPyramidAlphabeticPattern4(int n) {
        char ch = 'a';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
                ch = (ch >= 'a' && ch <= 'z') ? (char) (ch - 31) : (char) (ch + 33);
            }
            System.out.println();
        }
    }    

    static void printPyramidAlphabeticPattern5(int n) {
        for (int i = 0; i < n; i++) {
            char ch = (char) ('A' + n - i - 1);
            for (int j = 0; j < n - i; j++) {
                System.out.print(ch + " ");
                ch--;
            }
            System.out.println();
        }
    }    

    static void printPyramidAlphabeticPattern6(int n) {

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


        System.out.println("\nPyramid Alphabetic Pattern 3");        
        // E
        // D E
        // C D E
        // B C D E
        // A B C D E
        printPyramidAlphabeticPattern3(5);

        System.out.println("\nPyramid Alphabetic Pattern 4");
        // a
        // B c
        // D e F
        // g H i J
        // k L m N o
        printPyramidAlphabeticPattern4(5);

        System.out.println("\nPyramid Alphabetic Pattern 5");
        // E D C B A
        // D C B A
        // C B A
        // B A
        // A
        printPyramidAlphabeticPattern5(5);

        System.out.println("\nPyramid Alphabetic Pattern 6");
        // A B C D E F G
        // A B C   E F G
        // A B       F G
        // A           G
        printPyramidAlphabeticPattern6(4);

        



    }
}
