package timer;

import log.Logger;

import java.util.Calendar;

public class RealtimeTimer {
    private Logger logger = Logger.getInstance();
    private int timerInterval = 1000;
    private TimerListener listener = null;
    private boolean condition = true;
    private Thread timerThread = new Thread(new TimerTask(this));
    private Calendar startDate;
    private Calendar endDate;

    private class TimerTask implements Runnable {
        private RealtimeTimer timer;

        public TimerTask(RealtimeTimer timer) {
            this.timer = timer;
        }

        @Override
        public void run() {
            while (condition) {
                if (checkBounds() && listener != null) {
                    listener.onTimerTick(timer);
                }

                if (timerInterval > 0) {
                    try {
                        Thread.sleep(timerInterval);
                    } catch (InterruptedException e) {
                        logger.traceERROR(e);
                        condition = false;
                    }
                }
            }
        }
    }

    public void start() {
        timerThread.start();
    }

    public void stop() {
        condition = false;
    }

    public RealtimeTimer(int timerInterval, int hourStart, int minStart, int hourStop, int minStop) {
        this.timerInterval = timerInterval;
        Calendar startDateCal = Calendar.getInstance();
        startDateCal.set(Calendar.HOUR_OF_DAY, hourStart);
        startDateCal.set(Calendar.MINUTE, minStart);
        startDateCal.set(Calendar.SECOND, 0);

        Calendar endDateCal = Calendar.getInstance();
        endDateCal.set(Calendar.HOUR_OF_DAY, hourStop);
        endDateCal.set(Calendar.MINUTE, minStop);
        endDateCal.set(Calendar.SECOND, 0);

        this.startDate = startDateCal;
        this.endDate = endDateCal;
        logger.traceINFO("start time = " + startDate.getTime().toString());
        logger.traceINFO("end time = " + endDate.getTime().toString());
    }

    public void setListener(TimerListener listener) {
        this.listener = listener;
    }

    long lastCheckBoundsMessageMs = System.currentTimeMillis();

    private boolean checkBounds() {
        Calendar nowDate = Calendar.getInstance();

        if (startDate.get(Calendar.DATE) < nowDate.get(Calendar.DATE)) {
            // Increment day by one.
            startDate.add(Calendar.DATE, 1);
            endDate.add(Calendar.DATE, 1);
            logger.traceINFO("start time = " + startDate.getTime().toString());
            logger.traceINFO("end time = " + endDate.getTime().toString());
        }

        if (nowDate.getTime().after(startDate.getTime()) && nowDate.getTime().before(endDate.getTime())) {
            return true;
        } else {
            long currentMs = nowDate.getTime().getTime();
            if (currentMs - lastCheckBoundsMessageMs > 5000) {
                lastCheckBoundsMessageMs = currentMs;
                logger.traceINFO("Out of dates bounds");
            }
            return false;
        }
    }
}
