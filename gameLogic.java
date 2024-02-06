package TicTacToe2;

public class gameLogic {

    //checks each row to see if a player has the amount to win
    public static boolean rowsWinCheck(Board board, char symbol, int winAmount)
    {
        //row
        for (int i = 0; i < board.accessBoardSize(); i++)
        {
            int winCheck = 0;
            //column
            for (int j = 0; j < board.accessBoardSize(); j++)
            {
                if (board.accessBoardSymbol(i, j) == symbol)
                {
                    winCheck++;
                    if (winCheck >= winAmount)
                    {
                        return true;
                    }
                }
                else
                {
                    winCheck = 0;
                }
            }
        }
        return false;
    }

    //checks each column to see if a player has the amount to win
    public static boolean columnsWinCheck(Board board, char symbol, int winAmount)
    {
        //row
        for (int i = 0; i < board.accessBoardSize(); i++)
        {
            int winCheck = 0;
            //column
            for (int j = 0; j < board.accessBoardSize(); j++)
            {
                if (board.accessBoardSymbol(j, i) == symbol)
                {
                    winCheck++;
                    if (winCheck >= winAmount)
                    {
                        return true;
                    }
                }
                else
                {
                    winCheck = 0;
                }
            }
        }
        return false;
    }

    //checks the top left diagonals to see if a player has the amount to win
    public static boolean leftTopDiagonalsWinCheck(Board board, char symbol, int winAmount)
    {
        int leftTemp = 0;
        for (int i = 0; i < board.accessBoardSize() - winAmount + 1; i++)
        {
            int winCheck = 0;
            int winCheck2 = 0;
            Integer leftTemp2 = Integer.valueOf(leftTemp);
            for (int j = 0; j < board.accessBoardSize() - leftTemp; j++)
            {
                if (board.accessBoardSymbol(j, leftTemp2).equals(symbol))
                {
                    winCheck++;
                    if (winCheck >= winAmount)
                    {
                        return true;
                    }
                }
                else if (board.accessBoardSymbol(leftTemp2, j).equals(symbol))
                {
                    winCheck2++;
                    if (winCheck2 >= winAmount)
                    {
                        return true;
                    }
                }
                else
                {
                    winCheck = 0;
                    winCheck2 = 0;
                }
                leftTemp2++;
            }
            leftTemp++;
            winCheck = 0;
            winCheck2 = 0;
        }
        return false;
    }

    //checks the top right diagonals to see if a playerhas the amount to win
    public static boolean rightTopDiagonalsWinCheck(Board board, char symbol, int winAmount)
    {
        int rightTemp = 0;
        for (int i = 0; i < board.accessBoardSize() - winAmount + 1; i++)
        {
            //checks the diagonals starting from top right side
            int winCheck = 0;
            int rightTemp2 = 0;
            Integer rightTemp3 = Integer.valueOf(rightTemp) + 1;
            for (int j = board.accessBoardSize() - 1 - rightTemp; j >= 0; j--)
            {
                if (board.accessBoardSymbol(j, rightTemp2).equals(symbol))
                {
                    winCheck++;
                    if (winCheck >= winAmount)
                    {
                        return true;
                    }
                }
                else
                {
                    winCheck = 0;
                }
                rightTemp2++;
            }
            winCheck = 0;

            for (int j = board.accessBoardSize() - 1; j > rightTemp; j--)
            {
                if (board.accessBoardSymbol(j, rightTemp3).equals(symbol))
                {
                    winCheck++;
                    if (winCheck >= winAmount)
                    {
                        return true;
                    }
                }
                else
                {
                    winCheck = 0;
                }
                rightTemp3++;
            }
            rightTemp++;
            winCheck = 0;
        }
        return false;
    }
}
