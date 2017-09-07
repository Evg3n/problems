package com.hackerrank.datastructure.queue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/castle-on-the-grid/problem
 */
public class CastleOnTheGrid {
    public static void main(String[] args) {
        Scanner in = new Scanner(CastleOnTheGrid.class.getClassLoader()
                .getResourceAsStream("datastructure/queue/castle_on_the_grid.txt"));
        int n = in.nextInt();
        String[] grid = new String[n];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            grid[grid_i] = in.next();
        }
        int startX = in.nextInt();
        int startY = in.nextInt();
        int goalX = in.nextInt();
        int goalY = in.nextInt();
        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println(result);
        in.close();
    }

    private static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        if (startX == goalX && startY == goalY) {
            return 0;
        }

        boolean allFreeFlag = false;
        for (String line : grid) {
            if (line.contains("X")) {
                break;
            }
            allFreeFlag = true;
        }
        if (allFreeFlag) {
            return 2;
        }

        List<Vertex> graph = buildGraph(grid, startX, startY);
        List<Vertex> path = findPath(graph.get(0), goalX, goalY);

        return path.size() == 0 ? 0 : path.size() - 1;
    }

    @SuppressWarnings("Duplicates")
    private static List<Vertex> buildGraph(String[] sourceGrid, int startX, int startY) {
        char[][] grid = new char[sourceGrid[0].length()][sourceGrid[0].length()];
        for (int i = 0; i < sourceGrid.length; i++) {
            grid[i] = sourceGrid[i].toCharArray();
        }

        Vertex start = new Vertex(startX, startY);

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);

        List<Vertex> graph = new ArrayList<>();
        graph.add(start);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();

            //north
            int northX = v.getX();
            while (northX - 1 >= 0 && grid[northX - 1][v.getY()] != 'X') {
                northX--;
                if (northX != v.getX()) {
                    Vertex northV = new Vertex(northX, v.getY());
                    v.getVertices().add(northV);
                    if (!graph.contains(northV)) {
                        graph.add(northV);
                        queue.add(northV);
                    }
                }
            }

            //east
            int eastY = v.getY();
            while (eastY + 1 < sourceGrid[0].length() && grid[v.getX()][eastY + 1] != 'X') {
                eastY++;
                if (eastY != v.getY()) {
                    Vertex eastV = new Vertex(v.getX(), eastY);
                    v.getVertices().add(eastV);
                    if (!graph.contains(eastV)) {
                        graph.add(eastV);
                        queue.add(eastV);
                    }
                }
            }

            //south
            int southX = v.getX();
            while (southX + 1 < sourceGrid[0].length() && grid[southX + 1][v.getY()] != 'X') {
                southX++;
                if (southX != v.getX()) {
                    Vertex southV = new Vertex(southX, v.getY());
                    v.getVertices().add(southV);
                    if (!graph.contains(southV)) {
                        graph.add(southV);
                        queue.add(southV);
                    }
                }
            }

            //west
            int westY = v.getY();
            while (westY - 1 >= 0 && grid[v.getX()][westY - 1] != 'X') {
                westY--;
                if (westY != v.getY()) {
                    Vertex westV = new Vertex(v.getX(), westY);
                    v.getVertices().add(westV);
                    if (!graph.contains(westV)) {
                        graph.add(westV);
                        queue.add(westV);
                    }
                }
            }
        }

        return graph;
    }

    private static List<Vertex> findPath(Vertex root, int goalX, int goalY) {
        Vertex goalV = new Vertex(goalX, goalY);

        if (root == null) {
            return Collections.emptyList();
        }
        if (root == goalV) {
            return Collections.singletonList(root);
        }

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);

        Set<Vertex> visited = new HashSet<>();

        List<Vertex> shortestPath = new ArrayList<>();

        Map<Vertex, Vertex> parents = new HashMap<>();

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            visited.add(vertex);
            if (vertex.equals(goalV)) {
                List<Vertex> path = new ArrayList<>();
                Vertex parent = vertex;
                while (parent != null) {
                    path.add(parents.get(parent));
                    parent = parents.get(parent);
                }
                if (shortestPath.isEmpty() || shortestPath.size() > path.size()) {
                    shortestPath = path;
                }
            } else {
                List<Vertex> toAdd =
                        vertex.getVertices().stream().filter(v -> !visited.contains(v)).collect(Collectors.toList());
                for (Vertex v : toAdd) {
                    visited.addAll(toAdd);
                    parents.put(v, vertex);
                }
                queue.addAll(toAdd);
            }
        }

        Collections.reverse(shortestPath);
        return shortestPath;
    }

    private static class Vertex {
        private int x;
        private int y;
        private List<Vertex> vertices;

        Vertex() {
            vertices = new ArrayList<>();
        }

        Vertex(int x, int y) {
            this();
            this.x = x;
            this.y = y;
        }

        public List<Vertex> getVertices() {
            return vertices;
        }

        public void setVertices(List<Vertex> vertices) {
            this.vertices = vertices;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Vertex vertex = (Vertex) o;

            if (x != vertex.x) {
                return false;
            }
            return y == vertex.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}