package com.HPS.cuoos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openloginscreen(View v)
    {
        Intent i= new Intent(this, Main2Activity.class);
        startActivity(i);
    }
    public void openregisterscreen(View v)
    {
        Intent i= new Intent(this, Main3Activity.class);
        startActivity(i);
    }
}
