package TicTacToe2;

public class TicTacToe2 
{
    public static void main(String[] args) 
    {
        //Getting board size from user
        userInputInteractions userInput = new userInputInteractions();
        userInput.getPlayerCount();
        int playerCount = userInput.accessPlayerCount();

        //Create board
        int boardSize = playerCount + 1;
        Board board = new Board();
        board.createBoard(boardSize);
        board.printBoard();

        //Get character for each player
        userInput.getPlayerSymbols(playerCount);

        //Get amount for a win
        userInput.getWinCount();

        board.printBoard();


        //game loop
        boolean winner = false;
        boolean draw = false;
        int winnerPlayerNum = 0;
        while (winner == false && draw == false)
        {
            for (int i = 0; i < playerCount; i++)
            {
                winnerPlayerNum = i;
                userInput.playerTurn(board, userInput.accessPlayerSymbol(i));
                if (gameLogic.rowsWinCheck(board, userInput.accessPlayerSymbol(i), userInput.accessWinAmount()))
                {
                    winner = true;
                    break;
                }
                else if (gameLogic.columnsWinCheck(board, userInput.accessPlayerSymbol(i), userInput.accessWinAmount()))
                {
                    winner = true;
                    break;
                }
                else if (gameLogic.leftTopDiagonalsWinCheck(board, userInput.accessPlayerSymbol(i), userInput.accessWinAmount()))
                {
                    winner = true;
                    break;
                }
                else if (gameLogic.rightTopDiagonalsWinCheck(board, userInput.accessPlayerSymbol(i), userInput.accessWinAmount()))
                {
                    winner = true;
                    break;
                }
                else if(userInput.drawCheck())
                {
                    draw = true;
                    break;
                }
                board.printBoard();
            }
        }
        board.printBoard();

        //win conditions
        if (winner == true)
        {
            System.out.println("Congratulations to player " + userInput.accessPlayerSymbol(winnerPlayerNum) + " you win!!!");
        }
        else if (draw == true)
        {
            System.out.println("This game ends in a draw");
        }
        
        userInput.closeScanner();
    }
}

