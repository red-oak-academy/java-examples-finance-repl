package academy.redoak.financerepl.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * HttpClient for calling HTTP URLs. Currently supports GET only. Implemented as Singleton!
 */
public final class HttpClient {

    private HttpClient() {
        // private Ctr due to singleton pattern
    }

    /**
     * Performs a default GET request with the {@link HttpURLConnection} by opening a connection with {@link URL#openConnection()}.
     *
     * @param urlString The String representation of the URL to be called. Must be formed like that: https://google.de/index
     * @return The content of given URL.
     *
     * @throws IOException May throw an IOException, if there occurs any issue when calling backend.
     */
    public String doHttpGET(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();
        // do checks before casting!!
        if (!(urlConnection instanceof HttpURLConnection)) {
            throw new IOException("Malformed URL - is not HTTP(S) conform");
        }
        HttpURLConnection con = (HttpURLConnection) urlConnection;
        int responseCode = con.getResponseCode();
        System.out.println("DEBUG: " + responseCode);

        // retrieve input stream and put it into the BufferedReader in order to read the response
        InputStream inputStream = con.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }

        return sb.toString();
    }

    // --- Singleton

    private static HttpClient instance = new HttpClient();

    /**
     * @return The singleton instance
     */
    public static HttpClient getInstance() {
        return instance;
    }
}
