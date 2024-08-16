// 1. Set Matrix Zeroes - LeetCode 73 (https://leetcode.com/problems/set-matrix-zeroes/)
// 2. Rotate Image - LeetCode 48 (https://leetcode.com/problems/rotate-image/)
// 3. Determine Whether Matrix Can Be Obtained By Rotation - LeetCode 1886 (https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/)
// 4. Spiral Matrix - LeetCode 54 (https://leetcode.com/problems/spiral-matrix/)
// 5. Spiral Matrix II - LeetCode 59 (https://leetcode.com/problems/spiral-matrix-ii/)
// 6. Pascal's Triangle - LeetCode 118 (https://leetcode.com/problems/pascals-triangle/)


import java.util.*;

public class ProblemsOn2DArray {

    // 1. Set Matrix Zeroes - LeetCode 73
    public void setZeroes(int[][] matrix) {
        // Brute Force Approach - TC: O(n*m) | SC: O(n+m)
        int n = matrix.length; // rows
        int m = matrix[0].length; // columns

        boolean[] row = new boolean[n]; // false
        boolean[] col = new boolean[m]; // false

        // Store the row and column index with value 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Iterate over the array and use the row and col arrays to update the elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Efficient Approach - TC: O(n*m) | SC: O(1)
    }

    // 2. Rotate Image - LeetCode 48
    public void rotate(int[][] matrix){
        // Transpose of Matrix
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = i + 1; j < c; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row of transposed matrix
        for (int i = 0; i < r; i++) {
            int left = 0;
            int right = c - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    // 3. Determine Whether Matrix Can Be Obtained By Rotation - LeetCode 1886
    public boolean findRotation(int[][] mat, int[][] target){
        int r = mat.length;
        int c = mat[0].length;

        // 4 rotations
        for (int k = 0; k < 4; k++){
            // Transpose of Matrix
            for (int i = 0; i < r; i++) {
                for (int j = i + 1; j < c; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }

            // Reverse each row of transposed matrix
            for (int i = 0; i < r; i++) {
                int left = 0;
                int right = c - 1;

                while (left < right) {
                    int temp = mat[i][left];
                    mat[i][left] = mat[i][right];
                    mat[i][right] = temp;

                    left++;
                    right--;
                }
            }

            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
        }

        return false;
    }

    // 4. Spiral Matrix - LeetCode 54
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1; // top and bottom row
        int left = 0, right = n - 1; // left and right column

        while (top <= bottom && left <= right) {
            // Traverse top row : left -> right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // Traverse right column : top -> bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse bottom row : right -> left
            if (top <= bottom) { // to prevent 
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // Traverse left column : bottom -> top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    // 5. Spiral Matrix II - LeetCode 59
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int curr = 1; // current element to be filled

        while (curr <= n*n) {
            // Traverse top row
            for (int j = left; j <= right && curr <= n*n; j++) {
                matrix[top][j] = curr++;
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom && curr <= n*n; i++) {
                matrix[i][right] = curr++;
            }
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int j = right; j >= left && curr <= n*n; j--) {
                    matrix[bottom][j] = curr++;
                }
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top && curr <= n*n;  i--) {
                    matrix[i][left] = curr++;
                }
                left++;
            }
        }

        return matrix;
    }
    
    // 6. Pascal's Triangle - LeetCode 118
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    //         above row's j-1th element     +  above row's jth element
                    row.add(val);
                }
            }
            triangle.add(row);
        }
        return triangle;
    }

}
