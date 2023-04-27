package com.fromth.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fromth.R;
import com.fromth.model.Item;
import com.fromth.model.NumberTheLoai;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter2 extends RecyclerView.Adapter<RecycleViewAdapter2.HomeViewHolder>{
    private List<NumberTheLoai> list;

    public RecycleViewAdapter2() {
        list = new ArrayList<>();
    }

    public List<NumberTheLoai> getList() {
        return list;
    }

    public void setList(List<NumberTheLoai> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public NumberTheLoai getItem(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemtk,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        NumberTheLoai item = list.get(position);
        holder.theloai.setText(item.getTheloai());
        holder.number.setText(item.getNumber()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView theloai, number;

        public HomeViewHolder(@NonNull View view) {
            super(view);
            theloai= view.findViewById(R.id.tvAlbum1);
            number= view.findViewById(R.id.tvSL);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
        }
    }

}


