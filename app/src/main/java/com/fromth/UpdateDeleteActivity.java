package com.fromth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.fromth.db.SQLiteHelped;
import com.fromth.model.Item;

import java.util.Calendar;

public class UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name, singer;
    private Spinner album, theloai;
    private CheckBox yeuthich;
    private Button btUpdate, btRemove, btBack;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        initView();
        btUpdate.setOnClickListener(this);
        btRemove.setOnClickListener(this);
        btBack.setOnClickListener(this);
        Intent intent = getIntent();
        item = (Item) intent.getSerializableExtra("item");
        name.setText(item.getName());
        singer.setText(item.getSinger());
        int p = 0;
        int q=0;
        for (int i = 0; i < album.getCount(); i++) {
            if (album.getItemAtPosition(i).toString().equalsIgnoreCase(item.getAlbum())) {
                p = i;
                break;
            }
            album.setSelection(p);
        }
        for (int i = 0; i < theloai.getCount(); i++) {
            if (theloai.getItemAtPosition(i).toString().equalsIgnoreCase(item.getTheloai())) {
                q = i;
                break;
            }
            theloai.setSelection(q);
        }
        if(item.getYeuthich()==1)
        {
            yeuthich.setChecked(true);
        }else{
            yeuthich.setChecked(false);
        }
    }

    private void initView() {
        name = findViewById(R.id.ename1);
        singer = findViewById(R.id.esinger1);
        album = findViewById(R.id.spAlbum1);
        theloai = findViewById(R.id.spTheloai1);
        yeuthich= findViewById(R.id.checkbox1);
        btUpdate = findViewById(R.id.btUpdate);
        btBack = findViewById(R.id.btBack);
        btRemove = findViewById(R.id.btRemove);
        album.setAdapter(new ArrayAdapter<String>(this, R.layout.itemspinner, getResources().getStringArray(R.array.album)));
        theloai.setAdapter(new ArrayAdapter<String>(this, R.layout.itemspinner, getResources().getStringArray(R.array.theloai)));
    }

    @Override
    public void onClick(View view) {
        if (view == btBack)
            finish();
        if (view == btUpdate) {
            String t = name.getText().toString();
            String s = singer.getText().toString();
            String c = album.getSelectedItem().toString();
            String tl = theloai.getSelectedItem().toString();
            int yt=0;
            if(yeuthich.isChecked())
            {
                yt=1;
            }
            if( !(t.isEmpty() && s.isEmpty()&& c.matches("\\d+")&& tl.matches("\\d+")))
            {
                int id = item.getId();
                Item i = new Item(id, t, s,c, tl, yt);
                SQLiteHelped db = new SQLiteHelped(this);
                db.updateItem(i);
                finish();
            }
        }
        if(view==btRemove)
        {
            int id = item.getId();
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Xac nhan xoa");
            builder.setMessage("Ban chac chan muon xoa "+ item.getName()+" khong?");
            builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SQLiteHelped db = new SQLiteHelped(getApplicationContext());
                    db.delete(id);
                    finish();
                }
            });
            builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

}