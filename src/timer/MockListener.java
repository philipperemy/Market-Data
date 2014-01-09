package timer;

import log.Logger;

public class MockListener implements TimerListener
{
    private Logger logger = Logger.getInstance();
    long           count  = 0;

    @Override
    public void onTimerTick(RealtimeTimer timerRef)
    {
        count++;
        logger.traceINFO(String.valueOf(count));

        if (count == 100)
        {
            timerRef.stop();
        }
    }

}
