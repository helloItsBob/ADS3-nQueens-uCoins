import nQueens.ChessBoard;
import nQueens.Queens;
import uCoins.CoinsOfUtopia;
import uCoins.SackOfCoins;

import java.util.ArrayList;

public class Main
{
  public static void main(String[] args)
  {
    // uCoins solution
    System.out.println("\n-----------------------------------------------------");
    System.out.println("-----------------uCoins assignment.------------------");
    System.out.println("-----------------------------------------------------\n");

    CoinsOfUtopia utopiasCoins = new CoinsOfUtopia(15);
    ArrayList<SackOfCoins> solutionList = utopiasCoins.getPossibleSolutions();

    for (SackOfCoins sackOfCoins : solutionList)
    {
      System.out.println(sackOfCoins.toString());
    }

    // nQueens solution
    System.out.println("-----------------------------------------------------");
    System.out.println("-----------------nQueens assignment.-----------------");
    System.out.println("-----------------------------------------------------\n");

    Queens queens = new Queens(4);
    ArrayList<ChessBoard> solution = queens.getPossibleSolutions();

    for (ChessBoard chessBoard : solution)
    {
      chessBoard.printChessBoard();
    }
    System.out.println("Answer: " + solution.size() + " solutions!\n");
  }
}
