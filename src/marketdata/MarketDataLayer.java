package marketdata;

import http.HttpCallAbcBourse;

import java.io.IOException;

public class MarketDataLayer {
    HttpCallAbcBourse httpCall = new HttpCallAbcBourse();

    public String getLastPricesFromAbcBourse(String symbol) throws IOException {
        return httpCall.executeString(symbol);
    }
}
