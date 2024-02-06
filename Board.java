package TicTacToe2;

public class Board 
{
    /* | 0 | 1 | 2 | 3 |
    --------------------
     0 |   |   |   |   |
    --------------------
     1 |   |   |   |   |
    --------------------
     2 |   |   |   |   |
    --------------------
     3 |   |   |   |   |
    --------------------
 */
    //private variables
    private char[][] board;
    private int boardSize;

    //Sets up an empty board for player to play
    public void createBoard(int size)
    {
        boardSize = size;
        board = new char[boardSize][boardSize];
        // Initialize board
        for (int i = 0; i < boardSize; i++) 
        {
            for (int j = 0; j < boardSize; j++) 
            {
                board[i][j] = ' ';
            }
        }
    }

    //Updates the board with the coordinates given with given symbol
    public void updateBoard(int row, int column, char symbol)
    {
        board[row][column] = symbol;
    }
    
    //print out the board
    public void printBoard()
    {
        //Column setup
        System.out.print("  ");
        for (int i = 0; i < boardSize; i++)
        {
            System.out.print("| " + i + " ");
        }
        System.out.print("|");
        System.out.println();

        //Row setup
        for (int i = 0; i < boardSize; i++)
        {
            System.out.print("---");
            for (int j = 0; j < boardSize; j++)
            {
                System.out.print("----");
            }
            System.out.println();
            System.out.print(i);

            for (int j = 0; j < boardSize; j++)
            {
                System.out.print(" | " + board[i][j]);
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("\n");
    }

    //symbol accessor
    public Character accessBoardSymbol(Integer row, Integer  column)
    {
        return board[row][column];
    }

    //board size accessor
    public int accessBoardSize()
    {
        return boardSize;
    }
}
