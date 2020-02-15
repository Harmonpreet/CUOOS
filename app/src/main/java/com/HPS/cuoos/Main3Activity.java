package com.HPS.cuoos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity  {

     Button register;
     EditText email, password, name, phone;
     ProgressDialog pd;
     FirebaseAuth firebaseAuth;
     DatabaseReference databaseUser;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

         databaseUser= FirebaseDatabase.getInstance().getReference("user");
        firebaseAuth= FirebaseAuth.getInstance();
        register=(Button)findViewById(R.id.button2);

        email=(EditText)findViewById(R.id.editText4);
        password=(EditText)findViewById(R.id.editText5);
        name=(EditText)findViewById(R.id.editText6) ;
        phone=(EditText)findViewById(R.id.editText7);

        pd=new ProgressDialog(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }

    private void registerUser()
    {
        final String e= email.getText().toString().trim();
        final String p=password.getText().toString().trim();
        final String n=name.getText().toString().trim();
        final String ph=phone.getText().toString().trim();

        pd.setMessage("Registering User");
        pd.show();
        firebaseAuth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {

                    String key = databaseUser.push().getKey();
                    user u= new user( key, e, n, ph);

                    databaseUser.child(key).setValue(u);
                    pd.dismiss();
                    Toast.makeText(Main3Activity.this, "Registered Successfully", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

}
