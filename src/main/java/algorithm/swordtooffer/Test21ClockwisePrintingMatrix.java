package algorithm.swordtooffer;

import java.util.ArrayList;

/**
 * @author 李文浩
 * @date 2018/7/6
 */
public class Test21ClockwisePrintingMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        matrix = new int[][]{
                {1}
        };
        //
        //matrix = new int[][]{
        //        {1, 2},
        //        {3, 4}
        //};


        System.out.println(new Test21ClockwisePrintingMatrix().printMatrix(matrix));
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        int i = 0, j = 0, m1 = 0, m2 = 0, n1 = matrix.length, n2 = matrix[0].length, time = n1;
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 1) {
            for (int val : matrix[0]) {
                list.add(val);
            }
            return list;
        }
        while (time != 0) {
            while (j < n2 - 1) {
                System.out.println(matrix[i][j]+"j++");
                list.add(matrix[i][j]);
                j++;
            }
            time--;
            n2--;
            while (i < n1 - 1) {
                System.out.println(matrix[i][j]+"i++");
                list.add(matrix[i][j]);
                i++;
            }
            n1--;


            while (j > m2) {
                System.out.println(matrix[i][j]+"j--");
                list.add(matrix[i][j]);
                j--;
            }
            time--;
            m2++;

            while (i > m1) {
                System.out.println(matrix[i][j]+"i--");
                list.add(matrix[i][j]);
                i--;
            }
            m1++;

            i = m1;
            j = m2;
        }

        return list;
    }
}
