package org.example.dsa.arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class SetMatrixZeroes_73 {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,0},{1,1,1}};
        setZeroesBrute(matrix);
        setZeroesBetter(matrix);
    }

    private static void setZeroesBetter(int[][] matrix) {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int[] rows = new int[rowSize];
        int[] columns = new int[columnSize];
        for(int m=0;m<rowSize;m++){
            for(int n=0;n<columnSize;n++){
                if(matrix[m][n]==0){
                    rows[m]=1;
                    columns[n]=1;
                }
            }
        }
        for(int m=0;m<rowSize;m++){
            for(int n=0;n<columnSize;n++){
                if(rows[m]==1 || columns[n]==1){
                    matrix[m][n]=0;
                }
            }
        }
    }

    private static void setZeroesBrute(int[][] matrix) {
        Set<Integer> columnZeros = new HashSet<>();
        // making zeros for rows
        for (int m = 0; m < matrix.length; m++) {
            int columnSize = matrix[0].length;
            boolean zeroOccured = false;
            for (int n = 0; n < columnSize; n++) {
                if (matrix[m][n] == 0) {
                    columnZeros.add(n);
                    zeroOccured = true;
                }
                if (n == columnSize - 1 && zeroOccured) {
                    for (int n1 = 0; n1 < columnSize; n1++) {
                        matrix[m][n1] = 0;
                    }
                }
            }
            System.out.println(Arrays.toString(matrix[m]));
        }
        // making zeros for columns
        for (int m = 0; m < matrix.length; m++) {
            for (int set : columnZeros) {
                matrix[m][set] = 0;
            }
        }
    }
}
