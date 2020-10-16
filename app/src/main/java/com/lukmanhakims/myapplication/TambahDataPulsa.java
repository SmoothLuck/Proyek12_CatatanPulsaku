package com.lukmanhakims.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.lukmanhakims.myapplication.models.DatabaseListDataPulsa;

public class TambahDataPulsa extends AppCompatActivity {
    EditText text_username1,text_jumlah,text_deskripsist;
    ImageButton button_save;
    Button button;
    DatabaseListDataPulsa db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data_pulsa);


        db = new DatabaseListDataPulsa(this);

        text_username1 = (EditText) findViewById(R.id.text_username1);
        text_jumlah = (EditText) findViewById(R.id.text_jumlah1);
        text_deskripsist= (EditText) findViewById(R.id.text_deskripsi1);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbnya = db.getWritableDatabase();
                String jumlah = text_jumlah.getText().toString();
                int intJumlah = Integer.parseInt(jumlah);
                dbnya.execSQL("insert into note(nama, jumlah, deskripsi_status) values('" + text_username1.getText().toString() + "','" + intJumlah + "','" + text_deskripsist.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "DATA BERHASIL DITAMBAH", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(TambahDataPulsa.this, ListDataPulsa.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
