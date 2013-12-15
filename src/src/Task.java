package src;

import marketdata.MarketDataLayer;

public class Task implements Runnable
{

    public String quote = null;

    public String symbol;

    public Task(String symbol)
    {
        this.symbol = symbol;
    }

    @Override
    public void run()
    {
        try
        {
            MarketDataLayer marketDataLayer = new MarketDataLayer();
            quote = marketDataLayer.getLastPricesFromAbcBourse(symbol).toString();
            MapQuotes.put(symbol, quote);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
