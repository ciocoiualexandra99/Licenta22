package com.example.yogatrain.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.yogatrain.AsanaActivity;
import com.example.yogatrain.HomeActivity;
import com.example.yogatrain.LibModel;
import com.example.yogatrain.R;
import com.example.yogatrain.Utility;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    TextView nameTv,saTv;
    CardView fcv,scv,tcv;
    CardView becv1,becv2;
    List<LibModel> list2=new ArrayList<>();
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

        list2.add(new LibModel("Warrior2", " BENEFITS AND GOALS \n" +"\n"+
                " Strengthens the thighs, butt, abdomen and ankles. \n" +"\n"+
                " Opens the hips, chest and shoulders. \n" +"\n"+
                " Helps relieve back pain and cultivate focus. \n" + "\n"+
                " INSTRUCTION \n" +"\n"+
                " 1. Begin standing. \n" +"\n"+
                " 2. Spiral the left heel down at a 60 degree angle,extend the right arm forward and the left arm back, both parallel to the ground.\n" +
                "\n",R.drawable.warrior2));

        list2.add(new LibModel("DownDog"," BENEFITS AND GOALS \n" +"\n"+
                "  Stretches the hamstrings, calves, shoulders, and spine. \n" +"\n"+
                "  Strengthens the arms, core and legs. \n" +"\n"+
                "  Can relieve headaches, back pain, and improve digestion. \n" + "\n"+
                " INSTRUCTION \n" +"\n"+
                " 1. Starting on the belly, place the hands under the shoulders. Press the tops of the feet into the ground.\n" +"\n"+
                " 2. Lift the chest, belly and thighs off the floor, grounding firmly into the hands and feet.\n" + "\n"+
                " 3. Roll the shoulders away from the ears, rotate the triceps into the ribs, and retract the shoulder blades.\n" ,R.drawable.dog));

        list2.add(new LibModel("Cobra", " BENEFITS AND GOALS \n" +"\n"+
                " Streches the chest, spine, hip flexors . \n" +"\n"+
                " Strengthens the wrists, arms, quads. \n" +"\n"+
                " Helps improve posture, digestion and relieve back pain. \n" +"\n"+
                " INSTRUCTION \n" + "\n"+
                " 1. Begin standing. \n" +"\n"+
                " 2. Spiral the left heel down at a 60 degree angle,extend the right arm forward and the left arm back, both parallel to the ground.\n" +
                "\n",R.drawable.yoga));


        fcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.libModel= list2.get(1);
                Intent intent = new Intent(getActivity(), AsanaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);


            }
        });


        scv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.libModel= list2.get(0);
                Intent intent = new Intent(getActivity(), AsanaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);
            }
        });

        tcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.libModel= list2.get(2);
                Intent intent = new Intent(getActivity(), AsanaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);
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