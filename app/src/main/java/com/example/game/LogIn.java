package com.example.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;



public class LogIn extends AppCompatActivity {
    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    
        TextView createNew = (TextView) findViewById(R.id.CreateNewTextView);
        
        createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openNewActivity();
            }
        });
    }
    
    public void openNewActivity(){
        Intent intent = new Intent(this, CreateNewAccount.class);
        startActivity(intent);
    }
}