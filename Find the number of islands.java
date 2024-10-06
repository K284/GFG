/*
Find the number of islands
Difficulty: MediumAccuracy: 42.12%Submissions: 217K+Points: 4
Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid = [[0,1],[1,0],[1,1],[1,0]]
Output: 1
Explanation:
The grid is-

All lands are connected.
Input: grid = [[0,1,1,1,0,0,0],[0,0,1,1,0,1,0]]
Output: 2
Expanation:
The grid is-
 
There are two islands :- one is colored in "blue" and other in "red".
Expected Time Complexity: O(n*m)
Expected Space Complexity: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] = {'0', '1'}
*/
import java.util.*;

class Solution {
    // Directions arrays to cover all 8 directions
    private static final int[] rowDirection = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static final int[] colDirection = {-1, 0, 1, 1, 1, 0, -1, -1};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int n = grid.length;     // Number of rows
        int m = grid[0].length;  // Number of columns
        int count = 0;           // Number of islands
        
        // Traverse the entire grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the current cell is land ('1'), start DFS to explore the island
                if (grid[i][j] == '1') {
                    count++;
                    iterativeDFS(grid, i, j, n, m);
                }
            }
        }
        return count;
    }
    
    // Iterative DFS to mark all connected land cells as visited using an explicit stack
    private void iterativeDFS(char[][] grid, int row, int col, int n, int m) {
        // Use a stack to simulate DFS
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        
        // Mark the starting cell as visited by setting it to '0'
        grid[row][col] = '0';
        
        // Continue until the stack is empty
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int curRow = current[0];
            int curCol = current[1];
            
            // Explore all 8 directions
            for (int k = 0; k < 8; k++) {
                int newRow = curRow + rowDirection[k];
                int newCol = curCol + colDirection[k];
                
                // If the new cell is valid and is land ('1'), push it onto the stack
                if (isValid(grid, newRow, newCol, n, m)) {
                    grid[newRow][newCol] = '0';  // Mark it as visited
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
    }
    
    // Helper function to check if a cell is valid (within grid bounds and land)
    private boolean isValid(char[][] grid, int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == '1';
    }
}
