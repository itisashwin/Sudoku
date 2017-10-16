import java.awt.*;
import javax.swing.*;

/**
 * This class represents the Sudoku graphical user interface.
 * It createsan a two-dimensional array of TextField providing all the 
 * functionality of a SudokuBoard object.
 *
 * @author Ashwin Natampalli
 * @version 1.0
 */
public class SudokuBoardUI extends SudokuBoard {
    // The text boxes to  input numbers
    private JTextField[][] cells;  
    
    // The container having all the text fields
    private JPanel panel = new JPanel();   

    /**
     * Draws an empty board.
     * @param size Number of rows and columns of the board.
     */
    public SudokuBoardUI(int size) {
        super(size);
        cells = new JTextField[size][size];
        panel.setLayout(new GridLayout(size, size));
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++)  {
                cells[row][col] = new JTextField(1);
                cells[row][col].setHorizontalAlignment(SwingConstants.CENTER);
                cells[row][col].setFont(new Font ("Sans Serif", Font.BOLD, 22 ));
                panel.add(cells[row][col]);
            }
        }
    }

    /**
     * Draws and initializes the board.
     * @param board Array to initialize the contents of the board
     */
    public SudokuBoardUI(int[][] board) 
    {
        this(board.length);
        for (int row = 0; row < size; row++) 
        {
            for (int col = 0; col < size; col++) 
            {
                setCell(board[row][col], row, col);
            }
        }
    }
    
    /**
     * Puts a number into a specific text field.
     * @param num Number to put into the text field (cell).
     * @param row Cell's row.
     * @param col Cell's column.
     */
    public void setCell(int num, int row, int col) {
        super.setCell(num, row, col);
        String text;
        if (num == EMPTY_CELL)
        {
        	text = "";
        }
        else
        {
        	text = String.valueOf(num);
        }
        cells[row][col].setText(text);
    }
    
    /**
     * Returns the number contained in a specific text field (cell).
     * @param row Cell's row.
     * @param col Cell's column.
     * @return The number contained in the cell.
     */
    public int getCell(int row, int col) {
        int cell;

        try {
            cell = Integer.parseInt(cells[row][col].getText());
        }
        catch (NumberFormatException e) {
            cell = EMPTY_CELL;
        }
        return cell;
    }
    
    /**
     * Returns the JPanel containing the board.
     * @return Returns the board container.
     */
    public JPanel getPanel() {
        return panel;
    }
}
