package com.example.sqliteexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodataActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1;
    EditText text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dbHelper = new DataHelper(this);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        ton1 = (Button) findViewById(R.id.button1);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(text2.getText().toString().equals("")||text3.getText().toString().equals("")||text4.getText().toString().equals("")||text5.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Data Harus Lengkap", Toast.LENGTH_LONG).show();
                } else {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into biodata(nama, tgl, jk, alamat) values('" +
                            text2.getText().toString() + "','" +
                            text3.getText().toString() + "','" +
                            text4.getText().toString() + "','" +
                            text5.getText().toString() + "')");
                    MainActivity.ma.RefreshList();
                    finish();
                }
            }
        });
    }
}

