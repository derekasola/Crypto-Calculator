package com.example.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button updateButton = findViewById(R.id.button1);
        final TextView total = findViewById(R.id.outPut);
        final TextView crypto = findViewById(R.id.cryptoAndCurrency);
        final EditText dollarAmount = findViewById(R.id.dollarAmount);
        final EditText cryptoAmount = findViewById(R.id.cryptoAmount);
        
        //Spinner setup ^^^^^^^^^
        final Spinner cryptoType = findViewById(R.id.cryptoSpinner);
        final Spinner currencyType = findViewById(R.id.dollarSpinner);
        
        final String[] cryptoTypeValue = new String[]{"BTC", "LTC", "ETH", "LINK" , "TRX" , "BCH", "DOGE"};
        final String[] currencyTypeValue = new String[]{"USD", "JPY" , "EUR", "AUD", "CAD", "CNY", "KRW"};
        final String API_KEY = getResources().getString(R.string.AV_API_KEY);
    
    
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cryptoTypeValue);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currencyTypeValue);
        cryptoType.setAdapter(adapter);
        currencyType.setAdapter(adapter1);
        //end spinner setup vvvvvvvvv
        
        //update button onclickListener to return data for currency conversion
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cryptoType1 = cryptoType.getSelectedItem().toString();
                final String currencyType1 = currencyType.getSelectedItem().toString();
                final String URL = ("https://www.alphavantage.co" +
                        "/query?function=CURRENCY_EXCHANGE_RATE" +
                        "&from_currency=" + cryptoType1 +
                        "&to_currency=" + currencyType1 + "&apikey=" + API_KEY);
                String results = "";
                
                fetchData getData = new fetchData();
                
                try {
                    results = getData.execute(URL).get();
                    
                    
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
    
    /*
                crypto.setText(results);
                double currencyTotal = 0.00;
                
                if((cryptoAmount.getText().toString().length() > 0
                        && dollarAmount.getText().toString().length() > 0)
                        || (cryptoAmount.getText().toString().length() == 0
                        && dollarAmount.getText().toString().length() == 0)) {
                    Toast.makeText(MainActivity.this, "Use One Input", Toast.LENGTH_SHORT).show();
                }
                
                else if(cryptoAmount.getText().toString().length() > 0) {
                    dollarAmount.setText("");
                    currencyTotal = Double.parseDouble(results) * Double.parseDouble(cryptoAmount.getText().toString());
                }

                else if(dollarAmount.getText().toString().length() > 0) {
                    cryptoAmount.setText("");
                    currencyTotal = Double.parseDouble(dollarAmount.getText().toString()) / Double.parseDouble(results);
                }
                
                total.setText(Double.toString(currencyTotal));
                
                */
            }
            
     
        });
    }
}
