import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a Sudoku board.
 */
public class SudokuBoard {
    
    /**
     * The size of the Sudoku board (9x9)
     */
    public static final int SIZE = 9;

    /**
     * The 9x9 grid of Sudoku cells
     */
    private SudokuCell[][] board;

    /**
     * Strategy for toString representation
     */
    private ToStringStrategy toStringStrategy;

    /**
     * Constructor of the SudokuBoard class. Loads a Sudoku board from a file.
     *
     * @param contents   the name of the file containing the Sudoku board data. Each line has 9 digits (0-9), where 0 represents an empty cell.
     */
    public SudokuBoard(String contents) {
        setDefaultToStringStrategy();
        board = new SudokuCell[SIZE][SIZE];
        try (BufferedReader br = new BufferedReader(new FileReader(contents))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < SIZE) {
                String digits = line.replaceAll("[^0-9]", "");
                if (digits.length() != SIZE) {
                    throw new IllegalArgumentException("Row " + (row) + " invalid: expecting 9 digits.");
                }
                
                SudokuCell[] rowList = new SudokuCell[SIZE];
                
                for (int col = 0; col < SIZE; col++) {
                    int val = Character.getNumericValue(digits.charAt(col));
                    if (val < 0 || val > 9) {
                        throw new IllegalArgumentException("Invalid value in row " + (row) + ", column " + (col));
                    }
                    rowList[col] = new SudokuCell(val , val != 0);
                }
                
                for( int position = 0 ; position < SIZE ; position++){
                    board[row][position] = rowList[position];
                }
                row++;
            }
            if ( row != SIZE) {
                throw new IllegalArgumentException("File must contain exactly 9 lines with 9 digits each.");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File could not be opened: " + contents, e);
        }
    }

    /**
     * Copy constructor of the SudokuBoard class.
     *
     * @param board the SudokuBoard to copy
     */
    public SudokuBoard(SudokuBoard board) {
        this.board = new SudokuCell[SIZE][SIZE];
        
        this.toStringStrategy = board.toStringStrategy;
        
        for( int row = 0 ; row < SIZE ; row++ ){
            for( int col = 0 ; col < SIZE ; col++ ){
                SudokuCell old_cell = board.board[row][col];
                int value = old_cell.getValue();
                boolean state = old_cell.isFixed();
                this.board[row][col] = new SudokuCell( value , state );
            }
        }
    }

    /**
     * Sets the value of a cell and marks it as fixed.
     * Precondition: row and col are between 0 and 8 inclusive
     * Precondition: value is between 1 and 9 inclusive
     * Precondition: the cell at (row, col) is not already fixed
     * Precondition: the value does not already exist in the same row, column, or 3x3 box
     *
     * @param row   the row index of the cell
     * @param col   the column index of the cell
     * @param value the value to set in the cell
     */
    public void setFixedCellValue(int row, int col, int value) {
        assert row >= 0 && row < SIZE : "Row index out of bounds.";
        assert col >= 0 && col < SIZE : "Column index out of bounds.";
        assert value >= 1 && value <= 9 : "Value out of range.";
        assert !board[row][col].isFixed(): "Cannot change the value of a fixed cell.";
        assert !containsInRow(row, value) : "Value already exists in the same row.";
        assert !containsInColumn(col, value) : "Value already exists in the same column.";
        assert !containsInBox(row, col, value) : "Value already exists in the same 3x3 box.";
        SudokuCell cell = board[row][col];
        cell.setValue(value);
        cell.makeFixed();
    }

