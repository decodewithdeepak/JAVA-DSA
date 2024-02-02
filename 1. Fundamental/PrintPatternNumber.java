public class PrintPatternNumber {
    
    static void printLeftTriangleNumberPattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }
    }

    static void printLeftTriangleNumberPattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(i);
            System.out.println();
        }
    }

    static void printLeftTriangleNumberPattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(i + j - 1);
            System.out.println();
        }
    }

    static void printLeftTriangleNumberPattern4(int n) {
        int k = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++, k++)
                System.out.print(k);
            System.out.println();
        }
    }

    static void printInvertedLeftTriangleNumberPattern(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }
    }

    static void printRightTriangleNumberPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }
    }

    static void printInvertedRightTriangleNumberPattern(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }
    }

    static void printRectangleNumberPattern1(int rows, int columns) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++)
                System.out.print(i);
            System.out.println();
        }
    }

    static void printRectangleNumberPattern2(int rows, int columns) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++)
                System.out.print(j);
            System.out.println();
        }
    }

    static void printPyramidNumberPattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print(j);
            System.out.println();
        }
    }

    static void printPyramidNumberPattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j <= i)
                    System.out.print(j);
                else
                    System.out.print((2 * i - j));
            }
            System.out.println();
        }
    }

    static void printHollowPyramidNumberPattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1) || i == n)
                    System.out.print(i);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void printPascalTrianglePattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");

            int coeff = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(coeff + " ");
                coeff = coeff * (i - j) / j;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("\nLeft Triangle Number Pattern 1");
        // 1
        // 12
        // 123
        // 1234
        printLeftTriangleNumberPattern1(4);

        System.out.println("\nLeft Triangle Number Pattern 2");
        // 1
        // 22
        // 333
        // 4444
        printLeftTriangleNumberPattern2(4);

        System.out.println("\nLeft Triangle Number Pattern 3");
        // 1
        // 23
        // 345
        // 4567
        printLeftTriangleNumberPattern3(4);

        System.out.println("\nLeft Triangle Number Pattern 4");
        // 1
        // 23
        // 456
        // 78910
        printLeftTriangleNumberPattern4(4);

        System.out.println("\nInverted Left Triangle Number Pattern");
        // 1234
        // 123
        // 12
        // 1
        printInvertedLeftTriangleNumberPattern(4);

        System.out.println("\nRight Triangle Number Pattern");
        //    1
        //   12
        //  123
        // 1234
        printRightTriangleNumberPattern(4);

        System.out.println("\nInverted Right Triangle Number Pattern");
        // 1234
        //  123
        //   12
        //    1
        printInvertedRightTriangleNumberPattern(4);

        System.out.println("\nRectangle Number Pattern 1");
        // 1111
        // 2222
        // 3333
        // 4444
        printRectangleNumberPattern1(4, 4);

        System.out.println("\nRectangle Number Pattern 2");
        // 1234
        // 1234
        // 1234
        // 1234
        printRectangleNumberPattern2(4, 4);

        System.out.println("\nPyramid Number Pattern 1");
        //     1
        //    123
        //   12345
        //  1234567
        // 123456789
        printPyramidNumberPattern1(5);

        System.out.println("\nPyramid Number Pattern 2");
        //     1
        //    121
        //   12321
        //  1234321
        // 123454321        
        printPyramidNumberPattern2(5);

        System.out.println("\nHollow Pyramid Number Pattern 1");
        //     1
        //    2 2
        //   3   3
        //  4     4
        // 555555555
        printHollowPyramidNumberPattern1(5);

        System.out.println("\nPascal Triangle Pattern");
        //     1 
        //    1 1
        //   1 2 1
        //  1 3 3 1 
        // 1 4 6 4 1
        printPascalTrianglePattern(5);







    }
}
