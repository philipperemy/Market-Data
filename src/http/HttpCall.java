package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import log.Logger;

public class HttpCall
{
    protected Logger logger    = Logger.getInstance();
    protected String httpURL   = "";
    protected String suffixURL = "";

    protected List<String> performHttpGetRequest(String request) throws IOException
    {
        boolean exception;
        List<String> list = null;
        do
        {
            exception = false;
            logger.traceINFO("Performing Http GET Request : " + request);
            BufferedReader reader = null;
            try
            {
                list = new ArrayList<>();
                URL url = new URL(request);
                URLConnection urlConnection = url.openConnection();

                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String text;
                // int count = 0;

                while ((text = reader.readLine()) != null)
                {
                    list.add(text);
                    /*
                     * if (count % 100 == 0)
                     * {
                     * logger.traceINFO(count + " lines read from request");
                     * }
                     * count++;
                     */
                }
            }
            catch (Exception e)
            {
                logger.traceERROR(e.getMessage(), e);
                exception = true;
            }
            finally
            {
                reader.close();
            }
        }
        while (exception);

        return list;
    }

    protected String performHttpGetRequestString(String request) throws IOException
    {
        logger.traceINFO("Performing Http GET Request : " + request);
        return getPrice(request);
    }

    public String getPrice(String urlPage) throws MalformedURLException, IOException
    {
        String price = "";
        URLConnection urlConnection = new URL(urlPage).openConnection();
        urlConnection.connect();
        Scanner scanner = new Scanner(urlConnection.getInputStream());
        while (scanner.hasNextLine())
        {
            String currentLine = scanner.nextLine();
            if (currentLine.contains("EUR") && currentLine.contains("cotation"))
            {
                int idx = currentLine.indexOf("cotation") + "cotation".length();
                StringBuilder sb = new StringBuilder();
                for (int i = idx; i < currentLine.length(); i++)
                {
                    char c = currentLine.charAt(i);
                    if (Character.isDigit(c) || c == '.')
                    {
                        sb.append(String.valueOf(c));
                    }
                }

                price = sb.toString();
                break;
            }
        }

        scanner.close();
        return price;
    }

    public List<String> execute(String symbol)
    {
        String request = httpURL + symbol + suffixURL;
        try
        {
            return performHttpGetRequest(request);
        }
        catch (IOException e)
        {
            logger.traceERROR("Cannot make HTTP Call", e);
        }
        return null;
    }

    public String executeString(String symbol) throws IOException
    {
        String request = httpURL + symbol + suffixURL;
        return performHttpGetRequestString(request);
    }

}
