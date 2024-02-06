package TicTacToe2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class userInputInteractions 
{
    //private variables
    private Scanner scanner = new Scanner(System.in);
    private int playerCount;
    private int winCount;
    private char[] players;
    private int moveCount = 0;
    
    //gets player count
    public int getPlayerCount()
    {
        boolean validUserInput = false;
        while(validUserInput == false)
        {
            try
            {
                System.out.print("How many players will be playing (3-10): ");
                playerCount = scanner.nextInt();
                validUserInput = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input");
                scanner.next();
                continue;
            }
            if (playerCount < 3 || playerCount > 10)
            {
                System.out.println("Input is not between 3 and 10");
            }
            else
            {
                validUserInput = true;
            }
        }
        return playerCount;
    }

    //gets symbol player wants to represent themselves with
    public char[] getPlayerSymbols(int playerCount)
    {
        boolean validUserInput = false;
        char symbol = ' ';
        players = new char[playerCount];
        for (int player = 0; player < playerCount; player++)
        {
            validUserInput = false;
            while(validUserInput == false)
            {
                try
                {
                    System.out.print("What character would you like to represent you player " + (player + 1) + ':');
                    symbol = scanner.next().charAt(0);
                    validUserInput = false;
                }
                catch(InputMismatchException ex)
                {
                    System.out.println("Invalid input");
                    scanner.next();
                }
                if (Character.isLetter(symbol) && !(symbolCheck(players, symbol)))
                {
                    players[player] = symbol;
                    validUserInput = true;
                }
                else if (symbolCheck(players, symbol))
                {
                    System.out.println("That symbol is already taken");
                }
                else
                {
                    System.out.println("Invalid Symbol");
                }
            }
        }
        scanner.nextLine();
        return players;
    }

    //Checks if there are multiple symbols
    //if there are multiple symbols returns true else false
    private boolean symbolCheck(char[] symbols, char symbol)
    {
        for (int i = 0; i < symbols.length; i++)
        { 
            if (symbol == symbols[i])
            {
                return true;
            }
        }
        return false;
    }

    //gets user input for winAmount
    public int getWinCount()
    {
        boolean validUserInput = false;
        while(validUserInput == false)
        {
            try
            {
                System.out.print("How many pieces in a row counts as a win (3-" + (playerCount + 1) + "): ");
                winCount = scanner.nextInt();
                validUserInput = false;
            }
            catch(InputMismatchException ex)
            {
                System.out.println("Invalid input");
                scanner.next();
                continue;
            }
            if (winCount < 3 || winCount > (playerCount + 1))
            {
                System.out.print("Input is not between 3 and " + (playerCount + 1));
                System.out.println();
            }
            else
            {
                validUserInput = true;
            }
        }
        return winCount;
    }

    //A players move will go depending on symbol
    public void playerTurn(Board board, char symbol)
    {
        boolean validUserInput = false;
        boolean validMove = false;
        int row = 0;
        int column = 0;
        
        //Gets user input for row
        while(validMove == false)
        {
            while(validUserInput == false)
            {
                try
                {
                    System.out.print("Player " + symbol + " input row: ");
                    row = scanner.nextInt();
                }
                catch(InputMismatchException ex)
                {
                    board.printBoard();
                    System.out.println("Invalid input");
                    scanner.nextLine();
                    continue;
                }
                if (row <= playerCount && row >= 0)
                {
                    validUserInput = true;
                }
                else
                {
                    board.printBoard();
                    System.out.println("row input was either too big or small");
                }
            }

            //gets user input for column
            validUserInput = false;
            while(validUserInput == false)
            {
                try
                {
                    System.out.print("Player " + symbol + " input column: ");
                    column = scanner.nextInt();
                }
                catch(InputMismatchException ex)
                {
                    board.printBoard();
                    System.out.println("Invalid input");
                    scanner.nextLine();
                    continue;
                }
                //update board and validate their move
                if (column <= playerCount && column >= 0 && validatePlayerTurn(board, row, column))
                {
                    board.updateBoard(row, column, symbol);
                    System.out.println("player " + symbol + " entered " + row + ", " + column);
                    validUserInput = true;
                    validMove = true;
                }
                else if (!(column <= playerCount && column >= 0))
                {
                    board.printBoard();
                    System.out.println("Column input was either too big or small");
                }
                else if (!validatePlayerTurn(board, row, column))
                {
                    board.printBoard();
                    System.out.println("That position was already taken");
                    break;
                }
            }   
        }
        moveCount++;
    }

    //checks if that coordinate is already taken
    public boolean validatePlayerTurn(Board board, int row, int column)
    {
        //Checks if those coordinates are empty
        if (board.accessBoardSymbol(row, column) == ' ')
        {
            return true; 
        }
        else
        {
            return false;
        }
    }

    //checks if a darw has occured
    public boolean drawCheck()
    {
        if (moveCount == (playerCount + 1) * (playerCount + 1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //playerCount accessor
    public int accessPlayerCount()
    {
        return playerCount;
    }

    //winAmount accessor
    public int accessWinAmount()
    {
        return winCount;
    }

    //Player symbol accessor
    public char accessPlayerSymbol(int index)
    {
        return players[index];
    }

    //closes scanner
    public void closeScanner()
    {
        scanner.close();
    }
}
