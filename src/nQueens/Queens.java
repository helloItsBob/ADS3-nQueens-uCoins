package nQueens;

import java.util.ArrayList;

public class Queens
{
  private final int numberOfQueens;

  public Queens(int numberOfQueens)
  {
    this.numberOfQueens = numberOfQueens;
  }

  public ArrayList<ChessBoard> getPossibleSolutions()
  {
    ArrayList<ChessBoard> solutionsList = new ArrayList<>();
    ChessBoard chessBoard = new ChessBoard(numberOfQueens);
    Position position = chessBoard.getInitialPosition();

    for (int i = 0; i < numberOfQueens; i++)
    {
      for (; ; )
      {
        ArrayList<Position> queensList = chessBoard.getQueenPositionList();
        chessBoard.placeQueen(position);

        for (Position j : queensList)
        {
          if (queenCanStrike(j, position))
          {
            chessBoard.removeQueen(position);
            break;
          }
        }

        if (chessBoard.getQueenPositionList().size() == queensList.size() + 1)
          break;

        if (position.getTopPosition() != null)
          position = position.getTopPosition();

        else
          break;
      }

      if (chessBoard.getQueenPositionList().size() != i + 1)
      {
        for (; ; )
        {
          i -= 1;
          position = chessBoard.getQueenPositionList().get(i);
          chessBoard.removeQueen(position);

          if (position.getPositionX() == 0
              && position.getPositionY() == numberOfQueens - 1)
          {
            i = numberOfQueens;
            break;
          }

          if (position.getTopPosition() != null)
          {
            position = position.getTopPosition();
            i -= 1;
            break;
          }
        }
      }

      else
      {
        if (position.getRightPosition() != null)
          position = position.getRightPosition().getFarBottomPosition();

        else
        {
          solutionsList.add(chessBoard.copy());

          for (; ; )
          {
            position = chessBoard.getQueenPositionList().get(i);
            chessBoard.removeQueen(position);
            if (position.getPositionX() == 0
                && position.getPositionY() == numberOfQueens - 1)
            {
              i = numberOfQueens;
              break;
            }

            i -= 1;
            if (position.getTopPosition() != null)
            {
              position = position.getTopPosition();
              break;
            }
          }
        }
      }
    }
    return solutionsList;
  }

  public static boolean queenCanStrike(Position queenPosition,
      Position position)
  {
    return queenPosition.getPositionX() == position.getPositionX()
        || queenPosition.getPositionY() == position.getPositionY() ||
        (queenPosition.getPositionX() - position.getPositionX()) * (
            queenPosition.getPositionX() - position.getPositionX())
            == (queenPosition.getPositionY() - position.getPositionY()) * (
            queenPosition.getPositionY() - position.getPositionY());
  }
}