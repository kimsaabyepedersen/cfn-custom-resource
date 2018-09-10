package org.saabye_pedersen.cfn;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

class HttpClient {
    void put(String output, String responseURL) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(responseURL).openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(output);
            out.close();
            System.out.println("Status Code:" + connection.getResponseCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
