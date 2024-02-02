public class PrintPatternStar {
    
    static void printRectanglePattern(int rows, int columns) { // rows = 4, columns = 5
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    static void printHollowRectanglePattern(int rows, int columns) { // rows = 4, columns = 5
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (i == 1 || i == rows || j == 1 || j == columns) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    static void printLeftTriangularPattern(int n) { // n = 5 (rows)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    static void printInvertedLeftTriangularPattern(int n) { // n = 5 (rows)
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    static void printRightTriangularPattern(int n) { // n = 5 (rows)
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                if (j > i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }



    static void printInvertedRightTriangularPattern(int n) { // n = 5 (rows)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }



    static void printHolllowGlassPattern(int n) { // n = 5 (rows)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                if (i == j || j == (n + 1 - i) || i == 1 || i == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            System.out.println();
        }
    }



    static void printPyramidPattern(int n) { // n = 5 (rows)
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }
    }



    static void printInvertedPyramidPattern(int n) { // n = 5 (rows)
        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }
    }


    static void printHollowPyramidPattern(int n) { // n = 5 (rows)
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1) || i == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }


    static void printHollowInvertedPyramidPattern(int n) { // n = 5 (rows)
        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1) || i == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }


    static void printDiamondPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }
    }


    static void printHollowDiamondPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }


    static void printZPattern(int n) {
        for (int i = 1; i <= n; i++) { // Print the top line
            System.out.print("*");
        }
        System.out.println();

        for (int i = 1; i <= n - 2; i++) { // Print the middle lines
            for (int j = n - 2; j >= i; j--) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        for (int i = 1; i <= n; i++) { // Print the bottom line
            System.out.print("*");
        }
        System.out.println();
    }



    static void printXPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i || j == (n + 1 - i))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }


    static void printRhombusPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= n; j++)
                System.out.print("*");
            System.out.println();
        }
    }


    static void printHollowRohmbusPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void printButterflyPattern(int n) {
        // Upper part of the butterfly pattern
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            for (int j = 1; j <= 2 * (n - i); j++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    
        // Lower part of the butterfly pattern
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            for (int j = 1; j <= 2 * (n - i); j++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    


    static void printHollowButterflyPattern(int n) {
        // Upper part of the butterfly pattern
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    
        // Lower part of the butterfly pattern
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    

    public static void main(String[] args) {
        
        System.out.println("\nRectangle Pattern: ");
        // *****
        // *****
        // *****
        // *****
        printRectanglePattern(4,5);


        System.out.println("\nHollow Rectangle Pattern: ");
        // *****
        // *   *
        // *   *
        // *****
        printHollowRectanglePattern(4,5);


        System.out.println("\nLeft Triangular Pattern: ");
        // *
        // **
        // ***
        // ****
        // *****
        printLeftTriangularPattern(5);


        System.out.println("\nInverted Left Triangular Pattern: ");
        // *****
        // ****
        // ***
        // **
        // *
        printInvertedLeftTriangularPattern(5);


        System.out.println("\nRight Triangular Pattern: ");
        //     *
        //    **
        //   ***
        //  ****
        // *****
        printRightTriangularPattern(5);


        System.out.println("\nInverted Right Triangular Pattern: ");
        // *****
        //  ****
        //   ***
        //    **
        //     *
        printInvertedRightTriangularPattern(5);


        System.out.println("\nHourglass Pattern: ");
        // *****
        //  ***
        //   *
        //  ***
        // *****
        printHolllowGlassPattern(5);


        System.out.println("\nPyramid Pattern: ");
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        printPyramidPattern(5);


        System.out.println("\nInverted Pyramid Pattern: ");
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        printInvertedPyramidPattern(5);

        
        System.out.println("\nHollow Pyramid Pattern: ");
        //     *
        //    * *
        //   *   *
        //  *     *
        // *********
        printHollowPyramidPattern(5);


        System.out.println("\nHollow Inverted Pyramid Pattern: ");
        // *********
        //  *     *
        //   *   *
        //    * *
        //     *
        printHollowInvertedPyramidPattern(5);
        

        System.out.println("\nDiamond Pattern: ");
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        printDiamondPattern(5);


        System.out.println("\nHollow Diamond Pattern: ");
        //     *
        //    * *
        //   *   *
        //  *     *
        // *       *
        //  *     *
        //   *   *
        //    * *
        //     *
        printHollowDiamondPattern(5);


        System.out.println("\nZ Pattern: ");
        // *****
        //    *
        //   *
        //  *
        // *****
        printZPattern(5);


        System.out.println("\nX Pattern: ");
        // *   *
        //  * *
        //   *
        //  * *
        // *   *
        printXPattern(5);


        System.out.println("\nRhombus Pattern: ");
        //     *****
        //    *****
        //   *****
        //  *****
        // *****
        printRhombusPattern(5);


        System.out.println("\nHollow Rhombus Pattern: ");
        //     *****
        //    *   *
        //   *   *
        //  *   *
        // *****
        printHollowRohmbusPattern(5);


        System.out.println("\nButterfly Pattern: ");
        // *        *
        // **      **
        // ***    ***
        // ****  ****
        // **********
        // ****  ****
        // ***    ***
        // **      **
        // *        *
        printButterflyPattern(5);


        System.out.println("\nHollow Butterfly Pattern: ");
        // *        *
        // **      **
        // * *    * *
        // *  *  *  *
        // *   **   *
        // *  *  *  *
        // * *    * *
        // **      **
        // *        *
        printHollowButterflyPattern(5);
        


        // 7973590916 - Prashant Jindal Sir IITR

        
    }

}
