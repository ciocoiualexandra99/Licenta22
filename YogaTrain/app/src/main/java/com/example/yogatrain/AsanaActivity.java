package com.example.yogatrain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AsanaActivity extends AppCompatActivity {

    TextView nameTv1,descTv1;
    ImageView libWarrior1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pose_description);
        getSupportActionBar().hide();

        nameTv1=findViewById(R.id.nameTv1);
        descTv1=findViewById(R.id.descriere1);
        libWarrior1=findViewById(R.id.libWarrior1);

        nameTv1.setText(Utility.libModel.getTitle());
        descTv1.setText(Utility.libModel.getDesc());
        libWarrior1.setImageResource(Utility.libModel.getPhoto());

        Button button = (Button) findViewById(R.id.Begin);
        button.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          startActivity(new Intent(AsanaActivity.this, SetupCam.class));
                                      }
                                  }
        );

    }
}