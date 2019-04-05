package com.example.user.firebaseauthdemo;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class caffee extends AppCompatActivity   {


    private ImageView image;
    private TextView textView;
    private Button Logout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caffee);



        Logout = (Button) findViewById(R.id.buttonlog);
        image=(ImageView) findViewById(R.id.ImageViewFood);
        textView=(TextView) findViewById(R.id.CaffeetextId);
        firebaseAuth=FirebaseAuth.getInstance();

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent intent= new Intent(caffee.this,Login.class);
                startActivity(intent);
            }
        });

    }
}
