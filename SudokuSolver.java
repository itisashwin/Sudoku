/**
 * This is the base class for implementing a Sudoku solver.
 * It provides a solution to the puzzle by guessing the solution and
 * backtracking when there are errors.
 * 
 * @author Ashwin Natampalli
 * @version 1.0
 */
public class SudokuSolver {
    private SudokuBoard sb;    

    /**
     * Initializes the game board.
     * @param sb The puzzle to solve.
     */
    public SudokuSolver(SudokuBoard sb) {
        this.sb = sb;
    }
    
    /**
     * Check if a number is valid by Sudoku rules.
     * @param num Number to check.
     * @param row Cell's row.
     * @param col Cell's column.
     * @return false if num already appears in the row,
     * column or box the cell belongs to or true otherwise.
     */
    private boolean check(int num, int row, int col) {
        int r = (row / sb.box_size) * sb.box_size;
        int c = (col / sb.box_size) * sb.box_size;
        
        for (int i = 0; i < sb.size; i++) {
            if (sb.getCell(row, i) == num ||
                sb.getCell(i, col) == num ||
                sb.getCell(r + (i % sb.box_size), c + (i / sb.box_size)) == num) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Test all candidate numbers for a given cell until the board is complete.
     * @param row Cell's row.
     * @param col Cell's column.
     * @return false if no legal numbers are found for this cell.
     */
    public boolean guess(int row, int col) {
        int nextCol = (col + 1) % sb.size;
        int nextRow;
        if(nextCol == 0) 
        {
            nextRow = row + 1;
        }
        else nextRow = row;
        
        try {
            if (sb.getCell(row, col) != sb.EMPTY_CELL)
                return guess(nextRow, nextCol);
        }
        catch (ArrayIndexOutOfBoundsException e) {
                return true;
        }

        for (int i = 1; i <= sb.size; i++) {
            if (check(i, row, col)) {
                sb.setCell(i, row, col);
                if (guess(nextRow, nextCol)) {
                    return true;
                }
            }
        }
        sb.setCell(sb.EMPTY_CELL, row, col);
        return false;
    }
}