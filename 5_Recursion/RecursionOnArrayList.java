// 1. Print integer using arraylist in recursion

import java.util.ArrayList;

public class RecursionOnArrayList {

    // public static ArrayList<Integer> printInt(int n) {
    //     if (n == 0) return new ArrayList<>();
    //     ArrayList<Integer> l = printInt(n / 10);
    //     l.add(n % 10);
    //     return l;
    // }

    public static int printInt(ArrayList<Integer> l) {
        if (l.size() == 0) return 0;
        int n = l.remove(0);
        return printInt(l) * 10 + n;
    }

    public static void main(String[] args) {
        // int n = 12345;
        // System.out.println(printInt(n));
        // for (int i : printInt(n)) {
        //     System.out.print(i);
        // }

        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        System.out.println(printInt(l));


    }
    
}
