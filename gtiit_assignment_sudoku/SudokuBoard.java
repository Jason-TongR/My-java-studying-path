 

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
    private List<List<SudokuCell>> board;

    /**
     * Constructor of the SudokuBoard class. Loads a Sudoku board from a file.
     *
     * @param contents   the name of the file containing the Sudoku board data. Each line has 9 digits (0-9), where 0 represents an empty cell.
     */
    public SudokuBoard(String contents) {
        board = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(contents))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < SIZE) {
                String digits = line.replaceAll("[^0-9]", "");
                if (digits.length() != SIZE) {
                    assert false: "Row " + (row) + " invalid: expecting 9 digits.";
                }
                List<SudokuCell> rowList = new ArrayList<>();
                for (int col = 0; col < SIZE; col++) {
                    int val = Character.getNumericValue(digits.charAt(col));
                    if (val < 0 || val > 9) {
                        assert false: "Invalid value in row " + (row) + ", column " + (col);
                    }
                    rowList.add(new SudokuCell(val, val != 0));
                }
                board.add(rowList);
                row++;
            }
            if (board.size() != SIZE) {
                assert false: "File must contain exactly 9 lines with 9 digits each.";
            }
        } 
        catch (IOException e) {
            assert false: "File could not be opened: " + contents;
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
        assert !board.get(row).get(col).isFixed(): "Cannot change the value of a fixed cell.";
        assert !containsInRow(row, value) : "Value already exists in the same row.";
        assert !containsInColumn(col, value) : "Value already exists in the same column.";
        assert !containsInBox(row, col, value) : "Value already exists in the same 3x3 box.";
        SudokuCell cell = board.get(row).get(col);
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
            if (board.get(row).get(col).getValue() == value) {
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
            if (board.get(row).get(col).getValue() == value) {
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
        assert ( (value >= 1) && (value <= 9) ) : "value must in the range";
        assert ( (row >= 0) && (row < SIZE) ) : "row must in the range";
        assert ( (col >= 0) && (col < SIZE) ) : "col must in the range";
        for( int row_current = 0 ; row_current <= 6 ; row_current += 3 ){
            for( int col_current = 0 ; col_current <= 6 ; col_current += 3 ){
                if ( (row >= row_current && row <= (row_current + 2) ) && (col >= col_current && col <= (col_current + 2) ) ){
                    for( int i = row_current ; i <= row_current + 2 ; i++){
                        for( int j = col_current ; j <= col_current + 2 ; j++){
                            if ( board.get(row).get(col).getValue() == value)
                                return true;
                        }
                    }
                }
            }
        }
        return false;
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
        return board.get(row).get(col).isFixed();
    }

    /**
     * Checks if the Sudoku board is completely and correctly solved.
     *
     * @return true if the board is solved, false otherwise
     */
    public boolean isSolved() {
        boolean every_row_ok;
        boolean every_col_ok;
        boolean every_block_ok;
        for( int row_current = 0 ; row_current <= SIZE - 1 ; row_current++ ){           //this for loop is to check wether each row is ok.
            int[] appear = new int[9];      //this array is to record the appear times for "1 - 9" 
            for( int col_current = 0 ; col_current <= SIZE - 1 ; col_current++ ){
                if( board.get(row_current).get(col_current).getValue() == 0 )
                    return false;
                else{
                    for( int i = 1 ; i <= 9 ; i++ ){
                        if ( board.get(row_current).get(col_current).getValue() == i )
                            appear[i-1]++;
                    }
                }
            }
            for( int k = 0 ; k <= 8 ; k++ ){
                if( appear[k] != 1 )
                    return false;
            }
        }
        every_row_ok = true;
        
        for( int col_current = 0 ; col_current <= SIZE - 1 ; col_current++ ){       //this for loop is to check every column is ok.
            int[] appear = new int[9];      //this array is to record the appear times of "1 - 9"
            for( int row_current = 0 ; row_current <= SIZE - 1 ; row_current++ ){
                if( board.get(col_current).get(row_current).getValue() == 0 )
                    return false;
                else{
                    for( int i = 1 ; i <= 9 ; i++ ){
                        if( board.get(col_current).get(row_current).getValue() == i )
                            appear[i-1]++;
                    }
                }
            }
            for( int k = 0 ; k <= 8 ; k++ ){
                if( appear[k] != 1)
                    return false;
            }
        }
        every_col_ok = true;
        
        for( int block_row_boundary = 0 ; block_row_boundary <= 6 ; block_row_boundary += 3 ){  //this for loop is to check that every 3*3 block is ok.
            for( int block_col_boundary = 0 ; block_col_boundary <= 6 ; block_col_boundary += 3 ){
                int appear[] = new int[9];          //this array is to record the appear times of "1 - 9".
                for( int row = block_row_boundary ; row <= block_row_boundary + 2 ; row++ ){
                    for( int col = block_col_boundary ; col <= block_col_boundary + 2 ; col++ ){
                        if( board.get(row).get(col).getValue() == 0 )
                            return false;
                        else{
                            for( int i = 1 ; i <= 9 ; i++ ){
                                if( board.get(row).get(col).getValue() == i)
                                    appear[i-1]++;
                                }
                        }
                    }
                }
                for( int k = 0 ; k <= 8 ; k++ ){
                if( appear[k] != 1)
                    return false;
                }
            }
        }
        every_block_ok = true;
        
        
        if( every_row_ok == true && every_col_ok == true && every_block_ok == true){
            return true;
        }
        return false;
    }

    /**
     * Sets the value of a cell.
     * Precondition: the board is not in edit mode
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
        SudokuCell cell = board.get(row).get(col);
        assert !cell.isFixed(): "Cannot change the value of a fixed cell.";
        cell.setValue(value);
    }

    /**
     * Returns a string representation of the Sudoku board, e.g.,
     *  _   _  [4] [3]  _   _  [2]  _   _  
     *  _   _  [2] [6]  _   _   _  [8]  _  
     *  _  [6] [8] [3]  _   _   _   _  [7] 
     *  _   _  [3]  _   _  [1]  _   _  [5] 
     *  _  [5] [9]  _  [6]  _   _  [7] [2] 
     *  _   _   _  [5] [2]  _   _  [4] [6] 
     * [2]  _  [5] [9]  _  [6]  _   _   _  
     *  _   _   _  [4]  _  [8]  _  [5]  _  
     *  _   _   _   _   _  [7]  _   _  [4]
     * should be the output for puzzle_1.txt
     *
     * @return a string representation of the board
     */
    public String toString() {
        for( int row = 0 ; row <= SIZE - 1 ; row++ ){
            for( int col = 0 ; col <= SIZE - 1 ; col++ ){
                System.out.print(board.get(row).get(col).toString());
            }
            System.out.print("\n");
        }
        return "no board printing yet implemented!";
    }

}
