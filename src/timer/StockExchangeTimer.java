package timer;

public class StockExchangeTimer extends Timer
{

    private int begHour;
    private int begMin;
    private int endHour;
    private int endMin;

    public StockExchangeTimer(int INTERVAL_SECONDS, int begHour, int begMin, int endHour, int endMin)
    {
        super(INTERVAL_SECONDS);
        this.begHour = begHour;
        this.begMin = begMin;
        this.endHour = endHour;
        this.endMin = endMin;
    }

    public StockExchangeTimer(int INTERVAL_SECONDS)
    {
        super(INTERVAL_SECONDS);
    }

    @Override
    public boolean tick()
    {
        boolean secondsTick = super.tick();
        boolean after = after(begHour, begMin);
        boolean before = before(endHour, endMin);
        System.out.println(date + " - ( >start : " + after + " ) ( <end : " + before + " )");
        return after && before && secondsTick;
    }

    @SuppressWarnings("deprecation")
    public boolean after(int hour, int min)
    {
        if (date.getHours() > hour)
        {
            return true;
        }
        else if (date.getHours() == hour)
        {
            if (date.getMinutes() > min)
            {
                return true;
            }
            else if (date.getMinutes() == min)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public boolean before(int hour, int min)
    {
        return !after(hour, min);
    }

}
