package co.poligran.sw_recycleview;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class InformGetter {

    private ArrayList<Episode> data;

    public InformGetter(ArrayList<Episode> data){
        this.data = data;
    }

    public static final String URL_SWAPI = "https://swapi.co/api/";





    public void getInfo() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    URL urlService = new URL(URL_SWAPI + "films");
                    HttpsURLConnection connection = (HttpsURLConnection) urlService.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream responseBody = connection.getInputStream();

                    if (connection.getResponseCode() == 200) {
                        // Success
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        BufferedReader b = new BufferedReader(responseBodyReader);
                        String s = b.readLine();
                        System.out.println(s);
                        fillData(s);

                    } else {
                        // Error handling code goes here
                        Log.v("ERROR", "ERROR");
                    }

                } catch (MalformedURLException e) {
                    System.out.println(">>>>>>>>>>>>>>");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println(">>>>>>>>>>>>>>adfggalkdfhglk");
                    e.printStackTrace();
                }
            }


        });
    }


    private void fillData(String s) {
        try {


            JSONObject obj = new JSONObject(s);


            JSONArray arr = obj.getJSONArray("results");
            for (int i = 0; i < arr.length(); i++) {
                String title = arr.getJSONObject(i).getString("title");
                String episode_id = arr.getJSONObject(i).getString("episode_id");
                String opening_crawl = arr.getJSONObject(i).getString("opening_crawl").replace("\r\n\r\n","77777777").replace("\r\n"," ").replace("77777777","\r\n\r\n");
                data.add(new Episode(title, episode_id, opening_crawl));


            }
        } catch (JSONException e) {
            System.out.println("EEWRRRRRRRRRRRRRRRROOOOOOOOOOOOOOOOOOORRRRRRRRRRRRR");
        }
    }
}