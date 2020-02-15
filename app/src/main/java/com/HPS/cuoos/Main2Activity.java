package com.HPS.cuoos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText email, password;
    Button login;
    FirebaseAuth firebaseAuth;
    ProgressDialog pd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firebaseAuth=FirebaseAuth.getInstance();
        email=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        login=(Button) findViewById(R.id.button);
        pd= new ProgressDialog(this);
        login.setOnClickListener(this);
    }

    void AuthLogin()
    {
        pd.setMessage("Please wait");
        pd.show();
        String e= email.getText().toString().trim();
        String p=password.getText().toString().trim();
        firebaseAuth.signInWithEmailAndPassword(e, p).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Main2Activity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Main4Activity.class));
                }
                else
                {
                    Toast.makeText(Main2Activity.this, "Login failed", Toast.LENGTH_SHORT).show();

                }
                pd.dismiss();

            }
        });


    }
    public void onClick( View v)
    {
        if(v==login)
        {
            AuthLogin();
        }
    }
}
