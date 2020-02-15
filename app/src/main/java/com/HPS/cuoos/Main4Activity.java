package com.HPS.cuoos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Main4Activity extends AppCompatActivity  {


    TextView name;
    FirebaseAuth firebaseAuth;
    BottomNavigationView bottomNavigationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        //name=(TextView) findViewById(R.id.textView5);
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        //name.setText(user.getEmail())
        bottomNavigationView.setOnNavigationItemSelectedListener(navListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new home_fragment()).commit();
    }
    BottomNavigationView.OnNavigationItemSelectedListener navListner=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.home:
                            selectedFragment = new home_fragment();
                            break;
                        case R.id.stationary:
                            selectedFragment = new stationary_fragment();
                            break;
                        case R.id.food:
                            selectedFragment = new food_fragment();
                            break;
                        case R.id.laundry:
                            selectedFragment = new laundry_fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, selectedFragment).commit();
                    return true;
                }
                };
}
