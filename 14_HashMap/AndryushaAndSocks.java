// Q. Andryusha and Socks - Codeforces 780A (https://codeforces.com/problemset/problem/780/A)

import java.util.*;

public class AndryushaAndSocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of sock pairs
        int[] socks = new int[2 * n]; // Array to store the order of socks taken out
        for (int i = 0; i < 2 * n; i++) {
            socks[i] = sc.nextInt(); // Order in which socks were taken out
        }

        Set<Integer> table = new HashSet<>();
        int maxSocksOnTable = 0;

        for (int i = 0; i < 2 * n; i++) {
            if (table.contains(socks[i])) {
                table.remove(socks[i]); // Remove the pair from the table
            } else {
                table.add(socks[i]); // Add the sock to the table
            }
            maxSocksOnTable = Math.max(maxSocksOnTable, table.size());
        }

        System.out.println(maxSocksOnTable);

        sc.close();
    }
}
