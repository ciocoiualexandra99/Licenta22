package com.example.yogatrain.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yogatrain.HomeActivity;
import com.example.yogatrain.MainActivity;
import com.example.yogatrain.R;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    Button logoutBtn;
    TextView nameTv,mailTv;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        HomeActivity.Rl.setBackgroundColor(getResources().getColor(R.color.blue));


        logoutBtn=view.findViewById(R.id.logoutBtn);
        nameTv=view.findViewById(R.id.nameTv);
        mailTv=view.findViewById(R.id.mailTv);
        nameTv.setText("Hi, "+ FirebaseAuth.getInstance().getCurrentUser().getDisplayName()+" !");
        mailTv.setText( FirebaseAuth.getInstance().getCurrentUser().getEmail());


        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
            }
        });


        return view;
    }
}