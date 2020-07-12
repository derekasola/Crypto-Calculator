package com.example.game;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//URL, Progress, Return
public class fetchData extends AsyncTask<String, Void, String> {
    
    String result ="";
    
    @Override
    protected String doInBackground(String... strings) {
    
        try {
            URL myURL = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection)myURL.openConnection();
            InputStreamReader streamReader = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder builder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                builder.append(line);
            }
            
            
            
            result = builder.toString();
            
            //Log.e("Json",builder.toString());
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    
        return result;
    }
    
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONArray jsonArray = new JSONArray(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    
}
