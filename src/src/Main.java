package src;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import marketdata.Symbols;
import persistence.DatabaseAccess;
import timer.StockExchangeTimer;
import timer.Timer;

public class Main
{

    public static int             processorsCount = 1;                   // Runtime.getRuntime()
    // .availableProcessors();

    public static ExecutorService es              = null;

    public static DatabaseAccess  da              = new DatabaseAccess();

    public static void main(String[] args) throws InterruptedException
    {

        System.out.println("Processors count... " + processorsCount);

        Symbols symbolObj = new Symbols();
        Collection<String> symbols = symbolObj.getMapping().values();

        Timer timer = new StockExchangeTimer(60, 8, 58, 17, 37);

        while (true)
        {

            if (timer.tick())
            {

                es = Executors.newFixedThreadPool(processorsCount);

                for (String symbol : symbols)
                {
                    Task task = new Task(symbol);
                    es.execute(task);
                }

                es.shutdown();
                es.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

                for (String symbol : symbols)
                {
                    String price = MapQuotes.get(symbol);
                    if (price != null)
                    {
                        da.insertMarketData(symbol, price);
                    }
                }

                MapQuotes.flush();

            }
            else
            {
                Thread.sleep(1000);
            }

        }

    }

}