    /**
     * Checks if a value exists in a specific row.
     *
     * @param row   the row index to check
     * @param value the value to look for
     * @return true if the value exists in the row, false otherwise
     */
    public boolean containsInRow(int row, int value) {
        assert row >= 0 && row < SIZE : "Row index out of bounds.";
        assert value >= 1 && value <= 9 : "Value out of range.";
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col].getValue() == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a value exists in a specific column.
     *
     * @param col   the column index to check
     * @param value the value to look for
     * @return true if the value exists in the column, false otherwise
     */
    public boolean containsInColumn(int col, int value) {
        assert col >= 0 && col < SIZE : "Column index out of bounds.";
        assert value >= 1 && value <= 9 : "Value out of range.";
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col].getValue() == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a value exists in the 3x3 box containing the specified cell.
     *
     * @param row   the row index of the cell
     * @param col   the column index of the cell
     * @param value the value to look for
     * @return true if the value exists in the 3x3 box, false otherwise
     */
    public boolean containsInBox(int row, int col, int value) {
        assert row >= 0 && row < SIZE : "row must in the range";
        assert col >= 0 && col < SIZE : "col must in the range";
        assert value >= 1 && value <= 9 : "value must in the range";

        int boxStartRow = (row / 3) * 3;
        int boxStartCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxStartRow + i][boxStartCol + j].getValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a value can be placed in a specific cell without violating Sudoku rules.
     *
     * @param row   the row index of the cell
     * @param col   the column index of the cell
     * @param value the value to check
     * @return true if the value can be placed in the cell, false otherwise
     */
    public boolean isValidOption(int row, int col, int value) {
        assert row >= 0 && row < SIZE : "Row index out of bounds.";
        assert col >= 0 && col < SIZE : "Column index out of bounds.";
        assert value >= 1 && value <= 9 : "Value out of range.";
        return !containsInRow(row, value) && !containsInColumn(col, value) && !containsInBox(row, col, value);
    }

    /**
     * Checks if a cell is fixed.
     *
     * @param row   the row index of the cell
     * @param col   the column index of the cell
     * @return true if the cell is fixed, false otherwise
     */
    public boolean isCellFixed(int row, int col) {
        assert row >= 0 && row < SIZE : "Row index out of bounds.";
        assert col >= 0 && col < SIZE : "Column index out of bounds.";
        return board[row][col].isFixed();
    }

    /**
     * Checks if the Sudoku board is completely and correctly solved.
     *
     * @return true if the board is solved, false otherwise
     */
    public boolean isSolved() {
        for( int row = 0 ; row <= SIZE - 1 ; row++ ){
            if( Some_Row_ok( row ) == false )
                return false;
        }
        
        for( int col = 0 ; col <= SIZE - 1 ; col++ ){
            if( Some_Col_ok( col ) == false )
                return false;
        }
        
        for( int box_row_start = 0 ; box_row_start <= 6 ; box_row_start += 3 ){
            for( int box_col_start = 0 ; box_col_start <= 6 ; box_col_start += 3 ){
                if( Some_box_ok( box_row_start , box_col_start ) == false )
                    return false;
            }
        }
        return true;
    }
    
    
    private boolean Some_Row_ok( int row ){
        for( int col = 0 ; col <= SIZE - 1 ; col++ ){
            if( board[row][col].getValue() > 9 || board[row][col].getValue() < 1)
                return false;
        } 
        for( int number = 1 ; number <= 9 ; number++ ){
            int flat = 0;
            for( int col = 0 ; col <= SIZE - 1 && flat == 0 ; col++ ){
                if( number == board[row][col].getValue() )
                    flat = 1;
            }
            if( flat == 0)
                return false;
        }
        return true;
    }
    
    private boolean Some_Col_ok( int col ){
        for( int row = 0 ; row <= SIZE - 1 ; row++ ){
            if( board[row][col].getValue() > 9 || board[row][col].getValue() < 1)
                return false;
        }
        for( int number = 1 ; number <= 9 ; number++ ){
            int flat = 0;
            for( int row = 0 ; row <= SIZE - 1 && flat == 0 ; row++){
                if( number == board[row][col].getValue() )
                    flat = 1;
            }
            if( flat == 0 )
                return false;
        }
        return true;
    }
    
