package sample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AndmeteSaamine {
    private String html;
     private double hindMWH;

    public AndmeteSaamine(String html) throws Exception {
        this.html = html;
        uuendaHind(html);
    }

    public double getHindMWH() {
        return hindMWH;
    }

    public void setHindMWH(double hindMWH) {
        this.hindMWH = hindMWH;
    }

    public double uuendaHind(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result.toString());

        JSONArray jsonArray = (JSONArray) json.get("data");


        this.hindMWH = (double) ((JSONObject) jsonArray.get(0)).get("price");


        return hindMWH;

    }


}