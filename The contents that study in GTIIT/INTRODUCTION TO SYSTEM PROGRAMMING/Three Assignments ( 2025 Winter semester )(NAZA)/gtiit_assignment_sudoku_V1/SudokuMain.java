import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Main class of the Sudoku game.
 * This is a command line version of the game.
 */
public class SudokuMain {

    /**
     * List of file paths for puzzles.
     */
    private List<String> puzzles;

    /**
     * Current Sudoku board
     */
    private SudokuBoard board;

    /**
     * Input reader for user moves
     */
    private SudokuInputReader inputReader;


    /**
     * Main method to start the Sudoku game.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        SudokuMain game = new SudokuMain();
    }

    /**
     * Starts the Sudoku game by randomly choosing a puzzle to solve.
     */
    public SudokuMain() {
        loadPuzzles();
        String selectedPuzzle = selectPuzzle();
        board = new SudokuBoard(selectedPuzzle);
        inputReader = new SudokuInputReader();
        play();
    }

    /**
     * Loads predefined puzzles into the puzzles list.
     */
    private void loadPuzzles() {
        puzzles = new ArrayList<>();
        // Add predefined puzzles
        puzzles.add("puzzle_1.txt");
        puzzles.add("puzzle_2.txt");
        puzzles.add("puzzle_3.txt");
        puzzles.add("puzzle_4.txt");
        puzzles.add("puzzle_5.txt");
    }

    /**
     * Selects a random puzzle from the puzzles list.
     * @return the file path of the selected puzzle
     */
    private String selectPuzzle() {
        Random random = new Random();
        int index = random.nextInt(puzzles.size());
        return puzzles.get(index);
    }


    /**
     * Main game loop that handles user input and game progression.
     */
    private void play() {
        boolean gameFinished = false;
        while (!gameFinished) {
            System.out.println(board.toString());
            System.out.println("Enter your move (row, column, value) or 'q' to quit:");
            inputReader.readInput();
            if (inputReader.userWantsToQuit()) {
                System.out.println("Thanks for playing!");
                gameFinished = true;
            }
            else {
                int row = inputReader.getRowInput();
                int col = inputReader.getColInput();
                int value = inputReader.getValueInput();
                if (!board.isCellFixed(row, col) && value >= 1 && value <= 9) {
                    board.setCellValue(row, col, value);
                    if (board.isSolved()) {
                        System.out.println(board.toString());
                        System.out.println("Congratulations! You've solved the puzzle!");
                        gameFinished = true;
                    }
                }
                else {
                    System.out.println("Invalid move. Try again.");
                }
            }
        }
    }

}