    private boolean Some_box_ok( int start_row , int start_col ){
        assert (start_row == 0 || start_row == 3 || start_row == 6) : "we just need to check this three boxes";
        assert (start_col == 0 || start_col == 3 || start_col == 6) : "we just need to check this three boxes";
        for( int row = start_row ; row < start_row + 3 ; row++ ){
            for( int col = start_col ; col < start_col + 3 ; col++ ){
                if( board[row][col].getValue() > 9 || board[row][col].getValue() < 1)
                    return false;
            }
        }
        
        for( int number = 1 ; number <= 9 ; number++){
            int flat = 0;
            for( int row = start_row ; row < start_row + 3 && flat == 0 ; row++ ){
                for( int col = start_col ; col < start_col + 3 && flat == 0 ; col++ ){
                    if( number == board[row][col].getValue() )
                        flat = 1;
                }
            }
            if( flat == 0 )
                return false;
        }
        return true;
    }

    /**
     * Attempts to solve the Sudoku board. If solvable, returns a solved SudokuBoard instance;
     * otherwise, returns null.
     *
     * @return a solved SudokuBoard instance if solvable, null otherwise
     */
    public SudokuBoard solve() { 
        SudokuBoard copy = new SudokuBoard(this);
        if( dfs( copy ) ){
            return copy;
        }
        return null;
    }
    
    private boolean dfs( SudokuBoard Board ){
        for( int row = 0 ; row < SIZE ; row ++ ){
            for( int col = 0 ; col < SIZE ; col++ ){
                if( Board.board[row][col].getValue() == 0){
                    for( int new_value = 1 ; new_value < 10 ; new_value++ ){
                        if( Board.isValidOption( row , col , new_value ) ){
                            Board.board[row][col].setValue( new_value );
                            if( dfs( Board ) ){
                                return true;
                            }
                            Board.board[row][col].setValue(0);
                        }
                    }
                    return false; //because to reach here you must out of the for loop.so there is not the new_value satisfy.
                }
            }
        }
        
        if( Board.isSolved() ){
        return true; //because all cell is full
        }
        else{
            return false;
        }
    }


    /**
     * Sets the value of a cell.
     * Precondition: row and col are between 0 and 8 inclusive
     * Precondition: value is between 1 and 9 inclusive
     * Precondition: the cell at (row, col) is not fixed
     *
     * @param row   the row index of the cell
     * @param col   the column index of the cell
     * @param value the value to set in the cell
     */
    public void setCellValue(int row, int col, int value) {
        assert row >= 0 && row < SIZE : "Row index out of bounds.";
        assert col >= 0 && col < SIZE : "Column index out of bounds.";
        assert value >= 1 && value <= 9 : "Value out of range.";
        SudokuCell cell = board[row][col];
        assert !cell.isFixed(): "Cannot change the value of a fixed cell.";
        cell.setValue(value);
    }

    /**
     * Checks if cell has valid value. A cell has a valid value
     * iff it's unset (zero) or the value is greater or equal to one, smaller or equal to 9, and
     * is not repeated in the corresponding row, column or 3x3 box.
     * @param row   the row index of the cell
     * @param col   the column index of the cell
     * @return true iff cell is unset or has valid (non-conflicting with rows, columns and boxes) value 
     * according to Sudoku rules.
     */
    public boolean validValueInCell(int row, int col) {
        assert row >= 0 && row < SIZE : "row must between 0 and 8";
        assert col >= 0 && col < SIZE : "col must between 0 and 8";
        boolean has_correct_value = false;
        boolean row_ok = false;
        boolean col_ok = false;
        boolean box_ok = false;
        if( board[row][col].getValue() >=0 && board[row][col].getValue() <= 9 ){    //check whether the value is in the range.
            has_correct_value = true;
        }
        
        if( some_value_in_row_appeartimes( row , board[row][col].getValue() ) == 1 ){   //check the value for the corresponding row is ok
            row_ok = true;
        }
        
        if( some_value_in_col_appeartimes( col , board[row][col].getValue() ) == 1 ){   //check the value for the corresponding col is ok
            col_ok = true;
        }
        
        if( some_value_in_box_appeartimes( (row / 3) * 3 , (col / 3) * 3 , board[row][col].getValue() ) == 1 ){     //check the value for is corresponding box is ok.
            box_ok = true;
        }
        
        if( has_correct_value && row_ok && col_ok && box_ok){
            return true;
        }
        
        return false;
    }
    
