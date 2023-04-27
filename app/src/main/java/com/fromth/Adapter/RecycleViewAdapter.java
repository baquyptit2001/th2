package com.fromth.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fromth.R;
import com.fromth.model.Item;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.HomeViewHolder>{
    private List<Item> list;
    private ItemListener itemListener;



    public RecycleViewAdapter() {
        list = new ArrayList<>();

    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public Item getItem(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Item item = list.get(position);
        holder.name.setText(item.getName());
        holder.singer.setText(item.getSinger());
        holder.album.setText(item.getAlbum());
        holder.theloai.setText(item.getTheloai());
        holder.yeuthich.setText(item.getYeuthich() == 1? "Yeu thich":"Khong yeu thich");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name, singer,  album, theloai, yeuthich;

        public HomeViewHolder(@NonNull View view) {
            super(view);
            name= view.findViewById(R.id.tvname);
            singer= view.findViewById(R.id.tvSinger);
            album= view.findViewById(R.id.tvAlbum);
            theloai= view.findViewById(R.id.tvtheloai);
            yeuthich= view.findViewById(R.id.tvyeuthich);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (itemListener != null)
                itemListener.onItemClick(view, getAdapterPosition() );
        }
    }
    public interface  ItemListener{
        void onItemClick(View view,int position);
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }
}


