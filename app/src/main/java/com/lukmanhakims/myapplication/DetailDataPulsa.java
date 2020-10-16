package com.lukmanhakims.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.lukmanhakims.myapplication.models.DatabaseListDataPulsa;

public class DetailDataPulsa extends AppCompatActivity {
    String id;
    DatabaseListDataPulsa db;
    String nama, jumlah, deskripsi_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_pulsa);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        nama = intent.getStringExtra("nama");
        jumlah = intent.getStringExtra("jumlah");
        deskripsi_status = intent.getStringExtra("deskripsi_status");

        TextView text_username = (TextView) findViewById(R.id.text_username);
        TextView jumlah1= (TextView) findViewById(R.id.text_jumlah);
        TextView deskripsi = (TextView) findViewById(R.id.text_deskripsi);
        Button update = (Button) findViewById(R.id.update);
        Button hapus = (Button) findViewById(R.id.hapus);

        text_username.setText(" " + nama);
        jumlah1.setText("Jumlah\t = " +  jumlah);
        deskripsi.setText("Deskripsi\t = " + deskripsi_status);

        db = new DatabaseListDataPulsa(this);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = DetailDataPulsa.this;
                Intent i = new Intent(context, UpdateDataPulsa.class);
                i.putExtra("nama", nama);
                i.putExtra("jumlah", jumlah);
                i.putExtra("deskripsi", deskripsi_status);
                context.startActivity(i);
                finish();
            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbsql = db.getReadableDatabase();
                dbsql.delete("note","nama = '" + nama + "'",null);
                Toast.makeText(DetailDataPulsa.this,"Berhasil dihapus!", Toast.LENGTH_LONG).show();
                finish();
            }
        });



    }
}
