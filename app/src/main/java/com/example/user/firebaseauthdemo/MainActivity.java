package com.example.user.firebaseauthdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button btn;
    private EditText text1;
    private EditText text2;
    private TextView text3;
    private TextView text4;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(this);

        btn= (Button) findViewById(R.id.buttonSignup);

        text1= (EditText) findViewById(R.id.editTextEmail);
        text2= (EditText) findViewById(R.id.editTextPassword);

        text3= (TextView) findViewById(R.id.textViewSignin);
        text4= (TextView) findViewById(R.id.textRegis);



        btn.setOnClickListener(this);
        text3.setOnClickListener(this);

    }

    private void registerUser(){
        String email= text1.getText().toString().trim();
        String password= text2.getText().toString().trim();



        progressDialog.setMessage("Registering please wait....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),Login.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Registration error....",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();

                    }
                });
    }

    @Override
    public void  onClick(View view){
        if(view==btn){
            registerUser();
        }
        if(view==text3){
            startActivity(new Intent(getApplicationContext(),Login.class));

        }

    }
}


