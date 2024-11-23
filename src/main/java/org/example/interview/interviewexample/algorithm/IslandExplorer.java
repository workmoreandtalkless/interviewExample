package org.example.interview.interviewexample.algorithm;

import java.util.*;

public class IslandExplorer {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '0', '0', '1'},
                {'1', '0', '1', '1'},
                {'1', '1', '1', '1'}
        };

        // 1. Find the largest island using DFS
        System.out.println("Largest Island Size: " + largestIsland(grid));

        // 2. Shortest path from top-left to bottom-right using BFS
        System.out.println("Shortest Path: " + shortestPath(grid));

        // 3. Find two largest islands using PriorityQueue
        System.out.println("Two Largest Island Sizes: " + largestIslandsUsingPriorityQueue(grid));

        // 4. Count occurrences of '1' in the grid (String manipulation)
        System.out.println("Count of '1': " + countCharacter(grid, '1'));

    }

    // 1. Largest Island using DFS
    private static int largestIsland(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
                }
            }
        }
        return maxArea;
    }

    private static int dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        int area = 1;
        area += dfs(grid, visited, i + 1, j);
        area += dfs(grid, visited, i - 1, j);
        area += dfs(grid, visited, i, j + 1);
        area += dfs(grid, visited, i, j - 1);

        return area;
    }

    // 2. Shortest Path using BFS
    private static int shortestPath(char[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[]{0, 0, 0}); // {row, col, distance}
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], dist = curr[2];

            if (r == rows - 1 && c == cols - 1) return dist;

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols &&
                        grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                }
            }
        }
        return -1; // No path found
    }

    // 3. Two Largest Islands using PriorityQueue
    private static List<Integer> largestIslandsUsingPriorityQueue(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    pq.add(dfs(grid, visited, i, j));
                }
            }
        }

        List<Integer> largestIslands = new ArrayList<>();
        if (!pq.isEmpty()) largestIslands.add(pq.poll());
        if (!pq.isEmpty()) largestIslands.add(pq.poll());
        return largestIslands;
    }

    // 4. Count occurrences of a specific character in the grid
    private static int countCharacter(char[][] grid, char target) {
        return Arrays.stream(grid)
                .map(row -> new String(row))
                .mapToInt(row -> (int) row.chars().filter(c -> c == target).count())
                .sum();
    }


}

