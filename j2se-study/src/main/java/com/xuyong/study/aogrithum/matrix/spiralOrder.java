package com.xuyong.study.aogrithum.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 螺旋矩阵
 * @Author: xuyong
 * @Date: 2022/9/13
 **/
public class spiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int col = 0;
        int row = 0;
        List<Integer> result = new ArrayList<>();
        int target = 0;
        int rowMax = matrix.length;
        int colMax = matrix[0].length;
        int[][] visited = new int[rowMax][colMax];
        for (int i = 0; i < rowMax * colMax; i++) {
            System.out.println("row = " + row + ", col = " + col);
            visited[row][col] = 1;
            result.add(matrix[row][col]);
            if (target % 4 == 0) {
                col++;
                if (col + 1 >= colMax || visited[row][col + 1] == 1) {
                    target++;
                }
            } else if (target % 4 == 1) {
                row++;
                if (row + 1 >= rowMax || visited[row + 1][col] == 1) {
                    target++;
                }
            } else if (target % 4 == 2) {
                col--;
                if (col - 1 < 0 || visited[row][col - 1] == 1) {
                    target++;
                }
            } else if (target % 4 == 3) {
                row--;
                if (row - 1 < 0 || visited[row - 1][col] == 1) {
                    target++;
                }
            }
        }
        return result;
    }

}
