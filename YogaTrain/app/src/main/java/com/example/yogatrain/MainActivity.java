package com.example.yogatrain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        currentUser= FirebaseAuth.getInstance().getCurrentUser();


    }


    private void checkUserstatus() {

        if (currentUser!=null){
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            finish();
        }
        else {
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();
        }
    }

    public void goNext(View view) {
        checkUserstatus();
    }
}