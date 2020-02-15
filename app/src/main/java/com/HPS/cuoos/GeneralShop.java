package com.HPS.cuoos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GeneralShop extends AppCompatActivity {


    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    ListView listView;
    ArrayList<String > list;
    ArrayAdapter<String> adapter;
    shop newshop;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_shop);

        newshop= new shop();
        listView=(ListView)findViewById(R.id.listViewShop);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("shop");
        String type=getIntent().getStringExtra("type") ;

        Query query=FirebaseDatabase.getInstance().getReference("shop").orderByChild("shopType").equalTo(type);

        list=new ArrayList<>();
        adapter= new ArrayAdapter<String>(this, R.layout.generalshop, R.id.textviewShop, list);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot i: dataSnapshot.getChildren())
                {
                    newshop= i.getValue(shop.class);
                    list.add("Name :"+newshop.getShopName().toString()+" \nLocation: "+newshop.getShopLocation().toString());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LinearLayout ll = (LinearLayout) view; // get the parent layout view
                TextView tv = (TextView) ll.findViewById(R.id.textviewShop); // get the child text view
                String Name = tv.getText().toString();
                Name= Name.replace("Location: "," ");
                Name =Name.replace("Name :", " ");
                int p=Name.indexOf("\n");
                String req=Name.substring(0, p);
                Intent i = new Intent(getBaseContext(), generalMenu.class);
                i.putExtra("sName",req);
                startActivity(i);
            }
        });
    }
}
