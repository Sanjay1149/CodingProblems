package com.company.backtracking;

public class RatInAMaze {

    public static void printMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int mazeSlot : maze[i])
                System.out.print(mazeSlot + " ");
            System.out.println();
        }
    }

    public static boolean isSafeMove(int[][] maze, int x, int y, int N) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    public static boolean mazeUtilMovement(int[][] maze, int[][] sol, int x, int y, int N) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        if (isSafeMove(maze, x, y, N)) {
            if (sol[x][y] == 1) {
                System.out.println("Rat already visited so backtracking");
                return false;
            }
            System.out.println("Rat visited ( " + x + " , " + y + " ) now.");
            sol[x][y] = 1;

            if (mazeUtilMovement(maze, sol, x, y + 1, N))
                return true;

            if (mazeUtilMovement(maze, sol, x - 1, y, N))
                return true;

            if (mazeUtilMovement(maze, sol, x, y - 1, N))
                return true;

            if (mazeUtilMovement(maze, sol, x + 1, y, N))
                return true;

            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    public static void mazeUtils(int[][] maze) {
        System.out.println("Maze Layout ->");
        printMaze(maze);

        int sol[][] = new int[maze.length][maze.length];
        mazeUtilMovement(maze, sol, 0, 0, maze.length);

        System.out.println("Solved Layout ->");
        printMaze(sol);
    }

    public static void main(String[] args) {
        int maze[][] = {
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
        };
        mazeUtils(maze);
    }
}
