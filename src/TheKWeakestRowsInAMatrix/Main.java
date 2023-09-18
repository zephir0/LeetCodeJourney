package TheKWeakestRowsInAMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.execute();
    }
}

class Solution {
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the matrix: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns for the matrix: ");
        int columns = scanner.nextInt();

        int[][] mat = new int[rows][columns];

        System.out.println("Enter values for the matrix (1 or 0):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        Solution solution = new Solution();
        int[] result = solution.kWeakestRows(mat, k);

        System.out.println(Arrays.toString(result));
    }

    public int[] kWeakestRows(int[][] mat,
                              int k) {
        int[] result = new int[k];

        List<int[]> soldierCounts = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            soldierCounts.add(new int[]{count, i});
        }

        soldierCounts.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < k; i++) {
            result[i] = soldierCounts.get(i)[1];
        }

        return result;
    }
}
