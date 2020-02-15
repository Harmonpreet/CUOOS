package com.HPS.cuoos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class generalMenu extends AppCompatActivity {

    DatabaseReference databaseReferenceffs, databaseReferencefood;
    ProgressDialog pd;

    String foodKey=null, fullprice=null, halfprice=null;
    ListView listView;
    ArrayList<String > list;
    ArrayAdapter<String> adapter;
    foodForshops f;
    food fd;
    String foodname;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_menu);
        pd = new ProgressDialog(this);
        pd.setMessage("Please wait");
        listView=(ListView)findViewById(R.id.listViewMenu);
        list=new ArrayList<>();
        adapter= new ArrayAdapter<String>(this, R.layout.generalmenu, R.id.textviewMenu, list);
        databaseReferenceffs = FirebaseDatabase.getInstance().getReference("foodForshops");
        databaseReferencefood=FirebaseDatabase.getInstance().getReference("food");
        String sName = getIntent().getStringExtra("sName").trim();

        databaseReferenceffs.orderByChild("resName").equalTo(sName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ffs: dataSnapshot.getChildren())
                {
                    f=ffs.getValue(foodForshops.class);

                    fullprice=f.getfPrice();
                    halfprice=f.gethPrice();
                    foodname=f.getfKey();
                    list.add(foodname + " \nFull price: " + fullprice + " Half price: " + halfprice);
                }



                listView.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
        adapter.notifyDataSetChanged();

    }
}
