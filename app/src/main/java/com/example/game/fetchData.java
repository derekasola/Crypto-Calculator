package com.example.game;

import android.os.AsyncTask;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//URL, Progress, Return
public class fetchData extends AsyncTask<String, Void, String> {
    
    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        URL url;
        HttpURLConnection urlConection = null;
        
        try{
            url = new URL(strings[0]);
            urlConection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();
            
            while(data != -1) {
                char current = (char) data;
                result += current;
                data = reader.read();
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        Pattern p = Pattern.compile("\"5. Exchange Rate\": \"(.*?)000000\",");
        Matcher m =p.matcher(result);
        while(m.find()){
            result = m.group(1);
        }
        return result;
    }
}
