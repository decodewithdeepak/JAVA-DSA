public class Swap {
    public static void main(String[] args) {
        
        // Swap two given ingeger values
        int a = 5;
        int b = 10;
        System.out.println("Before swapping: a = " + a + " and b = " + b);

        // Swap using temp variable (third variable)
        // int temp = a;
        // a = b;
        // b = temp;

        // System.out.println("After swapping: a = " + a + " and b = " + b);

        // Swap without using temp variable (sum and difference method)
        a = a + b; // a = 5 + 10 = 15
        b = a - b; // b = 15 - 10 = 5
        a = a - b; // a = 15 - 5 = 10

        System.out.println("After swapping: a = " + a + " and b = " + b);


    }
}
