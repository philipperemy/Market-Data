package src;

import java.util.HashMap;
import java.util.Map;

public class MapQuotes {
    private Map<String, String> quotes = new HashMap<>();

    public synchronized String get(String symbol) {
        return quotes.get(symbol);
    }

    public synchronized void put(String symbol, String quote) {
        quotes.put(symbol, quote);
    }
}
