// Pattern Problems - Star Pattern | Number Pattern | Alphabetic Pattern | Diamond Pattern | Pyramid Pattern | Butterfly Pattern | Special Pattern

public class PrintPattern {

    public static void main(String[] args) {        
        
        System.out.println("\nLeft Triangle Pattern");
        // *
        // **
        // ***
        // ****

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println("\nInverted Left Triangle Pattern");
        // ****
        // ***
        // **
        // *

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j >= i; j--)
                System.out.print("*");
            System.out.println();
        }


        System.out.println("\nRight Triangle Pattern");
        //    *
        //   **
        //  ***
        // ****

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }


        System.out.println("\nInverted Right Triangle Pattern");
        // ****
        //  ***
        //   **
        //    *

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j < i; j++)
                System.out.print(" ");
            for (int j = 4; j >= i; j--)
                System.out.print("*");
            System.out.println();
        }


        System.out.println("\nRectangle Pattern");
        // ****
        // ****
        // ****
        // ****

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) 
                System.out.print("*");
            System.out.println();
        }


        System.out.println("\nHollow Rectangle Pattern"); // Hollow Hourglass Pattern
        // ****
        // *  *
        // *  *
        // ****

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i == 1 || i == 4 || j == 1 || j == 4)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        
        System.out.println("\nHourglass Pattern");
        // *****
        //  ***
        //   *
        //  ***
        // *****

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++)
                if (i == j || j == (6 - i) || i == 1 || i == 5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            System.out.println();
        }


        System.out.println("\nPyramid Pattern");
        //    *
        //   ***
        //  *****
        // *******

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }

        
        System.out.println("\nInverted Pyramid Pattern");
        // *******
        //  *****
        //   ***
        //    *

        for (int i = 4; i >= 1; i--) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }


        System.out.println("\nHollow Pyramid Pattern");
        //    *
        //   * *
        //  *   *
        // *******

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1) || i == 4)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("\nHollow Inverted Pyramid Pattern");
        // *******
        //  *   *
        //   * *
        //    *

        for (int i = 4; i >= 1; i--) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1) || i == 4)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }


        System.out.println("\nDiamond Pattern");
        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }

        for (int i = 3; i >= 1; i--) {
            for (int j = 3; j >= i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }


        System.out.println("\nHollow Diamond Pattern");
        //    *
        //   * *
        //  *   *
        // *     *
        //  *   *
        //   * *
        //    *

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 3; i >= 1; i--) {
            for (int j = 3; j >= i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }


        System.out.println("\nZ Pattern");
        // ****
        //   *
        //  *
        // ****
        for (int i = 0; i < 4; i++) { // Print the top line
            System.out.print("*");
        }
        System.out.println();

        for (int i = 1; i < 4 - 1; i++) { // Print the middle lines
            for (int j = 0; j < 4 - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        for (int i = 0; i < 4; i++) { // Print the bottom line
            System.out.print("*");
        }
        System.out.println();


        System.out.println("\nX Pattern");
        // *   *
        //  * *
        //   *
        //  * *
        // *   *

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++)
                if (i == j || j == (6 - i))
                    System.out.print("*");
                else
                    System.out.print(" ");
            System.out.println();
        }


        System.out.println("\nButterfly Pattern");
        // *        *
        // **      **
        // ***    ***
        // ****  ****
        // **********
        // **********
        // ****  ****
        // ***    ***
        // **      **
        // *        *

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            for (int j = 1; j <= 2 * (5 - i); j++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }

        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            for (int j = 1; j <= 2 * (5 - i); j++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }


        System.out.println("\nHollow Butterfly Pattern");
        // *        *
        // **      **
        // * *    * *
        // *  *  *  *
        // *   **   *
        // *   **   *
        // *  *  *  *
        // * *    * *
        // **      **
        // *        *

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++)
                if (j == 1 || j == i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            for (int j = 1; j <= 2 * (5 - i); j++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                if (j == 1 || j == i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            System.out.println();
        }

        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                if (j == 1 || j == i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            for (int j = 1; j <= 2 * (5 - i); j++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                if (j == 1 || j == i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            System.out.println();
        }


        System.out.println("\nRhombus Pattern");
        //    *****
        //   *****
        //  *****
        // *****

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= 5; j++)
                System.out.print("*");
            System.out.println();
        }


        System.out.println("\nHollow Rhombus Pattern");
        //    *****
        //   *   *
        //  *   *
        // *   *
        //*****

        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= 5; j++) {
                if (i == 1 || i == 5 || j == 1 || j == 5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }


        System.out.println("\nLeft Triangle Number Pattern 1");
        // 1
        // 12
        // 123
        // 1234

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }


        System.out.println("\nLeft Triangle Number Pattern 2");
        // 1
        // 22
        // 333
        // 4444

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(i);
            System.out.println();
        }

 
        System.out.println("\nLeft Triangle Number Pattern 3");
        // 1
        // 23
        // 345
        // 4567
        
        for (int i = 1; i <= 4; i++) {
            // int k = i;
            for (int j = 1; j <= i; j++){
                // System.out.print(k++);
                System.out.print(i + j - 1); // Alternate method
            }
            System.out.println();
        }


        System.out.println("\nLeft Triangle Number Pattern 4");
        // 1
        // 23
        // 456
        // 78910

        int k = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++, k++)
                System.out.print(k);
            System.out.println();
        }

       
        System.out.println("\nInverted Left Triangle Number Pattern");
        // 1234
        // 123
        // 12
        // 1

        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }


        System.out.println("\nRight Triangle Number Pattern");
        //    1
        //   12
        //  123
        // 1234

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }


        System.out.println("\nInverted Right Triangle Number Pattern");
        // 1234
        //  123
        //   12
        //    1

        for (int i = 4; i >= 1; i--) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }


        System.out.println("\nRectangle Number Pattern 1");
        // 1111
        // 2222
        // 3333
        // 4444

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++)
                System.out.print(i);
            System.out.println();
        }


        System.out.println("\nRectangle Number Pattern 2");
        // 1234
        // 1234
        // 1234
        // 1234

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++)
                System.out.print(j);
            System.out.println();
        }


        System.out.println("\nPyramid Number Pattern 1");
        //    1
        //   123
        //  12345
        // 1234567

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print(j);
            System.out.println();
        }


        System.out.println("\nPyramid Number Pattern 2");
        //    1
        //   121
        //  12321
        // 1234321

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j <= i)
                    System.out.print(j);
                else
                    System.out.print((2 * i - j));
            }
            System.out.println();
        }

        System.out.println("\nHollow Pyramid Number Pattern 1");
        //   1
        //  2 2
        // 3   3
        //4444444

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1) || i == 4)
                    System.out.print(i);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }


        System.out.println("\nPascal Triangle Pattern");
        //    1
        //   1 1
        //  1 2 1
        // 1 3 3 1

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");

            int n = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(n + " ");
                n = n * (i - j) / j;
            }
            System.out.println();
        }





        // Alphabetic Pattern - Character
        // ASCII value is used to print the character
        // A = 65, B = 66, C = 67, D = 68, E = 69, F = 70, ... Z = 90

        System.out.println("\nRectangle Alphabetic Pattern 1");
        // ABCD
        // ABCD
        // ABCD
        // ABCD

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++)
                System.out.print((char)(j + 64)); // 64 is used to convert the ASCII value to character
            System.out.println();
        }

        System.out.println("\nRectangle Alphabetic Pattern 2");
        // ABCD
        // BCDE
        // CDEF
        // DEFG
        
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print((char)('A' + i + j - 1));
            System.out.println();
        }


        System.out.println("\nPyramid Alphabetic Pattern 1");
        //    A
        //   ABC
        //  ABCDE
        // ABCDEFG

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print((char)(j + 64));
            System.out.println();
        }


        System.out.println("\nPyramid Alphabetic Pattern 2");
        //    A
        //   ABA
        //  ABCBA
        // ABCDCBA

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--)
                System.out.print(" ");
            
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j <= i)
                    System.out.print((char)(j + 64));
                else
                    System.out.print((char)(2 * i - j + 64));
            }
            System.out.println();
        }


        



        // 7973590916 - Prashant Jindal Sir IITR

    }
}
