package com.example.yogatrain.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogatrain.ExerActivity;
import com.example.yogatrain.LibModel;
import com.example.yogatrain.R;
import com.example.yogatrain.Utility;

import java.util.List;

public class LibAdapter extends RecyclerView.Adapter<LibAdapter.LibVH>{


    List<LibModel> list;
    Context context;

    public LibAdapter(List<LibModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public LibVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.exerlistlayout,null);
        return new LibVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibVH holder, @SuppressLint("RecyclerView") int position) {

        holder.mainIv.setImageResource(list.get(position).getPhoto());
        holder.nameTv.setText(list.get(position).getTitle());
        holder.descTv.setText("Start your yoga pose");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.libModel=list.get(position);
                Intent intent=new Intent(context, ExerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LibVH extends RecyclerView.ViewHolder{

        ImageView mainIv;
        TextView nameTv,descTv;


        public LibVH(@NonNull View itemView) {
            super(itemView);

            mainIv=itemView.findViewById(R.id.mainIv);
            nameTv=itemView.findViewById(R.id.nameTv);
            descTv=itemView.findViewById(R.id.descTv);
        }
    }
}
