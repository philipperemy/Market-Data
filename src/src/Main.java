package src;

import timer.RealtimeTimer;

public class Main
{
    public static void main(String[] args)
    {
        RealtimeTimer timer = new RealtimeTimer(30000, 9, 00, 17, 38);
        timer.setListener(new PricePoller());
        timer.start();
    }
}
