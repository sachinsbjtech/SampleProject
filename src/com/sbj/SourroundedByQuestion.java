package com.sbj;

public class SourroundedByQuestion {
	final static int Row = 4;
    final static int Col = 5;
    static int r[] = {0, 0, 1, -1};
    static int c[] = {1, -1, 0, 0};
  
    static boolean isSafe(int x, int y, int M[][]) {
        if (x >= 0 && x <Row && y >= 0
                && y < Col && M[x][y] == 0) {
            return true;
        }
        return false;
    }
  
// DFS function to mark all reachable cells from
// (x, y)
    static void DFS(int x, int y, int M[][]) {
        // make it's visited
        M[x][y] = 1;
        for (int k = 0; k < 4; k++) {
            if (isSafe(x + r[k], y + c[k], M)) {
                DFS(x + r[k], y + c[k], M);
            }
        }
    }
  
// function return count of 0's which are surrounded by 1
    static int CountAllZero(int M[][]) {
        // first we remove all zeros which are not
        // surrounded by 1 that means we only remove 
        // those zeros which are reachable from
        // any boundary of given matrix.
        for (int i = 0; i < Col; i++) {
            if (M[0][i] == 0) {
                DFS(0, i, M);
            }
        }
        for (int i = 0; i < Col; i++) {
            if (M[Row - 1][i] == 0) {
                DFS(Row - 1, i, M);
            }
        }
        for (int i = 0; i < Row; i++) {
            if (M[i][0] == 0) {
                DFS(i, 0, M);
            }
        }
        for (int i = 0; i < Row; i++) {
            if (M[i][Col - 1] == 0) {
                DFS(i, Col - 1, M);
            }
        }
  
        // count all zeros which are surrounded by 1
        int result = 0;
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                if (M[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }
  
// driver program to test above function
    public static void main(String[] args) {
        int M[][] = {{1, 1, 1, 0, 1},
        {1, 0, 0, 1, 0},
        {1, 0, 1, 0, 1},
        {0, 1, 1, 1, 1}};
        System.out.print(CountAllZero(M));
    }
}
