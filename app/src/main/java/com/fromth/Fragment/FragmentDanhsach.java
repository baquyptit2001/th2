package com.fromth.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fromth.Adapter.RecycleViewAdapter;
import com.fromth.R;
import com.fromth.UpdateDeleteActivity;
import com.fromth.db.SQLiteHelped;
import com.fromth.model.Item;

import java.util.List;

public class FragmentDanhsach extends Fragment implements RecycleViewAdapter.ItemListener {
    private RecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private SQLiteHelped db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentdanhsach, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            recyclerView = view.findViewById(R.id.recyHome);
            adapter= new RecycleViewAdapter();
            db = new SQLiteHelped(getContext());
            List<Item> list = db.getAll();
            adapter.setList(list);
            LinearLayoutManager manager= new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
            adapter.setItemListener(this);
            }

      @Override
    public void onItemClick(View view, int position) {
        Item item = adapter.getItem(position);
        Intent intent = new Intent(getActivity(), UpdateDeleteActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);
    }

@Override
public void onResume() {
        super.onResume();
        List<Item> list = db.getAll();
        adapter.setList(list);
        }
}
