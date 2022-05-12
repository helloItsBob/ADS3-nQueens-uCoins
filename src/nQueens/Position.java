package nQueens;

import java.util.HashMap;
import java.util.Map;

public class Position
{
  private final int x;
  private final int y;

  private static final Map<String, Position> positionMap = new HashMap<>();

  private Position(int x, int y)
  {
    this.x = x;
    this.y = y;

    positionMap.put(toString(), this);
  }

  public static Position getPosition(int x, int y)
  {
    if (positionMap.containsKey(x + "," + y))
      return positionMap.get(x + "," + y);

    else
      return new Position(x, y);
  }

  public int getPositionX()
  {
    return x;
  }

  public int getPositionY()
  {
    return y;
  }

  public Position getRightPosition()
  {
    return positionMap.get((x + 1) + "," + y);
  }

  public Position getTopPosition()
  {
    return positionMap.get(x + "," + (y + 1));
  }

  public Position getBottomPosition()
  {
    return positionMap.get(x + "," + (y - 1));
  }

  public Position getFarBottomPosition()
  {
    if (getBottomPosition() != null)
    {
      return getBottomPosition().getFarBottomPosition();
    }
    return this;
  }

  @Override public String toString()
  {
    return x + "," + y;
  }
}