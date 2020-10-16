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

public class UpdateDataPulsa extends AppCompatActivity {
    EditText text_username2, text_jumlah2, text_deskripsi2;
    Button button_save1;
    DatabaseListDataPulsa db;
    Cursor cursor;
    String nama, jumlah, deskripsi_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_pulsa);


        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        jumlah = intent.getStringExtra("jumlah");
        deskripsi_status  = intent.getStringExtra("deskripsi");

        text_username2 = (EditText) findViewById(R.id.text_username2);
        text_jumlah2 = (EditText) findViewById(R.id.text_jumlah2);
        text_deskripsi2 = (EditText) findViewById(R.id.text_deskripsi2);

        button_save1 = (Button) findViewById(R.id.button_save1);

        text_username2.setText(nama);
        text_jumlah2.setText(jumlah);
        text_deskripsi2.setText(deskripsi_status);
        db = new DatabaseListDataPulsa(this);

        button_save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbnya = db.getWritableDatabase();
                dbnya.execSQL("update note set nama='"+ text_username2.getText() +"', jumlah='"+ text_jumlah2.getText() +"', deskripsi_status='"+ text_deskripsi2.getText() +"' where nama='"+ nama +"'");
                finish();
                Toast.makeText(UpdateDataPulsa.this,"DATA BERHASIL DI UPDATE",Toast.LENGTH_LONG).show();
            }
        });

    }
}
