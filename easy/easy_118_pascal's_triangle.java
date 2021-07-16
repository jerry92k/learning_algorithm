import java.util.ArrayList;
import java.util.List;

/*

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangles = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangles.add(firstRow);

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> nextRow = new ArrayList<>();
            List<Integer> row = triangles.get(i);

            for (int j = 0; j < row.size(); j++) {
                if (j == 0) {
                    nextRow.add(row.get(j));
                }
                if (j == row.size() - 1) {
                    nextRow.add(row.get(j));
                }
                if (j + 1 < row.size()) {
                    nextRow.add(row.get(j) + row.get(j + 1));
                }
            }
            triangles.add(nextRow);
        }

        return triangles;
    }
}