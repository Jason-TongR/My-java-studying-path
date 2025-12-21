

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class containing tests of the SudokuBoard class.
 *
 * @author  Nazareno Aguirre
 * @version 0.1
 */
public class SudokuBoardTest {
    
    /**
     * Tests that the board:
     * 034678912
     * 672195348
     * 198042567
     * 859761423
     * 426853791
     * 713924856
     * 961537204
     * 280419635
     * 345286079
     * is solvable. 
     */
    @Test
    public void testSolvableBoard() {
        SudokuBoard board = new SudokuBoard("solvable_puzzle_2.txt");
        SudokuBoard solvedBoard = board.solve();
        assertNotNull(solvedBoard);
        assertTrue(solvedBoard.isSolved());
    }
    
    /**
     * Tests that the board:
     * 034678912
     * 672195348
     * 198042567
     * 859761423
     * 426853791
     * 713924856
     * 961537204
     * 280419635
     * 345286079
     * becomes unsolvable if we set coordinate (8, 6) with 9 (repeated value in row).
     */
    @Test
    public void testUnsolvableBoard() {
        SudokuBoard board = new SudokuBoard("solvable_puzzle_2.txt");
        board.setCellValue(8, 6, 9);
        SudokuBoard solvedBoard = board.solve();
        assertNull(solvedBoard);
    }
    
    /**
     * Tests in the board:
     * 034678912
     * 672195348
     * 198042567
     * 859761423
     * 426853791
     * 713924856
     * 961537204
     * 280419635
     * 345286079
     */
    @Test
    public void testcontainsInBox(){
        SudokuBoard board = new SudokuBoard("solvable_puzzle_2.txt");
        boolean result = board.containsInBox(0,1,3);
        assertTrue(result);
    }
    
    /**
     * Tests in the board:
     * 034678912
     * 672195348
     * 198042567
     * 859761423
     * 426853791
     * 713924856
     * 961537204
     * 280419635
     * 345286079
     */
    @Test
    public void testisSolved(){
        SudokuBoard board = new SudokuBoard("solvable_puzzle_2.txt");
        boolean result = board.isSolved();
        assertFalse(result);
    }
    
}