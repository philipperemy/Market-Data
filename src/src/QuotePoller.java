package src;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import log.Logger;
import marketdata.Symbols;
import persistence.DatabaseAccess;
import timer.RealtimeTimer;
import timer.TimerListener;

public class QuotePoller implements TimerListener
{
    private Logger                   logger          = Logger.getInstance();
    public static int                processorsCount = Runtime.getRuntime().availableProcessors();
    public static ExecutorService    executor;
    public static DatabaseAccess     dao             = new DatabaseAccess();
    public static Collection<String> symbols         = new Symbols().getMapping().values();

    @Override
    public void onTimerTick(RealtimeTimer timerRef)
    {
        //Instantiate a new executor each time because it needs to be shut down for await termination
        executor = Executors.newFixedThreadPool(processorsCount);

        MapQuotes quotes = new MapQuotes();
        for (String symbol : symbols)
        {
            Task task = new Task(symbol, quotes);
            executor.submit(task);
        }

        try
        {
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        }
        catch (InterruptedException e)
        {
            logger.traceERROR(e);
        }

        for (String symbol : symbols)
        {
            String price = quotes.get(symbol);
            if (price != null)
            {
                dao.insertMarketData(symbol, price);
            }
            else
            {
                logger.traceINFO("Price is undefined for symbol : " + symbol);
            }
        }
    }

}
