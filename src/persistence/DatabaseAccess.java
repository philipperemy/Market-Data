package persistence;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import log.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseAccess {
    private Logger logger = Logger.getInstance();
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private boolean dbExist = true;

    public DatabaseAccess() {
        readDataBase(true);
    }

    public void insertMarketData(String symbol, String price) {
        logger.traceINFO("Inserting ( " + symbol + ", " + price + " )");

        if (dbExist) {
            String query = "INSERT INTO `marketdata`.`market_data` (`ID`, `SYMBOL`, `PRICE`, `TIMESTAMP`) VALUES (NULL, '" + symbol + "', '" + price + "', CURRENT_TIMESTAMP);";
            try {
                connect.createStatement().execute(query);
            } catch (CommunicationsException e) {
                readDataBase(false);
                insertMarketData(symbol, price);
            } catch (Exception e) {
                logger.traceERROR(e);
            }
        }
    }

    private void readDataBase(boolean init) {
        try {
            logger.traceINFO("Initializing database...");
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/marketdata?" + "user=root&password=your_new_password");
        } catch (Exception e) {
            logger.traceERROR(e);
            logger.traceERROR("Program did not find a database at jdbc:mysql://localhost/marketdata?" + "user=root&password=your_new_password");
            dbExist = false;
        }
    }

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            logger.traceERROR(e);
        }
    }

}
