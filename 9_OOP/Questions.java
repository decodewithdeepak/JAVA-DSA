// 1. Make Fraction class and add methods to print, simplify, add and multiply two fractions.
// 2. Make your own ArrayList using array and class.

public class Questions {
    
    // 1. Fraction class
    public static class Fraction {
        int num;
        int den;

        Fraction(int n, int d) {
            num = n;
            den = d;
        }

        void print() {
            System.out.println(num + "/" + den);
        }

        void simplify() {
            int gcd = 1;
            int smaller = num < den ? num : den;
            for (int i = 2; i <= smaller; i++) {
                if (num % i == 0 && den % i == 0) {
                    gcd = i;
                }
            }
            num = num / gcd;
            den = den / gcd;
        }

        static Fraction add(Fraction f1, Fraction f2) { // Can be implemented outside the class
            int n = f1.num * f2.den + f2.num * f1.den;
            int d = f1.den * f2.den;
            Fraction f3 = new Fraction(n, d);
            f3.simplify();
            return f3;
        }

        static Fraction multiply(Fraction f1, Fraction f2) {
            int n = f1.num * f2.num;
            int d = f1.den * f2.den;
            Fraction f3 = new Fraction(n, d);
            f3.simplify();
            return f3;
        }
    }


    // 2. Own ArrayList using array and class
    public static class ownArrayList {
        private int[] arr;
        private int nextIndex;

        public ownArrayList() {
            arr = new int[10];
            nextIndex = 0;
        }

        public void add(int element) {
            if (nextIndex == arr.length) {
                int[] temp = arr;
                arr = new int[2 * temp.length]; // Resizing array to double
                for (int i = 0; i < temp.length; i++) {
                    arr[i] = temp[i];
                }
            }
            arr[nextIndex] = element;
            nextIndex++;
        }

        public void print() {
            for (int i = 0; i < nextIndex; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public int removeLast() {
            if (nextIndex == 0) {
                return -1;
            }
            int temp = arr[nextIndex - 1];
            nextIndex--;
            return temp;
        }

        public int get(int index) {
            if (index < nextIndex) {
                return arr[index];
            } else {
                return -1;
            }
        }

        public void add(int index, int element) {
            if (index < nextIndex) {
                arr[index] = element;
            } else if (index == nextIndex) {
                add(element);
            } else {
                return;
            }
        }
    }


    public static void main(String[] args) {
        
        Fraction f1 = new Fraction(4, 6);
        f1.print(); // 4/6
        f1.simplify();
        f1.print(); // 2/3

        Fraction f2 = new Fraction(3, 4);
        f2.print(); // 3/4
        f2.simplify();
        f2.print(); // 3/4

        // Adding f1 and f2
        Fraction f3 = Fraction.add(f1, f2); // Calling add method using Fraction class
        f3.print(); // 17/12

        // Multiplying f1 and f2
        Fraction f4 = Fraction.multiply(f1, f2); // Calling multiply method using Fraction class
        f4.print(); // 1/2


        // 2. Own ArrayList using array and class
        ownArrayList list = new ownArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10); 
        list.add(11); // Resizing array to double

        list.print(); // 1 2 3 4 5 6 7 8 9 10 11

        list.removeLast();
        list.print(); // 1 2 3 4 5 6 7 8 9 10

        list.add(5, 100);
        list.print(); // 1 2 3 4 5 100 7 8 9 10

        System.out.println(list.get(5)); // 100
        System.out.println(list.get(10)); // -1



    }
}
