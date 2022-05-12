package uCoins;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SackOfCoins
{
  private final Map<Coin, Integer> coinNumberMap;

  public SackOfCoins()
  {
    coinNumberMap = new HashMap<>();
    for (int i = 0; ; i++)
    {
      if (Coin.getCoin(i) != null)
      {
        coinNumberMap.put(Coin.getCoin(i), 0);
      }
      else
        break;
    }
  }

  public void addCoin(Coin coin)
  {
    int number = coinNumberMap.get(coin) + 1;
    coinNumberMap.put(coin, number);
  }

  public int getNumberOfCoins()
  {
    int number = 0;
    for (int i = 0; ; i++)
    {
      if (Coin.getCoin(i) != null)
      {
        number += coinNumberMap.get(Coin.getCoin(i));
      }
      else
        break;
    }

    return number;
  }

  @Override public String toString()
  {
    String printCoins = "\n";
    int totalValue = 0;

    for (int i = 0; ; i++)
    {
      if (Coin.getCoin(i) != null)
      {
        printCoins +=
            Objects.requireNonNull(Coin.getCoin(i)) + " x " + coinNumberMap
                .get(Coin.getCoin(i)) + " times\n";
        totalValue += coinNumberMap.get(Coin.getCoin(i)) * Objects
            .requireNonNull(Coin.getCoin(i)).getValue();
      }
      else
        break;
    }

    return "Requested value: " + totalValue + "\n" + "Minimum amount of coins: "
        + getNumberOfCoins() + "\n" + printCoins;
  }
}
