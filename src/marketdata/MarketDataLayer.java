package marketdata;

import http.HttpCallAbcBourse;

public class MarketDataLayer
{

    public String getLastPricesFromAbcBourse(String symbol)
    {
        HttpCallAbcBourse httpCall = new HttpCallAbcBourse();
        return httpCall.executeString(symbol);
    }

}
