import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class  SudokuGUIMain {

    private static JFrame frame;
    
    private static JPanel mainPanel;
    
    private static SudokuBoard board;
    
    private static final int SIZE = board.SIZE;
    
    private static JTextField[][] guiCells = new JTextField[SIZE][SIZE];
    
    private static boolean gameInProgress = false;
    
    private static JMenu newgameMenu;
    
    private static JMenuItem solveItem;


        public static void main(String[] args) {
        
        frame = new JFrame();
        frame.setTitle("9*9 Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.setResizable(false);
        
        mainPanel = new JPanel();
        frame.add(mainPanel);
        
        JMenuBar menuBar = new JMenuBar();
        
        //building file menu
        JMenu fileMenu = new JMenu("{|All about Game|}");
        
        //buiding a submenu called" click here to start a new game"
        newgameMenu = new JMenu(" Click here to start a new game");
        
        //building Quit menu item
        JMenuItem quitItem = new JMenuItem("Quit this app");
        
        //building New Game menu item
        JMenuItem newGameItem1 = new JMenuItem("New Game with puzzle 1");
        JMenuItem newGameItem2 = new JMenuItem("New Game with puzzle 2");
        JMenuItem newGameItem3 = new JMenuItem("New Game with puzzle 3");
        JMenuItem newGameItem4 = new JMenuItem("New Game with puzzle 4");
        JMenuItem newGameItem5 = new JMenuItem("New Game with puzzle 5");
        JMenuItem newGameItem6 = new JMenuItem("New Game with puzzle 6");
        JMenuItem newGameItem7 = new JMenuItem("New Game with puzzle 7");
        
        //buliding Solve menu item
        solveItem = new JMenuItem("Solve");
        
        // building help menu
        JMenu helpMenu = new JMenu("{|(important!!!click here first!)About How to use this SUdoku app|}");
        JMenuItem about = new JMenuItem("About how to play it");
        
        //add items into the subMenu.
        newgameMenu.add(newGameItem1);
        newgameMenu.add(newGameItem2);
        newgameMenu.add(newGameItem3);
        newgameMenu.add(newGameItem4);
        newgameMenu.add(newGameItem5);
        newgameMenu.add(newGameItem6);
        newgameMenu.add(newGameItem7);
        
        //add the subMenu "click here to start a new game" to the  main menu
        fileMenu.add(newgameMenu);
        fileMenu.add(solveItem);
        
        //add quititem into the main Menu.
        fileMenu.add(quitItem);
        
        //add the aboutitem into the helpmenu.
        helpMenu.add(about);
        
        //add fileMenu and helpMenu.
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        
        solveItem.setEnabled(false);    //In the very beginning . solveitem can not be clicked until a new game starts.
        
        //Add a listener for each new game menu item.
        ActionListener newGameListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = "";
                if (e.getSource() == newGameItem1) filename = "puzzle_1.txt";
                else if (e.getSource() == newGameItem2) filename = "puzzle_2.txt";
                else if (e.getSource() == newGameItem3) filename = "puzzle_3.txt";
                else if (e.getSource() == newGameItem4) filename = "puzzle_4.txt";
                else if (e.getSource() == newGameItem5) filename = "puzzle_5.txt";
                else if (e.getSource() == newGameItem6) filename = "solvable_puzzle_1.txt";
                else if (e.getSource() == newGameItem7) filename = "solvable_puzzle_2.txt";
                
                CleanBoard();
                startNewGame(filename);
                solveItem.setEnabled(true);
                newgameMenu.setEnabled(false);  //once new game started , this menu "click here to start a new game" should be closed.
                gameInProgress = true;
            }
        };
        
        newGameItem1.addActionListener(newGameListener);
        newGameItem2.addActionListener(newGameListener);
        newGameItem3.addActionListener(newGameListener);
        newGameItem4.addActionListener(newGameListener);
        newGameItem5.addActionListener(newGameListener);
        newGameItem6.addActionListener(newGameListener);
        newGameItem7.addActionListener(newGameListener);
        
        solveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SudokuBoard solvedBoard = board.solve();
                if (solvedBoard == null) {
                    JOptionPane.showMessageDialog(frame, 
                        "This puzzle cannot be solved! You can start another new puzzle or quit the app.", 
                        "FAIL!", 
                        JOptionPane.WARNING_MESSAGE);
                    
                    // The game is over. You can choose a new game.
                    newgameMenu.setEnabled(true);
                    
                    gameInProgress = false;
                } 
                else{
                    board = solvedBoard;
                    updateSolvedBoard();
                    
                    int choice = JOptionPane.showConfirmDialog(frame,
                        "DONE! Would you like to start a new game?",
                        "SUCCESS!",
                        JOptionPane.YES_NO_OPTION);
                    
                    if (choice == JOptionPane.YES_OPTION) {
                        // The user wants to start a new game.The user wants to start a new game.
                        CleanBoard();
                        solveItem.setEnabled(false);
                        newgameMenu.setEnabled(true);   // user want to start a new game.this menu should be open now.
                        gameInProgress = false;
                        // The new game menu is still available.
                    } else {
                        // The user wishes to continue viewing the answer.
                        gameInProgress = true;
                        newgameMenu.setEnabled(true);   // user want to start a new game.this menu should be open now.
                    }
                }
                solveItem.setEnabled(false);
            }
        });
        
        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, 
                    "Instructions:\n\n" +
                    "1. Click 'Click here to start a new game' to choose a puzzle\n" +
                    "2. Enter numbers (1-9) into the empty cells\n" +
                    "3. Press ENTER after filling a cell to update the board\n" +
                    "4. When all cells are filled, the app will automatically check your solution\n" +
                    "5. Click 'Solve' to see the solution\n" +
                    "6. After solving or completing a puzzle, you can start a new one\n" +
                    "7. Click 'Quit this app' to exit the game\n\n" +
                    "Note: Gray cells are fixed and cannot be changed.",
                    "How to Play Sudoku",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }


    /**
    * Method called when new game menu item is selected
     */

    private  static void startNewGame( String file_name_of_puzzle ) {
        board = new SudokuBoard(file_name_of_puzzle);
        mainPanel.setLayout(new GridLayout( SIZE, SIZE ));
        for ( int row = 0; row < SIZE ; row++) {
            for ( int col = 0; col <  SIZE; col++) {
                int value = board.getValueFromBoard( row , col );
                JTextField cell = new JTextField();
                guiCells[row][col] = cell;
                if (board.isCellFixed(row, col)) {
                    cell.setText("" + value);
                    cell.setEditable(false);
                    cell.setBackground(Color.LIGHT_GRAY);
                }
                else {
                    cell.setText("");
                    cell.setEditable(true);
                    cell.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // whenever an editable field text changes, the board must be updated
                            updateBoard();
                            
                            if( board.check_whether_borad_full() ){
                                if( board.isSolved() ){
                                    int choice = JOptionPane.showConfirmDialog(frame,
                                    "DONE! Would you like to start a new game?",
                                    "SUCCESS!",
                                    JOptionPane.YES_NO_OPTION); 
                                    if (choice == JOptionPane.YES_OPTION) {
                                        // The user wants to start a new game.The user wants to start a new game.
                                        CleanBoard();
                                        solveItem.setEnabled(false);
                                        newgameMenu.setEnabled(true);   // user want to start a new game.this menu should be open now.
                                        gameInProgress = false;
                                        // The new game menu is still available.
                                    } 
                                    else {
                                        // The user wishes to continue viewing the answer.
                                        gameInProgress = true;
                                        newgameMenu.setEnabled(true);   // user want to start a new game.this menu should be open now.
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(frame, 
                                    "NO CORRECT!Please keep going try to solve it!", 
                                    "OOPS!", 
                                    JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    });
                }
                mainPanel.add(cell);
            }
        }
        frame.revalidate();
    }
    
    /**
     * Method called whenever a field of the game board is updated.
     */
    private static void updateBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE ; col++) {
                if (!board.isCellFixed(row, col)) {
                    JTextField guiCell = guiCells[row][col];
                    String text = guiCell.getText();
                    if (!text.equals("")) {
                        try {
                            int value = Integer.parseInt(text);
                            if (value >= 1 && value <= 9) {
                                board.setCellValue(row, col, value);
                            }
                            else {
                                // value outside range
                                JOptionPane.showMessageDialog(frame, "invalid integer value in position " + row + " " + col);
                                guiCell.setText("");
                                guiCell.setText(board.getValueFromBoard(row, col) == 0 ? "" : "" + board.getValueFromBoard(row, col));
                            }
                        }
                        catch (Exception e) {
                            // value is not an integer
                            JOptionPane.showMessageDialog(frame, "invalid input in position " + row + " " + col);
                            guiCell.setText("");
                            guiCell.setText(board.getValueFromBoard(row, col) == 0 ? "" : "" + board.getValueFromBoard(row, col));
                        }
                    }
                    else {
                        // board value is empty string, set the corresponding board cell to zero
                        guiCell.setText(board.getValueFromBoard(row, col) == 0 ? "" : "" + board.getValueFromBoard(row, col));
                    }
                }
            }
        }
        frame.repaint();
    }
    
    private static void updateSolvedBoard(){
        for( int row = 0 ; row < SIZE ; row++ ){
            for( int col = 0 ; col < SIZE ; col++ ){
                JTextField cell = guiCells[row][col];
                int value = board.getValueFromBoard( row , col );
                if( value != 0 ){
                    cell.setText(String.valueOf(value));
                }
                else{
                    cell.setText("");
                }
                
                if(!board.isCellFixed( row , col )){
                    cell.setEditable(false);
                    cell.setBackground(new Color(200,255,200));
                }
                
                ActionListener[] listeners = cell.getActionListeners();
                for( ActionListener listener : listeners){
                    cell.removeActionListener(listener);
                }
            }
        }
        
        frame.revalidate();
        frame.repaint();
    }
    
    private static void CleanBoard(){
        mainPanel.removeAll();
        for( int row = 0 ; row < SIZE ; row++ ){
            for( int col = 0 ; col < SIZE ; col++ ){
                JTextField cell = new JTextField();
                guiCells[row][col] = cell;
                cell.setText("");
            }
        }
        frame.revalidate();
        frame.repaint();
    } 
}