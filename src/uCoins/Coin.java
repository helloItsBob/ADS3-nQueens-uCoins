package uCoins;

import java.util.ArrayList;

public class Coin
{
  private static ArrayList<Coin> coinArrayList;
  private final int value;

  private Coin(int value)
  {
    this.value = value;
  }

  public int getValue()
  {
    return value;
  }

  public static Coin getCoin(int index)
  {
    if (coinArrayList == null)
    {
      coinArrayList = new ArrayList<>();
      ArrayList<Integer> valueList = new ArrayList<>();
      valueList.add(1);
      valueList.add(7);
      valueList.add(10);
      valueList.add(22);

      for (int i : valueList)
      {
        coinArrayList.add(new Coin(i));
      }

    }
    if (index >= 0 && index < coinArrayList.size())
    {
      return coinArrayList.get(index);
    }
    return null;
  }

  public ArrayList<SackOfCoins> getCoinsForMinimumNumber(int totalValue,
      CoinsOfUtopia coinsOfUtopia, int numberOfCoins)
  {
    ArrayList<SackOfCoins> sackOfCoinsArrayList = new ArrayList<>();
    if (totalValue >= value && numberOfCoins < coinsOfUtopia
        .getMinimumNumberOfCoins()
        || totalValue >= value && coinsOfUtopia.getMinimumNumberOfCoins() == -1)
    {
      for (Coin coin : coinArrayList)
      {
        if (totalValue - value > 0)
        {
          ArrayList<SackOfCoins> sackOfCoinsList = coin
              .getCoinsForMinimumNumber(totalValue - value, coinsOfUtopia,
                  numberOfCoins + 1);
          for (SackOfCoins sackOfCoins : sackOfCoinsList)
          {
            sackOfCoins.addCoin(this);
            sackOfCoinsArrayList.add(sackOfCoins);
          }
        }
        else if (totalValue - value == 0)
        {
          SackOfCoins coinSack = new SackOfCoins();
          coinSack.addCoin(this);
          sackOfCoinsArrayList.add(coinSack);
          coinsOfUtopia.updateMinimumNumberOfCoins(numberOfCoins + 1);
          break;
        }
        else
          break;
      }
    }

    return sackOfCoinsArrayList;
  }

  @Override public String toString()
  {
    return value + "";
  }
}
