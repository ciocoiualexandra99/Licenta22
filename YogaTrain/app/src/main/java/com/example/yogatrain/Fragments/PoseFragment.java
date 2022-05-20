package com.example.yogatrain.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yogatrain.HomeActivity;
import com.example.yogatrain.PoseDownDog;
import com.example.yogatrain.PoseUpDog;
import com.example.yogatrain.Posedescription;
import com.example.yogatrain.R;


public class PoseFragment extends Fragment {

    CardView fcv,scv,tcv,fourthcv;

    public PoseFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pose, container, false);
        HomeActivity.Rl.setBackgroundColor(getResources().getColor(R.color.white));

        fcv=view.findViewById(R.id.fcv);
        tcv=view.findViewById(R.id.tcv);
        fourthcv=view.findViewById(R.id.fourthcv);

        fourthcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PoseDownDog.class);
                getActivity().startActivity(intent);
            }

        });
        fcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Posedescription.class);
                getActivity().startActivity(in);
            }

        });
        tcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PoseUpDog.class);
                getActivity().startActivity(intent);
            }

        });
        return view;
    }
}