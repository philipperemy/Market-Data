package src;

import java.util.HashMap;
import java.util.Map;

public class MapQuotes
{

    private static Map<String, String> quotesMap = new HashMap<>();

    public static synchronized void put(String symbol, String quote)
    {
        quotesMap.put(symbol, quote);
    }

    public static synchronized int size()
    {
        return quotesMap.size();
    }

    public static synchronized void print()
    {
        for (String symbol : quotesMap.keySet())
        {
            System.out.println("<" + symbol + " ; " + quotesMap.get(symbol) + " >");
        }
    }

    public static synchronized void flush()
    {
        quotesMap.clear();
    }

    public static synchronized String get(String symbol)
    {
        return quotesMap.get(symbol);
    }

}
