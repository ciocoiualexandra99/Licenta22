package com.example.yogatrain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerActivity extends AppCompatActivity {
TextView nameTv,descTv;
ImageView libIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exer);
        getSupportActionBar().hide();

        nameTv=findViewById(R.id.nameTv);
        descTv=findViewById(R.id.descTv);
        libIv=findViewById(R.id.libIv);

        nameTv.setText(Utility.libModel.getTitle());
        descTv.setText(Utility.libModel.getDesc());
        libIv.setImageResource(Utility.libModel.getPhoto());



    }
}