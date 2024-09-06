// Notes : https://drive.google.com/file/d/1NC_eU8KQPHZSC4BO09uHKG73IAQJDDqg/view

// Problems on Time Complexity

public class TimeComplexityProblems {

    public static void main(String[] args) {

        // 1. Calculate the time complexity for the following code snippet
        int val = 0;
        for (int i = 1; i <= N; i *= 2) { // For total k+1 iterations => i = 2^k
            val++;
        }

        // i <= N => 2^k <= N => k <= log2(N) => k = log2(N)
        // Time Complexity : O(log2(N)) => O(logN)


        // 2. Calculate the time complexity for the following code snippet
        int val = 0;
        for (int i = 1; i <= N; i *= k) { // For total p+1 iterations => i = k^p
            val++;
        }

        // i <= N => k^p <= N => p <= logk(N) => p = logk(N)
        // Time Complexity : O(logk(N)) => O(logN)


        // 3. Calculate the time complexity for the following code snippet
        int val = 0;
        for (int i = 1; i <= N; i += i) { // For total k+1 iterations => i = 2^k
            val++;
        }

        // i <= N => 2^k <= N => k <= log2(N) => k = log2(N)
        // Time Complexity : O(log2(N)) => O(logN)


        // 4. Calculate the time complexity for the given code snippet (nested loop with linear complexity) 
        int val = 0;
        for (int i = 1; i <= N; i *= 2) { // For total k+1 iterations => i = 2^k
            for (int j = 1; j <= i; j++) { // For total 2^k iterations => j = 2^k
                val++;
            }
        }

        // i <= N => 2^k <= N => k <= log2(N) => k = log2(N)
        // 1+2+4+8+...+2^k = 2^(k+1) - 1 = 2^(log2(N)+1) - 1 = 2*2^log2(N) - 1 = 2N - 1
        // Time Complexity : O(N)


        // 5. Calculate the time complexity for the given code snippet
        int val = 0;
        for (int i = 1; i <= N; i *= 2) { // For total k+1 iterations => i = 2^k
            for (int j = N; j > i; j--) { // For total N - 2^k iterations => j = N - 2^k
                val++;
            }
        }

        // i <= N => 2^k <= N => k <= log2(N) => k = log2(N)
        // N + N - 2 + N - 4 + ... + N - 2^k = kN - 2^k(k+1)/2 = Nlog2(N) - N/2
        // Time Complexity : O(NlogN)


        // 6. Calculate the time complexity for the given code snippet
        int val = 0;
        for (int i = N; i > 0; i /= 2) { // For total k+1 iterations => i = N/2^k
            for (int j = 0; j < i; j++) { // For total N - N/2^k iterations => j = N - N/2^k
                val++;
            }
        }
        
        // i > 0 => N/2^k > 0 => k < log2(N) => k = log2(N) - 1
        // N + N/2 + N/4 + ... + N/2^k = N(1 + 1/2 + 1/4 + ... + 1/2^k) = N(2 - 1/2^k) = 2N - N/2^k = 2N - N/2^(log2(N) - 1) = 2N - N/(N/2) = 2N - 2 = 2(N - 1)
        // Time Complexity : O(N)


        // 7. Calculate the time complexity for the given code snippet
        int val = 0;
        for (int i = 2; i <= N; i *= i) { // For total k+1 iterations => i = 2^2^k
            val++;
        }

        // i <= N => 2^2^k <= N => 2^k <= log2(N) => k <= log2(log2(N)) => k = log2(log2(N))
        // Time Complexity : O(loglogN)



    }

}
