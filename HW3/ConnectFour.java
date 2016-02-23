import java.util.Scanner;
import java.util.Random;

/**
 * This file contains the logic for playing a connect four game
 * either against another player or a random agent, depending on
 * the given command line args.
 *
 * I worked on the homework assignment with Ying Ying Choi,
 * stackoverflow.com, and Java Documentation.
 *
 * @author Sujeeth Jinesh
 *
 */

public class ConnectFour {

    /*
     * Static variables to use throughout printBoard()
     * and the main method. You MUST use "X" and "O",
     * so you might as well use TOKEN1 and TOKEN2 variables!
     */
    private static final int GAME_WIDTH = 7;
    private static final int GAME_HEIGHT = 6;
    private static final String TOKEN1 = "X";
    private static final String TOKEN2 = "O";
    private static Scanner scanner = new Scanner(System.in);
    private static String dash = "-------------------------------\n";
    private static String numbers = "   1   2   3   4   5   6   7  ";
    private static String currentPlayer = "Player 1";
    private static String currentToken = TOKEN1;

    /**
     * Alter this variable when making changes to your
     * connect four board!!
     */
    private static String[][] board = new String[GAME_HEIGHT][GAME_WIDTH];

    /**
     * This enumeration is used as outcomes for findWinner().
     *
     * Read the pdf for a complete description. Think of how
     * GameStatus.QUIT might help you in your game functionality!
     */
    private enum GameStatus {
        ONE, TWO, TIE, ONGOING, QUIT
    }

    public static void main(String[] args) {
        int arg = 0;

        if (args.length > 0) {
            arg = Integer.parseInt(args[0]);
        }

        switch (arg) {
        case 1:
            System.out.println("Welcome to 1-player mode of Connect Four!\n"
                    + "Choose where to go by entering the slot number.\n"
                    + "Type ’q’ if you would like to quit.\n");
            onePlayer();
            break;
        case 2:
            System.out.println("Welcome to 2-player mode of Connect Four!\n"
                    + "Choose where to go by entering the slot number.\n"
                    + "Type ’q’ if you would like to quit.\n");
            twoPlayer();
            break;
        default:
            System.out.println("Would you like to play single player"
                    + "or two player mode? (Enter 1 or 2)");
            int userChoice = scanner.nextInt();
            if (userChoice == 2) {
                System.out.println("Welcome to 2-player mode of Connect Four!\n"
                        + "Choose where to go by entering the slot number.\n"
                        + "Type ’q’ if you would like to quit.\n");
                twoPlayer();
            } else if (userChoice == 1) {
                System.out.println("Welcome to 1-player mode of Connect Four!\n"
                        + "Choose where to go by entering the slot number.\n"
                        + "Type ’q’ if you would like to quit.\n");
                onePlayer();
            }
            break;
        }
    }

    public static void twoPlayer() {
        char firstPlayerInput = 'a';
        currentToken = TOKEN1;

        do {
            printBoard();
            System.out.println(currentPlayer + ", where would you like to go?");
            firstPlayerInput = scanner.next().charAt(0);

            if (firstPlayerInput == 'q') {
                System.out.println("Goodbye!");
            } else if (isColumnFull(
                    Integer.parseInt(String.valueOf(firstPlayerInput)))) {
                System.out.println("That column is full. Please pick another!");
            } else {
                addColumn(currentToken,
                        Integer.parseInt(String.valueOf(firstPlayerInput)));
                if (findWinner() == GameStatus.ONE) {
                    printBoard();
                    System.out.println("Woohoo! Player 1 won!");
                } else if (findWinner() == GameStatus.TWO) {
                    printBoard();
                    System.out.println("Woohoo! Player 2 won!");
                } else if (findWinner() == GameStatus.TIE) {
                    printBoard();
                    System.out.println("There was a tie");
                }
                currentPlayer = getNextPlayer(currentPlayer);
                currentToken = getNextToken(currentToken);
            }
        } while (findWinner() == GameStatus.ONGOING && firstPlayerInput != 'q');
    }

    public static void onePlayer() {
        char firstPlayerInput = 'a';
        int playerInput;

        do {
            if (currentPlayer.equals("Player 1")) {
                printBoard();
                System.out.println(currentPlayer
                        + ", where would you like to go?");
                firstPlayerInput = scanner.next().charAt(0);

                if (firstPlayerInput == 'q') {
                    System.out.println("Goodbye!");
                } else if (isColumnFull(Integer.parseInt(
                        String.valueOf(firstPlayerInput)))) {
                    System.out.println("That column is full. "
                            + "Please pick another!");
                } else {
                    addColumn(currentToken,
                            Integer.parseInt(String.valueOf(firstPlayerInput)));
                    if (findWinner() == GameStatus.ONE) {
                        printBoard();
                        System.out.println("Woohoo! Player 1 won!");
                    } else if (findWinner() == GameStatus.TWO) {
                        printBoard();
                        System.out.println("Woohoo! Player 2 won!");
                    } else if (findWinner() == GameStatus.TIE) {
                        printBoard();
                        System.out.println("There was a tie");
                    }
                    currentPlayer = getNextPlayer(currentPlayer);
                    currentToken = getNextToken(currentToken);
                }
            } else {
                Random rand = new Random();

                playerInput = rand.nextInt(7) + 1;

                if (!isColumnFull(playerInput)) {
                    addColumn(currentToken, playerInput);
                    if (findWinner() == GameStatus.ONE) {
                        printBoard();
                        System.out.println("Woohoo! Player 1 won!");
                    } else if (findWinner() == GameStatus.TWO) {
                        printBoard();
                        System.out.println("Woohoo! Player 2 won!");
                    } else if (findWinner() == GameStatus.TIE) {
                        printBoard();
                        System.out.println("There was a tie");
                    }
                    currentPlayer = getNextPlayer(currentPlayer);
                    currentToken = getNextToken(currentToken);
                }
            }
        } while (findWinner() == GameStatus.ONGOING && firstPlayerInput != 'q');
    }

