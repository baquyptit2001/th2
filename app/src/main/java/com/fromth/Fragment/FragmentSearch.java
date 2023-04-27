package com.fromth.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fromth.Adapter.RecycleViewAdapter;
import com.fromth.Adapter.RecycleViewAdapter2;
import com.fromth.R;
import com.fromth.db.SQLiteHelped;
import com.fromth.model.Item;
import com.fromth.model.NumberTheLoai;

import java.util.List;

public class FragmentSearch extends Fragment implements View.OnClickListener{
    private Spinner album;
    private RecyclerView recyclerView;
    private Button btsearch, thongke;
    private RecycleViewAdapter adapter;
    private RecycleViewAdapter2 adapter1;
    private SQLiteHelped db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentsearch, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        adapter = new RecycleViewAdapter();
        db= new SQLiteHelped(getContext());
        List<Item> list = db.getAll();
        adapter.setList(list);
        LinearLayoutManager manager= new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        btsearch.setOnClickListener(this);
        thongke.setOnClickListener(this);
    }

    private void initView(View view) {
        recyclerView =view.findViewById(R.id.reSearch);
        album = view.findViewById(R.id.spinner);
        btsearch = view.findViewById(R.id.btSearch);
        thongke = view.findViewById(R.id.btThongke);
        String[] arr = getResources().getStringArray(R.array.album);
        String[] arr2 = new String[arr.length+1];
        arr2[0]="All";
        for (int i =0 ; i<arr.length;i++)
        {
            arr2[i+1]=arr[i];
        }
        album.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.itemspinner,arr2));
    }

    @Override
    public void onClick(View view) {
        if(view==btsearch)
        {
            String alt = album.getSelectedItem().toString();
            if(alt =="All")
            {
                List<Item> list = db.getAll();
                adapter.setList(list);
            }
            else
            {
                List<Item> list = db.searchByAlbum(alt);
                adapter.setList(list);
            }
        }
        if(view == thongke)
        {
            adapter1 = new RecycleViewAdapter2();
            db= new SQLiteHelped(getContext());
            List<NumberTheLoai> list = db.thongke();
            adapter1.setList(list);
            LinearLayoutManager manager= new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter1);
        }

    }
}