    private int some_value_in_row_appeartimes( int row , int value ){
        assert ( row >= 0 && row <= 8 ) : "row must in the range";
        assert ( value >=0 && value <= 9 ) : "value must in the range";
        int times = 0;
        for( int check = 0 ; check < SIZE ; check++ ){
            if( board[row][check].getValue() == value ){
                times++;
            }
        }
        return times;
    }
    
    private int some_value_in_col_appeartimes( int col , int value ){
        assert ( col >= 0 && col <= 8 ) : "col must in the range";
        assert ( value >=0 && value <= 9 ) : "value must in the range";
        int times = 0;
        for( int check = 0 ; check < SIZE ; check++ ){
            if( board[check][col].getValue() == value){
                times++;
            }
        }
        return times;
    }
    
    private int some_value_in_box_appeartimes( int Box_start_row , int Box_start_col , int value){
        assert (Box_start_row == 0 || Box_start_row == 3 || Box_start_row == 6) : "we just need to check this three boxes";
        assert (Box_start_col == 0 || Box_start_col == 3 || Box_start_col == 6) : "we just need to check this three box"; 
        int times = 0;
        for( int row = Box_start_row ; row < Box_start_row + 3 ; row++ ){
            for( int col = Box_start_col ; col < Box_start_col + 3 ; col++ ){
                if( board[row][col].getValue() == value){
                    times++;
                }
            }
        }
        return times;
    }
    
    /**
     * Sets the toString strategy to use colored output.
     */
    public void setColoredToStringStrategy() {
        toStringStrategy = new ColoredBoardToString();
    }

    /**
     * Sets the toString strategy to use default output.
     */
    public void setDefaultToStringStrategy() {
        toStringStrategy = new DefaultBoardToString();
    }

    /**
     * Returns a string representation of the Sudoku board.
     * The specific format is determined by the toString strategy in use.
     *
     * @return a string representation of the board
     */
    public String toString() {
        return toStringStrategy.toString(this);
    }

    /**
     * Strategy interface for toString representation
     */
    public interface ToStringStrategy {

        /**
         * Converts the Sudoku board to a string representation.
         * @param board the Sudoku board to convert
         * @return string representation of the board
         */
        String toString(SudokuBoard board);
    }

    /**
     * Implementation of ToStringStrategy that provides colored output.
     */
    public class ColoredBoardToString implements ToStringStrategy {

        /**
         * Converts the given SudokuBoard object to its string representation
         * with colors.
         *
         * @param sb the SudokuBoard to be converted
         * @return the string representation of the board
         */
        public String toString(SudokuBoard sb) {
            String output = "";
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    SudokuCell cell = sb.board[i][j];
                    if (!cell.isFixed()) {
                        if (validValueInCell(i, j)) {
                            output += "\u001B[34m" + cell.toString() + "\u001B[0m ";
                        } else {
                            output += "\u001B[31m" + cell.toString() + "\u001B[0m ";
                        }
                    } else {
                        output += "\u001B[30m" + cell.toString() + "\u001B[0m ";
                    }
                }
                output += "\n";
            }
            return output;
        }

    }

    /**
     * Default implementation of ToStringStrategy without colors.
     */
    public class DefaultBoardToString implements ToStringStrategy {

        /**
         * Converts the given SudokuBoard object to its string representation.
         *
         * @param sb the SudokuBoard to be converted
         * @return the string representation of the board
         */
        public String toString(SudokuBoard sb) {
            String output = "";
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    SudokuCell cell = sb.board[i][j];
                    output += cell.toString() + " ";
                }
                output += "\n";
            }
            return output;
        }

    }

}