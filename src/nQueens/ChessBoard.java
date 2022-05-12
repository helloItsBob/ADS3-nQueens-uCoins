package nQueens;

import java.util.ArrayList;

public class ChessBoard
{
  private final Position initialPosition;
  private final ArrayList<Position> possiblePositionOfQueensList;

  private ChessBoard(Position initialPosition, ArrayList<Position> queensMap)
  {
    this.initialPosition = initialPosition;
    this.possiblePositionOfQueensList = queensMap;
  }

  public ChessBoard(int i)
  {
    initialPosition = Position.getPosition(0, 0);
    possiblePositionOfQueensList = new ArrayList<>();

    for (int x = 0; x < i; x++)
    {
      for (int y = 0; y < i; y++)
        Position.getPosition(x, y);
    }
  }

  public Position getInitialPosition()
  {
    return initialPosition;
  }

  public void placeQueen(Position position)
  {
    if (!possiblePositionOfQueensList.contains(position) && position != null)
    {
      possiblePositionOfQueensList.add(position);
    }
  }

  public void removeQueen(Position position)
  {
    possiblePositionOfQueensList.remove(position);
  }

  public ArrayList<Position> getQueenPositionList()
  {
    return copy().possiblePositionOfQueensList;
  }

  public ChessBoard copy()
  {
    ArrayList<Position> copyMap = new ArrayList<>(possiblePositionOfQueensList);
    return new ChessBoard(initialPosition, copyMap);
  }

  public void printChessBoard()
  {
    String print = "";
    Position firstOnTheLine = initialPosition;

    while (firstOnTheLine.getTopPosition() != null)
    {
      firstOnTheLine = firstOnTheLine.getTopPosition();
    }
    Position printPosition = firstOnTheLine;

    int i = 0;
    for (; ; )
    {
      if (firstOnTheLine != null)
      {
        if (printPosition != null)
        {
          if (possiblePositionOfQueensList.contains(printPosition))
          {
            print += "♛ ";
          }
          else
          {
            if (i % 2 == 0)
              print += "▢ ";
            else
              print += "▣ ";
          }
          i++;

          printPosition = printPosition.getRightPosition();
        }
        else
        {
          print += "\n";
          firstOnTheLine = firstOnTheLine.getBottomPosition();
          printPosition = firstOnTheLine;
          i++;
        }
      }
      else
        break;
    }

    System.out.println(print);
  }
}