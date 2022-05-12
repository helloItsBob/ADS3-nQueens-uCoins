package uCoins;

import java.util.ArrayList;
import java.util.Objects;

public class CoinsOfUtopia
{
  private final int total;
  private int minimumNumberOfCoins = -1;
  private final ArrayList<SackOfCoins> listOfSolutions;

  public CoinsOfUtopia(int totalValue)
  {
    this.total = totalValue;
    this.listOfSolutions = new ArrayList<>();
  }

  public int getMinimumNumberOfCoins()
  {
    return minimumNumberOfCoins;
  }

  public void updateMinimumNumberOfCoins(int number)
  {
    if (number < minimumNumberOfCoins || minimumNumberOfCoins == -1)
    {
      minimumNumberOfCoins = number;
      listOfSolutions.clear();
    }
  }

  public ArrayList<SackOfCoins> getPossibleSolutions()
  {
    listOfSolutions.clear();
    for (int x = 0; ; x++)
    {
      if (Coin.getCoin(x) != null)
      {
        ArrayList<SackOfCoins> returnSolutionList = Objects
            .requireNonNull(Coin.getCoin(x))
            .getCoinsForMinimumNumber(total, this, 0);

        for (SackOfCoins sackOfCoins : returnSolutionList)
        {
          if (minimumNumberOfCoins == -1)
          {
            minimumNumberOfCoins = sackOfCoins.getNumberOfCoins();
          }
          if (sackOfCoins.getNumberOfCoins() == minimumNumberOfCoins)
          {
            if (listOfSolutions.isEmpty())
            {
              listOfSolutions.add(sackOfCoins);
            }
          }
          else if (sackOfCoins.getNumberOfCoins() < minimumNumberOfCoins)
          {
            updateMinimumNumberOfCoins(sackOfCoins.getNumberOfCoins());
            listOfSolutions.add(sackOfCoins);
          }
        }
      }
      else
        break;
    }

    return listOfSolutions;
  }
}
