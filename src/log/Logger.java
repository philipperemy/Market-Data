package log;

import java.util.Date;

public class Logger {
    private static final String ERROR_KEY = "ERROR";
    private static final String INFO_KEY = "INFO";
    private static Date now;
    private static Logger instance = new Logger();

    public static synchronized Logger getInstance() {
        return instance;
    }

    private Logger() {

    }

    public void traceINFO(String msg) {
        print(INFO_KEY, msg, null);
    }

    public void traceERROR(String msg) {
        print(ERROR_KEY, msg, null);
    }

    public void traceERROR(String msg, Exception e) {
        print(ERROR_KEY, msg, e);
    }

    public void traceERROR(Exception e) {
        print(ERROR_KEY, "", e);
    }

    private void print(String debugKey, String msg, Exception e) {
        now = new Date();
        System.out.println(now + " [" + debugKey + "] - " + msg);
        if (e != null) {
            e.printStackTrace();
        }
    }

}
