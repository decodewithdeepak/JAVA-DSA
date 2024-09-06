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

        for (int i = 1; i <= 3; i++) { // rows r = 3
            for (int j = 1; j <= 6; j++) { // columns c = 6
                System.out.print("*");
            }
            System.out.println();
        }

        // ******
        // *    *
        // *    *
        // ******

        for (int i = 1; i <= 4; i++) { // r = 4
            for (int j = 1; j <= 6; j++) { // c = 6
                if (i == 1 || i == 4 || j == 1 || j == 6) { // print * for 1st and last row and 1st and last column
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

        for (int i = 1; i <= 5; i++) { // rows r = 5
            for (int j = 1; j <= i; j++) { // columns c = i -> 1, 2, 3, 4, 5
                System.out.print("*");
            }
            System.out.println();
        }

        // *****
        // ****
        // ***
        // **
        // *

        for (int i = 5; i >= 1; i--) { // decrease i from 5 to 1
            for (int j = 1; j <= i; j++) { // columns c = i -> 5, 4, 3, 2, 1
                System.out.print("*");
            }
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
            for (int k = 1; k < i; k++) {
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



        
        // Pattern Questions

        // Print these patterns using loops:

        // 1.  *****
        //     *****
        //     *****
        //     *****
        //     *****


        // 2.  *
        //     **
        //     ***
        //     ****
        //     *****


        // 3.  *****
        //     ****
        //     ***
        //     **
        //     *


        // 4.  1
        //     1 2
        //     1 2 3
        //     1 2 3 4
        //     1 2 3 4 5


        // 5.  *
        //     **
        //     ***
        //     ****
        //     *****
        //     ****
        //     ***
        //     **
        //     *


        // 6.       *
        //         **
        //        ***
        //       ****
        //      *****


        // 7.   *****
        //       ****
        //        ***
        //         **
        //          *


        // 8.      *
        //        ***
        //       *****
        //      *******
        //     *********


        // 9.  *********
        //      *******
        //       *****
        //        ***
        //         *


        // 10.      *
        //         * *
        //        * * *
        //       * * * *
        //      * * * * *


        // 11.  * * * * *
        //       * * * *
        //        * * *
        //         * *
        //          *


        // 12.  * * * * *
        //       * * * *
        //        * * *
        //         * *
        //          *
        //          *
        //         * *
        //        * * *
        //       * * * *
        //      * * * * *


        // 13.      *
        //         * *
        //        *   *
        //       *     *
        //      *********


        // 14.  *********
        //       *     *
        //        *   *
        //         * *
        //          *


        // 15.      *
        //         * *
        //        *   *
        //       *     *
        //      *       *
        //       *     *
        //        *   *
        //         * *
        //          *


        // 16.           1
        //             1   1
        //           1   2   1
        //         1   3   3   1
        //       1   4   6   4   1


        // 17.      1
        //         212
        //        32123
        //       4321234
        //        32123
        //         212
        //          1


        // 18.   **********
        //       ****  ****
        //       ***    ***
        //       **      **
        //       *        *
        //       *        *
        //       **      **
        //       ***    ***
        //       ****  ****
        //       **********


        // 19.    *        *
        //        **      **
        //        ***    ***
        //        ****  ****
        //        **********
        //        ****  ****
        //        ***    ***
        //        **      **
        //        *        *


        // 20.    ****
        //        *  *
        //        *  *
        //        *  *
        //        ****

        // 21.    1
        //        2  3
        //        4  5  6
        //        7  8  9  10
        //        11 12 13 14 15

        // 22.    1
        //        0 1
        //        1 0 1
        //        0 1 0 1
        //        1 0 1 0 1

        // 23.        *      *
        //          *   *  *   *
        //        *      *      *

        // 24.    *        *
        //        **      **
        //        * *    * *
        //        *  *  *  *
        //        *   **   *
        //        *   **   *
        //        *  *  *  *
        //        * *    * *
        //        **      **
        //        *        *

        // 25.       *****
        //          *   *
        //         *   *
        //        *   *
        //       *****

        // 26.   1 1 1 1 1 1
        //       2 2 2 2 2
        //       3 3 3 3
        //       4 4 4
        //       5 5
        //       6

        // 27.   1 2 3 4  17 18 19 20
        //         5 6 7  14 15 16
        //           8 9  12 13
        //             10 11

        // 28.      *
        //         * *
        //        * * *
        //       * * * *
        //      * * * * *
        //       * * * *
        //        * * *
        //         * *
        //          *

        // 29.      
        //        *        *
        //        **      **
        //        ***    ***
        //        ****  ****
        //        **********
        //        ****  ****
        //        ***    ***
        //        **      **
        //        *        *

        // 30.         1
        //           2 1 2
        //         3 2 1 2 3
        //       4 3 2 1 2 3 4
        //     5 4 3 2 1 2 3 4 5


        // 31.      4 4 4 4 4 4 4  
        //          4 3 3 3 3 3 4   
        //          4 3 2 2 2 3 4   
        //          4 3 2 1 2 3 4   
        //          4 3 2 2 2 3 4   
        //          4 3 3 3 3 3 4   
        //          4 4 4 4 4 4 4   

        // 32.    E
        //        D E
        //        C D E
        //        B C D E
        //        A B C D E

        // 33.    a
        //        B c
        //        D e F
        //        g H i J
        //        k L m N o
            
        // 34.    E D C B A
        //        D C B A
        //        C B A
        //        B A
        //        A
            
        // 35.    1      1
        //        12    21
        //        123  321
        //        12344321




    }

}
