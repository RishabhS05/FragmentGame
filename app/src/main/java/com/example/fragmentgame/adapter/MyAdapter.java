package com.example.fragmentgame.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fragmentgame.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

Context context;
List<String> heros;

public static final String TAG = MyAdapter.class.getSimpleName();
    public MyAdapter(List<String> heros, Context context) {
        this.heros = heros;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context)
                        .inflate(R.layout.names,null));
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {
         final String hero=heros.get(i);
         holder.name.setText(hero);
    }


    @Override
    public int getItemCount() {
        return heros!=null?heros.size():0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.tv_names);

        }
    }
}
