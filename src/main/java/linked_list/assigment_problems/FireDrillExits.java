package linked_list.assigment_problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 5: The Fire Drill Exits
 *
 * TASK:
 * For the hostel fire drill, the floor plan is a grid where:
 *   'E' is an exit,
 *   '#' is a wall,
 *   '.' is an open room.
 * Students move up, down, left, or right one room per step.
 * Implement int[][] exitDistance(char[][] plan) that returns, for every cell,
 * the minimum number of steps to the nearest exit:
 *   0 for an exit,
 *  -1 for a wall or a room that cannot reach any exit.
 *
 * Solved using multi-source Breadth-First Search (BFS) starting from all exits simultaneously.
 */
public class FireDrillExits {

    public static int[][] exitDistance(char[][] plan) {
        if (plan == null || plan.length == 0 || plan[0].length == 0) {
            return new int[0][0];
        }

        int rows = plan.length;
        int cols = plan[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize distances:
        // Exits get 0 and are added to BFS queue.
        // Walls and rooms start as -1.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (plan[r][c] == 'E') {
                    dist[r][c] = 0;
                    queue.offer(new int[]{r, c});
                } else {
                    dist[r][c] = -1;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int currentDist = dist[r][c];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check bounds
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    // Only expand to unvisited open rooms '.'
                    if (plan[nr][nc] == '.' && dist[nr][nc] == -1) {
                        dist[nr][nc] = currentDist + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist;
    }
}
