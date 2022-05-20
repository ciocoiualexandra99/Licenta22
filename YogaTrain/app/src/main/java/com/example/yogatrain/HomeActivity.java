package com.example.yogatrain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yogatrain.Fragments.HomeFragment;
import com.example.yogatrain.Fragments.LibraryFragment;
import com.example.yogatrain.Fragments.PoseFragment;
import com.example.yogatrain.Fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {


    BottomNavigationView bNav;
    public static RelativeLayout Rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

        Rl=findViewById(R.id.Rl);
        bNav=findViewById(R.id.bNav);
        bNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
                }
                else if (item.getItemId()==R.id.library){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new LibraryFragment()).commit();
                }
                else if (item.getItemId()==R.id.pose){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new PoseFragment()).commit();
                }
                else if (item.getItemId()==R.id.profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfileFragment()).commit();
                }
                return true;
            }
        });


    }
}