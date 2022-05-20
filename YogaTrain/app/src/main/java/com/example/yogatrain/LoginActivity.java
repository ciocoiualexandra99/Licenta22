package com.example.yogatrain;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    List<AuthUI.IdpConfig> provider;
    int AuthUI_Request_Code=1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        provider= Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build());
        gotoSignInMethods();


    }

    private void gotoSignInMethods() {

        Intent intent= AuthUI.getInstance().createSignInIntentBuilder().setLogo(R.drawable.llogo).setIsSmartLockEnabled(false).
                setAvailableProviders(provider).setTheme(R.style.Theme_YogaTrain).build();
        startActivityForResult(intent,AuthUI_Request_Code);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==AuthUI_Request_Code){
            if (resultCode==RESULT_OK){

                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                finish();
            }
            else {

                IdpResponse response= IdpResponse.fromResultIntent(data);
                if (response==null){

                    Toast.makeText(this, "you have cancled tht sign in process", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {

                    Toast.makeText(this, response.getError().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}