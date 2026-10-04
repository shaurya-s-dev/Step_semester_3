package data_structures.assigment_problems;

public class WarehouseScan {
    public static class Summary {
        public int totalItems;
        public int maxRow;
        public int maxCol;
        
        public Summary(int t, int r, int c) {
            this.totalItems = t;
            this.maxRow = r;
            this.maxCol = c;
        }
        
        @Override
        public String toString() {
            return "total = " + totalItems + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")";
        }
    }
    
    public static Summary warehouseSummary(int[][] grid) {
        int total = 0;
        int max = -1;
        int maxRow = -1;
        int maxCol = -1;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        
        return new Summary(total, maxRow, maxCol);
    }
}
