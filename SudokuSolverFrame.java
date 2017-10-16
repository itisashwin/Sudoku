import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class adds the Sudoku board panel to the frame.
 * The user should fill the board with the puzzle to solve and click the
 * 'Start' button to get the solution.
 *
 * @author Ashwin Natampalli
 * @version 1.0
 */
public class SudokuSolverFrame extends SudokuSolver {

	private Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);
	final JFrame frame;
	private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    
    /**
     * Draw the game board.
     * @param ssb The puzzle to solve.
     */
    public SudokuSolverFrame(SudokuBoardUI ssb, String frameText) {
		super(ssb);
		final JPanel panel = ssb.getPanel();
		frame = new JFrame("Sudoku Solver - " + frameText);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.setCursor(waitCursor);
				if (!guess(0, 0))
					JOptionPane.showMessageDialog(frame, "Solution not found!");
				frame.setCursor(defaultCursor);
			}
		};
		
		ActionListener alExit = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(frame, "Thanks for playing!");
				System.exit(0);
			}
		};
		
		ActionListener alReturn = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int[][] board = null;
		        
		        String[] options = {"Novice", "Intermediate", "Expert", "Custom"};
		        String space = "                                      ";
		        int x = JOptionPane.showOptionDialog(frame, space + "Choose a difficulty level!",
		                "More Sudoku?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		        
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
		        	/* Extremely difficult....
		        	int[][] board3 = 
		        		   {{6, 0, 0, 8, 0, 9, 0, 0, 1},
		                    {0, 4, 0, 0, 6, 0, 0, 9, 0},
		                    {0, 0, 0, 7, 0, 2, 0, 0, 0},
		                    {0, 3, 0, 0, 0, 0, 0, 8, 0},
		                    {1, 0, 2, 0, 8, 0, 9, 0, 7},
		                    {0, 9, 0, 0, 0, 0, 0, 4, 0},
		                    {0, 0, 0, 6, 0, 8, 0, 0, 0},
		                    {0, 5, 0, 0, 9, 0, 0, 2, 0},
		                    {8, 0, 0, 4, 0, 7, 0, 0, 6}};
		                    */
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
		        frame.dispose();

			}
		};
		frame.setLayout(new GridBagLayout());
		addComponent(frame, panel, 0, 0, 1, 1);

		JButton b = new JButton("Solve!");
		b.setFont(new Font ("Sans Serif", Font.BOLD, 30));
		b.setMnemonic(KeyEvent.VK_S);
		b.addActionListener(al);
		addComponent(frame, b, 0, 1, 1, 1);
		
		JButton exit = new JButton("Exit");
		exit.setFont(new Font ("Sans Serif", Font.BOLD, 30));
		exit.setMnemonic(KeyEvent.VK_S);
		exit.addActionListener(alExit);
		addComponent(frame, exit, 0, 2, 1, 1);
		
		JButton returnToMain = new JButton("Return to Main Menu");
		returnToMain.setFont(new Font ("Sans Serif", Font.BOLD, 28));
		returnToMain.setMnemonic(KeyEvent.VK_S);
		returnToMain.addActionListener(alReturn);
		addComponent(frame, returnToMain, 0, 3, 1, 1);

		frame.setSize(500, 930);
		frame.setLocation(720, 40);
		frame.setVisible(true);
          
    }
    
    /**
     * Add a component to the GUI.
     * @param container Container to add the component to.
     * @param component The component to be added.
     * @param gridx Horizontal cell position inside the grid.
     * @param gridy Vertical cell position inside the grid.
     * @param gridwidth Number of cells in a row for the text field.
     * @param gridheight Number of cells in a column for the text field.
     */
    private static void addComponent(Container container, Component component,
        int gridx, int gridy, int gridwidth, int gridheight) {
        Insets insets = new Insets(0, 0, 0, 0);
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth,
                gridheight, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, insets, 0, 0);
        container.add(component, gbc);
    }
}