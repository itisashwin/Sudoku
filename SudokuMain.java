import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class is the entry point to launch the Sudoku Solver UI.
 * It dynamically creates the appropriate board based on the difficulty
 * level selected by the user.
 * 
 * @author Ashwin Natampalli
 * @version 1.0
 *
 */
public class SudokuMain {

	public final static JFrame frame = new JFrame("Sudoku Solver");
	/**
	 * Constructor
	 */
	public SudokuMain() {
	}

	/**
     * Creates the GUI with a default puzzle.
     * @params args Command-line arguments
     */
    public static void main(String[] args) 
    {
        int[][] board = null;
        
        String[] options = {"Novice", "Intermediate", "Expert", "Custom"};
        
        int x = JOptionPane.showOptionDialog(frame, "This game has puzzles of 3 difficulty levels: Novice, Intermediate, Expert. Select one, or input your own puzzle to solve.",
                "Welcome to Sudoku!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        
        String frameText = "";
        if (x == 0) 
        {
        	int[][] board1 = 
        		   {{0, 2, 0, 1, 0, 0, 6, 0, 0},
                    {8, 0, 1, 3, 0, 0, 0, 2, 0},
                    {3, 0, 6, 7, 2, 5, 0, 0, 1},
                    {0, 7, 0, 4, 0, 1, 0, 0, 0},
                    {2, 5, 0, 0, 0, 0, 0, 6, 4},
                    {0, 0, 0, 2, 0, 3, 0, 5, 0},
                    {7, 0, 0, 6, 3, 4, 2, 0, 9},
                    {0, 3, 0, 0, 0, 8, 5, 0, 6},
                    {0, 0, 9, 0, 0, 2, 0, 3, 0}};
        	board = board1;
        	frameText = "Novice";
        }
        else if (x ==1)
        {
        	int[][] board2 = 
        		   {{0, 8, 0, 0, 0, 0, 0, 5, 0},
                    {6, 0, 0, 5, 0, 9, 0, 0, 7},
                    {0, 0, 7, 0, 6, 0, 4, 0, 0},
                    {0, 4, 0, 8, 0, 7, 0, 1, 0},
                    {0, 0, 5, 0, 0, 0, 7, 0, 0},
                    {0, 7, 0, 3, 0, 1, 0, 6, 0},
                    {0, 0, 8, 0, 1, 0, 6, 0, 0},
                    {9, 0, 0, 4, 0, 3, 0, 0, 2},
                    {0, 2, 0, 0, 0, 0, 0, 4, 0}};
        	board = board2;
        	frameText = "Intermediate";
        }
        else if (x == 2)
        {
        	int[][] board3 = 
     		    {{8, 0, 0, 0, 2, 0, 0, 0, 9},
                 {0, 0, 6, 9, 0, 4, 1, 0, 0},
                 {0, 3, 0, 0, 0, 0, 0, 6, 0},
                 {0, 4, 0, 0, 0, 0, 0, 1, 0},
                 {7, 0, 0, 0, 5, 0, 0, 0, 4},
                 {0, 6, 0, 0, 0, 0, 0, 3, 0},
                 {0, 2, 0, 0, 0, 0, 0, 9, 0},
                 {0, 0, 5, 3, 0, 8, 4, 0, 0},
                 {4, 0, 0, 0, 1, 0, 0, 0, 5}};
        	board = board3;
        	frameText = "Expert";
        }
        else if (x == 3)
        {
        	int[][] board4 = 
        		   {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        	board = board4;
        	frameText = "Custom";
        }
        else System.exit(0);
        SudokuSolverFrame solverFrame = new SudokuSolverFrame(new SudokuBoardUI(board), frameText);        
    }   

}
