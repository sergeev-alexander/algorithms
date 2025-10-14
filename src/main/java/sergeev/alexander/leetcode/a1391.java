package sergeev.alexander.leetcode;

// 1391. Check if There is a Valid Path in a Grid
public class a1391 {

    /*
    You are given an m x n grid. Each cell of grid represents a street. The street of grid[i][j] can be:
    1 which means a street connecting the left cell and the right cell.
    2 which means a street connecting the upper cell and the lower cell.
    3 which means a street connecting the left cell and the lower cell.
    4 which means a street connecting the right cell and the lower cell.
    5 which means a street connecting the left cell and the upper cell.
    6 which means a street connecting the right cell and the upper cell.
    You will initially start at the street of the upper-left cell (0, 0). A valid path in the grid is a path that starts
    from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.
    Notice that you are not allowed to change any street.
    Return true if there is a valid path in the grid or false otherwise.
     */

    public static void main(String[] args) {
//        int[][] nums = {{2, 4, 3}, {6, 5, 2}};
//        int[][] nums = {{6, 1, 3}, {4, 1, 5}};
        int[][] nums = {{1, 1, 1, 1, 1, 1, 3}};
//        int[][] nums = {{4, 1}, {6, 1}};
        System.out.println(hasValidPath(nums));
    }

    // BEATS 99.35%
    public static boolean hasValidPath(int[][] grid) {
        if (grid[0].length == 1) return true;

        int first = grid[0][0];

        return switch (first) {
            case 1, 3 -> checkPath(Direction.RIGHT, grid);
            case 2, 6 -> checkPath(Direction.DOWN, grid);
            case 4 -> checkPath(Direction.UP, grid) || checkPath(Direction.LEFT, grid);
            case 5 -> false;
            default -> throw new IllegalArgumentException();
        };
    }

    private static boolean checkPath(Direction startIn, int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        try {
            Street street = new Street(grid[0][0], startIn);
            int x = street.out.x;
            int y = street.out.y;

            while (true) {
                if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length) {
                    return false;
                }

                if (visited[y][x]) {
                    return false;
                }
                visited[y][x] = true;

                if (x == grid[0].length - 1 && y == grid.length - 1) {
                    try {
                        Street finalStreet = new Street(grid[y][x], street.out);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }

                street = new Street(grid[y][x], street.out);
                x += street.out.x;
                y += street.out.y;
            }
        } catch (Exception ignored) {
            return false;
        }
    }

    public static class Street {

        private final int id;
        private final Direction in;
        private final Direction out;

        public Street(int id, Direction in) {
            this.id = id;
            this.in = in;

            this.out = switch (id) {
                case 1 -> switch (in) {
                    case RIGHT -> Direction.RIGHT;
                    case LEFT -> Direction.LEFT;
                    default -> throw new IllegalArgumentException();
                };
                case 2 -> switch (in) {
                    case UP -> Direction.UP;
                    case DOWN -> Direction.DOWN;
                    default -> throw new IllegalArgumentException();
                };
                case 3 -> switch (in) {
                    case RIGHT -> Direction.DOWN;
                    case UP -> Direction.LEFT;
                    default -> throw new IllegalArgumentException();
                };
                case 4 -> switch (in) {
                    case UP -> Direction.RIGHT;
                    case LEFT -> Direction.DOWN;
                    default -> throw new IllegalArgumentException();
                };
                case 5 -> switch (in) {
                    case RIGHT -> Direction.UP;
                    case DOWN -> Direction.LEFT;
                    default -> throw new IllegalArgumentException();
                };
                case 6 -> switch (in) {
                    case DOWN -> Direction.RIGHT;
                    case LEFT -> Direction.UP;
                    default -> throw new IllegalArgumentException();
                };

                default -> throw new IllegalArgumentException();
            };
        }

        public int getId() {
            return id;
        }

        public Direction getIn() {
            return in;
        }

        public Direction getOut() {
            return out;
        }

    }

    public enum Direction {

        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        private final int x;
        private final int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