    public static String getNextPlayer(String currentPlayer) {

        if (currentPlayer.equals("Player 1")) {
            currentPlayer = "Player 2";
        } else if (currentPlayer.equals("Player 2")) {
            currentPlayer = "Player 1";
        }
        return currentPlayer;
    }

    public static String getNextToken(String currentToken) {

        if (currentToken.equals(TOKEN1)) {
            currentToken = TOKEN2;
        } else if (currentToken.equals(TOKEN2)) {
            currentToken = TOKEN1;
        }
        return currentToken;
    }

    /**
     * Adds a token to the column inputted.
     *
     * @return void
     **/
    private static void addColumn(String currentToken, int columnNumber) {

        int row = 0;

        columnNumber = columnNumber - 1;

        while (row < board.length) {
            if (board[row][columnNumber] == null) {
                board[row][columnNumber] = currentToken;
                return;
            }
            row++;
        }
    }

    /**
     * Checks if the column inputted is full.
     *
     * @return boolean
     **/
    private static boolean isColumnFull(int columnNumber) {

        for (int row = 0; row < GAME_HEIGHT; row++) {
            if (board[row][columnNumber - 1] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Prints the current state of the board array.
     *
     * @return void
     **/
    private static void printBoard() {

        String row = " |  |  |  |  |  |  |  | ";
        String tempRow = " |  |  |  |  |  |  |  | ";

        for (int i = GAME_HEIGHT - 1; i >= 0; i--) {
            for (int j = 0; j < GAME_WIDTH; j++) {
                if (board[i][j] != null) {
                    tempRow = row.substring(0, 3) + board[i][j];
                    System.out.print(tempRow);
                } else {
                    tempRow = row.substring(0, 4) + "";
                    System.out.print(tempRow);
                }
            }
            System.out.println(row.substring(0, 4));
            tempRow = row;
        }

        System.out.print(dash);
        System.out.println(numbers);
    }

    /**
     * Determines what the current result of the game is
     * given the current state of the board.
     *
     * @return GameStatus enumeration value that determines
     * if player one has won, player two has won, a tie exists,
     * or there is no result yet.
     */
    private static GameStatus findWinner() {
        if (isColumnVictory(TOKEN1) || isRowVictory(TOKEN1)
                || isTopLeftDiagonalVictory(TOKEN1)
                || isTopRightDiagonalVictory(TOKEN1)) {
            return GameStatus.ONE;
        } else if (isColumnVictory(TOKEN2) || isRowVictory(TOKEN2)
                || isTopLeftDiagonalVictory(TOKEN2)
                || isTopRightDiagonalVictory(TOKEN2)) {
            return GameStatus.TWO;
        } else if (isBoardFull()) {
            return GameStatus.TIE;
        } else {
            return GameStatus.ONGOING;
        }
    }

    /*
     * ~~~~~~YOU SHOULD NOT BE CALLING METHODS BELOW THIS POINT~~~~~
     */

    /**
     * Determines whether or not the board has any moves
     * remaining.
     *
     * @return true or false
     */
    private static boolean isBoardFull() {
        for (int col = 0; col < GAME_WIDTH; col++) {
            for (int row = 0; row < GAME_HEIGHT; row++) {
                if (board[row][col] == null || board[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in columns.
     *
     * @return true or false
     */
    private static boolean isColumnVictory(String token) {
        for (int col = 0; col < GAME_WIDTH; col++) {
            int count = 0;
            for (int row = 0; row < GAME_HEIGHT; row++) {
                if (board[row][col] != null) {
                    if (board[row][col].equals(token)) {
                        count++;
                    } else {
                        count = 0;
                    }
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in rows.
     *
     * @return true or false
     */
    private static boolean isRowVictory(String token) {
        for (int row = 0; row < GAME_HEIGHT; row++) {
            int count = 0;
            for (int col = 0; col < GAME_WIDTH; col++) {
                if (board[row][col] != null) {
                    if (board[row][col].equals(token)) {
                        count++;
                    } else {
                        count = 0;
                    }
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in top to left diagonals.
     *
     * @return true or false
     */
    private static boolean isTopLeftDiagonalVictory(String token) {
        for (int row = 0; row < GAME_HEIGHT; row++) {
            for (int col = 0; col < GAME_WIDTH; col++) {
                int count = 0;
                for (int delta = 0; delta < 5; delta++) {
                    if (withinBounds(row + delta, col + delta)
                            && board[row + delta][col + delta] != null) {
                        if (board[row + delta][col + delta].equals(token)) {
                            count++;
                        } else {
                            count = 0;
                        }
                    } else {
                        count = 0;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in top to right diagonals.
     *
     * @return true or false
     */
    private static boolean isTopRightDiagonalVictory(String token) {
        for (int row = 0; row < GAME_HEIGHT; row++) {
            for (int col = GAME_WIDTH - 1; col >= 0; col--) {
                int count = 0;
                for (int delta = 0; delta < 5; delta++) {
                    if (withinBounds(row + delta, col - delta)
                            && board[row + delta][col - delta] != null) {
                        if (board[row + delta][col - delta].equals(token)) {
                            count++;
                        } else {
                            count = 0;
                        }
                    } else {
                        count = 0;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Small bounds checker helper method.
     */
    private static boolean withinBounds(int row, int col) {
        return (row < GAME_HEIGHT && row >= 0)
                && (col < GAME_WIDTH && col >= 0);
    }
}
