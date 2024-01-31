// Notes 8 : https://drive.google.com/file/d/1DL2hDl1eTV56YujksBX_TxvV5VfhWK2u/view

// Rectangle Pattern
// Triangular Pattern
// Numerical Rectangular Pattern
// Numerical Triangular Pattern
// Special Pattern

// Steps:
// 1. Analyse the row and column
// 2. Derive the relation between row and column
// 3. What to print and where to print

// Visualize the pattern with matrix of row and column

public class PatternProblems {
    public static void main(String[] args) {

        // Nested Loop
        Outer: for (int i = 1; i <= 3; i++) {
            Inner: for (int j = 1; j <= 3; j++) {
                System.out.println(i + " " + j);
            }
            System.out.println();
        }

        // Rectangle Pattern
        // ******
        // ******
        // ******

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // ******
        // *    *
        // *    *
        // ******

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i == 1 || i == 4 || j == 1 || j == 6) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Triangular Pattern
        // *
        // **
        // ***
        // ****
        // *****

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }

        // *****
        // ****
        // ***
        // **
        // *

        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= i; j--)
                System.out.print("*");
            System.out.println();
        }

        // Pyramid Pattern
        //      *
        //     ***
        //    *****
        //   *******

        for (int i = 1; i <= 4; i++) { // traverse row
            for (int j = 3; j >= i; j--) // print row - 1 spaces
                System.out.print(" ");
            for (int k = 1; k <= 2 * i - 1; k++) // print 2*i - 1 stars
                System.out.print("*");
            System.out.println();
        }

        // Numerical Rectangular Pattern
        // 1234567
        // 2345671
        // 3456712
        // 4567123
        // 5671234
        // 6712345
        // 7123456

        for (int i = 1; i <= 7; i++) {
            for (int j = i; j <= 7; j++) {
                System.out.print(j);
            }
            for (int k = 1; k <= i - 1; k++) {
                System.out.print(k);
            }
            System.out.println();
        }

        // 123456
        // 123456
        // 123456
        // 123456

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        // 121212
        // 212121
        // 121212
        // 212121

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 6; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("2");
                }
            }
            System.out.println();
        }

        // Numerical Triangular Pattern
        // 1
        // 12
        // 123
        // 1234
        // 12345

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        
        //      1
        //     121
        //    12321
        //   1234321

        for (int i = 1; i <= 4; i++) { // traverse row
            for (int j = 1; j <= 4 - i; j++) { // print row - 1 spaces
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) { // print 1 to i
                System.out.print(k);
            }
            for (int l = i - 1; l >= 1; l--) { // print i - 1 to 1
                System.out.print(l);
            }
            System.out.println();
        }


        //   1
        //  2 2
        // 3   3
        //4444444




    }

}
