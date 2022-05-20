package com.example.yogatrain.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yogatrain.HomeActivity;
import com.example.yogatrain.R;
import com.google.firebase.auth.FirebaseAuth;


public class HomeFragment extends Fragment {

    TextView nameTv,saTv;
    CardView fcv,scv,tcv;
    CardView becv1,becv2;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        HomeActivity.Rl.setBackgroundColor(getResources().getColor(R.color.blue));

        becv2=view.findViewById(R.id.becv2);
        becv1=view.findViewById(R.id.becv1);
        nameTv=view.findViewById(R.id.nameTv);
        fcv=view.findViewById(R.id.fcv);
        scv=view.findViewById(R.id.scv);
        tcv=view.findViewById(R.id.tcv);
        saTv=view.findViewById(R.id.saTv);



        nameTv.setText("Hi, "+ FirebaseAuth.getInstance().getCurrentUser().getDisplayName()+"!");

        fcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new PoseFragment()).commit();

            }
        });


        scv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new PoseFragment()).commit();

            }
        });

        tcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new PoseFragment()).commit();

            }
        });

        saTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new PoseFragment()).commit();

            }
        });

        becv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new LibraryFragment()).commit();

            }
        });

        becv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new LibraryFragment()).commit();

            }
        });

        return view;
    }
}