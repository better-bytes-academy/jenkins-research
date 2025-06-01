package main.java;
public class NhanMaTran {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] B = {
                {7, 8},
                {9, 10},
                {11, 12}
        };
        int hangA = A.length;
        int cotA = A[0].length;
        int hangB = B.length;
        int cotB = B[0].length;
        int[][] C = new int[hangA][cotB];
        if (cotA != hangB) {
            System.out.println("không thể nhân hai ma trận này");
        }
        for (int i = 0; i < hangA; i++) {
            for (int j = 0; j < cotB; j++) {
                C[i][j] = 0;
                for (int k = 0; k < cotA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        System.out.println("Kết quả phép nhân ma trận A × B:");
        for (int i = 0; i < hangA; i++) {
            for (int j = 0; j < cotB; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
