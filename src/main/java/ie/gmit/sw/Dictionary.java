package ie.gmit.sw;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Dictionary {

    public static boolean wordExists(String word) throws IOException {
        String app_id = "49bd1907";
        String app_key = "a5d88cdfc2e208b0b5c15ee7d74c7e4f";
        String language = "en";
        String url = "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word.toLowerCase();

        URL urlForGetRequest = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("app_id", app_id);
        connection.setRequestProperty("app_key", app_key);
        int responseCode = connection.getResponseCode();

        return responseCode == HttpURLConnection.HTTP_OK;
    }
}
