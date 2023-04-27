package com.fromth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.fromth.db.SQLiteHelped;
import com.fromth.model.Item;


public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name,singer;
    private Spinner album, theloai;
    private Button btA, btC;
    private CheckBox yeuthich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        btA.setOnClickListener(this);
        btC.setOnClickListener(this);
    }

    private void initView() {
        name = findViewById(R.id.ename);
        singer = findViewById(R.id.esinger);
        album = findViewById(R.id.spAlbum);
        theloai = findViewById(R.id.spTheloai);
        yeuthich = findViewById(R.id.checkbox);
        btA = findViewById(R.id.btAdd);
        btC = findViewById(R.id.btCancel);
        theloai.setAdapter(new ArrayAdapter<String>(this,R.layout.itemspinner,getResources().getStringArray(R.array.theloai)));
        album.setAdapter(new ArrayAdapter<String>(this,R.layout.itemspinner,getResources().getStringArray(R.array.album)));

    }

    @Override
    public void onClick(View view) {
        if(view==btC)
            finish();
        if (view == btA)
        {
            String t = name.getText().toString();
            String s = singer.getText().toString();
            String c = album.getSelectedItem().toString();
            String tl = theloai.getSelectedItem().toString();
            int yt=0;
            if(yeuthich.isChecked())
            {
                 yt=1;
            }
            if( !(t.isEmpty() && s.isEmpty()))
            {
                Item i = new Item(t,s,c,tl,yt);
                SQLiteHelped db = new SQLiteHelped(this);
                db.addItem(i);
                finish();
            }
        }
    }
}
