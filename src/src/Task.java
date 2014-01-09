package src;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import marketdata.MarketDataLayer;

public class Task implements Callable<Object>
{
    public String     symbol;
    private MapQuotes quotes;

    public Task(String symbol, MapQuotes quotes)
    {
        this.symbol = symbol;
        this.quotes = quotes;
    }

    @Override
    public Future<Object> call()
    {
        try
        {
            MarketDataLayer marketDataLayer = new MarketDataLayer();
            String price = marketDataLayer.getLastPricesFromAbcBourse(symbol).toString();
            quotes.put(symbol, price);
        }
        catch (UnknownHostException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

}
