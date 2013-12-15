package timer;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Timer
{

    private int    INTERVAL_SECONDS = 60;

    protected Date date             = new Date();

    public Timer(int INTERVAL_SECONDS)
    {
        this.INTERVAL_SECONDS = INTERVAL_SECONDS;
    }

    public long getSeconds()
    {
        Calendar calParis = Calendar.getInstance();
        calParis.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        long msec = calParis.getTimeInMillis();
        date.setTime(msec);
        long sec = msec / 1000l;
        return sec;
    }

    public boolean tick()
    {
        return getSeconds() % INTERVAL_SECONDS == 0;
    }

}
